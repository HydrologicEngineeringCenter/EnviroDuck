package enviroduck;

class AreaCounter extends Object
{
    public AreaCounter(double a, int c)
    {
        area = a;
        count = c;
    }

    public String toString() { return "{area: " + area + " count: " + count + "}"; }

    public double area;
    public int count;
}
