// the main package
package staffentryarraylist;

//import the library to could read and write from ,to txt files
import java.io.*;

//import libraries to work with javafx codes 
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class StaffEntryArrayList extends Application {
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    //the main function (the start of the program)
    public static void main(String[] args) {
        launch(args);
    }
    
    //function to read the items from the text file
    public static void read(ArrayList staffArray)
    {
        
        try
        {
            //create a reader to read from the located file
            FileReader fr = new FileReader("C:\\Users\\habib\\Desktop\\project\\StaffEntryArrayList\\staffinfo.txt");
            BufferedReader br = new BufferedReader(fr);
            
            //declare a variable to hold the line
            String line;
           
            //loop on each line in the file
            while((line =  br.readLine()) != null)
            {
                //make split to the line to be 0 = name ,1 = number
                String [] tmp = line.split("-");
               
                //create new object of staffentry class to store the data in
                StaffEntry staff = new StaffEntry(tmp[0],tmp[1]);
                
                //store the staff object  in the list
                staffArray.Insert(staff);
            }
           
            //close the reader
            br.close();
        }
        // this catch for if there an errors
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    //function to write the items of the list in text file 
    public static void Write(ArrayList staffArray)
    {
        //to sort the array before printing
        staffArray.insertionSort(staffArray.arr);
        
        try
        {
            //create objects to build text file and print on it
            FileWriter fw = new FileWriter("staffinfo.txt");
            PrintWriter pw = new PrintWriter(fw);
            
            //loop on the list to print it's items
            for(int j = 0; j <= staffArray.size; j++)
            {
                /*convert the items in the list to string to could print it
                and then print it by the printer object (pw) in the text file we created
                */ 
                pw.println(staffArray.getItem(j).toString());
            }
            
            //close the printer
            pw.close();
        }
        // this catch for if there an errors
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
}
