// Nathans Binary Search Tree Class
// 9 April 2023
// Nathan Wells


public class BinarySearchTree{

   //BST root node 
   private Node root;
   
   /*
    * Constructor for BST => initial empty tree
    */
    public BinarySearchTree(){ 
        this.root = null; 
    } 
    
    
    public Node getRoot() {return this.root;}

    /**
     * Find the profile description for a given account
     * @param accountName The accountname with the description we are searching for
     * @return Returns the account description if found
     */
    public String findDescription(String accountName){
      Node answer;
      if (root == null)
         return null;
      else
         answer = find(accountName, root);
         if (answer == null)
            return null;
         else
            return answer.getData().getProfileDescription();
    }
 

      /**
       * Helper method for find description method
       * @param accountName The accountname with the description we are searching for
       * @param root Root node
       * @return returns the Node with matching account name
       */
      public Node find(String accountName, Node root){ //Now we traverse until we find matching name
         int cmp = accountName.compareTo(root.getData().getAccountName()); //Seeing whether accountName is =,< or > alphabetically
     
         if (cmp == 0)
            return root;
         else if (cmp < 0)
            return (root.getLeft() == null) ? null : find (accountName, root.getLeft());
         else
            return (root.getRight() == null) ? null : find (accountName, root.getRight());   
  }
  
  
  
  /**
   * Visiting node and printing out information
   * @param node the node we want to print information out for
   */
   public void visit (Node node){
      System.out.println(node.getData()); //Prints the toString for User
   }
   
  
   /**
    * Starts the preOrder method with the root node
    */
   public void preOrder(){
      if (this.root == null){
         System.out.println("There are 0 accounts present.");
      }
      else{
         preOrder(this.root);
      }
   }
  
   /**
    * Visits every node using going from fully left, then right.
    * @param node Gets sent the root node first then visiting and getting the left and right nodes recursively
    */
   public void preOrder(Node node){
      if (node != null){
         visit(node);
         preOrder(node.getLeft());
         preOrder(node.getRight());
      } 
} 
 
  
  
  /**
   * Insert new account into tree.
   * @param user New user object to insert into the BST
   */
  public void insert (User user){
      if (root == null)
         root = new Node(user, null, null);
      else
         insert(user, root);
} 


  /**
   * Search until an empty spot is found and is done accordingly
   * @param user User we want to insert into the BST
   * @param root Starting at the root node
   */
  public static void insert (User user, Node root){
     if (user.compareTo(root.getData()) <= 0){
        if (root.getLeft() == null)
           root.setLeft(new Node(user, null, null));  
        else
           insert(user, root.getLeft());
}  
        else {
        if (root.getRight() == null)
           root.setRight(new Node(user, null, null));
        else
           insert (user, root.getRight());
      }
   }    
  
  
  
  /**
   * Delete an account
   * @param accountName The account name of the account we want to delete
   */
  public void delete (String accountName){
      root = delete(accountName, root);
   }
   
   /**
    * Helper method for delete method
    * @param accountName The name of the account we want to delete
    * @param root Starting at the root node of the BST
    * @return returns the node we in turn delete
    */
   public Node delete(String accountName, Node root){
      if (root == null) return null;
      int cmp = accountName.compareTo(root.getData().getAccountName());
      
      if (cmp < 0)
         root.setLeft(delete(accountName, root.getLeft())); 
      else if (cmp > 0)
         root.setRight(delete(accountName, root.getRight()));
      else if (root.getLeft() != null && root.getRight() != null){
         root.setData(findMin(root.getRight()).getData());
         root.setRight(removeMin (root.getRight()));
      }
      else
         if (root.getLeft() != null)
            root = root.getLeft();
         else 
            root = root.getRight();
            
      return root;    
   }
   

   /**
    * Helper functions for the delete method
    * @param node finds the minimum from sent in node
    * @return returns minimum node
    */
   public Node findMin(Node node){
      if (node != null)
         while (node.getLeft() != null)
            node = node.getLeft();
      return node;
   }
   
   /**
    * Removes the minimum 
    * @param node removes node
    * @return returns node to be removed
    */
   public Node removeMin(Node node){
      if (node == null)
         return null;
      else if (node.getLeft() != null)
      {  
         node.setLeft(removeMin (node.getLeft()));
         return node;
      }
      else
         return node.getRight();
   }
   
   
   
   /**
    * Display all posts for a given account
    * @param accountName The name of the account we want to display all posts for
    */
   public void displayPosts(String accountName){
      Node account = find(accountName,this.root); //this is the account we want to print all posts for
      account.getData().printAllPosts();
   
   }
   
   
   /**
    * Add post for account in BST
    * @param accountName The account we are adding the post to
    * @param post The post we are adding
    */
   public void addPost(String accountName, Post post){
       Node account = find(accountName, this.root); //Find account and use its add post method
       account.getData().addPost(post);
   }


   /**
    * Delete post for account in tree
    * @param accountName The account which we are deleting a post from
    * @param post The post object we are deleting from the account
    */
   public void deletePost(String accountName, Post post){
      Node account = find(accountName, this.root); //Find account and use its delete post method
      account.getData().deletePost(post);
  }



  /**
   * A method to add a follower for a chosen account
   * @param accountName The name of the account to which we are adding the follower to
   * @param follower The user object we are adding as a follower
   */
  public void addFollower(String accountName, User follower){
      Node account = find(accountName,this.root);
      account.getData().addFollower(follower);
  }


  /**
   * A method to print out all followers for an account
   * @param accountName The name of the account we want to print out all followers for
   */
  public void printFollowers(String accountName){
   Node account = find(accountName,this.root);
   account.getData().printAllFollowers();
}

      
   
   
   
    
}