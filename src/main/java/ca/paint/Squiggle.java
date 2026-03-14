package ca.utoronto.utm.assignment2.paint;

//imports
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * A class to represent the Squiggle shape.
 *
 * @author moha2780
 */
public class Squiggle implements Drawable{

    private final ArrayList<Point> points = new ArrayList<>(); //the list of points that make up a squiggle

    /**
     * Default constructor of squiggle.
     *
     * @author moha2780
     */
    public Squiggle(Point start) {
        points.add(start);
    }//end of constructor

    /**
     * Adds a point to the squiggle. That is, extends the squiggle.
     * @param point - the point to extend to the squiggle
     *
     * @author moha2780
     */
    public void addPoint(Point point){
        points.add(point);
    }//end of addPoint() method

    /**
     * Returns all the points of the squiggle
     * @return an ArrayList of Points
     *
     * @author moha2780
     */
    public ArrayList<Point> getPoints(){
        return points;
    }//end of getter

    /**
     * @param g2d
     */
    @Override
    public void draw(GraphicsContext g2d) {
        ArrayList<Point> points = this.getPoints();
        g2d.setStroke(Color.BLACK);// temporary colour
        g2d.setLineDashes(0);//continuous lines
        for (int i=0; i < points.size() - 1; i++){
            Point p1 = points.get(i);
            Point p2 = points.get(i+1);
            g2d.strokeLine(p1.x,p1.y,p2.x,p2.y);
        }
    }
}
