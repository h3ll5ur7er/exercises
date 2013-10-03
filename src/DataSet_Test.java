/**
 * Tests all functions of DataSet
 * Project: DataSetTester
 * User: Emanuel Knecht
 * Date: 27.09.13
 */
public class DataSet_Test
{
    //Test run

    /**Execute unit- and integration-tests*/
    public static void Run()
    {
        DataSet_Test run = new DataSet_Test();

        boolean initial = run.Initial(run);
        boolean add = run.AddValue(run);
        boolean min = run.GetMin(run);
        boolean max = run.GetMax(run);
        boolean sum = run.GetSum(run);
        boolean average = run.GetAverage(run);

        Boolean passed = initial & add & min & max & sum & average;

        if (passed)
        {
            Debug.Instance().Log.Append("Foo");
        }
    }

    //CodeUnderTest

    private boolean Initial(DataSet_Test run)
    {
        boolean initialSum = run.Initial_InitialValues();

        return initialSum;
    }

    private boolean AddValue(DataSet_Test run)
    {
        boolean increaseByOne = run.AddValue_IncreaseByOne();
        boolean increaseByMinusOne = run.AddValue_IncreaseByMinusOne();

        return increaseByOne & increaseByMinusOne;
    }

    private boolean GetMin(DataSet_Test run)
    {
        boolean minimumPositive = run.GetMin_MinimumPositive();
        boolean minimumNegative = run.GetMin_MinimumNegative();

        return minimumPositive & minimumNegative;
    }

    private boolean GetMax(DataSet_Test run)
    {
        boolean maximumPositive = run.GetMax_MaximumPositive();
        boolean maximumNegative = run.GetMax_MaximumNegative();

        return maximumPositive & maximumNegative;
    }

    private boolean GetSum(DataSet_Test run)
    {
        boolean sumOfMany = run.GetSum_SumOfMany();

        return sumOfMany;
    }

    private boolean GetAverage(DataSet_Test run)
    {
        boolean averageOfMany = run.GetAverage_AverageOfMany();

        return averageOfMany;
    }

    //Tests

    private boolean Initial_InitialValues()
    {
        DataSet set = CreateEmptyDataSet();

        return
                set.sum == 0 &
                set.count == 0 &
                set.max == Integer.MAX_VALUE &
                set.min == Integer.MIN_VALUE;
    }

    private boolean AddValue_IncreaseByOne()
    {
        return AssertIncrement(1);
    }

    private boolean AddValue_IncreaseByMinusOne()
    {
        return AssertIncrement(-1);
    }

    private boolean AddValue_IncreaseByZero()
    {
        return AssertIncrement(0);
    }

    private boolean AddValue_IncreaseByIntegerMaxValue()
    {
        return AssertIncrement(Integer.MAX_VALUE);
    }

    private boolean AddValue_IncreaseByIntegerMaxValuePlusOne()
    {
        DataSet set = CreateEmptyDataSet();

        set.addValue(Integer.MAX_VALUE + 1);

        return set.sum == Integer.MAX_VALUE + 1;
    }

    private boolean AddValue_IncreaseByIntegerMinValue()
    {
        return AssertIncrement(Integer.MIN_VALUE);
    }

    private boolean AddValue_IncreaseByIntegerMinValueMinusOne()
    {
        return AssertIncrement(Integer.MIN_VALUE - 1);
    }

    private boolean GetMin_MinimumPositive()
    {
        DataSet set = CreateDataSetWithOnePositiveElement();
        return set.getMin()== 42;
    }

    private boolean GetMin_MinimumNegative()
    {
        DataSet set = CreateDataSetWithOneNegativeElement();
        return set.getMin()== -13;
    }

    private boolean GetMax_MaximumPositive()
    {
        DataSet set = CreateDataSetWithOnePositiveElement();
        return set.getMax()== 42;
    }

    private boolean GetMax_MaximumNegative()
    {
        DataSet set = CreateDataSetWithOneNegativeElement();
        return set.getMax()== -13;
    }

    private boolean GetSum_SumOfMany()
    {
        DataSet set = CreateDataSetMoreElements();
        return set.getSum()== 153;
    }

    private boolean GetAverage_AverageOfMany()
    {
        DataSet set = CreateDataSetMoreElements();

        return Math.abs(set.getAverage()-(153/7))<0.0001;
    }

    //Helpers

    private boolean AssertIncrement(int value)
    {
        DataSet set = CreateEmptyDataSet();

        set.addValue(value);

        return set.getSum()== value;
    }

    //Factories

    private DataSet CreateEmptyDataSet()
    {
        return new DataSet();
    }

    private DataSet CreateDataSetWithOneNegativeElement()
    {
        DataSet ds = new DataSet();
        ds.addValue(-13);
        return ds;
    }

    private DataSet CreateDataSetWithOnePositiveElement()
    {
        DataSet ds = CreateEmptyDataSet();
        ds.addValue(42);
        return ds;
    }

    private DataSet CreateDataSetMoreElements()
    {
        DataSet ds = CreateEmptyDataSet();
        ds.addValue(123);
        ds.addValue(0);
        ds.addValue(24);
        ds.addValue(42);
        ds.addValue(-42);
        ds.addValue(4);
        ds.addValue(2);
        return ds;
    }
}
