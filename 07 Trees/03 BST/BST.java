//Name: J1-24  
//Date: 2-11-2021

interface BSTinterface
{
   public int size();
   public boolean contains(String obj);
   public void add(String obj);
   //public void addBalanced(String obj);
   //public boolean remove(String obj);
   public String min();
   public String max();
   public String toString();
}

/*******************
Represents a binary search tree holding Strings. 
Implements (most of) BSTinterface, above. 
The recursive methods all have a public method calling a private helper method. 
Copy the display() method from TreeLab. 
**********************/
class BST implements BSTinterface
{
   private TreeNode root;
   private int size;
   public BST()
   {
      root = null;
      size = 0;
   }
   public int size()
   {
      return size;
   }
   public TreeNode getRoot()   //for Grade-It
   {
      return root;
   }
   /***************************************
   @param s -- one string to be inserted
   ****************************************/
   public void add(String s) 
   {
      size++;
      if(root == null)
         root = new TreeNode(s);
      else
         add(root, s);
   }
   private TreeNode add(TreeNode t, String s) //recursive helper method
   {  
      if(s.compareTo("" + t.getValue()) <= 0)
      {
         if(t.getLeft() != null)
            add(t.getLeft(), s);
         else
            t.setLeft(new TreeNode(s));
      }
      else
      {
         if(t.getRight() != null)
            add(t.getRight(), s);
         else
            t.setRight(new TreeNode(s));
      }
      return t;
   }
   
   public String display()
   {
      return display(root, 0);
   }
   private String display(TreeNode t, int level) //recursive helper method
   {
      String toRet = "";
      if(t == null)
         return "";
      toRet += display(t.getRight(), level + 1);
      for(int k = 0; k < level; k++)
         toRet += "\t";
      toRet += t.getValue() + "\n";
      toRet += display(t.getLeft(), level + 1);
      return toRet;
   }
   
   public boolean contains( String obj)
   {
      return contains(root, obj);
   }
   private boolean contains(TreeNode t, String x) //recursive helper method
   {
      if(t == null)
         return false;
      else if(x.equals("" + t.getValue()))
         return true;
      else if(x.compareTo("" + t.getValue()) <= 0)
         return contains(t.getLeft(), x);
      else
         return contains(t.getRight(), x);
   }
   
   public String min()
   {
      return min(root);
   }
   private String min(TreeNode t)  //use iteration
   {
      while(t.getLeft() != null)
      {
         t = t.getLeft();
      }
      return "" + t.getValue();
   }
   
   public String max()
   {
      return max(root);
   }
   private String max(TreeNode t)  //recursive helper method
   {
      while(t.getRight() != null)
      {
         t = t.getRight();
      }
      return "" + t.getValue();
   }
   public TreeNode queueToTree( Queue<Comparable> q )
   
   {
      if( q.isEmpty() )
         return null;
      Queue<Comparable> q1 = new LinkedList<Comparable>();
      Queue<Comparable> q2 = new LinkedList<Comparable>();
      Comparable x, y;
      x = q.remove();
      while( !q.isEmpty() )
      {
         y = q.remove();
         if( y.compareTo(x) < 0 )
            q1.add( y );
         else
            q2.add( y );
      }
      return new TreeNode( x, queueToTree(q1), queueToTree(q2) );
   }
   public String toString()
   {
      return toString(root);
   }
   private String toString(TreeNode t)  //an in-order traversal.  Use recursion.
   {
      String toReturn = "";
      if(t == null)
         return "";
      toReturn += toString(t.getLeft());	       						 	
      toReturn += t.getValue() + " ";    				 					
      toReturn += toString(t.getRight());          								
      return toReturn;
   }
}
