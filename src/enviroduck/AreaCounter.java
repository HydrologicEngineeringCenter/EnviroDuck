package enviroduck;

class AreaCounter {
    public AreaCounter(double a, int c)
    {
        area = a;
        count = c;
    }

    public String toString() { return "{area: " + area + " count: " + count + "}"; }

    public double area;
    public int count;
}
