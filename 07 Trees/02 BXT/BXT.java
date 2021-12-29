// Name: J1-24
// Date: 2-9-2021
/*  Represents a binary expression tree.
 *  The BXT builds itself from postorder expressions. It can
 *  evaluate and print itself.  Also prints inorder and postorder strings. 
 */
 
import java.util.*;

public class BXT
{
   private TreeNode root;   
   public static final String operators = "+ - * / % ^ !";
   public static final String numbers = "1234567890";
   public BXT()
   {
      root = null;
   }
   public TreeNode getRoot()   //for Grade-It
   {
      return root;
   }
    
   public void buildTree(String str)
   {
      String[] s = str.split(" ");
      Stack<TreeNode> t = new Stack<TreeNode>();
      for(String p : s)
      {
         if(!(isOperator(p)))
            t.push(new TreeNode(p));
         else
         {
            TreeNode x = new TreeNode(p);
            if(!(t.isEmpty()))
               x.setRight(t.pop());
            if(!(t.isEmpty()))
               x.setLeft(t.pop());
            t.push(x);
         }
      }
      root = t.pop();
   }
   
   public double evaluateTree()
   {
      return evaluateNode(root);
   }
   
   private double evaluateNode(TreeNode t)  //recursive
   {
      if(!(isOperator("" + t.getValue())))
         return Double.parseDouble("" + t.getValue());
      else
      {
         return computeTerm("" + t.getValue(), evaluateNode(t.getLeft()), evaluateNode(t.getRight()));
      }
   }
   
   private double computeTerm(String s, double a, double b)
   {
      double x = 0;
      switch(s)
      {
         case("*"): 
            x = a * b;
            break;
         case("+"): 
            x = a + b;
            break;
         case("-"): 
            x = a - b;
            break;
         case("/"): 
            x = a / b;
            break;
      }
      return x;
   }
   
   private boolean isOperator(String s)
   {
      if(operators.contains(s))
      {
         if(!(numbers.contains(s)))
            return true;
      }
      return false;
   }
   
   public String display()
   {
      return display(root, 0);
   }
   
   private String display(TreeNode t, int level)
   {
      String toRet = "";
      if(t == null)
         return "";
      toRet += display(t.getRight(), level + 1); //recurse right
      for(int k = 0; k < level; k++)
         toRet += "\t";
      toRet += t.getValue() + "\n";
      toRet += display(t.getLeft(), level + 1); //recurse left
      return toRet;
   }
    
   public String inorderTraverse()
   {
      return inorderTraverse(root);
   }
   
   private  String inorderTraverse(TreeNode t)
   {
      String s = "";
      if(t == null)
         return "";
      s += inorderTraverse(t.getLeft());	       						 		
      s += t.getValue() + " ";    				 					
      s += inorderTraverse(t.getRight());          				
      return s;
   }
   
   public String preorderTraverse()
   {
      return preorderTraverse(root);
   }
   
   private String preorderTraverse(TreeNode root)
   {
      String s = "";
      if(root == null)
         return "";
      s += root.getValue() + " "; 
      s += preorderTraverse(root.getLeft());	       						 		   				 					
      s += preorderTraverse(root.getRight());          				
      return s;
   }
   
  /* extension */
   // public String inorderTraverseWithParentheses()
   // {
      // return inorderTraverseWithParentheses(root);
   // }
//    
   // private String inorderTraverseWithParentheses(TreeNode t)
   // {
      // return "";
   // }
}