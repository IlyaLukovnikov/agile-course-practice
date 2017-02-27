package ru.unn.agile.IntersectLineAndPlane.model;




public class Line3D {
    private final double coordinateOfVectorL;
    private final double coordinateOfVectorM;
    private final double coordinateOfVectorN;
    private final double coordinateOfPointX0;
    private final double coordinateOfPointY0;
    private final double coordinateOfPointZ0;


    public Line3D(final double l, final double m, final double n,
                  final double x0, final double y0, final double z0) {
        this.coordinateOfVectorL = l;
        this.coordinateOfVectorM = m;
        this.coordinateOfVectorN = n;
        this.coordinateOfPointX0 = x0;
        this.coordinateOfPointY0 = y0;
        this.coordinateOfPointZ0 = z0;
    }
    public Line3D(final String l, final String m, final String n,
                  final String x0, final String y0, final String z0) {
        this.coordinateOfVectorL = Double.parseDouble(l);
        this.coordinateOfVectorM = Double.parseDouble(m);
        this.coordinateOfVectorN = Double.parseDouble(n);
        this.coordinateOfPointX0 = Double.parseDouble(x0);
        this.coordinateOfPointY0 = Double.parseDouble(y0);
        this.coordinateOfPointZ0 = Double.parseDouble(z0);
    }

    public double getL() {
        return coordinateOfVectorL;
    }
    public double getM() {
        return coordinateOfVectorM;
    }
    public double getN() {
        return coordinateOfVectorN;
    }
    public double getX0() {
        return coordinateOfPointX0;
    }
    public double getY0() {
        return coordinateOfPointY0;
    }
    public double getZ0() {
        return coordinateOfPointZ0;
    }
    public String toFormulaLine() {
        return FormaterLine.getFormatedLine(this);
    }

    public String checkIntersection(final Plane3D plane) {
        double coordinateX, coordinateY, coordinateZ, parametrT;
        parametrT = (-plane.getD() - plane.getC() * getZ0() - plane.getB() * getY0()
                - plane.getA() * getX0()) / (plane.getA() * getL() + plane.getB()
                * getM() + plane.getC() * getN());
        coordinateX = getX0() + getL() * parametrT;
        coordinateY = getY0() + getM() * parametrT;
        coordinateZ = getZ0() + getN() * parametrT;
        if (plane.getA() * getL() + plane.getB() * getM() + plane.getC() * getN() == 0
                & plane.getA() * getX0() + plane.getB() * getY0() + plane.getC()
                * getZ0() + plane.getD() != 0) {
            return "Line and plane parallel";
        } else if (plane.getA() * getX0() + plane.getB() * getY0() + plane.getC()
                * getZ0() + plane.getD() == 0) {
            return "Line lies in the plane";
        } else {
            return "Intersection point (" + coordinateX + "; " + coordinateY + "; "
                    + coordinateZ + ")";
        }

    }

}




