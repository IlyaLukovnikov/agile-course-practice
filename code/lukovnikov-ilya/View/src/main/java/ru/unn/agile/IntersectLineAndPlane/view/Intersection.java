package ru.unn.agile.IntersectLineAndPlane.view;

import ru.unn.agile.IntersectLineAndPlane.viewmodel.ViewModel;
import ru.unn.agile.IntersectLineAndPlane.infrastructure.TxtLogger;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public final class Intersection {
    private JPanel mainPanel;
    private final ViewModel viewModel;

    private JTextField textCoordinateL;
    private JTextField textCoordinateX0;
    private JTextField textCoefficientA;
    private JTextField textCoordinateN;
    private JTextField textCoordinateM;
    private JTextField textCoordinateY0;
    private JTextField textCoordinateZ0;
    private JTextField textCoefficientB;
    private JTextField textCoefficientC;
    private JTextField textCoefficientD;
    private JButton findIntersectionButton;
    private JTextField textResult;
    private JLabel lbStatus;
    private JList<String> lstLog;

    private Intersection(final ViewModel viewModel) {
        this.viewModel = viewModel;
        backBind();

        findIntersectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                bind();
                Intersection.this.viewModel.intersect();
                backBind();
            }
        });

        KeyAdapter keyListener = new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                bind();
                Intersection.this.viewModel.processKeyInTextField(e.getKeyCode());
                backBind();
            }
        };

        textCoordinateL.addKeyListener(keyListener);
        textCoordinateM.addKeyListener(keyListener);
        textCoordinateM.addKeyListener(keyListener);
        textCoordinateN.addKeyListener(keyListener);
        textCoordinateX0.addKeyListener(keyListener);
        textCoordinateY0.addKeyListener(keyListener);
        textCoordinateZ0.addKeyListener(keyListener);
        textCoefficientA.addKeyListener(keyListener);
        textCoefficientB.addKeyListener(keyListener);
        textCoefficientC.addKeyListener(keyListener);
        textCoefficientD.addKeyListener(keyListener);

        FocusAdapter focusLostListener = new FocusAdapter() {
            public void focusLost(final FocusEvent e) {
                bind();
                Intersection.this.viewModel.focusLost();
                backBind();
            }
        };
        textCoordinateL.addFocusListener(focusLostListener);
        textCoordinateM.addFocusListener(focusLostListener);
        textCoordinateM.addFocusListener(focusLostListener);
        textCoordinateN.addFocusListener(focusLostListener);
        textCoordinateX0.addFocusListener(focusLostListener);
        textCoordinateY0.addFocusListener(focusLostListener);
        textCoordinateZ0.addFocusListener(focusLostListener);
        textCoefficientA.addFocusListener(focusLostListener);
        textCoefficientB.addFocusListener(focusLostListener);
        textCoefficientC.addFocusListener(focusLostListener);
        textCoefficientD.addFocusListener(focusLostListener);
    }

    private void bind() {
        viewModel.setCoordinateL(textCoordinateL.getText());
        viewModel.setCoordinateM(textCoordinateM.getText());
        viewModel.setCoordinateN(textCoordinateN.getText());
        viewModel.setCoordinateX0(textCoordinateX0.getText());
        viewModel.setCoordinateY0(textCoordinateY0.getText());
        viewModel.setCoordinateZ0(textCoordinateZ0.getText());
        viewModel.setParametrA(textCoefficientA.getText());
        viewModel.setParametrB(textCoefficientB.getText());
        viewModel.setParametrC(textCoefficientC.getText());
        viewModel.setParametrD(textCoefficientD.getText());
    }

    private void backBind() {
        findIntersectionButton.setEnabled(viewModel.isIntersectButtonEnabled());

        textResult.setText(viewModel.getResult());
        lbStatus.setText(viewModel.getStatus());

        List<String> log = viewModel.getLog();
        String[] items = log.toArray(new String[log.size()]);
        lstLog.setListData(items);
    }

    public static void main(final String[]  args) {
        JFrame frame = new JFrame("Intersection");

        TxtLogger logger = new TxtLogger("./Intersection.log");
        frame.setContentPane(new Intersection(new ViewModel(logger)).mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
