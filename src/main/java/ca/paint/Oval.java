package ca.utoronto.utm.assignment2.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Oval extends RectangularBorder{
    /**
     * A constructor for the rectangle class.
     * Creates a rectangle.
     *
     * @param topLeft - the top left Point of the rectangle
     * @author wuyuhua2
     */
    public Oval(Point topLeft) {
        super(topLeft);
    }

    @Override
    public void draw(GraphicsContext g2d) {
        g2d.setFill(Color.ROSYBROWN);//ovals will be rosy brown
        g2d.fillOval(this.getTopLeft().x, this.getTopLeft().y,
                this.getWidth(), this.getHeight());
        g2d.setStroke(Color.CORNFLOWERBLUE);//border will be cornflower blue
        g2d.setLineWidth(0.15);
        g2d.setLineDashes(5);//border will be drawn with dashed lines
        g2d.strokeRect(this.getTopLeft().x, this.getTopLeft().y,
                this.getWidth(), this.getHeight());
        g2d.setLineWidth(1);//to revert change made to thickness
    }
}
