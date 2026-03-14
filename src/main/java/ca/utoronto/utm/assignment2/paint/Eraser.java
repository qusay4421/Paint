package ca.utoronto.utm.assignment2.paint;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

/**
 * A class to represent the Eraser shape.
 *
 * @author albakh5
 */

public class Eraser implements Drawable{

    private Point topLeft;
    private double width;
    private double height;
    private final ArrayList<Eraser> eraserPath = new ArrayList<>();

    /**
     * Default constructor of squiggle.
     *
     * @author albakh5
     */
    public Eraser(Point topLeft, double width, double height) {
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * Adds an eraser to the eraserPath. That is, it extends the eraserPath.
     * @param e - the eraser to extend to the eraserPath
     *
     * @author albalkh5
     */
    public void addToEraserPath(Eraser e){
        eraserPath.add(e);
    }

    public ArrayList<Eraser> getEraserPath(){
        return eraserPath;
    }

    /**
     *
     * @return the topLeft point of the eraser.
     * @author albakh5
     */
    public Point getTopLeft() {return topLeft;}

    /**
     *
     * @return the width of the eraser.
     * @author albakh5
     */
    public double getWidth() {return this.width;}

    /**
     *
     * @return the height of the eraser.
     * @author albakh5
     */
    public double getHeight() {return this.height;}

    /**
     *
     * @param topLeft: sets the eraser's topLeft to given topLeft
     * @author albakh5
     */
    public void setTopLeft(Point topLeft) {this.topLeft = topLeft;}

    /**
     *
     * @param width: sets the eraser's width to given width
     * @author albakh5
     */
    public void setWidth(double width) {this.width = width;}

    /**
     *
     * @param height: sets the eraser's height to given height
     * @author albakh5
     */
    public void setHeight(double height) {this.height = height;}

    /**
     * @param g2d
     */
    @Override
    public void draw(GraphicsContext g2d) {
        ArrayList<Eraser> erasersInPath = this.getEraserPath();
        for (Eraser e2: erasersInPath) {
            g2d.clearRect(e2.getTopLeft().x - e2.getWidth() / 2, e2.getTopLeft().y - e2.getHeight() / 2,
                    e2.getWidth(), e2.getHeight());
        }
    }
}
