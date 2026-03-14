package ca.utoronto.utm.assignment2.paint;

import javafx.scene.input.MouseEvent;

/**
 * An oval ShapeHandler.
 * This OvalHandler handles MouseEvents when drawing ovals
 */
public class OvalHandler extends ShapeHandler{
    //class attributes
    private Oval oval;
    private FinalOval finalOval;

    public OvalHandler(PaintModel paintModel) {
        super(paintModel);
    }//end of constructor

    /**
     * Updates the model's status as the mouse is pressed.
     * In this case, an oval is created.
     *
     * @param mouseEvent the MouseEvent
     * @author moha2780
     */
    @Override
    protected void onMousePressed(MouseEvent mouseEvent) {
        System.out.println("Started Oval");
        Point topLeft = new Point(mouseEvent.getX(), mouseEvent.getY());
        oval = new Oval(topLeft);
    }

    @Override
    protected void onMouseDrag(MouseEvent mouseEvent) {
        //calculating dimensions of the oval mid-construction
        double x = mouseEvent.getX() - this.oval.getTopLeft().x;
        double y = mouseEvent.getY() - this.oval.getTopLeft().y;
        Point newTopLeft = new Point(mouseEvent.getX(), mouseEvent.getY());

        // The following if else block adjusts topLeft depending on the direction of the mouse drag
        if (x < 0 && y < 0) {   // direction: drag down, right
            Point oldTopLeft = this.oval.getTopLeft();
            double new_width = this.oval.getTopLeft().x - newTopLeft.x;
            double new_height = this.oval.getTopLeft().y - newTopLeft.y;

            this.oval.setTopLeft(newTopLeft);
            this.oval.setWidth(new_width);
            this.oval.setHeight(new_height);

            this.model.addDrawable(this.oval);
            this.oval.setTopLeft(oldTopLeft);
        } else if (x < 0) {     // direction: drag down, left
            Point oldTopLeft = this.oval.getTopLeft();
            double new_width = this.oval.getTopLeft().x - newTopLeft.x;
            double new_height = newTopLeft.y - this.oval.getTopLeft().y;

            newTopLeft.y -= new_height;
            this.oval.setTopLeft(newTopLeft);
            this.oval.setWidth(new_width);
            this.oval.setHeight(new_height);

            this.model.addDrawable(this.oval);
            this.oval.setTopLeft(oldTopLeft);
        } else if (y < 0) {     // direction: drag up, right
            Point oldTopLeft = this.oval.getTopLeft();
            double new_width = newTopLeft.x - this.oval.getTopLeft().x;
            double new_height = this.oval.getTopLeft().y - newTopLeft.y;

            newTopLeft.x -= new_width;
            this.oval.setTopLeft(newTopLeft);
            this.oval.setWidth(new_width);
            this.oval.setHeight(new_height);

            this.model.addDrawable(this.oval);
            this.oval.setTopLeft(oldTopLeft);
        } else {                // direction: drag up, left
            this.oval.setWidth(x);
            this.oval.setHeight(y);

            this.model.addDrawable(this.oval);
        }
    }

    /**
     * Updates the model's status when the mouse is released.
     * In this case, an oval is added to the model.
     *
     * @param mouseEvent the MouseEvent
     * @author moha2780
     */
    @Override
    protected void onMouseRelease(MouseEvent mouseEvent) {
        if (this.oval != null) {
            this.finalOval = new FinalOval(this.oval.getTopLeft());

            // calculating dimensions of the oval
            Point newTopLeft = this.finalOval.getTopLeft();// by default, newTopLeft == old topLeft
            double height = mouseEvent.getY() - this.finalOval.getTopLeft().y;
            double width = mouseEvent.getX() - this.finalOval.getTopLeft().x;

            // The following if else block adjusts topLeft if needed
            if (height < 0 && width < 0) {//both height & width are negative, topLeft is actually bottom right
                newTopLeft = new Point(mouseEvent.getX(), mouseEvent.getY());
            } else if (height < 0) { //only height is negative, then topLeft is actually bottom left.
                newTopLeft = new Point(this.finalOval.getTopLeft().x, mouseEvent.getY());
            } else if (width < 0) { //only height is negative, then topLeft is actually top right.
                newTopLeft = new Point(mouseEvent.getX(), this.finalOval.getTopLeft().y);
            }

            //setting dimensions of the oval
            width = Math.abs(width);
            height = Math.abs(height);
            this.finalOval.setTopLeft(newTopLeft);
            this.finalOval.setHeight(height);
            this.finalOval.setWidth(width);

            this.model.clearOvals();
            this.model.addDrawable(this.finalOval);
            System.out.println("Added Oval");
            this.oval = null;
            this.finalOval = null;
        }

    }

}
