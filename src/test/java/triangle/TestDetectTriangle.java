package triangle;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestDetectTriangle {
    private Triangle triangle;

    @DataProvider(name = "dataOrdinaryTriangle")
    public Object[][] createDataOrdinaryTriangle() {
        triangle = new Triangle(0, 0, 0);
        return new Object[][]{
                {4, 5, 6, triangle.TR_ORDYNARY},
                {6, 4, 5, triangle.TR_ORDYNARY},
                {5, 6, 4, triangle.TR_ORDYNARY},
        };
    }

    @DataProvider(name = "dataSimpleIsoscelesTriangle")
    public Object[][] createSimpleIsoscelesTriangle() {
        triangle = new Triangle(0, 0, 0);
        return new Object[][]{
                {3, 3, 1, triangle.TR_ISOSCELES},
                {3, 1, 3, triangle.TR_ISOSCELES},
                {1, 3, 3, triangle.TR_ISOSCELES},
        };
    }

    @DataProvider(name = "dataSimpleEquilateralTriangle")
    public Object[][] createSimpleEquilateralTriangle() {
        triangle = new Triangle(0, 0, 0);
        return new Object[][]{
                {3, 3, 3, triangle.TR_EQUILATERAL | triangle.TR_ISOSCELES},
        };
    }

    @DataProvider(name = "dataSimpleRectangularTriangle")
    public Object[][] createDataSimpleRectangularTriangle() {
        triangle = new Triangle(0, 0, 0);
        return new Object[][]{
                {3, 4, 5, triangle.TR_RECTANGULAR},
                {5, 3, 4, triangle.TR_RECTANGULAR},
                {4, 5, 3, triangle.TR_RECTANGULAR},
                {3 * 1e-14, 4 * 1e-14, 5 * 1e-14, triangle.TR_RECTANGULAR},
                {5 * 1e-14, 3 * 1e-14, 4 * 1e-14, triangle.TR_RECTANGULAR},
                {4 * 1e-14, 5 * 1e-14, 3 * 1e-14, triangle.TR_RECTANGULAR},
        };
    }

    // template dataprovider for overflow tests
    @DataProvider(name = "dataOrdinaryTriangleWithBigSides")
    public Object[][] createOrdinaryTriangleWithBigSides() {
        triangle = new Triangle(0, 0, 0);
        return new Object[][]{
                {1, 1.1, 1.2, triangle.TR_ORDYNARY},
        };
    }

    @DataProvider(name = "dataInvalidTriangle")
    public Object[][] createDataInvalidTriangle() {
        return new Object[][]{
                {1, 2, 3},
        };
    }


    @Test(dataProvider = "dataOrdinaryTriangle")
    public void testTriangleIsOrdinary(double a, double b, double c, int stateExpected) {
        triangle = new Triangle(a, b, c);
        int stateActual = triangle.detectTriangle();
        assertEquals(stateActual, stateExpected);
    }

    @Test(dataProvider = "dataSimpleIsoscelesTriangle")
    public void testTriangleIsOnlyIsosceles(double a, double b, double c, int stateExpected) {
        triangle = new Triangle(a, b, c);
        int stateActual = triangle.detectTriangle();
        assertEquals(stateActual, stateExpected);
    }

    @Test(dataProvider = "dataSimpleEquilateralTriangle")
    public void testTriangleIsEquilateralAndIsosceles(double a, double b, double c, int stateExpected) {
        triangle = new Triangle(a, b, c);
        int stateActual = triangle.detectTriangle();
        assertEquals(stateActual, stateExpected);
    }

    @Test(dataProvider = "dataSimpleRectangularTriangle")
    public void testTriangleIsOnlyRectangular(double a, double b, double c, int stateExpected) {
        triangle = new Triangle(a, b, c);
        int stateActual = triangle.detectTriangle();
        assertEquals(stateActual, stateExpected);
    }

    @Test(dataProvider = "dataInvalidTriangle", expectedExceptions = TriangleDoesNotExistException.class)
    public void testDetectTriangleThrowsExceptionWhenInvalidTriangle(double a, double b, double c) {
        Triangle inst = new Triangle(a, b, c);
        inst.checkTriangle();
        inst.detectTriangle();
    }
}
