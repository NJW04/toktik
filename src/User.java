// Nathans User Class
// 9 April 2023
// Nathan Wells


import java.util.ArrayList;

public class User implements Comparable<User>{

   private String accountName;
   private String profileDescription;
   private ArrayList<Post> posts;
   private ArrayList<User> followers;


   /**
    * Creates a new user object
    * @param accountName The name of the account
    * @param profileDescription The profile description for the account
    */
   public User(String accountName, String profileDescription){
      this.accountName = accountName;
      this.profileDescription = profileDescription;
      posts = new ArrayList<Post>();
      followers = new ArrayList<User>();
   }
   
   
   /**
    * An accessor method for the account name
    * @return It is returning the account name
    */
   public String getAccountName(){
      return this.accountName;
   }
   
   /**
    * An accessor method for the account description
    * @return It is returning the account description
    */
   public String getProfileDescription(){
      return this.profileDescription;
   }
   
   
   /**
    * A method to compare 2 users according to their account name
    * @param anotherUser This is another User object that is being compared
    * @return It is returning a number depending on which one is bigger,smaller or equal
    */
   @Override 
   public int compareTo(User anotherUser){
      return this.accountName.compareTo(anotherUser.getAccountName());
   } 
   
   
   
   /**
    * A toString method for the user class
    * @return It is returning a string representation of this object
    */
   public String toString(){
      return "The name of this account is " + this.accountName + ". This is a short description of this account: " + this.profileDescription; 
   }
   
   
   /**
    * A method to add a post to the users account
    * @param post This is a post which is being added to the users account
    */
   public void addPost(Post post){
      this.posts.add(post);
   }

   /**
    * A method to delete a post for an account
    * @param post Which is the post that is removed from the arraylist of posts
    */
   public void deletePost(Post post){
      for(int i = 0; i < posts.size();i++){
         if (this.posts.get(i).equals(post)){
            this.posts.remove(i);
            System.out.println("Post Deleted.");
            return;
         }
   }
      System.out.println("Post not found, check that all the details are correct.");
}
   
   /**
    * A method to print out all posts for a user by newest posts first
    */
   public void printAllPosts(){
      if (posts.size() == 0){
         System.out.println("There are no posts for this account.");
         return;
      }
      else{
         for(int i = (posts.size() - 1); i >= 0; i--){ //Going from back to front to get newest post first
            System.out.println(posts.get(i).toString());
         }
      }
   }


   /**
    * A method to add a follower for an account
    * @param follower This is a user object who is added as a follower
    */
   public void addFollower(User follower){
      if (this.followers.contains(follower)){
         System.out.println("You are already following " + this.accountName + ".");
      }
      else{
         this.followers.add(follower);
         System.out.println(follower.getAccountName() + ", you are now following, " + this.accountName );
      }
   }


   /**
    * A method to print all followers for an account, and prints a special message if the account has 0 followers
    */
   public void printAllFollowers(){
      if (followers.size() == 0){
         System.out.println("You have 0 followers :(. Maybe try posting some videos of cats?");
      }else{
      for(int i=0;i<followers.size();i++){
         System.out.println(followers.get(i).getAccountName());
      }
         if (this.followers.size() == 1)
            System.out.println("This account has " + this.followers.size() + " follower");
         else
            System.out.println("This account has " + this.followers.size() + " followers");
      
      }
   }

  

}