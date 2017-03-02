package ru.unn.agile.IntersectLineAndPlane.infrastructure;

import ru.unn.agile.IntersectLineAndPlane.viewmodel.ViewModel;
import ru.unn.agile.IntersectLineAndPlane.viewmodel.ViewModelTest;

public class ViewModelWithTxtLoggerTests extends ViewModelTest {
    @Override
    public void setUp() {
        TxtLogger realLogger =
            new TxtLogger("./ViewModelWithTxtLoggerTests.log");
        super.setViewModel(new ViewModel(realLogger));
    }
}
