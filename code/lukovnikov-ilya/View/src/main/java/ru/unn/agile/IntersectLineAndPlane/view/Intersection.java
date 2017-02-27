package ru.unn.agile.IntersectLineAndPlane.view;

import ru.unn.agile.IntersectLineAndPlane.viewmodel.ViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
    }

    public static void main(final String[]  args) {
        JFrame frame = new JFrame("Intersection");
        frame.setContentPane(new Intersection(new ViewModel()).mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
