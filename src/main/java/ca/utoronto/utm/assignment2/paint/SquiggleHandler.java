package ca.utoronto.utm.assignment2.paint;

import javafx.scene.input.MouseEvent;

public class SquiggleHandler extends ShapeHandler{

    private Squiggle squiggle;

    public SquiggleHandler(PaintModel model) {
        super(model);
    }

    /**
     * Creates a squiggle object at the location of the
     * initial mouse click.
     *
     * @param mouseEvent: the MouseEvent.
     */
    @Override
    protected void onMousePressed(MouseEvent mouseEvent) {
        System.out.println("Started Squiggle"); //alerting the console
        Point start = new Point(mouseEvent.getX(), mouseEvent.getY());
        this.squiggle = new Squiggle(start);
        this.model.addDrawable(squiggle);
    }

    /**
     * Live feedback of the squiggle being drawn onto PaintPanel following
     * the path of the mouse drag.
     *
     * @param mouseEvent: the MouseEvent
     */
    @Override
    protected void onMouseDrag(MouseEvent mouseEvent) {
        // keeps adding points to create a continuous line
        Point point = new Point(mouseEvent.getX(), mouseEvent.getY());
        this.squiggle.addPoint(point); // extends the squiggle by point
        this.model.addDrawable(this.squiggle);//this updates the squiggle feedback
    }

    /**
     * Sets the squiggle to null so new squiggles can be drawn at the
     * release of the mouse click.
     *
     * @param mouseEvent: the MouseEvent
     */
    @Override
    protected void onMouseRelease(MouseEvent mouseEvent) {
        if (this.squiggle != null) {
            this.model.addDrawable(this.squiggle);
            System.out.println("Added Squiggle"); //alerting the console
            this.squiggle = null;
        }
    }
}
