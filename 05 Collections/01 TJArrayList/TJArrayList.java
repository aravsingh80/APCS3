// Name: J1-24
// Date: 12-8-2020

/**
 * Implements the cheat sheet's List interface.  Implements generics.
 * The backing array is an array of (E[]) new Object[10];
 * @override toString()
 */ 
public class TJArrayList<E>
{
   private int size;							//stores the number of objects
   private E[] myArray;
   public TJArrayList()                //default constructor makes 10 cells
   {
      myArray = (E[]) new Object[10];
      size = 0;                         //default constructor
   }
   public int size()
   {
      return size;    //returns size
   }
 	/* appends obj to end of list; increases size;
      must be an O(1) operation when size < array.length, 
         and O(n) when it doubles the length of the array.
	  @return true  */
   public boolean add(E obj)
   {
      if(size < myArray.length)
      {
         myArray[size] = obj;
      }
      else
      {
         E[] myArray2 = (E[]) new Object[2*size];
         for(int x = 0; x < size; x++)
            myArray2[x] = myArray[x];
         myArray2[size] = obj;
         myArray = myArray2;
      }
      size++;
      return true;
   }
   /* inserts obj at position index.  increments size. 
		*/
   public void add(int index, E obj) throws IndexOutOfBoundsException  //this the way the real ArrayList is coded
   {
      if(index > size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      if(!(size < myArray.length))
      {
         E[] myArray2 = (E[]) new Object[2*size];
         for(int x = 0; x < size; x++)
            myArray2[x] = myArray[x];
         myArray = myArray2;
      }
      if(myArray[index] != null)
      {
         if(myArray[index + 1] == null)
         {
            E temp = myArray[index];
            myArray[index] = obj;
            myArray[index+1] = temp;
         }
         else
         {
            E temp = myArray[index];
            E temp2 = myArray[index+1];
            myArray[index] = obj;
            myArray[index + 1] = temp;
            temp = temp2;
            int x = index+1;
            while(myArray[x+1] != null)
            {
               temp2 = myArray[x+1];
               myArray[x+1] = temp;
               temp = temp2;
               x++;
            }
            myArray[x+1] = temp;
         }
      }
      else
      {
         myArray[index] = obj;
      }
      size++;
      
   }

   /* return obj at position index.  
		*/
   public E get(int index) throws IndexOutOfBoundsException
   {
      return myArray[index];
   }
   /**
    * Replaces obj at position index. 
    * @return the object is being replaced.
    */  
   public E set(int index, E obj) throws IndexOutOfBoundsException  
   { 
      E temp = myArray[index];
      myArray[index] = obj;
      return temp;
   }
 /*  removes the node from position index. shifts elements 
     to the left.   Decrements size.
	  @return the object at position index.
	 */
   public E remove(int index) throws IndexOutOfBoundsException  
   {
      E temp = myArray[index];
      for(int x = index; x < size-1; x++)
      {
         myArray[x] = myArray[x+1];
      }
      size--;
      return temp;
   }
	   /*
		   This method compares objects.
         Must use .equals(), not ==
     	*/
   public boolean contains(E obj)
   {
      for(int x = 0; x < size; x++)
      {
         if(myArray.equals(obj))
         {
            return true;
         }
      }
      return false;
   }
	 /*returns a String of E objects in the array with 
       square brackets and commas.
     	*/
   public String toString()
   {
      String list = "[";
      for(int x = 0; x < size; x++)
      {
         if(x == (size - 1))
            list = list + "" + myArray[x] + "]";
         else
            list = list + "" + myArray[x] + ", ";
      } 
      return list;
   }
}