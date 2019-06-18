package enviroduck;
import java.util.*;

public class AreaCalculator {

    public AreaCalculator(double[] x, double[] y)
    {
        this.rawStage = x;
        this.rawArea = y;
        makeIncrementalStageAndArea();
    }

    private double FindArea(double[] xvals, double[] yvals, double num)
    {

        if (xvals.length == 0 || num < Math.floor(xvals[0]) || num > Math.ceil(xvals[xvals.length - 1]))
        {
            return -1;
        }

        double interpolateVal = Interpolate(xvals, yvals, num);
        if (interpolateVal == -1.0)
        {
            if (num >= Math.round(xvals[xvals.length - 1] * 10) / 10.0)
            {
                return Extrapolate(xvals, yvals, num, xvals.length - 2, xvals.length - 1);
            } else
            {
                return Extrapolate(xvals, yvals, num, 0, 1);
            }
        }

        return interpolateVal;
    }

    double Interpolate(double[] xvals, double[] yvals, double num)
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

        return -1.0;
    }

    double Extrapolate(double[] xvals, double[] yvals, double num, int indexUpper, int indexLower)
    {
        double x1 = Math.round(xvals[indexLower] * 10) / 10.0;
        double x2 = Math.round(xvals[indexUpper] * 10) / 10.0;
        double y1 = yvals[indexLower];
        double y2 = yvals[indexUpper];

        double slope = (y2 - y1) / (x2 - x1);
        double rval = y1+(num - x1)*slope;
        return rval;
    }

    void makeIncrementalStageAndArea()
    {
        for (double x = Math.floor(rawStage[0]); x < Math.ceil(rawStage[rawStage.length - 1]); x = Math.round((x + 0.1) * 10) / 10.0)
        {
            double area2 = FindArea(rawStage, rawArea, x + 0.1);
            double area1 =  FindArea(rawStage, rawArea, x);
            double diff = area2 - area1;

            incrementalStage.add(x);
            incrementalArea.add(diff);
        }
    }

    double getMin()
    {
        return Math.floor(incrementalStage.get(0));
    }

    double getMax()
    {
        return Math.ceil(incrementalStage.get(incrementalStage.size() - 1));
    }

    private double rawStage[];
    private double rawArea[];
    public List<Double> incrementalStage = new ArrayList<Double>();
    public List<Double> incrementalArea = new ArrayList<Double>();

}
