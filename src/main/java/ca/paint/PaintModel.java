package ca.utoronto.utm.assignment2.paint;

import java.util.ArrayList;
import java.util.Observable;

/**
 * The Model for the Paint program.
 */
public class PaintModel extends Observable {

        private ArrayList<Drawable> drawables = new ArrayList<>();

        public void addDrawable(Drawable drawable) {
                this.drawables.add(drawable);
                setChanged();
                notifyObservers();
        }

        /**
         * Removes all mid-construction ovals.
         *
         * @author moha2780
         */
        public void clearOvals(){
                drawables.removeIf(drawable -> drawable instanceof Oval);
                setChanged();
                notifyObservers();
        }

        public ArrayList<Drawable> getDrawables() {
                return drawables;
        }

        public void clearDrawables() {
                drawables.clear();
        }

}
