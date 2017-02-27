package ru.unn.agile.IntersectLineAndPlane.model;
import org.junit.Test;



import static org.junit.Assert.assertEquals;

public class FormaterLineTest {

    @Test
    public void canFormatToFormulaForDefaultLine() {
        Line3D line = new Line3D(2.1, 1.1, 4.2, 2.4, 2.3, 5.1);
        assertEquals("{ x=2.4+2.1t; y=2.3+1.1t; z=5.1+4.2t }", line.toFormulaLine());
    }
    @Test
    public void canFormatToFormulaLineWithAllNegativeArguments() {
        Line3D line = new Line3D(-2.1, -1.1, -4.2, -2.4, -2.3, -5.1);
        assertEquals("{ x=-2.4-2.1t; y=-2.3-1.1t; z=-5.1-4.2t }", line.toFormulaLine());
    }
    @Test
    public void canFormatToFormulaLineWithNegativeCoordinateX0() {
        Line3D line = new Line3D(2.1, 1.1, 4.2, -2.4, 2.3, 5.1);
        assertEquals("{ x=-2.4+2.1t; y=2.3+1.1t; z=5.1+4.2t }", line.toFormulaLine());
    }
    @Test
    public void canFormatToFormulaLineWithNegativeCoordinateL() {
        Line3D line = new Line3D(-2.1, 1.1, 4.2, 2.4, 2.3, 5.1);
        assertEquals("{ x=2.4-2.1t; y=2.3+1.1t; z=5.1+4.2t }", line.toFormulaLine());
    }
    @Test
    public void canFormatToFormulaLineWithNegativeCoordinateY0() {
        Line3D line = new Line3D(2.1, 1.1, 4.2, 2.4, -2.3, 5.1);
        assertEquals("{ x=2.4+2.1t; y=-2.3+1.1t; z=5.1+4.2t }", line.toFormulaLine());
    }
    @Test
    public void canFormatToFormulaLineWithNegativeCoordinateM() {
        Line3D line = new Line3D(2.1, -1.1, 4.2, 2.4, 2.3, 5.1);
        assertEquals("{ x=2.4+2.1t; y=2.3-1.1t; z=5.1+4.2t }", line.toFormulaLine());
    }
    @Test
    public void canFormatToFormulaLineWithNegativeCoordinateZ0() {
        Line3D line = new Line3D(2.1, 1.1, 4.2, 2.4, 2.3, -5.1);
        assertEquals("{ x=2.4+2.1t; y=2.3+1.1t; z=-5.1+4.2t }", line.toFormulaLine());
    }
    @Test
    public void canFormatToFormulaLineWithNegativeCoordinateN() {
        Line3D line = new Line3D(2.1, 1.1, -4.2, 2.4, 2.3, 5.1);
        assertEquals("{ x=2.4+2.1t; y=2.3+1.1t; z=5.1-4.2t }", line.toFormulaLine());
    }
    @Test (expected = IllegalArgumentException.class)
    public void cannotFormatToFormulaLineWithZeroCoordinatesOfVector() {
        Line3D line = new Line3D(0, 0, 0, -3.2, 1.1, 2.4);
        line.toFormulaLine();
    }
}
