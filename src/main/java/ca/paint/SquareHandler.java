package ca.utoronto.utm.assignment2.paint;

import javafx.scene.input.MouseEvent;

public class SquareHandler extends ShapeHandler {
    private Square square;
    public SquareHandler(PaintModel model) {
        super(model);
    }

    /**
     * Updates the model's status on the press of a mouse.
     * In this case, the square should be initialized.
     *
     * @param mouseEvent the MouseEvent
     * @author moha2780
     */
    @Override
    protected void onMousePressed(MouseEvent mouseEvent) {
        System.out.println("Started Square"); //alerting the console
        Point topLeft = new Point(mouseEvent.getX(), mouseEvent.getY());
        this.square = new Square(topLeft);
        this.model.addDrawable(this.square);
    }

    /**
     * Updates the model's status as the mouse is dragged.
     *
     * @param mouseEvent the MoseEvent
     * @author moha2780
     */
    @Override
    protected void onMouseDrag(MouseEvent mouseEvent) {

        Point newTopLeft, oldTopLeft;
        oldTopLeft = this.square.getTopLeft();
        newTopLeft = oldTopLeft;

        double width = mouseEvent.getX() - this.square.getTopLeft().x;
        double height = mouseEvent.getY() - this.square.getTopLeft().y;

        double smallestDimension = Math.min(Math.abs(width), Math.abs(height));

        // The following if else block adjusts topLeft if needed
        if (height < 0 && width < 0) {//both height & width are negative, topLeft is actually bottom right
            newTopLeft = new Point(this.square.getTopLeft().x - smallestDimension,
                    this.square.getTopLeft().y - smallestDimension);
        } else if (height < 0) { //only height is negative, then topLeft is actually bottom left.
            newTopLeft = new Point(this.square.getTopLeft().x, this.square.getTopLeft().y - smallestDimension);
        } else if (width < 0) { //only height is negative, then topLeft is actually top right.
            newTopLeft = new Point(this.square.getTopLeft().x - smallestDimension, this.square.getTopLeft().y);
        }

        this.square.setTopLeft(newTopLeft);
        this.square.setHeight(smallestDimension);
        this.square.setWidth(smallestDimension);

        this.model.addDrawable(this.square);
        this.square.setTopLeft(oldTopLeft);
    }

    /**
     * Updates the model's status on the release of a mouse.
     * In this case, the square should be added to the model
     *
     * @param mouseEvent the MouseEvent
     * @author moha2780
     */
    @Override
    protected void onMouseRelease(MouseEvent mouseEvent) {
        if (this.square != null) {

            Point newTopLeft = this.square.getTopLeft();// by default, newTopLeft == old topLeft
            double width = mouseEvent.getX() - this.square.getTopLeft().x;
            double height = mouseEvent.getY() - this.square.getTopLeft().y;

            double smallestDimension = Math.min(Math.abs(width), Math.abs(height));

            // The following if else block adjusts topLeft if needed
            if (height < 0 && width < 0) {//both height & width are negative, topLeft is actually bottom right
                newTopLeft = new Point(this.square.getTopLeft().x - smallestDimension,
                        this.square.getTopLeft().y - smallestDimension);
            } else if (height < 0) { //only height is negative, then topLeft is actually bottom left.
                newTopLeft = new Point(this.square.getTopLeft().x, this.square.getTopLeft().y - smallestDimension);
            } else if (width < 0) { //only height is negative, then topLeft is actually top right.
                newTopLeft = new Point(this.square.getTopLeft().x - smallestDimension, this.square.getTopLeft().y);
            }

            this.square.setTopLeft(newTopLeft);
            this.square.setHeight(smallestDimension);
            this.square.setWidth(smallestDimension);

            this.model.addDrawable(this.square);
            System.out.println("Added Square"); //alerting the console
            this.square = null;
        }
    }

}
