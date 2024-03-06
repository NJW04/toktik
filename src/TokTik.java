//Nathans TokTik Gui
//13 April 2023
//Nathan Wells

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException; 

public class TokTik {

	public static void main(String[] args) {
        BinarySearchTree BST = new BinarySearchTree();
        
		Scanner scanner = new Scanner(System.in);
		
        int choice;
        
        do {
            System.out.println("Choose an action from the menu:");
            System.out.println("1.  Find the profile description for a given account");
            System.out.println("2.  List all accounts");
            System.out.println("3.  Create an account");
            System.out.println("4.  Delete an account");
            System.out.println("5.  Display all posts for a single account");
            System.out.println("6.  Add a new post for an account");
            System.out.println("7.  Load a file of actions from disk and process this");
            System.out.println("8.  Delete a post from an account");
            System.out.println("9.  Select an account to follow");
            System.out.println("10. Display followers for an account");
            System.out.println("11. Quit");

            
            while (true) {
                System.out.print("Enter your choice: ");
            
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    break;
                } else {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.next(); // consume non-integer input
                }
            }

            System.out.println();
            switch (choice) {
                /**
                 * This case is for finding the profile description of an account. The user enters an account name and if it is in the BST,
                 * it outputs the description.
                 */
                case 1:
                    System.out.print("Enter the account name: ");
                    String accountName = scanner.next();
                    String description = BST.findDescription(accountName);
                    if (description != null) {
                    	System.out.println("The profile description is: " + description);
                    } else {
                    	System.out.println("Account not found.");
                    }
                    break;
                /**
                 * This case is for printing out all of the accounts in the BST.
                 */
                case 2:
                  System.out.print("LIST OF ALL ACCOUNTS:\n");
                  
                  BST.preOrder();
                 
                  
                    break;
                
                /**
                 * This case is for creating a new account. The user enters account name and description and if it already exists, an error message
                 * is printed and if its not in the BST it is inserted.
                 */
                case 3:
                 System.out.print("Enter the account name: ");
                  accountName = scanner.next();
                  scanner.nextLine();
                  String desChecker = BST.findDescription(accountName);
                     if (desChecker != null) {
                        System.out.println("Account already exists.");
                     } else {
                        System.out.print("Enter the profile description: ");
                        String profileDescription = scanner.nextLine();
                        User user = new User(accountName, profileDescription);
                        BST.insert(user);
                        System.out.println("Account created successfully.");
                     }
                
                
                  break;
                
                /**
                 * This case is for deleting an account. If the user enters an account name not present in the tree an error message is outputted,
                 * and if it is in the tree then it is deleted.
                 */  
                case 4:
                    System.out.print("Enter the account name: ");
                    accountName = scanner.next();
                    desChecker = BST.findDescription(accountName);
                    if (desChecker != null) {
                      BST.delete(accountName);
                      System.out.println("Account deleted successfully.");
                    } else {
                    	System.out.println("Account not found.");
                    }
                    break;
                /**
                 * This case is for displaying all posts for an account. If the account isnt in the tree, an error message is outputted, and if the 
                 * account is in the tree, all its posts are printed.
                 */
               case 5:
                    System.out.print("Enter the account name: ");
                    accountName = scanner.next();
                    desChecker = BST.findDescription(accountName);
                    if (desChecker != null) {
                    	System.out.println("Posts for account " + accountName + ":");
                    	BST.displayPosts(accountName);
                    } else { 
                    	System.out.println("Account not found.");
                    }
                    break;
                /**
                 * This case is for adding a new post for an account. If the account isnt in the tree, an error message is outputted, and if it is
                 * in the tree, the post is added.
                 */
               case 6:
                    System.out.print("Enter the account name: ");
                    accountName = scanner.next();
                    scanner.nextLine();
                    desChecker = BST.findDescription(accountName);
                    if (desChecker != null) {
                    System.out.print("Enter the post title: ");
                    String title = scanner.nextLine();
                    //scanner.nextLine();
                    System.out.print("Enter the post video: ");
                    String video = scanner.next();
                    System.out.print("Enter the number of likes: ");
                    int likes = scanner.nextInt();
                    //scanner.nextLine();
                    BST.addPost(accountName, new Post(title, video, likes));
                    System.out.println("Post added.");
                   
                    } else {
                    	System.out.println("Account not found.");
                    }
                    break;
                /**
                 * This case is for reading an loading data from a textfile. If the textfile is not found an error message is outputted, and if the
                 * textfile is found, it loads the data accordingly into the BST.
                 */
                case 7:
                  //File Reading and loading code
                    try{
                        System.out.print("Enter the file name: ");
                        String fileName = scanner.next();
                        BufferedReader reader = new BufferedReader(new FileReader(fileName)); //text file user inputs
                        String line = reader.readLine();

                        while (line != null){
                            String[] information = line.split(" "); //Create hussein The lecturer dude. 
                            if (information[0].equals("Create")){
                                String accName = information[1]; //hussein
                                String accountDescription = "";
              
                                for (int i=2; i<information.length; i++){
                                    accountDescription = accountDescription + information[i] + " "; //The lecturer dude
                                }
           
                                User user = new User(accName,accountDescription);
                                BST.insert(user);
              
                            }else if (information[0].equals("Add")) { //hussein video34.mpg 34 Yet another video of cats
                                String[] postInfo = line.split(" ");
                                String accName = postInfo[1];
                                String videoFile = postInfo[2];
                                int numLikes = Integer.parseInt(postInfo[3]);
                                String title = "" ;
                                for (int i=4;i<postInfo.length;i++){
                                        title = title + postInfo[i] + " ";
                                }
              
                                Post post = new Post(title, videoFile, numLikes);
                                BST.addPost(accName, post);
              
           
           }                 
               // read next line
               line = reader.readLine();
           }

           reader.close();
        System.out.println("File Successfully Loaded!");
        
       }catch (IOException f) {
           System.out.println("File not found, try again.");
           }
                    
                    
                    break;
                /**
                 * This case is for deleting a post from an account, if the account isnt in the BST or the post isnt on the users account, 
                 * an error message is outputted, and if it is there it is deleted.
                 */
                case 8:
                    System.out.print("Enter the account name: ");
                    accountName = scanner.next();
                    desChecker = BST.findDescription(accountName);
                    if (desChecker != null) {
                        System.out.print("Enter the post title: ");
                        String title = scanner.next();
                        System.out.print("Enter the post video: ");
                        String video = scanner.next();
                        System.out.print("Enter the number of likes: ");
                        int likes = scanner.nextInt();
                        scanner.nextLine();
                        BST.deletePost(accountName, new Post(title, video, likes));
               
                    } else {
                    System.out.println("Account not found.");
                    }
                    break;

                /**
                 * This case is for following an account, from an account. If either of the accounts arent in the BST, an error message is outputted,
                 * and if they are both in the BST, the follower is added to the users account.
                 */
                case 9:
                    System.out.print("Enter the name of the account you want to follow: ");
                    accountName = scanner.next();
                    String nullChecker = BST.findDescription(accountName);
                    if (nullChecker != null) {
                        System.out.print("Enter your account name: ");
                        String follower = scanner.next();
                        if (BST.findDescription(follower) == null){
                            System.out.println("You don't seem to have an account, create your own account now!");
                        }else{
                            User followerAccount = BST.find(follower,BST.getRoot()).getData();
                            BST.addFollower(accountName,followerAccount);

                        }
           
                        } else {
                        System.out.println("Account not found.");
                        }
                    break;
                
                /**
                 * This case is for displaying all followers for an account. If the account entered isnt in the BST, an error message is outputted, 
                 * and if it is in the tree, the followers and number of followers is outputted.
                 */
                case 10:
                        System.out.print("Enter the name of the account whose followers you want to see: ");
                        accountName = scanner.next();
                        if (BST.findDescription(accountName) == null){
                            System.out.println("Account not found.");
                        }else{
                        System.out.println("FOLLOWERS FOR ACCOUNT: " + accountName);
                        BST.printFollowers(accountName);
                        }
                        break;
                /**
                 * This case is for ending the program and quitting out.
                 */
                case 11:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
            
            System.out.println();
            
        } while (choice != 11);
        
        scanner.close();
    }
}


   

