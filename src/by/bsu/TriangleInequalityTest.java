package by.bsu;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleInequalityTest {
    @Test
    public void rightTriangle(){
        assertTrue(TriangleInequality.isTriangleExist(5.0, 4.0, 3.0));
    }

    @Test
    public void allZeroSides() {
        assertThrows(IllegalArgumentException.class, () -> TriangleInequality.isTriangleExist(0, 0, 0));
    }

    @Test
    public void oneZeroSide() {
        assertThrows(IllegalArgumentException.class, () -> TriangleInequality.isTriangleExist(0.0, 4.0, 5.0));
    }

    @Test
    public void oneNegativeSide() {
        assertThrows(IllegalArgumentException.class, () -> TriangleInequality.isTriangleExist(-3.0, 4.0, 5.0));
    }

    @Test
    public void allNegativeSides() {
        assertThrows(IllegalArgumentException.class, () -> TriangleInequality.isTriangleExist(-3.0, -4.0, -5.0));

    }

    @Test
    public void sumOfTwoSidesLessThird() {
        assertFalse(TriangleInequality.isTriangleExist(3.0, 3.0, 6.1));
    }

    @Test
    public void sumOfTwoSidesEqualsThird()  {
        assertFalse(TriangleInequality.isTriangleExist(12.5, 12.5, 25.0));
    }

    @Test
    public void sumOfTwoSidesGreaterThird() {
        assertFalse(TriangleInequality.isTriangleExist(12.6, 99.3, 24.7));
    }

    @Test
    public void allEqualSide(){
        assertTrue(TriangleInequality.isTriangleExist(5.0, 5.0, 5.0));
    }


}
