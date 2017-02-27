package ru.unn.agile.IntersectLineAndPlane.model;

import org.junit.Test;



import static org.junit.Assert.assertEquals;


public class FormaterPlaneTest {
    @Test
    public void canFormatToFormulaForDefaultPlane() {
        Plane3D plane = new Plane3D(2.1, 1.1, 4.2, 2.4);
        assertEquals("2.1x+1.1y+4.2z+2.4=0", plane.toFormula());
    }

    @Test
    public void canFormatToFormulaPlaneWithAllNegativeArguments() {
        Plane3D plane = new Plane3D(-2.1, -1.1, -4.2, -1.1);
        assertEquals("-2.1x-1.1y-4.2z-1.1=0", plane.toFormula());
    }

    @Test
    public void canFormatToFormulaPlaneWithNegativeArgumentA() {
        Plane3D plane = new Plane3D(-2.1, 1.1, 4.2, 1.1);
        assertEquals("-2.1x+1.1y+4.2z+1.1=0", plane.toFormula());
    }
    @Test
    public void canFormatToFormulaWithNegativeArgumentB() {
        Plane3D plane = new Plane3D(2.1, -1.1, 4.2, 1.1);
        assertEquals("2.1x-1.1y+4.2z+1.1=0", plane.toFormula());
    }
    @Test
    public void canFormatToFormulaWithNegativeArgumentC() {
        Plane3D plane = new Plane3D(2.1, 1.1, -4.2, 1.1);
        assertEquals("2.1x+1.1y-4.2z+1.1=0", plane.toFormula());
    }
    @Test
    public void canFormatToFormulaWithNegativeArgumentD() {
        Plane3D plane = new Plane3D(2.1, 1.1, 4.2, -1.1);
        assertEquals("2.1x+1.1y+4.2z-1.1=0", plane.toFormula());
    }
    @Test (expected = IllegalArgumentException.class)
    public void cannotFormatToFormulaWithZeroArgumentsABC() {
        Plane3D plane = new Plane3D(0, 0, 0, -3.2);
        plane.toFormula();
    }
}
