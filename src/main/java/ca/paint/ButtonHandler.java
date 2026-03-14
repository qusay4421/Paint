//package ca.utoronto.utm.assignment2.paint;
//
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.control.Button;
//
//public class ButtonHandler implements EventHandler<ActionEvent> {
//
//    private ShapeChooserPanel shapeChooserPanel;
//    private Button button;
//    private PaintPanelEventHandler ppHandler;
//    private View view;
//
//    protected ButtonHandler(ShapeChooserPanel shapeChooserPanel, Button button, PaintPanelEventHandler ppHandler, View view){
//        this.shapeChooserPanel = shapeChooserPanel;
//        this.button = button;
//        this.ppHandler = ppHandler;
//        this.view = view;
//    }
//
//    /**
//     * @param event
//     */
//    @Override
//    public void handle(ActionEvent event) {
//        String command = (String) button.getUserData();
//        System.out.println("Button clicked: "+command);
//
//        shapeChooserPanel.clearHighlight();
//
//        shapeChooserPanel.highlightButton(button);
//
//        shapeChooserPanel.setSelectedButton(button);
//
//        ppHandler.setMode(command);
//        view.setMode(command);
//
//    }
//}

package ca.utoronto.utm.assignment2.paint;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonHandler implements EventHandler<ActionEvent> {

    private ShapeChooserPanel shapeChooserPanel;
    private PaintPanelEventHandler ppHandler;
    private View view;

    protected ButtonHandler(ShapeChooserPanel shapeChooserPanel, PaintPanelEventHandler ppHandler, View view) {
        this.shapeChooserPanel = shapeChooserPanel;
        this.ppHandler = ppHandler;
        this.view = view;
    }

    /**
     * Handles button click events and updates the mode in PaintPanelEventHandler.
     * @param event ActionEvent triggered by button click
     */
    @Override
    public void handle(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String command = (String) clickedButton.getUserData(); // Get the shape name
        System.out.println("Button clicked: " + command);

        shapeChooserPanel.clearHighlight();
        shapeChooserPanel.highlightButton(clickedButton);
        shapeChooserPanel.setSelectedButton(clickedButton);
        ppHandler.setMode(command);
    }
}
