package ru.unn.agile.IntersectLineAndPlane.viewmodel;


import ru.unn.agile.IntersectLineAndPlane.model.Line3D;
import ru.unn.agile.IntersectLineAndPlane.model.Plane3D;


public class ViewModel {
    private String coordinateL;
    private String coordinateM;
    private String coordinateN;
    private String coordinateX0;
    private String coordinateY0;
    private String coordinateZ0;
    private String parametrA;
    private String parametrB;
    private String parametrC;
    private String parametrD;
    private String result;
    private String status;
    private boolean isIntersectButtonEnabled;

    public ViewModel() {
        coordinateL = "";
        coordinateM = "";
        coordinateN = "";
        coordinateX0 = "";
        coordinateY0 = "";
        coordinateZ0 = "";
        parametrA = "";
        parametrB = "";
        parametrC = "";
        parametrD = "";
        result = "";
        status = Status.WAITING;

        isIntersectButtonEnabled = false;
    }

    public String getCoordinateL() {
        return coordinateL;
    }

    public void setCoordinateL(final String coordinateL) {
        if (coordinateL.equals(this.coordinateL)) {
            return;
        }

        this.coordinateL = coordinateL;
    }

    public String getCoordinateM() {
        return coordinateM;
    }

    public void setCoordinateM(final String coordinateM) {
        if (coordinateM.equals(this.coordinateM)) {
            return;
        }

        this.coordinateM = coordinateM;
    }

    public String getCoordinateN() {
        return coordinateN;
    }

    public void setCoordinateN(final String coordinateN) {
        if (coordinateN.equals(this.coordinateN)) {
            return;
        }

        this.coordinateN = coordinateN;
    }

    public String getCoordinateX0() {
        return coordinateX0;
    }

    public void setCoordinateX0(final String coordinateX0) {
        if (coordinateX0.equals(this.coordinateX0)) {
            return;
        }

        this.coordinateX0 = coordinateX0;
    }

    public String getCoordinateY0() {
        return coordinateY0;
    }

    public void setCoordinateY0(final String coordinateY0) {
        if (coordinateY0.equals(this.coordinateY0)) {
            return;
        }

        this.coordinateY0 = coordinateY0;
    }

    public String getCoordinateZ0() {
        return coordinateZ0;
    }

    public void setCoordinateZ0(final String coordinateZ0) {
        if (coordinateZ0.equals(this.coordinateZ0)) {
            return;
        }

        this.coordinateZ0 = coordinateZ0;
    }

    public String getParametrA() {
        return parametrA;
    }

    public void setParametrA(final String parametrA) {
        if (parametrA.equals(this.parametrA)) {
            return;
        }

        this.parametrA = parametrA;
    }

    public String getParametrB() {
        return parametrB;
    }

    public void setParametrB(final String parametrB) {
        if (parametrB.equals(this.parametrB)) {
            return;
        }

        this.parametrB = parametrB;
    }

    public String getParametrC() {
        return parametrC;
    }

    public void setParametrC(final String parametrC) {
        if (parametrC.equals(this.parametrC)) {
            return;
        }

        this.parametrC = parametrC;
    }

    public String getParametrD() {
        return parametrD;
    }

    public void setParametrD(final String parametrD) {
        if (parametrD.equals(this.parametrD)) {
            return;
        }

        this.parametrD = parametrD;
    }

    public String getResult() {
        return result;
    }

    public String getStatus() {
        return status;
    }

    public final class Status {
        public static final String WAITING = "Please provide input data";
        public static final String READY = "Press 'Find intersection' or Enter";
        public static final String BAD_FORMAT = "Bad format";
        public static final String SUCCESS = "Success";

        private Status() { }
    }

    private boolean isInputAvailable() {
        return !coordinateL.isEmpty() && !coordinateM.isEmpty() && !coordinateN.isEmpty()
                && !coordinateX0.isEmpty() && !coordinateY0.isEmpty() && !coordinateZ0.isEmpty()
                && !parametrA.isEmpty() && !parametrB.isEmpty() && !parametrC.isEmpty()
                && !parametrD.isEmpty();
    }

    private boolean parseInput() {
        try {
            if (!coordinateL.isEmpty()) {
                Double.parseDouble(coordinateL);
            }
            if (!coordinateM.isEmpty()) {
                Double.parseDouble(coordinateM);
            }
            if (!coordinateN.isEmpty()) {
                Double.parseDouble(coordinateN);
            }
            if (!coordinateX0.isEmpty()) {
                Double.parseDouble(coordinateY0);
            }
            if (!coordinateY0.isEmpty()) {
                Double.parseDouble(coordinateY0);
            }
            if (!coordinateZ0.isEmpty()) {
                Double.parseDouble(coordinateZ0);
            }
            if (!parametrA.isEmpty()) {
                Double.parseDouble(parametrA);
            }
            if (!parametrB.isEmpty()) {
                Double.parseDouble(parametrB);
            }
            if (!parametrC.isEmpty()) {
                Double.parseDouble(parametrC);
            }
            if (!parametrD.isEmpty()) {
                Double.parseDouble(parametrD);
            }
        } catch (Exception e) {
            status = Status.BAD_FORMAT;
            isIntersectButtonEnabled = false;
            return false;
        }

        isIntersectButtonEnabled = isInputAvailable();
        if (isIntersectButtonEnabled) {
            status = Status.READY;
        } else {
            status = Status.WAITING;
        }

        return isIntersectButtonEnabled;
    }
    public void intersect() {
        if (!parseInput()) {
            return;
        }

        Line3D line = new Line3D(coordinateL, coordinateM, coordinateN,
                coordinateX0, coordinateY0, coordinateZ0);
        Plane3D plane = new Plane3D(parametrA, parametrB, parametrC, parametrD);
        String intersect = line.checkIntersection(plane);

        result = intersect;
        status = Status.SUCCESS;
    }

    public void processKeyInTextField(final int keyCode) {
        parseInput();

        if (keyCode == KeyboardKeys.ENTER) {
            enterPressed();
        }
    }
    private void enterPressed() {

        if (isIntersectButtonEnabled()) {
            intersect();
        }
    }
    public boolean isIntersectButtonEnabled() {
        return isIntersectButtonEnabled;
    }
}

