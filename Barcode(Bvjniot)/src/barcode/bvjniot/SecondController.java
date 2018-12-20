/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barcode.bvjniot;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import org.sqlite.SQLiteConfig;

/**
 * FXML Controller class
 *
 * @author omkarkamate
 */
public class SecondController implements Initializable {

    /**
     * Initializes the controller class.
     * 
     */
      ObservableList<Databasesample> data=FXCollections.observableArrayList();
    
    private static Statement stat;
    private PreparedStatement preparedStatement;
      ResultSet rs ;
        private  Connection con=SqliteConnection.Connector();

    @FXML
    private VBox drawer;
     @FXML
    private Button returnbtn;
       @FXML
    private TableView<Databasesample> tableView;

  
    @FXML
    void ret(ActionEvent event) {
        TranslateTransition openNav = new TranslateTransition(new Duration(350), drawer);
        openNav.setToX(0);
        TranslateTransition closeNav = new TranslateTransition(new Duration(350), drawer);
      if (drawer.getTranslateX() != 0) {
                openNav.play();
            } else {
                closeNav.setToX(-(drawer.getWidth()));
                closeNav.play();
            }
      
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
        if(con!=null){
           System.out.println("bvjniot");
        }else{
            System.out.println("bvjnio21223dmnit");
        }
       /* final ObservableList<Databasesample> data = FXCollections.observableArrayList(
             new Databasesample(1, 1, "jacob.smith@example.com"),
             new Databasesample(1, 1, "jacob.smith@example.com"),
             new Databasesample(1, 1, "jacob.smith@example.com"),
             new Databasesample(1, 1, "jacob.smith@example.com"),
             new Databasesample(1, 1, "jacob.smith@example.com")
            );*/
        
           
        TableColumn albumId = new TableColumn("Albumid");
        albumId.setCellValueFactory(new PropertyValueFactory<Databasesample, Integer>("albumId"));
        
        TableColumn artistId = new TableColumn("Artistid");
        artistId.setCellValueFactory(new PropertyValueFactory<Databasesample,Integer>("artistId"));
        
        TableColumn artistName = new TableColumn("artistname");
        artistName.setCellValueFactory(new PropertyValueFactory<Databasesample,String>("artistName"));
        //tableView.setItems(data);
         
        loadDatabaseData();
        tableView.getColumns().addAll(albumId, artistId, artistName);
        
       
        }catch(Exception e){
            e.printStackTrace();
        }


        
    }
    
    public void loadDatabaseData(){
          try {               
              String query="select * from albums";
              preparedStatement=con.prepareStatement(query);
              rs=preparedStatement.executeQuery();
              while(rs.next()){
                  data.add(new Databasesample(
                  rs.getInt("AlbumId"),
                          rs.getString("Title"),
                           rs.getInt("ArtistId")
                  ));
                  tableView.setItems(data);
                  System.out.println
                          (rs);
              }
              preparedStatement.close();
              rs.close();
          } catch (SQLException ex) {
              Logger.getLogger(SecondController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    }    
    

