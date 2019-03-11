/**
  Implement a list of integer elements, including
  both data and operations.
 */

public class List_inArraySlotsv1 {

    private int[] elements;     // container for the elements of the list
    private int filledElements; // the number of elements in this list

    private static final int INITIAL_CAPACITY = 10;

    /**
      Construct an empty list with a small initial capacity.
     */
    public List_inArraySlotsv1() {
        elements = new int[ INITIAL_CAPACITY];
        // filledElements has been initialized to the desired value, 0
    }


    /**
      @return the number of elements in this list
     */
    public int size() {
        return filledElements;
    }


     /**
       @return a string representation of this list,
       in [a,b,c,] format
      */
    public String toString() {
        String result = "[";
        for( int elemIndex = 0; elemIndex < filledElements; elemIndex++)
            result += elements[ elemIndex] + ",";
        return result + "]";
    }


    /**
      Appends @value to the end of this list.

      @return true, in keeping with conventions yet to be discussed
     */
     public boolean add( int value) {
         // expand if necessary
         if( filledElements == elements.length) expand();

         elements[ filledElements] = value;
         filledElements++;
         // idiomatic version: elements[ filledElements++] = value;
        return true;
}


    /**
      Double the capacity of the List_inArraySlots,
      preserving existing data.
     */
     private void expand() {
        System.out.println( "expand... (for debugging)");
           /* S.O.P. rules for debugging:
              Working methods should be silent. But during
              development, the programmer must verify that
              this method is called when that is appropriate.
              So test using the println(), then comment it out.
              */
        int[] bigger = new int[ elements.length * 2];
        for( int elemIndex = 0; elemIndex < filledElements; elemIndex++)
            bigger[ elemIndex] = elements[ elemIndex];
        elements = bigger;
     }

     /**
  accessor
  @return element @index from this list
  precondition: @index is within the bounds of the array.
      (Having warned the user about this precondition,
       you should NOT complicate your code to check
       whether user violated the condition.)
 */

public int get( int index ) {
  return elements[index];
}


/**
  Store et value at @index to @newValue

  @return old value at @index
  @precondition: @index is within the bounds of this list.
 */
public int set( int index, int newValue ) {
  int currentValue = elements[index];
  elements[index] = newValue;
  return currentValue;
}


/**
  Remove the element at position @index in this list.
  Shift any subsequent elements to the left (that is,
  decrease the index associated with each).

  @return the value that was removed from the list
 */
 public int remove( int index) {
   int removed = elements[index];
   for (int i = index; i < filledElements; i++){
     elements[i] = elements[i+1];
   }
   filledElements -= 1;
   return removed;
 }


/**
  Insert @value at position @index in this list.

  Shift the element currently at that position (if any)
  and any subsequent elements to the right
  (that is, increase the index associated with each).
 */
 public void add( int index, int value) {
     add( index + 1, elements[index]);
     //for (int i = index; i < elements.length; i++)
     remove(index);
     set (index, value);
 }
}
