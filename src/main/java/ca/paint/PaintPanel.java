package ca.utoronto.utm.assignment2.paint;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class PaintPanel extends Canvas implements Observer {

    public PaintPanel() {
        super(300, 300);
    }

    @Override
    public void update(Observable o, Object arg) {
        GraphicsContext g2d = this.getGraphicsContext2D();
        g2d.clearRect(0, 0, this.getWidth(), this.getHeight());

        PaintModel model = (PaintModel) o;

        // Draw
        ArrayList<Drawable> drawables = model.getDrawables();
        for (Drawable drawable : drawables) {
            drawable.draw(g2d);
        }
    }
}
