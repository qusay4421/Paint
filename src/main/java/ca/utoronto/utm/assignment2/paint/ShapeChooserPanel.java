package ca.utoronto.utm.assignment2.paint;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ShapeChooserPanel extends GridPane {

        private View view;
        private PaintPanelEventHandler ppHandler; // reference to paintPanel to access the current mode
        private Button selectedButton;

        public ShapeChooserPanel(View view, PaintPanelEventHandler ppHandler) {

                this.view = view;
                this.ppHandler = ppHandler;

                String[][] buttonData = {
                        {"Circle", "/assets/circle.jpg"},
                        {"Rectangle", "/assets/rectangle.jpg"},
                        {"Square", "/assets/square.jpg"},
                        {"Triangle", "/assets/triangle.jpg"},
                        {"Squiggle", "/assets/squiggle.jpg"},
                        {"Polyline", "/assets/polyline.jpg"},
                        {"Oval", "/assets/oval.jpg"},
                        {"Eraser", "/assets/eraser.jpg"},
                };

                int row = 0;
                for (String[]data : buttonData) {
                        String shapeName = data[0];
                        String imagePath = data[1];

                        Image image = new Image(getClass().getResourceAsStream(imagePath));

                        ImageView imageView = new ImageView(image);
                        imageView.setFitWidth(50);
                        imageView.setFitHeight(50);

                        Button button = new Button();
                        button.setGraphic(imageView);
                        button.setMinWidth(100);
                        button.setUserData(shapeName);

                        if (shapeName.equals(ppHandler.getMode())){
                                highlightButton(button);
                                selectedButton = button;
                        }

                        this.add(button, 0, row);
                        row++;

                        button.setOnAction(new ButtonHandler(this, ppHandler, view));
                }
        }


        /**
         * highlights the button
         *
         * @param button, the Button object to be highlighted
         * @author liuste15
         */
        protected void highlightButton(Button button) {
                button.setStyle("-fx-border-color: blue; -fx-border-width: 3px;");
        }

        /**
         * clears the highlight from the previously selected button
         * @return
         */
        protected void clearHighlight(){
                if(selectedButton != null) {
                        selectedButton.setStyle("");
                }
        }

        public Button getSelectedButton() {
                return this.selectedButton;
        }

        public void setSelectedButton(Button button){
                this.selectedButton = button;
        }

}


