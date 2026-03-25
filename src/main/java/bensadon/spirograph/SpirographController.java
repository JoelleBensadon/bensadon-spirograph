package bensadon.spirograph;

import javax.swing.*;

public class SpirographController {
    private final SpirographView spirographView;
    private final JTextField largeRadiusField;
    private final JTextField smallRadiusField;
    private final JTextField penDistanceField;
    private final JTextField numStepsField;
    private final JTextField anglePerStepField;

    public SpirographController(SpirographView spirographView,
                                JTextField largeRadiusField,
                                JTextField smallRadiusField,
                                JTextField penDistanceField,
                                JTextField numStepsField,
                                JTextField anglePerStepField) {
        this.spirographView = spirographView;
        this.largeRadiusField = largeRadiusField;
        this.smallRadiusField = smallRadiusField;
        this.penDistanceField = penDistanceField;
        this.numStepsField = numStepsField;
        this.anglePerStepField = anglePerStepField;
    }

    public void updateSpirograph() {
        double largeRadius = Double.parseDouble(largeRadiusField.getText());
        double smallRadius = Double.parseDouble(smallRadiusField.getText());
        double penDistance = Double.parseDouble(penDistanceField.getText());
        int numSteps = Integer.parseInt(numStepsField.getText());
        double anglePerStep = Double.parseDouble(anglePerStepField.getText());

        SpirographModel model = new SpirographModel(
                largeRadius, smallRadius, penDistance, numSteps, anglePerStep
        );

        spirographView.setModel(model);
    }
}