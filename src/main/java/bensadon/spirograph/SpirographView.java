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

        g.setColor(new Color(30, 144, 255));

        setBackground(Color.BLACK);
        setOpaque(true);

        for (int i = 1; i < model.getNumSteps(); i++) {
            final double time1 = (i - 1) * model.getAnglePerStep();
            final double time2 = i * model.getAnglePerStep();


            double radiusDifference = model.getLargeRadius() - model.getSmallRadius();

            double x1 = radiusDifference * Math.cos(time1)
                    + model.getPenDistance()
                    * Math.cos(radiusDifference * time1 / model.getSmallRadius());

            double y1 = radiusDifference * Math.sin(time1)
                    - model.getPenDistance()
                    * Math.sin(radiusDifference * time1 / model.getSmallRadius());

            double x2 = radiusDifference * Math.cos(time2)
                    + model.getPenDistance()
                    * Math.cos(radiusDifference * time2 / model.getSmallRadius());

            double y2 = radiusDifference * Math.sin(time2)
                    - model.getPenDistance()
                    * Math.sin(radiusDifference * time2 / model.getSmallRadius());

            g.drawLine((int) x1, (int) -y1, (int) x2, (int) -y2);
        }
    }
}