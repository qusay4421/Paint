package ca.utoronto.utm.assignment2.paint;

import javafx.scene.input.MouseEvent;

public class CircleHandler extends ShapeHandler{

    private Circle circle;
    public CircleHandler(PaintModel model) {
        super(model);
    }

    /**
     * Sets the centre of the new circle as the initial mouse click.
     *
     * @param mouseEvent: The MouseEvent.
     */
    @Override
    protected void onMousePressed(MouseEvent mouseEvent) {
        System.out.println("Started Circle");
        Point centre = new Point(mouseEvent.getX(), mouseEvent.getY());
        this.circle = new Circle(centre, 0);
        drawCircle(mouseEvent);
    }

    /**
     * Generate circles for live feedback while dragging mouse.
     *
     * @param mouseEvent: The MouseEvent.
     */
    @Override
    protected void onMouseDrag(MouseEvent mouseEvent) {
        drawCircle(mouseEvent);
    }

    /**
     * Adds the final state of the circle to the model and sets
     * circle to null for future circles.
     *
     * @param mouseEvent: The MouseEvent.
     */
    @Override
    protected void onMouseRelease(MouseEvent mouseEvent) {
        if (this.circle != null) {
            drawCircle(mouseEvent);
            System.out.println("Added Circle");
            this.circle = null;
        }
    }

    /**
     * Uses Pythagorean Theorem to calculate the distance between
     * centre of circle to mouse.
     * Resets the circles radius and adds the circle to the model
     * to be painted onto PaintPanel.
     *
     * @author wuyuhua2
     * @param mouseEvent: The MouseEvent.
     */
    private void drawCircle(MouseEvent mouseEvent) {
        double x = this.circle.getCentre().x - mouseEvent.getX();
        double y = this.circle.getCentre().y - mouseEvent.getY();
        double radius = Math.sqrt(x * x + y * y);
        this.circle.setRadius(radius);
        this.model.addDrawable(this.circle);
    }

}
