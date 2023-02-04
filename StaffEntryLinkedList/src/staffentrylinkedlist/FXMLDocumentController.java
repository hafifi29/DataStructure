package staffentrylinkedlist;

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
import static staffentrylinkedlist.StaffEntryLinkedList.read;


/**
 *
 * @author habib
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    TextField lsnameInsertTextField;
    
    @FXML
    TextField lsphoneInsertTextField;
    
    @FXML
    TextField lsnameDeleteTextField;
    
    @FXML
    TextField lsnameUpdateTextField;
    
    @FXML
    TextField lsphoneUpdateTextField;
    
    @FXML
    TextField lsnameSearchTextField;
    
    @FXML
    TextField lsofficenumberTextField;
    
    static boolean firstRead = true;
    
    public static MyLinkedList staffList = new MyLinkedList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(firstRead)
        {
            read( staffList );
            firstRead = false;
        }
        
    } 
    
    @FXML
    public void InsertCliked(){
        StaffEntry person = new StaffEntry();
        person.setName(lsnameInsertTextField.getText());
        person.setOffice_number(lsphoneInsertTextField.getText());
        
        staffList.insert(person);
        
        lsnameInsertTextField.clear();
        lsphoneInsertTextField.clear();
    }

    @FXML
    public void DeleteCliked()
    {
        staffList.delete(lsnameDeleteTextField.getText());   
        
        lsnameDeleteTextField.clear();
        lsphoneUpdateTextField.clear();
    }
    
    @FXML
    public void UpdateCliked()
    {
        staffList.linearSearch(lsnameUpdateTextField.getText()).setOffice_number(lsphoneUpdateTextField.getText());
        
        
        lsnameUpdateTextField.clear();
        lsphoneUpdateTextField.clear();
        
    }
    @FXML
    public void DisplayClicked(ActionEvent event)throws IOException
    {
        Parent display = FXMLLoader.load(getClass().getResource("DisplayLinkedList.fxml"));
        
        Scene displayScene = new Scene(display);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
//        DisplayController controller = loader.getController();
//          controller.loadData(staffArray);
        window.setScene(displayScene);
        window.show();
    }
    
    @FXML 
    public void SearchClicked()
    {
        StaffEntry ans = staffList.linearSearch(lsnameSearchTextField.getText());
        
        lsofficenumberTextField.setText(ans.getOffice_number());
    }
    
}
