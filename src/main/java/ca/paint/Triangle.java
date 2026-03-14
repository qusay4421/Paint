package ca.utoronto.utm.assignment2.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle implements Drawable{
    private Point top;
    private Point mousePoint;

    public Triangle(Point top, Point mousePoint) {
        this.top = top;
        this.mousePoint = mousePoint;
    }

    public Point getTop() {
        return top;
    }

    public Point getMousePoint() {
        return mousePoint;
    }

    public void setTop(Point top) {
        this.top = top;
    }

    public void setMousePoint(Point bottomRight) {
        this.mousePoint = bottomRight;
    }

    /**
     * @param g2d
     */
    @Override
    public void draw(GraphicsContext g2d) {
        g2d.setLineDashes(0);
        g2d.setStroke(Color.TEAL);
        Point top = this.getTop(); Point mousePoint = this.getMousePoint();
        double diffx = mousePoint.x - top.x;

        // should work for quadrant I and IV. For quadrants II and III, mousePoint = oppMousePoint
        g2d.strokeLine(top.x, top.y, mousePoint.x, mousePoint.y); // draw from top to mouse
        g2d.strokeLine(top.x, top.y, top.x - diffx, mousePoint.y); // draw from top to opposite of mouse
        g2d.strokeLine(top.x - diffx, mousePoint.y, mousePoint.x, mousePoint.y); // draw from mouse to opposite mouse
    }
}
