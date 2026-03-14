package ca.utoronto.utm.assignment2.paint;

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

public class Circle implements Drawable{
        private Point centre;
        private double radius;

        public Circle(Point centre, int radius){
                this.centre = centre;
                this.radius = radius;
        }

        public Point getCentre() {
                return centre;
        }

        public void setCentre(Point centre) {
                this.centre = centre;
        }

        public double getRadius() {
                return radius;
        }

        public void setRadius(double radius) {
                this.radius = radius;
        }

        /**
         * @param g2d
         */
        @Override
        public void draw(GraphicsContext g2d) {
                double x = this.getCentre().x;
                double y = this.getCentre().y;
                double radius = this.getRadius();
                    /* The centre of fillOval is top left corner so we have to do math to
                     adjust so it looks centred in the panel */
                g2d.setFill(Color.GREEN);
                g2d.fillOval(x - radius, y - radius, radius * 2, radius * 2);
        }
}
