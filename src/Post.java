// Nathans Post Class
// 9 April 2023
// Nathan Wells

public class Post{

   private String title;
   private String videoFile;
   private int numLikes;

   /**
    * Constructor for a post
    * @param title This is the posts title
    * @param videoFile This is the name of the posts videofile
    * @param numLikes This is the number of likes the post has
    */
   
   public Post(String title, String videoFile, int numLikes){
      this.title = title;
      this.videoFile = videoFile;
      this.numLikes = numLikes;
   }


   /**
    * An equals method to see whether 2 post objects are equal
    * @param o Another object for comparison
    */
   @Override
   public boolean equals(Object o){
      if (o == this)
          return true;
      if (!(o instanceof Post))
          return false;
      Post other = (Post)o;
      boolean postEquals = (this.title == null && other.title == null)
        || (this.title != null && this.title.equals(other.title));
      boolean videofileEquals = (this.videoFile == null && other.videoFile == null)
        || (this.videoFile != null && this.videoFile.equals(other.videoFile));
      return (this.numLikes == other.numLikes) && postEquals && videofileEquals;
   }
   
   /**
    * toString for Post
    * @return This returns a string representation of a post
    */
   public String toString(){
      return "Title: " + this.title + "\n" + "Video: " + this.videoFile + "\n" + "Number of likes: " + String.valueOf(numLikes);
   }

}