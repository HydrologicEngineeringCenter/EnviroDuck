package enviroduck;
import java.util.*;

public class AreaCalculator {

    private static final double MISSING=-998877.0;

    public AreaCalculator(double[] x, double[] y)
    {
        this.rawStage = x;
        this.rawArea = y;
        makeIncrementalStageAndArea();
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
            double diff = area2 - area1;

            incrementalStage.add(x);
            incrementalArea.add(diff);
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

    private double rawStage[];
    private double rawArea[];
     List<Double> incrementalStage = new ArrayList<Double>();
     List<Double> incrementalArea = new ArrayList<Double>();

}
