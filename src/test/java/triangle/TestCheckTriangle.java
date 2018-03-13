package triangle;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class TestCheckTriangle {
    private Triangle triangle;
    
    @DataProvider(name = "dataWithSideLessThanZero")
    public Object[][] createDataWithSideLessThanZero() {
        return new Object[][]{
                {-1, 1, 1, "a<=0"},
                {1, -1, 1, "b<=0"},
                {1, 1, -1, "c<=0"},
        };
    }

    @DataProvider(name = "dataWithSideEqualToZero")
    public Object[][] createDataWithSideEqualToZero() {
        return new Object[][]{
                {0, 1, 1, "a<=0"},
                {1, 0, 1, "b<=0"},
                {1, 1, 0, "c<=0"},
        };
    }

    @DataProvider(name = "dataWithTwoSidesLessThanThird")
    public Object[][] createDataWithTwoSidesLessThanThird() {
        return new Object[][]{
                {3, 1, 1, "b+c<=a"},
                {1, 3, 1, "a+c<=b"},
                {1, 1, 3, "a+b<=c"},
        };
    }
    @DataProvider(name = "dataWithTwoSidesEqualToThird")
    public Object[][] createDataWithTwoSidesEqualToThird() {
        return new Object[][]{
                {2, 1, 1, "b+c<=a"},
                {1, 2, 1, "a+c<=b"},
                {1, 1, 2, "a+b<=c"},
        };
    }

    @Test
    public void testAllSidesAreZero() {
        triangle = new Triangle(0, 0, 0);
        assertFalse(triangle.checkTriangle());
        System.out.println(triangle.getMessage());
    }

    @Test(dataProvider = "dataWithSideLessThanZero")
    public void testSideLessThanZero(double a, double b, double c, String message) {
        triangle = new Triangle(a, b, c);
        assertFalse(triangle.checkTriangle());
        assertEquals(triangle.getMessage(), message);
    }

    @Test(dataProvider = "dataWithSideLessThanZero")
    public void testSideEqualToZero(double a, double b, double c, String message) {
        triangle = new Triangle(a, b, c);
        assertFalse(triangle.checkTriangle());
        assertEquals(triangle.getMessage(), message);
    }

    @Test(dataProvider = "dataWithTwoSidesLessThanThird")
    public void testTwoSidesLessThanThird(double a, double b, double c, String message) {
        triangle = new Triangle(a, b, c);
        assertFalse(triangle.checkTriangle());
        assertEquals(triangle.getMessage(), message);
    }

    @Test(dataProvider = "dataWithTwoSidesEqualToThird")
    public void testTwoSidesEqualToThird(double a, double b, double c, String message) {
        triangle = new Triangle(a, b, c);
        assertFalse(triangle.checkTriangle());
        assertEquals(triangle.getMessage(), message);
    }
}
