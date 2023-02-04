//the main package
package staffentrylinkedlist;

//class of list to hold in the all teacher data objects
public class MyLinkedList {
    
    //class to build the node which had the staffentry object
    public class Node
    {
        //nodes datafields
        public StaffEntry value;
        public Node next;

        //node constructor
        public Node(StaffEntry value) {
            this.value = value;
        }
    }
    
    //list datafields
    public Node head;
    public Node end;
    public int size;
    
    //default constructor
    public MyLinkedList()
    {
        head = null;
        size = -1;           
    }
    
    //function to insert teacher object in the last of the list
    public void insert (StaffEntry s)
    {
        //check if the list is empty
        if(head == null)
        {
            //make the inserted node the heaad and the end
            head = end = new Node(s);
            size++;
        }
        //if not
        else
        {
            //insert in the end of the list
            end =  end.next = new Node(s);
            
            //increase the size
            size++;
        }
    }
    
    //function to delete the object by its name
    public void delete (String name)
    {
        //check if the first node is that what we want if it is exist
        Node currNode = this.head, prev = null;
        if (currNode != null && currNode.value.getName().equalsIgnoreCase(name))
        {
            //delete it and make the head is the next node
            this.head = currNode.next;
            //decrease the size
            size--;
        }
        
        //if not loop the list until u find it or the list is finished
        while (currNode != null && currNode.value.getName().compareToIgnoreCase(name) != 0)
        {
            prev = currNode;
            currNode = currNode.next;
        }
 
        //chek the reason of finishing the loop
        //if you found the node
        if (currNode != null) 
        {
            //make previous node refere to the next node to current
            prev.next = currNode.next;
            
            //decrease the size
            size--;
        }
        //or say that you don'y found
        else {
            throw new IllegalArgumentException("not found");
        }
    }   
    
    //function to search on the array by name
    public StaffEntry linearSearch(String name) 
    {
        //loop the list elements
        Node pointer = head;
        
        while(pointer != null) 
        {
            //if you found it return the staff object
            if(pointer.value.getName().equals(name)) {
                
                return pointer.value;
            }
            pointer = pointer.next;
        }
        //if you don't found it print not found
        throw new IllegalArgumentException("person not avilable");
    }
    
    //function to find the middle node to use in binary search
    Node middleNode(Node start, Node last)
    {
        //check if it is empty
        if (start == null)
            return null;
        
        //slow walk the half distance fast walk to get the middle node
        Node slow = start;
        Node fast = start.next;
 
        while (fast != last)
        {
            fast = fast.next;
            if (fast != last)
            {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }
     
    //binary search function
    public Node binarySearch(String name)
    {
        //start at the first of the list and the last at the end
        Node start = head;
        Node last = null;
 
        do
        {
            //get the middle node
            Node mid = middleNode(start, last);
 
            //if there isn't a middle then you don't fount it
            if (mid == null)
            {
                return null;
            }
            
            //if the middle is exist
            //check if it equal what we want return it
            if (mid.value.getName().compareToIgnoreCase(name) == 0)
            {
                return mid;
            }
 
            //check if is bigger make start in second half of the list
            else if (mid.value.getName().compareToIgnoreCase(name) > 0)
            {
                start = mid.next;
            }
            
            //if smaller make last in the second half of the list
            else
            {
                last = mid;
            }   
        } while (last == null || last != start);
 
        //if you don't found it
        return null;
    }
    
    //function to sort the list with the name
    public void selection_sort() 
    {
        //select each element in the list
        Node pointer = head;

        while (pointer != null) {
            Node min = pointer;
            Node next = pointer.next;
            
            //and compare it with all next elements to find the min element
            while (next != null) {
                if (min.value.getName().compareTo(next.value.getName()) > 0)
                    min = next;

                next = next.next;
            }

            //swap them to put the min in the first
            StaffEntry temp = pointer.value;
            pointer.value = min.value;
            min.value = temp;
            pointer = pointer.next;
        }
    }
    
    //get the object by it's position
    public StaffEntry getItem(int position) 
    {
        //check if the list is empty
        if(head == null)
            return null;
        
        //if the number sent out of the range
        else if (position < 0 && position > size -1) 
            return null;
        
        //the range is right
        else {
            //loop until find the position
            Node ptr = head;
            for (int i = 0; i < position ; i++)
                ptr = ptr.next;
            return ptr.value;
        }
    }
    
    //function to insert in the first of the list
    public void front(StaffEntry  v)
    {
        //build node refere to the head and equal staffEntry we want to insert
        Node node=new Node(v);
        node.next=head;
        head=node;
    }
}
