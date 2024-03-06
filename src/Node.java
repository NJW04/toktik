// Nathans Node Class
// 9 April 2023
// Nathan Wells


public class Node{
   
   private User data;
   private Node left;
   private Node right;
   
   /**
    * Creates a new node 
    * @param data The data type for the node which is a User object
    */
   public Node(User data){
      this.data = data;
      this.left = null;
      this.right = null;
   }
   
   /**
    * Creates a new node 
    * @param data The data type for the node which is a User object
    * @param l Which is a node for the left of this node
    * @param r Which is a node for the right of this node
    */
   public Node(User data, Node l, Node r ){
      this.data = data;
      this.left = l;
      this.right = r; }
      
   /**
    * @return returns this nodes data
    */   
   public User getData() {return this.data;}

   /**
    * @return returns this nodes left node
    */
   public Node getLeft() {return this.left;}

   /**
    * @return returns this nodes right node
    */
   public Node getRight() {return this.right; }
  
   /**
    * A mutator method for this nodes left node
    * @param node The node to which we set this nodes left node
    */
   public void setLeft(Node node) {this.left = node;}

   /**
    * A mutator method for this nodes right node
    * @param node The node to which we set this nodes right node
    */
   public void setRight(Node node) {this.right = node;}

   /**
    * A mutator method for this nodes data
    * @param User We set this nodes data to the user parameter
    */
   public void setData(User user) {this.data = user;}
}