package staffentryarraylist;

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
import static staffentryarraylist.FXMLDocumentController.staffArray;
import static staffentryarraylist.StaffEntryArrayList.Write;


public class DisplayDataController implements Initializable {
    
    int firsttime =0;
    
    @FXML TableView<StaffEntry> tableview;
    @FXML TableColumn<StaffEntry , String> nameCol;
    @FXML TableColumn<StaffEntry , String> phneCol;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        nameCol.setCellValueFactory(new PropertyValueFactory<StaffEntry,String>("name"));
        phneCol.setCellValueFactory(new PropertyValueFactory<StaffEntry,String>("office_number"));
        
        
            loadData(FXMLDocumentController.staffArray);
   
    }  
    public void loadData(ArrayList my_array) {
        
        my_array.insertionSort(staffArray.arr);
        tableview.getItems().clear();
        
        
        for (int i = 0; i <= my_array.size; i++) {
            tableview.getItems().add(my_array.getItem(i));
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
        Write(FXMLDocumentController.staffArray);
    }
    
}
