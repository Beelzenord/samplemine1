/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samplemine1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author fauzianordlund
 */
public class View {
   @FXML
    private MenuBar menuBar;
    @FXML
    private VBox fx_VHbox;

    @FXML
    private MenuItem loadGame;

    @FXML
    private GridPane gPnae;

    @FXML
    private Menu Menu;

    @FXML
    private MenuItem NewGame;

    @FXML
    private Button ze_Button;

    @FXML
    private Pane Pane;

    @FXML
    private MenuItem closeGame;

    @FXML
    private MenuItem saveGame;
    
    @FXML
    void freshPane(ActionEvent event) {
            setupPane();
    }
    @FXML
    void pressedButton(ActionEvent event) {
             System.out.println("Hello");
            
    }
    void setupPane(){
        for(int i = 0 ; i < 3  ; i++){
            for(int j = 0 ; j < 2 ; j++){
                 gPnae.add(new Button(), i,j);
            }
        }
    }
}
