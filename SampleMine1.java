/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samplemine1;

import java.lang.reflect.InvocationTargetException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author fauzianordlund
 */
public class SampleMine1 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        MineField mField = new MineField();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        View view = new View();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
