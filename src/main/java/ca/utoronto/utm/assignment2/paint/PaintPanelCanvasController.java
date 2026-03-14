package ca.utoronto.utm.assignment2.paint;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class PaintPanelCanvasController {
    private PaintModel model;
    private View view;
    public PaintPanelCanvasController(PaintModel model, View view) {
        this.model = model;
        this.view = view;
        resize();
    }

    private void resize() {
        BorderPane root = view.getRoot();
        PaintPanel paintPanel = view.getPaintPanel();

        paintPanel.widthProperty().bind(root.widthProperty());
        paintPanel.heightProperty().bind(root.heightProperty());

        paintPanel.widthProperty().addListener((_, _, newVal) -> draw(paintPanel));
        paintPanel.heightProperty().addListener((_, _, newVal) -> draw(paintPanel));
    }

    private void draw(PaintPanel paintPanel) {
        paintPanel.getGraphicsContext2D().clearRect(0, 0, paintPanel.getWidth(), paintPanel.getHeight());
        paintPanel.update(model, null);
        model.hasChanged();
        model.notifyObservers();
    }
}
