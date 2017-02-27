package ru.unn.agile.IntersectLineAndPlane.model;


public final class  FormaterPlane {
    private FormaterPlane() { }

    public static double formatPositiveDouble(final double value) {
        if (value < 0) {
            return -value;
        } else {
            return value;
        }
    }

    public static String getFormatedPlane(final Plane3D plane) {
        StringBuffer buffer = new StringBuffer();
        if (plane.getA() == 0.0 & plane.getB() == 0.0 & plane.getC() == 0.0) {
            throw new IllegalArgumentException("arguments A, B, C can't be null");
        } else {
            double coefficientA = formatPositiveDouble(plane.getA());
            buffer.append(plane.getA() < 0 ? "-" : "");
            buffer.append(coefficientA + "x");
            double coefficientB = formatPositiveDouble(plane.getB());
            buffer.append(plane.getB() < 0 ? "-" : "+");
            buffer.append(coefficientB + "y");
            double coefficientC = formatPositiveDouble(plane.getC());
            buffer.append(plane.getC() < 0 ? "-" : "+");
            buffer.append(coefficientC + "z");
            double coefficientD = formatPositiveDouble(plane.getD());
            buffer.append(plane.getD() < 0 ? "-" : "+");
            buffer.append(coefficientD);
            buffer.append("=0");
            return buffer.toString();
        }
    }
}
