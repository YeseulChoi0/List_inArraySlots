//received help from Greg Zborovsky

/**
  Implement a list of integer elements, including
  both data and operations.
 */

public class List_inArraySlots {

    private int[] refArray;
    private int filledElements = 0;

    private static final int INITIAL_CAPACITY = 5;

    /**
      Construct an empty list with a small initial capacity.
     */
    public List_inArraySlots() {
      refArray = new int[INITIAL_CAPACITY];
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
      String rep = "[";
      for (int i = 0; i < filledElements; i++){
        rep += refArray[i] + " , ";
      }
      return rep + "]";
    }


    /**
      Appends @value to the end of this list.

      @return true, in keeping with conventions yet to be discussed
     */
     public boolean add( int value) {
       System.out.println(refArray.length);
       if (filledElements == refArray.length){
         expand();
       }
         refArray[filledElements] = value;
         filledElements++;
         return true;
     }


    /**
      Double the capacity of the List_inArraySlots,
      preserving existing data
     */
     private void expand() {
        System.out.println( "expand... (for debugging)");
           /* S.O.P. rules for debugging:
              Working methods should be silent. But during
              development, the programmer must verify that
              this method is called when that is appropriate.
              So test using the println(), then comment it out.
              */
        int[] newRefArray = new int[refArray.length * 2];
        for (int i = 0; i < refArray.length; i++){
          newRefArray[i] = refArray[i];
        }
        refArray = newRefArray;
     }
}
