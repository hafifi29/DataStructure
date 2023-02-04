//the main package
package staffentryarraylist;

//class of array to hold in the all teacher data objects
public class ArrayList {

    //array of staffEntry with max size 1000
    public StaffEntry[] arr;
    private int MaxSize = 1000;
    public int size;

    //default constructor
    public ArrayList() {
        //build array with size 1000 and initialize the size with -1
        arr = new StaffEntry[MaxSize];
        size = -1;

    }

    //function to insert teacher object in the last of the list
    public void Insert(StaffEntry s) {
        //check if we reach to the max size
        if (size == MaxSize - 1) {
            //return that the array is full
            throw new IllegalArgumentException("Array full");
        } //if not
        else {
            //increase the size and store the object
            arr[++size] = s;
        }
    }

    //function to delete the object by its name
    public void delete(String name) {
        //find the element we want 
        int found = this.linearSearch(name);

        //check if we found
        if (found != -1) {
            //loop the array to shift the elements 
            for (int i = found; i < this.size; i++) {
                arr[i] = arr[i + 1];
            }
            //decrease the size
            arr[this.size] = null;
            this.size--;
        }
    }

    //function to search on the array by name
    public int linearSearch(String name) {
        //loop the array elements
        int i = 0;
        while (i <= this.size) {
            //if the name of this object equal the name we want
            if (arr[i].getName().compareToIgnoreCase(name) == 0) {
                //return it's key in the array
                return i;
            }
            i++;
        }
        //if we don't found it return -1
        return -1;
    }

    //a second way to search
    public StaffEntry binarySearch(String name) {
        //make two variables one referes to the first object and one to the last
        int low = 0;
        int high = this.size;

        //loop until they skip it's half
        while (low <= high) {
            //get the index of the middle object
            int mid = (low + high) / 2;

            //check if this name is equal we want
            if (arr[mid].getName().compareToIgnoreCase(name) == 0) {
                return arr[mid];
            } //if it is bigger
            else if (arr[mid].getName().compareToIgnoreCase(name) > 0) {
                high = mid - 1;
            } //or smaller
            else {
                low = mid + 1;
            }
        }
        //if you don't found it
        return null;
    }

    //function to print the objects of the list
    public void print() {
        for (int i = 0; i <= this.size; i++) {
            System.out.print(arr[i].toString());
        }
    }

    //function to sort the array
    public void insertionSort(StaffEntry[] arr) {
        int in, out;
        //loop on each object in the array except the first one
        for (out = 1; out <= this.size; out++) {
            StaffEntry temp = arr[out];
            in = out;

            //loop on all previous elements until we found smaller object
            while (in > 0 && arr[in - 1].compareTo(temp) > 0) {
                //shift if the previous is larger
                arr[in] = arr[in - 1];
                --in;
            }
            //and put the object in the smaller index we can
            arr[in] = temp;
        }
    }

    //function to get the object by it's key
    public StaffEntry getItem(int key) {
        return arr[key];
    }

    //function to merge sort the array 
    //arr is an temp arr to sort the array in
    public void mergeSort(StaffEntry[] arr, int lower, int upper) {
        //check if the arr size is 0
        if (lower == upper) {
            return;
        } else {
            //find the middle point
            int mid = (lower + upper) / 2;

            //sort the first part
            mergeSort(arr, lower, mid);

            //sort the second part
            mergeSort(arr, mid + 1, upper);

            //merge the two sorted parts
            merge(arr, lower, mid + 1, upper);
        }
    }

    //merging two sorted array
    public void merge(StaffEntry[] tempArray, int lowerIndexCursor, int higerIndex, int upperIndex) {
        //the counter for the array that the data will be sorted in
        int tempIndex = 0;

        //the first array counter
        int lowerIndex = lowerIndexCursor;

        //the middle points between the two arrays
        int midIndex = higerIndex - 1;

        //the number of items to be sorted
        int totalItems = upperIndex - lowerIndex + 1;

        //merging the two array trough comparison
        while (lowerIndex <= midIndex && higerIndex <= upperIndex) {
            //if the item in the upper half is smaller 
            if (arr[lowerIndex].compareTo(arr[higerIndex]) > 0) {
                tempArray[tempIndex++] = arr[higerIndex++];
            } //if the item in the lower half is smaller 
            else {
                tempArray[tempIndex++] = arr[lowerIndex++];
            }

        }
        //transfare all the remaining items from the lower half to the temp array 
        while (lowerIndex <= midIndex) {
            tempArray[tempIndex++] = arr[lowerIndex++];
        }

        //transfare all the remaining items from the upper half to the temp array  
        while (higerIndex <= upperIndex) {
            tempArray[tempIndex++] = arr[higerIndex++];
        }

        //copying the temp array to the original array
        for (int i = 0; i < totalItems; i++) {
            arr[lowerIndexCursor++] = tempArray[i];
        }

    }

}
