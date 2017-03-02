package ru.unn.agile.IntersectLineAndPlane.viewmodel;


import ru.unn.agile.IntersectLineAndPlane.model.Line3D;
import ru.unn.agile.IntersectLineAndPlane.model.Plane3D;

import java.util.List;


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
    private boolean isInputChanged;
    private final ILogger logger;

    public ViewModel(final ILogger logger) {
        if (logger == null) {
            throw new IllegalArgumentException("Logger parameter can't be null");
        }

        this.logger = logger;
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
        isInputChanged = true;
    }

    public String getCoordinateL() {
        return coordinateL;
    }

    public void setCoordinateL(final String coordinateL) {

        this.coordinateL = coordinateL;
        isInputChanged = true;
    }

    public String getCoordinateM() {
        return coordinateM;
    }

    public void setCoordinateM(final String coordinateM) {

        this.coordinateM = coordinateM;
        isInputChanged = true;
    }

    public String getCoordinateN() {
        return coordinateN;
    }

    public void setCoordinateN(final String coordinateN) {

        this.coordinateN = coordinateN;
        isInputChanged = true;
    }

    public String getCoordinateX0() {
        return coordinateX0;
    }

    public void setCoordinateX0(final String coordinateX0) {

        this.coordinateX0 = coordinateX0;
        isInputChanged = true;
    }

    public String getCoordinateY0() {
        return coordinateY0;
    }

    public void setCoordinateY0(final String coordinateY0) {

        this.coordinateY0 = coordinateY0;
        isInputChanged = true;
    }

    public String getCoordinateZ0() {
        return coordinateZ0;
    }

    public void setCoordinateZ0(final String coordinateZ0) {

        this.coordinateZ0 = coordinateZ0;
        isInputChanged = true;
    }

    public String getParametrA() {
        return parametrA;
    }

    public void setParametrA(final String parametrA) {

        this.parametrA = parametrA;
        isInputChanged = true;
    }

    public String getParametrB() {
        return parametrB;
    }

    public void setParametrB(final String parametrB) {

        this.parametrB = parametrB;
        isInputChanged = true;
    }

    public String getParametrC() {
        return parametrC;
    }

    public void setParametrC(final String parametrC) {

        this.parametrC = parametrC;
        isInputChanged = true;
    }

    public String getParametrD() {
        return parametrD;
    }

    public void setParametrD(final String parametrD) {

        this.parametrD = parametrD;
        isInputChanged = true;
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
        logger.log(intersectLogMessage());

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
        logInputParametrs();

        if (isIntersectButtonEnabled()) {
            intersect();
        }
    }

    private void logInputParametrs() {
        if (!isInputChanged) {
            return;
        }

        logger.log(editingFinishedLogMessage());
        isInputChanged = false;
    }

    public void focusLost() {
        logInputParametrs();
    }

    private String editingFinishedLogMessage() {
        String message = LogMessages.EDITING_FINISHED
                + "Input arguments are: ["
                + coordinateL + "; "
                + coordinateM + "; "
                + coordinateN + "; "
                + coordinateX0 + "; "
                + coordinateY0 + "; "
                + coordinateZ0 + "; "
                + parametrA + "; "
                + parametrB + "; "
                + parametrC + "; "
                + parametrD + "]";

        return message;
    }

    public boolean isIntersectButtonEnabled() {
        return isIntersectButtonEnabled;
    }

    public List<String> getLog() {
        return logger.getLog();
    }

    private String intersectLogMessage() {
        String message =
                LogMessages.INTERSECT_WAS_PRESSED + "Arguments"
                        + ": CoordinateL = " + coordinateL
                        + "; CoordinateM = " + coordinateM
                        + "; CoordinateN = " + coordinateN
                        + "; CoordinateX0 = " + coordinateX0
                        + "; CoordinateY0 = " + coordinateY0
                        + "; CoordinateZ0 = " + coordinateZ0
                        + "; CoordinateX0 = " + coordinateX0
                        + "; ParametrA = " + parametrA
                        + "; ParametrB = " + parametrB
                        + "; ParametrC = " + parametrC
                        + "; ParametrD = " + parametrD + ".";

        return message;
    }

    public final class LogMessages {
        public static final String INTERSECT_WAS_PRESSED = "Intersection. ";
        public static final String EDITING_FINISHED = "Updated input. ";

        private LogMessages() { }
    }
}

