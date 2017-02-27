package ru.unn.agile.IntersectLineAndPlane.model;

import org.junit.Test;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;



public class IntercectionLineAndPlaneTest {
    private final double delta = 0.001;

    @Test
    public void canCreateLineWhithInitialValues() {
        Line3D line = new Line3D(1, 1, 1, 1, 1, 1);
        assertNotNull(line);
    }

    @Test
    public void canSetInitialLValueOfLine() {
        Line3D lane = new Line3D(2.1, 3.2, 4.5, 1.2, 2.3, 4.1);
        assertEquals(2.1, lane.getL(), delta);
    }

    @Test
    public void canSetInitialMValue() {
        Line3D lane = new Line3D(2.1, 3.2, 4.5, 1.2, 2.3, 4.1);
        assertEquals(3.2, lane.getM(), delta);
    }

    @Test
    public void canSetInitialNValue() {
        Line3D line = new Line3D(2.1, 3.2, 4.5, 1.2, 2.3, 4.1);
        assertEquals(4.5, line.getN(), delta);
    }

    @Test
    public void canSetInitialX0Value() {
        Line3D line = new Line3D(2.1, 3.2, 4.5, 1.2, 2.3, 4.1);
        assertEquals(1.2, line.getX0(), delta);
    }

    @Test
    public void canSetInitialY0Value() {
        Line3D line = new Line3D(2.1, 3.2, 4.5, 1.2, 2.3, 4.1);
        assertEquals(2.3, line.getY0(), delta);
    }

    @Test
    public void canSetInitialZ0Value() {
        Line3D line = new Line3D(2.1, 3.2, 4.5, 1.2, 2.3, 4.1);
        assertEquals(4.1, line.getZ0(), delta);
    }

    @Test
    public void canCreatePlaneWhithInitialValues() {
        Plane3D plane = new Plane3D(1, 1, 1, 1);
        assertNotNull(plane);
    }

    @Test
    public void canSetInitialAValueOfPlane() {
        Plane3D plane = new Plane3D(2.1, 3.2, 4.5, 1.2);
        assertEquals(2.1, plane.getA(), delta);
    }

    @Test
    public void canSetInitialBValueOfPlane() {
        Plane3D plane = new Plane3D(2.1, 3.2, 4.5, 1.2);
        assertEquals(3.2, plane.getB(), delta);
    }

    @Test
    public void canSetInitialCValueOfPlane() {
        Plane3D plane = new Plane3D(2.1, 3.2, 4.5, 1.2);
        assertEquals(4.5, plane.getC(), delta);
    }

    @Test
    public void canSetInitialDValueOfPlane() {
        Plane3D plane = new Plane3D(2.1, 3.2, 4.5, 1.2);
        assertEquals(1.2, plane.getD(), delta);
    }

    @Test
    public void canCreatePointIntersectLineAndPlane() {
        Line3D line = new Line3D(2, -1, 3, 4, 2, 6);
        Plane3D plane = new Plane3D(1, -2, 5, -3);
        assertNotNull(line.checkIntersection(plane));
    }

    @Test
    public void showThatLineAndPlaneAreParallel() {
        Line3D line = new Line3D(0.5, 0.25, 8, 7, 2.2, 1.);
        Plane3D plane = new Plane3D(2, 4, -0.25, 3);
        assertEquals("Line and plane parallel", line.checkIntersection(plane));
    }

    @Test
    public void showThatLineLiesInThePlane() {
        Line3D line = new Line3D(0.5, 0.25, 8, 0.5, 0.25, 4);
        Plane3D plane = new Plane3D(2, 4, -0.25, -1);
        assertEquals("Line lies in the plane", line.checkIntersection(plane));
    }
}
