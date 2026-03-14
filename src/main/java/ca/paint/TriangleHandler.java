package ca.utoronto.utm.assignment2.paint;

import javafx.scene.input.MouseEvent;

public class TriangleHandler extends ShapeHandler{
    private Triangle triangle;
    public TriangleHandler(PaintModel model) {
        super(model);
    }

    /**
     * @param mouseEvent
     */
    @Override
    protected void onMousePressed(MouseEvent mouseEvent) {
        System.out.println("Started Triangle"); //alerting the console
        Point top = new Point(mouseEvent.getX(), mouseEvent.getY());
        this.triangle = new Triangle(top, top);
    }

    /**
     * @param mouseEvent
     */
    @Override
    protected void onMouseDrag(MouseEvent mouseEvent) {
        Point startingPoint = this.triangle.getTop();
        this.triangle.setTop(startingPoint);
        Point mousePoint = new Point(mouseEvent.getX(), mouseEvent.getY());
        this.triangle.setMousePoint(mousePoint);

        // Quadrants I and IV should work by default.
        // Reverse mouse position for quadrants II and III
        if ((startingPoint.x >= mousePoint.x && startingPoint.y <= mousePoint.y) ||
                (startingPoint.x >= mousePoint.x && startingPoint.y >= mousePoint.y)) {
            mousePoint = new Point(startingPoint.x - mousePoint.x + startingPoint.x, mousePoint.y);
            this.triangle.setMousePoint(mousePoint);
        }
        this.model.addDrawable(this.triangle);
    }

    /**
     * @param mouseEvent
     */
    @Override
    protected void onMouseRelease(MouseEvent mouseEvent) {

        if (this.triangle != null) {
            this.model.addDrawable(this.triangle);
            System.out.println("Added Triangle"); //alerting the console
            this.triangle = null;
        }
    }
}
