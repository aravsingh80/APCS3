// Name: J1-24
// Date: 2-19-2021

interface BSTinterface
{
   public int size();
   public boolean contains(String obj);
   public void add(String obj);
   //public void addBalanced(String obj);
   public void remove(String obj);
   public String min();
   public String max();
   public String display();
   public String toString();
}

/*******************
Copy your BST code.  Implement the remove() method.
Test it with BST_Delete.java
**********************/
public class BST implements BSTinterface
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
      if(t != null)
      {
         while(t.getLeft() != null)
         {
            t = t.getLeft();
         }
      }
      return "" + t.getValue();
   }
   
   public String max()
   {
      return max(root);
   }
   private String max(TreeNode t)  //recursive helper method
   {
      if(t != null)
      {
         while(t.getRight() != null)
         {
            t = t.getRight();
         }
      }
      return "" + t.getValue();
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

   public void remove(String target)
   {
      root = remove(root, target);
      size--;
   }
   private TreeNode remove(TreeNode current, String target)
   {
      if(current == null)
         return current;
      else if(target.compareTo((String)current.getValue()) < 0)
         current.setLeft(remove(current.getLeft(), target));
      else if(target.compareTo((String)current.getValue()) > 0)
         current.setRight(remove(current.getRight(), target));
      else
      {
         if(current.getLeft() == null)
            return current.getRight();
         else if(current.getRight() == null)
            return current.getLeft();
         else
         {
            String temp = min(current.getRight());
            current.setValue(temp);
            current.setRight(remove(current.getRight(), temp));
         }
      }
      return current;
   }
}