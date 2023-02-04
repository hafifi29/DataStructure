
package staffentrylinkedlist;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import static staffentrylinkedlist.StaffEntryLinkedList.Write;



public class DisplayLinkedListController implements Initializable {

    @FXML TableView<StaffEntry> lstableview;
    @FXML TableColumn<StaffEntry , String> lsnameCol;
    @FXML TableColumn<StaffEntry , String> lsphneCol;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        lsnameCol.setCellValueFactory(new PropertyValueFactory<StaffEntry,String>("name"));
        lsphneCol.setCellValueFactory(new PropertyValueFactory<StaffEntry,String>("office_number"));
        
        
            loadData(FXMLDocumentController.staffList);
        
    }   
    public void loadData(MyLinkedList my_array) {
        lstableview.getItems().clear();
        
        
        for (int i = 0; i <= my_array.size; i++) {
            lstableview.getItems().add(my_array.getItem(i));
        }
    }
   
    
    @FXML
    public void DisplayClicked(ActionEvent event)throws IOException
    {
        Parent display = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene displayScene = new Scene(display);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(displayScene);
        window.show();
    }
    
    @FXML
    public void saveClicked()
    {
        Write(FXMLDocumentController.staffList);
    }
}
