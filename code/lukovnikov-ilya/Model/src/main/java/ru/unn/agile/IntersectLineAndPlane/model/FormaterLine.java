package ru.unn.agile.IntersectLineAndPlane.model;


public final class FormaterLine {
    private FormaterLine() {
    }


    public static String getFormatedLine(final Line3D line) {
        StringBuffer buffer = new StringBuffer();
        if (line.getL() == 0.0 & line.getM() == 0.0 & line.getN() == 0.0) {
            throw new IllegalArgumentException("Coordinates of vector l, m, n can't be null");
        } else {
                double coordinateX0 = FormaterPlane.formatPositiveDouble(line.getX0());
                buffer.append("{ x=");
                buffer.append(line.getX0() < 0 ? "-" : "");
                buffer.append(coordinateX0);
                double coordinateL = FormaterPlane.formatPositiveDouble(line.getL());
                buffer.append(line.getL() < 0 ? "-" : "+");
                buffer.append(coordinateL + "t; y=");
                double coordinateY0 = FormaterPlane.formatPositiveDouble(line.getY0());
                buffer.append(line.getY0() < 0 ? "-" : "");
                buffer.append(coordinateY0);
                double coordinateM = FormaterPlane.formatPositiveDouble(line.getM());
                buffer.append(line.getM() < 0 ? "-" : "+");
                buffer.append(coordinateM + "t; z=");
                double coordinateZ0 = FormaterPlane.formatPositiveDouble(line.getZ0());
                buffer.append(line.getZ0() < 0 ? "-" : "");
                buffer.append(coordinateZ0);
                double coordinateN = FormaterPlane.formatPositiveDouble(line.getN());
                buffer.append(line.getN() < 0 ? "-" : "+");
                buffer.append(coordinateN + "t }");
                return buffer.toString();
            }

    }
}
