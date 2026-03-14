package ca.utoronto.utm.assignment2.paint;

import javafx.scene.input.MouseEvent;

public class EraserHandler extends ShapeHandler{

    private Eraser eraser;

    public EraserHandler(PaintModel model) {
        super(model);
    }

    /**
     * Sets the topLeft of the new eraser as the initial mouse click.
     *
     * @param mouseEvent: The MouseEvent.
     */
    @Override
    protected void onMousePressed(MouseEvent mouseEvent) {
        System.out.println("Started Eraser");
        Point topLeft = new Point(mouseEvent.getX(), mouseEvent.getY());
        // default thickness will be 10 x 10
        this.eraser = new Eraser(topLeft, 10, 10);
        this.model.addDrawable(eraser);
    }

    /**
     * Live feedback of the eraser being drawn onto PaintPanel following
     * the path of the mouse drag.
     *
     * @param mouseEvent: the MouseEvent
     */
    @Override
    protected void onMouseDrag(MouseEvent mouseEvent) {
        Point mousePoint = new Point(mouseEvent.getX(), mouseEvent.getY());
        Eraser newEraser = new Eraser(mousePoint, 10, 10);
        this.eraser.setTopLeft(mousePoint);
        this.eraser.addToEraserPath(newEraser);
        this.model.addDrawable(eraser);
    }

    /**
     * Sets the eraser to null so new erasers can be drawn at the
     * release of the mouse click.
     *
     * @param mouseEvent: the MouseEvent
     */
    @Override
    protected void onMouseRelease(MouseEvent mouseEvent) {
        if (this.eraser != null) {
            this.model.addDrawable(eraser);
            System.out.println("Added Eraser");
            this.eraser = null;
        }
    }

}
