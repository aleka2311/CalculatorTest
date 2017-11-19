import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Double.NaN;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test(dataProvider = "sumLongTestData")
    public void sumLongTest(long firstNumber, long secondNumber, long expectedResult) {
        Assert.assertEquals(calculator.sum(firstNumber, secondNumber), expectedResult);
    }

    @DataProvider
    public Object[][] sumLongTestData() {
        return new Object[][]{
                {5, 6, 11},
                {50, 40, 90},
                {10, 58, 68},
                {10025, -498415, -488390}
        };
    }

    @Test(dataProvider = "sumDoubleTestData")
    public void sumDoubleTest(double firstNumber, double secondNumber, double expectedResult) {
        Assert.assertEquals(calculator.sum(firstNumber, secondNumber), expectedResult);
    }

    @DataProvider
    public Object[][] sumDoubleTestData() {
        return new Object[][]{
                {3.2, 4.8, 8.0},
                {50.001, 0.002, 50.003},
                {-10.697, 21.47, 10.773},
                {10.58, 21.47, 32.05}
        };
    }
    @Test(dataProvider = "subLongTestData")
    public void subLongTest(long firstNumber, long secondNumber, long expectedResult) {
        Assert.assertEquals(calculator.sub(firstNumber, secondNumber), expectedResult);
    }

    @DataProvider
    public Object[][] subLongTestData() {
        return new Object[][]{
                {11, 6, 5},
                {90, 40, 50},
                {68, 58, 10},
                {488390, 498415, -10025}
        };
    }
    @Test(dataProvider = "subDoubleTestData")
    public void subDoubleTest(double firstNumber, double secondNumber, double expectedResult, double delta) {
        Assert.assertEquals(calculator.sub(firstNumber, secondNumber), expectedResult, delta);
    }

    @DataProvider
    public Object[][] subDoubleTestData() {
        return new Object[][]{
                {8.0, 4.8, 3.2, 0.001},
                {50.003, 0.002, 50.001, 0.001},
                {-12.02, -56.056, 44.036, 0.001},
                {32.05, 21.47, 10.58, 0.001}
        };
    }
    @Test(dataProvider = "multLongTestData")
    public void multLongTest(long firstNumber, long secondNumber, long expectedResult) {
        Assert.assertEquals(calculator.mult(firstNumber, secondNumber), expectedResult);
    }

    @DataProvider
    public Object[][] multLongTestData() {
        return new Object[][]{
                {11, 6, 66},
                {90, -40,-3600 },
                {-68, -58, 3944},
                      };
    }
    @Test(dataProvider = "multDoubleTestData")
    public void multDoubleTest(double firstNumber, double secondNumber, double expectedResult, double delta) {
         Assert.assertEquals(calculator.mult(firstNumber, secondNumber), expectedResult, delta);
         //1
            }

    @DataProvider
    public Object[][] multDoubleTestData() {
        return new Object[][]{
                {8.0, 4.8, 38.4, 0.001},
                {50.003, -5, -250.01, 0.001},
                {-12.02, -56.56, 679.8512, 0.0001}
        };
    }

    @Test(expectedExceptions = {NumberFormatException.class})
    public void divLongTest(){
    long result=calculator.div(5,0);
    Assert.assertEquals(calculator.div(6,2), 3);
    }

    @Test (dataProvider = "divDoubleTestData")
    public void divDoubleTest(double firstNumber, double secondNumber, double expectedResult, double delta) {
        Assert.assertEquals(calculator.div(firstNumber, secondNumber), expectedResult, delta);

    }
    @DataProvider
    public Object[][] divDoubleTestData() {
        return new Object[][]{
                {8.0, 4.0, 2.0, 0.001},
                {50.05, -5, -10.01, 0.001},

        };
    }
    @Test (dataProvider = "powTestData")
    public void powTest(double firstNumber, double secondNumber, double expectedResult, double delta) {
        Assert.assertEquals(calculator.pow(firstNumber, secondNumber), expectedResult, delta);
        //2
    }
    @DataProvider
    public Object[][] powTestData() {
        return new Object[][]{
                {8.0, 4.0, 4096.0, 0.001},
                {5.2, 2.3, 44.3412253379, 0.001},

        };
    }
    @Test (dataProvider = "sqrtTestData")
    public void sqrtTest(double number, double expectedResult, double delta) {
        Assert.assertEquals(calculator.sqrt(number), expectedResult, delta);
//3
    }
    @DataProvider
    public Object[][] sqrtTestData() {
        return new Object[][]{
                {16.0, 4.0, 0.001},
                 {-16.0, NaN, 0.001}
           };
    }

    @Test (dataProvider = "tgTestData")
    public void tgTest(double number, double expectedResult, double delta) {
        Assert.assertEquals(calculator.tg(number), expectedResult, delta);
//4

    }
    @DataProvider
    public Object[][] tgTestData() {
        return new Object[][]{
                {0, 0, 0.001},
                {-16.0, -0.2867453858, 0.001}
                //Что такое НАН?

        };
    }
    @Test (dataProvider = "сtgTestData")
    public void сtgTest(double number, double expectedResult, double delta) {
        Assert.assertEquals(calculator.ctg(number), expectedResult, delta);
//5

    }
    @DataProvider
    public Object[][] сtgTestData() {
        return new Object[][]{
                {0, NaN, 0.001},
                {-16.0, -3.4874144438, 0.001}
                 };
    }
    @Test (dataProvider = "cosTestData")
    public void cosTest(double number, double expectedResult, double delta) {
        Assert.assertEquals(calculator.cos(number), expectedResult, delta);
    //6

    }
    @DataProvider
    public Object[][] cosTestData() {
        return new Object[][]{
                {0, 1.0, 0.001},
                {-16.0, -0.9612616959, 0.001}
        };
    }
    @Test (dataProvider = "sinTestData")
    public void sinTest(double number, double expectedResult, double delta) {
        Assert.assertEquals(calculator.sin(number), expectedResult, delta);
           }
    @DataProvider
    public Object[][] sinTestData() {
        return new Object[][]{
                {0, 0, 0.001},
                {2.5, 0.5984721441039564, 0.001}
        };
    }

    @Test(dataProvider = "isPositiveTestData")
    public void isPositiveTest(long val, boolean expectedResult){
Assert.assertEquals(calculator.isPositive(val), expectedResult);

    }
    @DataProvider
    public Object[][] isPositiveTestData() {
        return new Object[][]{
                {0, false},
                {16, true},
                {-16, false}
        };
    }
    @Test(dataProvider = "isNegativeTestData")
    public void isNegativeTest(long val, boolean expectedResult){
        Assert.assertEquals(calculator.isNegative(val), expectedResult);

    }
    @DataProvider
    public Object[][] isNegativeTestData() {
        return new Object[][]{
                {0, false},
                {16, false},
                {-16, true}
        };
    }
}
