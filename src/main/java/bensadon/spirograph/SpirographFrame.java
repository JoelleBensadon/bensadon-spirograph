package bensadon.spirograph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpirographFrame extends JFrame {

    public SpirographFrame() {
        setSize(900, 700);
        setTitle("Spirograph");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JTextField largeRadiusField = new JTextField("200");
        JTextField smallRadiusField = new JTextField("75");
        JTextField penDistanceField = new JTextField("55");
        JTextField numStepsField = new JTextField("8000");
        JTextField anglePerStepField = new JTextField("0.007");

        SpirographView spirographView = new SpirographView();

        SpirographController spirographController = new SpirographController(
                spirographView,
                largeRadiusField,
                smallRadiusField,
                penDistanceField,
                numStepsField,
                anglePerStepField
        );

        JButton drawButton = new JButton("Draw");
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spirographController.updateSpirograph();
            }
        });

        JPanel westPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints;

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        westPanel.add(new JLabel("Large Radius"), constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1;
        westPanel.add(largeRadiusField, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        westPanel.add(new JLabel("Small Radius"), constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1;
        westPanel.add(smallRadiusField, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 2;
        westPanel.add(new JLabel("Pen Distance"), constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1;
        westPanel.add(penDistanceField, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 3;
        westPanel.add(new JLabel("Num Steps"), constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1;
        westPanel.add(numStepsField, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 4;
        westPanel.add(new JLabel("Angle Per Step"), constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1;
        westPanel.add(anglePerStepField, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.NORTH;
        westPanel.add(drawButton, constraints);

        add(westPanel, BorderLayout.WEST);
        add(spirographView, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SpirographFrame frame = new SpirographFrame();
        frame.setVisible(true);
    }
}