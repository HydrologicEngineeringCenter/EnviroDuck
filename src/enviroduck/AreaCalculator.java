package enviroduck;
import hec.io.PairedDataContainer;
import hec.io.PairedDataContainerVertDatum;
import hec.io.TimeSeriesContainer;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class AreaCalculator {

    private static final double MISSING=-998877.0;
    private double rawStage[];
    private double rawArea[];
    ArrayList<Double> incrementalStage ;
    ArrayList<Double> incrementalArea;
    ArrayList<Double> totalArea;

    public AreaCalculator(PairedDataContainer ratingTable)
    {
        this.rawStage = ratingTable.xOrdinates;
        this.rawArea = ratingTable.yOrdinates[0];
        incrementalStage = new ArrayList<Double>();
        incrementalArea = new ArrayList<Double>();
        totalArea = new ArrayList<Double>();

        makeIncrementalStageAndArea();
    }

    /**
     * computeDuckAreas() computes
     * average stage
     * feeding area
     * resting area
     * total area
     *
     * on a daily and annual basis
     * @return
     */
    public AreaResult computeDuckAreas( TimeSeriesContainer tsc)
    {
        AreaResult rval = new AreaResult();
        // TO DO...

        return rval;
    }

    public String writeIncrementalStageTableToFile(String fileName){
        PrintWriter out=null;
        try {
            int size = incrementalStage.size();
            out = new PrintWriter( fileName, "UTF-8");
            out.println("stage,incrementalArea, totalArea");

            for (int i = 0; i < size; i++) {
                out.println(incrementalStage.get(i)+", "+incrementalArea.get(i)+", "+totalArea.get(i));
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getLocalizedMessage());
        }
        finally{
            out.close();
        }
        return "";
    }

    public double lookupArea(double stage)
    {

        if (rawStage.length == 0 || stage < Math.floor(rawStage[0]) || stage > Math.ceil(rawStage[rawStage.length - 1]))
        {
            return MISSING;
        }

        double interpolateVal = Interpolate(rawStage, rawArea, stage);
        if (interpolateVal == MISSING)
        {
            if (stage >= Math.round(rawStage[rawStage.length - 1] * 10) / 10.0)
            {
                return Extrapolate(rawStage, rawArea, stage, rawStage.length - 2, rawStage.length - 1);
            } else
            {
                return Extrapolate(rawStage, rawArea, stage, 0, 1);
            }
        }

        return interpolateVal;
    }

    private static double Interpolate(double[] xvals, double[] yvals, double num)
    {
        for (int i = 0; i < xvals.length - 1; i++)
        {
            double x1 = Math.round(xvals[i] * 10) / 10.0;
            double x2 = Math.round(xvals[i+1] * 10) / 10.0;
            double y1 = yvals[i];
            double y2 = yvals[i+1];

            if (num >= x1 && num <= x2)
            {
                double slope = (y2 - y1) / (x2 - x1);
                double rval = y1+(num - x1)*slope;
                return rval;
            }
        }

        return MISSING;
    }

    private static double Extrapolate(double[] xvals, double[] yvals, double num, int indexUpper, int indexLower)
    {
        double x1 = Math.round(xvals[indexLower] * 10) / 10.0;
        double x2 = Math.round(xvals[indexUpper] * 10) / 10.0;
        double y1 = yvals[indexLower];
        double y2 = yvals[indexUpper];

        double slope = (y2 - y1) / (x2 - x1);
        double rval = y1+(num - x1)*slope;
        return rval;
    }

    private void makeIncrementalStageAndArea()
    {
        for (double x = Math.floor(rawStage[0]); x < Math.ceil(rawStage[rawStage.length - 1]); x = Math.round((x + 0.1) * 10) / 10.0)
        {
            double area2 = lookupArea( x + 0.1);
            double area1 =  lookupArea( x);
            double areaTotal =  lookupArea( x);
            double diff = area2 - area1;

            incrementalStage.add(x);
            incrementalArea.add(diff);
            totalArea.add(areaTotal);
        }
    }

    private double getMin()
    {
        return Math.floor(incrementalStage.get(0));
    }

    private double getMax()
    {
        return Math.ceil(incrementalStage.get(incrementalStage.size() - 1));
    }



    /** makeAreaTable
     *  Use the stage area table to construct an area increment map.
     *  This will hold the number of new acres flooded in 1/10 of a foot
     *  increments. For example the mapped value for 90 is the number of
     *  acres that flood when the stage moves from 90 feet tp 90.1 feet */

    java.util.HashMap<Double, AreaCounter> makeAreaTable()
    {
        java.util.HashMap<Double, AreaCounter> areaTable =
                new java.util.HashMap<Double, AreaCounter>();

        for (int i = 0; i < incrementalStage.size(); i++)
        {
            double stage =incrementalStage.get(i);
            double area = incrementalArea.get(i);
            areaTable.put(stage, new AreaCounter(area, 0));
        }
        return areaTable;
    }


}
