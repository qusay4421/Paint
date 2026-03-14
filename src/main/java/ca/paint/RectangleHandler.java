package ca.utoronto.utm.assignment2.paint;

import javafx.scene.input.MouseEvent;

public class RectangleHandler extends ShapeHandler{

    private RectangularBorder rectangle;

    public RectangleHandler(PaintModel model) {
        super(model);
    }

    /**
     * @param mouseEvent
     */
    @Override
    protected void onMousePressed(MouseEvent mouseEvent) {
        System.out.println("Started Rectangle"); //alerting the console
        Point topLeft = new Point(mouseEvent.getX(), mouseEvent.getY());
        this.rectangle = new RectangularBorder(topLeft);
    }

    /**
     * @param mouseEvent
     */
    @Override
    protected void onMouseDrag(MouseEvent mouseEvent) {

        double x = mouseEvent.getX() - this.rectangle.getTopLeft().x;
        double y = mouseEvent.getY() - this.rectangle.getTopLeft().y;

        // The following if else block adjusts topLeft depending on the direction of the mouse drag
        if (x <= 0 && y <= 0) {
            Point newTopLeft = new Point(mouseEvent.getX(), mouseEvent.getY());
            Point oldTopLeft = this.rectangle.getTopLeft();
            double new_width = this.rectangle.getTopLeft().x - newTopLeft.x;
            double new_height = this.rectangle.getTopLeft().y - newTopLeft.y;

            this.rectangle.setTopLeft(newTopLeft);
            this.rectangle.setWidth(new_width);
            this.rectangle.setHeight(new_height);

            this.model.addDrawable(this.rectangle);
            this.rectangle.setTopLeft(oldTopLeft);
        } else if (x <= 0 && y >= 0) {
            Point newTopLeft = new Point(mouseEvent.getX(), mouseEvent.getY());
            Point oldTopLeft = this.rectangle.getTopLeft();
            double new_width = this.rectangle.getTopLeft().x - newTopLeft.x;
            double new_height = newTopLeft.y - this.rectangle.getTopLeft().y;

            newTopLeft.y -= new_height;
            this.rectangle.setTopLeft(newTopLeft);
            this.rectangle.setWidth(new_width);
            this.rectangle.setHeight(new_height);

            this.model.addDrawable(this.rectangle);
            this.rectangle.setTopLeft(oldTopLeft);
        } else if (x >= 0 && y <= 0) {
            Point newTopLeft = new Point(mouseEvent.getX(), mouseEvent.getY());
            Point oldTopLeft = this.rectangle.getTopLeft();
            double new_width = newTopLeft.x - this.rectangle.getTopLeft().x;
            double new_height = this.rectangle.getTopLeft().y - newTopLeft.y;

            newTopLeft.x -= new_width;
            this.rectangle.setTopLeft(newTopLeft);
            this.rectangle.setWidth(new_width);
            this.rectangle.setHeight(new_height);

            this.model.addDrawable(this.rectangle);
            this.rectangle.setTopLeft(oldTopLeft);
        } else {
            this.rectangle.setWidth(x);
            this.rectangle.setHeight(y);

            this.model.addDrawable(this.rectangle);
        }
    }

    /**
     * @param mouseEvent
     */
    @Override
    protected void onMouseRelease(MouseEvent mouseEvent) {
        if (this.rectangle != null) {
            Point newTopLeft = this.rectangle.getTopLeft();// by default, newTopLeft == old topLeft
            double height = mouseEvent.getY() - this.rectangle.getTopLeft().y;
            double width = mouseEvent.getX() - this.rectangle.getTopLeft().x;

            // The following if else block adjusts topLeft if needed
            if (height < 0 && width < 0) {//both height & width are negative, topLeft is actually bottom right
                newTopLeft = new Point(mouseEvent.getX(), mouseEvent.getY());
                height = height * -1;
                width = width * -1;
            } else if (height < 0) { //only height is negative, then topLeft is actually bottom left.
                newTopLeft = new Point(this.rectangle.getTopLeft().x, mouseEvent.getY());
                height = height * -1;//make it non-negative
            } else if (width < 0) { //only height is negative, then topLeft is actually top right.
                newTopLeft = new Point(mouseEvent.getX(), this.rectangle.getTopLeft().y);
                width = width * -1;// make it non-negative
            }

            this.rectangle.setTopLeft(newTopLeft);
            this.rectangle.setHeight(height);
            this.rectangle.setWidth(width);

            this.model.addDrawable(this.rectangle);
            System.out.println("Added Rectangle"); //alerting the console
            this.rectangle = null;
        }
    }
}
