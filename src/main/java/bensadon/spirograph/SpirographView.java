package bensadon.spirograph;

import javax.swing.*;
import java.awt.*;

public class SpirographView extends JComponent {
    private SpirographModel model = new SpirographModel(200, 75, 55, 8000, 0.007);

    public void setModel(SpirographModel model) {
        this.model = model;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.translate(getWidth() / 2, getHeight() / 2);

        for (int i = 1; i < model.getNumSteps(); i++) {
            double time1 = (i - 1) * model.getAnglePerStep();
            double time2 = i * model.getAnglePerStep();

            g.setColor(new Color(30, 144, 255));

            setBackground(Color.BLACK);
            setOpaque(true);

            double x1 = (model.getLargeRadius() - model.getSmallRadius()) * Math.cos(time1)
                    + model.getPenDistance() * Math.cos((model.getLargeRadius() - model.getSmallRadius()) * time1 / model.getSmallRadius());

            double y1 = (model.getLargeRadius() - model.getSmallRadius()) * Math.sin(time1)
                    - model.getPenDistance() * Math.sin((model.getLargeRadius() - model.getSmallRadius()) * time1 / model.getSmallRadius());

            double x2 = (model.getLargeRadius() - model.getSmallRadius()) * Math.cos(time2)
                    + model.getPenDistance() * Math.cos((model.getLargeRadius() - model.getSmallRadius()) * time2 / model.getSmallRadius());

            double y2 = (model.getLargeRadius() - model.getSmallRadius()) * Math.sin(time2)
                    - model.getPenDistance() * Math.sin((model.getLargeRadius() - model.getSmallRadius()) * time2 / model.getSmallRadius());

            g.drawLine((int) x1, (int) -y1, (int) x2, (int) -y2);
        }
    }
}