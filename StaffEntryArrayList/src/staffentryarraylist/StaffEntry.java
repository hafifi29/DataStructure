//the main package
package staffentryarraylist;

/*the class of the staff teacher
implement comparable interface to could making sort 
*/
public class StaffEntry implements Comparable<StaffEntry> {
    
    //data of each teacher
    private String name;
    private String office_number;

    //the default constructor put value null to both the name and office_number
    public StaffEntry() {
    }

    //constructor with parameters to create object with specific data
    public StaffEntry(String name, String office_number) {
        this.name = name;
        this.office_number = office_number;
    }

    //setters
    
    //function to set the value of name by using it
    public void setName(String name) {
        this.name = name;
    }

    //function to set the value of office_number by using it
    public void setOffice_number(String office_number) {
        this.office_number = office_number;
    }

    //getters
    
    //function to get the name value
    public String getName() {
        return name;
    }

    //function to get the office_number value
    public String getOffice_number() {
        return office_number;
    }

    @Override
    //function return all data of the teacher as string in one line
    public String toString() {
        return name +"-"+ office_number;
    }

  
    @Override
    //function to compare between two objects by its name
    public int compareTo(StaffEntry o) {
        
        //if the string of this object is less than the other return -1
        if (this.name.compareToIgnoreCase(o.name) < 0)
            return -1;
        
        //if the two strings is equal return 0
        else if(this.name.compareToIgnoreCase(o.name) == 0)
            return 0;
        
        //if the string of this object is bigger than the other return 1
        return 1;
    }
    
}
