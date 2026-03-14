package ca.utoronto.utm.assignment2.paint;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;

public class PaintPanelEventHandler implements EventHandler<MouseEvent> {
    private String mode="Circle";
    private PaintModel model;
    private PaintPanel paintPanel;

    private ShapeHandler shapeHandler;

    protected PaintPanelEventHandler(PaintModel model, PaintPanel paintPanel) {

        this.model = model;
        this.paintPanel = paintPanel;

        this.model.addObserver(this.paintPanel);
        this.shapeHandler = new CircleHandler(this.model);     // initialized as circle to match the mode
        paintPanel.addEventHandler(MouseEvent.MOUSE_PRESSED, this);
        paintPanel.addEventHandler(MouseEvent.MOUSE_RELEASED, this);
        paintPanel.addEventHandler(MouseEvent.MOUSE_MOVED, this);
        paintPanel.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
        paintPanel.addEventHandler(MouseEvent.MOUSE_DRAGGED, this);

    }
    public void setMode(String mode){
        this.mode = mode;
        System.out.println(this.mode);

        switch (this.mode){
            case "Circle":
                this.shapeHandler = new CircleHandler(this.model);
                break;
            case "Rectangle":
                this.shapeHandler = new RectangleHandler(this.model);
                break;
            case "Square":
                this.shapeHandler = new SquareHandler(this.model);
                break;
            case "Squiggle":
                this.shapeHandler = new SquiggleHandler(this.model);
                break;
            case "Polyline":
                this.shapeHandler = null;
                break;
            case "Triangle":
                this.shapeHandler = new TriangleHandler(this.model);
                break;
            case "Oval":
                this.shapeHandler = new OvalHandler(this.model);
                break;
            case "Eraser":
                this.shapeHandler = new EraserHandler(this.model);
                break;
            default:
                break;
        }

    }

    public String getMode(){
        return this.mode;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        // Later when we learn about inner classes...
        // https://docs.oracle.com/javafx/2/events/DraggablePanelsExample.java.htm

        // For unimplemented cases
        if(this.shapeHandler == null){
            return;
        }

        EventType<MouseEvent> mouseEventType = (EventType<MouseEvent>) mouseEvent.getEventType();

        if(mouseEventType.equals(MouseEvent.MOUSE_PRESSED)){
            this.shapeHandler.onMousePressed(mouseEvent);
        }else if(mouseEventType.equals(MouseEvent.MOUSE_DRAGGED)){
            this.shapeHandler.onMouseDrag(mouseEvent);
        }else if(mouseEventType.equals(MouseEvent.MOUSE_RELEASED)){
            this.shapeHandler.onMouseRelease(mouseEvent);
        }
    }
}
