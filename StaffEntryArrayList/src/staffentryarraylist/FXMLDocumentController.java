/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffentryarraylist;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static staffentryarraylist.StaffEntryArrayList.read;

/**
 *
 * @author habib
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    TextField nameInsertTextField;
    
    @FXML
    TextField phoneInsertTextField;
    
    @FXML
    TextField nameDeleteTextField;
    
    @FXML
    TextField nameUpdateTextField;
    
    @FXML
    TextField phoneUpdateTextField;
    
    @FXML
    TextField nameSearchTextField;
    
    @FXML
    TextField officenumberTextField;
    
    public static ArrayList staffArray = new ArrayList();
    
    static int firstRead =0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        if (firstRead == 0)
        {
            read(staffArray);
            firstRead++;
            StaffEntry [] temp = new StaffEntry[staffArray.size +1];
            staffArray.mergeSort(temp, 0, staffArray.size);
            
        }
         
    }

    @FXML
    public void InsertCliked(){
        StaffEntry person = new StaffEntry();
        person.setName(nameInsertTextField.getText());
        person.setOffice_number(phoneInsertTextField.getText());
        
        staffArray.Insert(person);
        
        nameInsertTextField.clear();
        phoneInsertTextField.clear();
    }

    @FXML
    public void DeleteCliked()
    {
        staffArray.delete(nameDeleteTextField.getText());   
        
        nameDeleteTextField.clear();
        
    }
    
    @FXML
    public void UpdateCliked()
    {
        staffArray.binarySearch(nameUpdateTextField.getText()).setOffice_number(phoneUpdateTextField.getText());
        
        
        nameUpdateTextField.clear();
        phoneUpdateTextField.clear();
        
    }
    @FXML
    public void DisplayClicked(ActionEvent event)throws IOException
    {
        Parent display = FXMLLoader.load(getClass().getResource("DisplayData.fxml"));
        
        Scene displayScene = new Scene(display);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        

        window.setScene(displayScene);
        window.show();
    }
    
    @FXML 
    public void SearchClicked()
    {
        StaffEntry ans = staffArray.getItem(staffArray.linearSearch(nameSearchTextField.getText()));
        
        officenumberTextField.setText(ans.getOffice_number());
    }
    
    
    
}
