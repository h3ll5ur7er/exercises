/**
 * Project: DataSetTester
 * User: Emanuel Knecht
 * Date: 27.09.13
 */
public class DataSet
{
    public int min = 0, max = 0, sum = 0, count = 0;

    public void addValue(int value)
    {
        if (value<min)
            this.min = value;

        if (value>max)
            this.max = value;

        this.sum += value;

        this.count++;
    }

    public int getMin()
    {
        if (this.count != 0)
                return min;
        else
            return Integer.MIN_VALUE; // replace by exception handling..
    }

    public int getMax()
    {
        if (this.count != 0)
            return max;
        else
            return Integer.MAX_VALUE; // replace by exception handling..
    }

    public int getSum()
    {
        return sum;
    }

    public float getAverage()
    {
        return (float) this.sum / (float) this.count;
    }
}
