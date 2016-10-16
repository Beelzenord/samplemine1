import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Model;
import model.Zone;

public class Main extends Application {
   
    
    @Override
    public void start(Stage primaryStage) {
        
        Model model = new Model();
        model.init();
        System.out.println(model.getGrid().toString());
        
        
        GridPane grid = new GridPane();
        //
        int numRows = model.getGrid().getNumRows();
        int numColumns = model.getGrid().getNumColumns();;
        // 
        for (int row = 0 ; row < numRows ; row++ ){
            RowConstraints rc = new RowConstraints();
            rc.setFillHeight(true);
            rc.setVgrow(Priority.ALWAYS);
            grid.getRowConstraints().add(rc);
        }
        for (int col = 0 ; col < numColumns; col++ ) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setFillWidth(true);
            cc.setHgrow(Priority.ALWAYS);
            grid.getColumnConstraints().add(cc);
        }

        for (int x = 0; x < numColumns; x++) {
            for (int y = 0; y < numRows; y++) {
                Button button = createButton("");
                grid.add(button, x, y);
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        grid.getChildren().remove(button);
                        Integer x = GridPane.getColumnIndex(button);
                        Integer y = GridPane.getRowIndex(button);
                         
                        Zone z = model.getZone(x, y);
                        System.out.println("(" + x + "," + y + ")");
                        if (z.hasBomb()) {
                            System.out.println("Game Over!");
                            grid.add(new Label("*"), x, y);
                        }
                        else {
                            int nearbyBombs = z.getNearbyBombs();
                            grid.add(new Label(" " + nearbyBombs + " "), x, y);
                        }
                    }
                });
            }
        }
        
        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createButton(String text) {
        Button button = new Button(text);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        button.setOnAction(e -> System.out.println(text));
        return button ;
    }

    public static void main(String[] args) {
        launch(args);
    }
}