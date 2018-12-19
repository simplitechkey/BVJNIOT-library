/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barcode.bvjniot;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author omkarkamate
 */
public class SecondController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private JFXButton returnbtn;

    @FXML
    void ret(ActionEvent event) {
        returnbtn.getScene().getWindow().hide();
        System.out.println("I am hidden find me if you can");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
