package ca.utoronto.utm.assignment2.paint;

import javafx.scene.input.MouseEvent;

/**
`* The abstract class for handing MouseEvent generated from mouse interaction
 * on PaintPanel.
 *
 * @author wuyuhua2
 */
abstract public class ShapeHandler {

    PaintModel model;
    public ShapeHandler(PaintModel model){
        this.model = model;
    }

    /**
     * Method for handing MOUSE_PRESSED MouseEvent.
     *
     * @author wuyuhua2
     */
    abstract protected void onMousePressed(MouseEvent mouseEvent);

    /**
     * Method for handing MOUSE_DRAGGED MouseEvent.
     *
     * @author wuyuhua2
     */
    abstract protected void onMouseDrag(MouseEvent mouseEvent);

    /**
     * Method for handing MOUSE_RELEASED MouseEvent.
     *
     * @author wuyuhua2
     */
    abstract protected void onMouseRelease(MouseEvent mouseEvent);
}
