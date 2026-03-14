package ca.utoronto.utm.assignment2.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends RectangularBorder{
    /**
     * A constructor for the rectangle class.
     * Creates a rectangle.
     *
     * @param topLeft - the top left Point of the rectangle
     * @author wuyuhua2
     */
    public Square(Point topLeft) {
        super(topLeft);
    }

    public void draw(GraphicsContext g2d) {
        g2d.setFill(Color.PURPLE);
        g2d.fillRect(this.getTopLeft().x, this.getTopLeft().y, this.getWidth(), this.getHeight());
    }
}
