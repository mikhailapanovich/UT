package triangle;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestGetSquare {

    private static final double E = 1e-10;          //todo: epsilon need to be specified

    @DataProvider(name = "dataTriangleArea")
    public Object[][] createDataOrdinaryTriangle() {
        return new Object[][]{
                {3, 4, 5, 6},
                {Math.sqrt(20000), Math.sqrt(30000), Math.sqrt(50000), Math.sqrt(300000000. / 2)},
        };
    }

    @DataProvider(name = "dataInvalidTriangle")
    public Object[][] createDataInvalidTriangle() {
        return new Object[][]{
                {1, 2, 3},
        };
    }

    @Test(dataProvider = "dataTriangleArea")
    public void testAreaCalculation(double a, double b, double c, double areaExpected) {
        Triangle inst = new Triangle(a, b, c);
        assertEquals(inst.getSquare(), areaExpected, E);
    }

    @Test(dataProvider = "dataInvalidTriangle", expectedExceptions = TriangleDoesNotExistException.class)
    public void testGetSquareThrowsExceptionWhenInvalidTriangle(double a, double b, double c) {
        Triangle inst = new Triangle(a, b, c);
        inst.checkTriangle();
        inst.getSquare();
    }
}
