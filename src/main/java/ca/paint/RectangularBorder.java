package ca.utoronto.utm.assignment2.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * A rectangle shape in the Paint Program.
 *
 * @author moha2780
 */
public class RectangularBorder implements Drawable{

    private Point topLeft;
    private double width = 0, height = 0;

    /**
     * A constructor for the rectangle class.
     * Creates a rectangle.
     *
     * @param topLeft - the top left Point of the rectangle
     * @author moha2780
     */
    public RectangularBorder(Point topLeft) {
        this.topLeft = topLeft;
    }//end of constructor

    /**
     * Updates the top left corner of this rectangle
     *
     * @param topLeft - the new top left corner
     * @author moha2780
     */
    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }//end of TopLeft setter

    /**
     * Updates the width of this rectangle
     *
     * @param width - the new width of the rectangle
     * @author moha2780
     */
    public void setWidth(double width) {
        this.width = width;
    }//end of width setter

    /**
     * Updates the height of this rectangle
     *
     * @param height - the new height of this rectangle
     * @author moha2780
     */
    public void setHeight(double height) {
        this.height = height;
    }//end of height setter

    /**
     * Returns the top left corner of this rectangle
     * @return the top left point of this rectangle
     *
     * @author moha2780
     */
    public Point getTopLeft() {
        return topLeft;
    }//end of topLeft getter

    /**
     *Returns the width of this rectangle
     *
     * @return the width
     * @author moha2780
     */
    public double getWidth() {
        return width;
    }//end of width getter

    /**
     * Returns the height of this rectangle
     *
     * @return the height
     * @author moha2780
     */
    public double getHeight() {
        return height;
    }//end of height getter

    /**
     * @param g2d
     */
    @Override
    public void draw(GraphicsContext g2d) {
        g2d.setFill(Color.BLUE);
        g2d.fillRect(this.getTopLeft().x, this.getTopLeft().y, this.getWidth(), this.getHeight());
    }
}//end of class
