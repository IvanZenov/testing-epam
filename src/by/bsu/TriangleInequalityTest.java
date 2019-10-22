package by.bsu;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class TriangleInequalityTest {
    @Test
    public void rightTriangle() {
        assertTrue(TriangleInequality.isTriangleExists(5.0, 4.0, 3.0));
    }

    @Test
    public void allZeroSides() {
        assertFalse(TriangleInequality.isTriangleExists(0.0, 0.0, 0.0));
    }

    @Test
    public void oneZeroSide() {
       assertFalse(TriangleInequality.isTriangleExists(0.0,4.0,5.0));
    }

    @Test
    public void oneNegativeSide() {
        assertFalse(TriangleInequality.isTriangleExists(-3.0, 4.0, 5.0));
    }

    @Test
    public void allNegativeSides() {
        assertFalse(TriangleInequality.isTriangleExists(-3.0, -4.0, -5.0));
    }

    @Test
    public void sumOfTwoSidesLessThird() {
        assertFalse(TriangleInequality.isTriangleExists(3.0, 3.0, 6.1));
    }

    @Test
    public void sumOfTwoSidesEqualsThird() {
        assertFalse(TriangleInequality.isTriangleExists(12.5, 12.5, 25.0));
    }

    @Test
    public void sumOfTwoSidesGreaterThird() {
        assertFalse(TriangleInequality.isTriangleExists(12.6, 99.3, 24.7));
    }

    @Test
    public void allEqualSide() {
        assertTrue(TriangleInequality.isTriangleExists(5.0, 5.0, 5.0));
    }

    @Test
    public void oneSideIsMaxDouble() {
        assertFalse(TriangleInequality.isTriangleExists(Double.MAX_VALUE,5.0,4.0));
    }


}
