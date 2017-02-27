package ru.unn.agile.IntersectLineAndPlane.model;


public class Plane3D {
    private final double coefficientA;
    private final double coefficientB;
    private final double coefficientC;
    private final double coefficientD;

    public Plane3D(final double factorA, final double factorB,
                   final double factorC, final double factorD) {
        this.coefficientA = factorA;
        this.coefficientB = factorB;
        this.coefficientC = factorC;
        this.coefficientD = factorD;
    }
    public Plane3D(final String factorA, final String factorB,
                   final String factorC, final String factorD) {
        this.coefficientA = Double.parseDouble(factorA);
        this.coefficientB = Double.parseDouble(factorB);
        this.coefficientC = Double.parseDouble(factorC);
        this.coefficientD = Double.parseDouble(factorD);
    }


    public double getA() {
        return coefficientA;
    }
    public double getB() {
        return coefficientB;
    }
    public double getC() {
        return coefficientC;
    }
    public double getD() {
        return coefficientD;
    }
    public String toFormula() {
        return FormaterPlane.getFormatedPlane(this);
    }
}
