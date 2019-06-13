package enviroduck;
import hec.io.PairedDataContainer;

public class AreaCalculator {

    public AreaCalculator(double[] x, double[] y)
    {
        this.rawStage = x;
        this.rawArea = y;
    }

    public double rawStage[];
    public double rawArea[];
    public double incrementalStage[];
    public double incrementalArea[];

    public double LinearInterpolate(double[] xvals, double[] yvals, double num)
    {

        if (xvals.length == 0 || num < xvals[0] || num > xvals[xvals.length - 1])
        {
            return -1;
        }

        for (int i = 0; i < xvals.length; i++)
        {
            double x1 = xvals[i];
            double x2 = xvals[i+1];
            double y1 = yvals[i];
            double y2 = yvals[i+1];

            if (num >= x1 && num <= x2)
            {
                double slope = (y2 - y1) / (x2 - x1);
                double rval = y1+(num - x1)*slope;
                return rval;
            }
        }
        return -2;
    }

}
