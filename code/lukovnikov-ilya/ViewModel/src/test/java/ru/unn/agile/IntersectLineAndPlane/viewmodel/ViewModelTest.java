package ru.unn.agile.IntersectLineAndPlane.viewmodel;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

import ru.unn.agile.IntersectLineAndPlane.viewmodel.ViewModel.Status;

public class ViewModelTest {
    private ViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new ViewModel();
    }

    @After
    public void tearDown() {
        viewModel = null;
    }

    @Test
    public void canSetDefaultValues() {
        assertEquals("", viewModel.getCoordinateL());
        assertEquals("", viewModel.getCoordinateM());
        assertEquals("", viewModel.getCoordinateN());
        assertEquals("", viewModel.getCoordinateX0());
        assertEquals("", viewModel.getCoordinateY0());
        assertEquals("", viewModel.getCoordinateZ0());
        assertEquals("", viewModel.getParametrA());
        assertEquals("", viewModel.getParametrB());
        assertEquals("", viewModel.getParametrC());
        assertEquals("", viewModel.getParametrD());
        assertEquals("", viewModel.getResult());
    }

    @Test
    public void isStatusWaitingInTheBeginning() {
        assertEquals(Status.WAITING, viewModel.getStatus());
    }

    @Test
    public void isStatusWaitingWhenCalculateWithEmptyFields() {
        viewModel.intersect();

        assertEquals(Status.WAITING, viewModel.getStatus());
    }

    @Test
    public void isStatusReadyWhenFieldsAreFill() {
        fillInputFields();

        viewModel.processKeyInTextField(KeyboardKeys.ANY);

        assertEquals(Status.READY, viewModel.getStatus());
    }
    private void fillInputFields() {
        viewModel.setCoordinateL("1");
        viewModel.setCoordinateM("2");
        viewModel.setCoordinateN("3");
        viewModel.setCoordinateX0("4");
        viewModel.setCoordinateY0("5");
        viewModel.setCoordinateZ0("6");
        viewModel.setParametrA("7");
        viewModel.setParametrB("8");
        viewModel.setParametrC("9");
        viewModel.setParametrD("10");
    }

    @Test
    public void canReportBadFormat() {
        viewModel.setCoordinateL("a");
        viewModel.processKeyInTextField(KeyboardKeys.ANY);

        assertEquals(Status.BAD_FORMAT, viewModel.getStatus());
    }

    @Test
    public void canCleanStatusIfParseIsOK() {
        viewModel.setCoordinateL("a");
        viewModel.processKeyInTextField(KeyboardKeys.ANY);
        viewModel.setCoordinateL("1.0");
        viewModel.processKeyInTextField(KeyboardKeys.ANY);

        assertEquals(Status.WAITING, viewModel.getStatus());
    }

    @Test
    public void isInsertButtonDisabledInitially() {
        assertEquals(false, viewModel.isIntersectButtonEnabled());
    }

    @Test
    public void isInsertButtonDisabledWhenFormatIsBad() {
        fillInputFields();
        viewModel.processKeyInTextField(KeyboardKeys.ANY);
        assertEquals(true, viewModel.isIntersectButtonEnabled());

        viewModel.setCoordinateL("false");
        viewModel.processKeyInTextField(KeyboardKeys.ANY);

        assertEquals(false, viewModel.isIntersectButtonEnabled());
    }

    @Test
    public void isInsertButtonDisabledWithIncompleteInput() {
        viewModel.setCoordinateL("1");
        viewModel.setCoordinateM("2");
        viewModel.setParametrA("3");
        viewModel.setParametrB("4");
        viewModel.processKeyInTextField(KeyboardKeys.ANY);

        assertEquals(false, viewModel.isIntersectButtonEnabled());
    }

    @Test
    public void isInsertButtonEnabledWithCorrectInput() {
        fillInputFields();

        viewModel.processKeyInTextField(KeyboardKeys.ANY);

        assertEquals(true, viewModel.isIntersectButtonEnabled());
    }
    @Test
    public void canPerformIntersection() {
        viewModel.setCoordinateL("-3");
        viewModel.setCoordinateM("2");
        viewModel.setCoordinateN("-2");
        viewModel.setCoordinateX0("-1");
        viewModel.setCoordinateY0("-2");
        viewModel.setCoordinateZ0("3");
        viewModel.setParametrA("1");
        viewModel.setParametrB("3");
        viewModel.setParametrC("-5");
        viewModel.setParametrD("9");

        viewModel.intersect();

        assertEquals("Intersection point (-4.0; 0.0; 1.0)", viewModel.getResult());
    }

    @Test
    public void canSetSuccessMessage() {
        fillInputFields();

        viewModel.intersect();

        assertEquals(Status.SUCCESS, viewModel.getStatus());
    }

    @Test
    public void canSetBadFormatMessage() {
        viewModel.setCoordinateL("a");

        viewModel.intersect();

        assertEquals(Status.BAD_FORMAT, viewModel.getStatus());
    }

    @Test
    public void isStatusReadyWhenKeyIsNotEnter() {
        fillInputFields();

        viewModel.processKeyInTextField(KeyboardKeys.ANY);

        assertEquals(Status.READY, viewModel.getStatus());
    }

    @Test
    public void isStatusSuccessWhenKeyIsEnter() {
        fillInputFields();

        viewModel.processKeyInTextField(KeyboardKeys.ENTER);

        assertEquals(Status.SUCCESS, viewModel.getStatus());
    }
}
