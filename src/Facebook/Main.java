package Facebook;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import Facebook.Map;

/**
 * Main class
 */
public class Main {
    /**
     * Main options for the user to choose
     * @return an integer
     */
    public static int Options(){
        int input;
        Scanner reader = new Scanner(System.in);
        System.out.println("***************************");
        System.out.print("1-Create a profile\n");
        System.out.print("2-Go to list of profiles\n");
        System.out.print("3-Exit the program\n");
        System.out.println("***************************");
        System.out.print("Choose: ");
        input = Integer.valueOf(reader.next());
        while (input < 1 || input > 3){
            System.out.print("Invalid input!\n");
        }
        return input;
    }

    /**
     * Other options for user to choose after they go to the profile list
     */
    public static void otherOptions(){
        System.out.println("********************************************************");
        System.out.print("1- Search for a person to list his/her friend list\n");
        System.out.print("2- Add someone to a person's friend list\n");
        System.out.print("3- Remove a person from someone's friend list\n");
        System.out.print("4- Check if two persons are friends\n");
        System.out.print("5- Go back to previous page\n");
        System.out.println("********************************************************");
        System.out.print("Choose:\n");
    }

    /**
     * Contains actions such as search for a profile, add friend, remove friend, etc.
     * @param list a Map object that contains the hash table
     */
    public static void Actions(Map list){
        Scanner reader = new Scanner(System.in);
        int input = 1;
        while (input>0 && input < 5){
            otherOptions();
            input = Integer.valueOf(reader.next());
            if (input == 1){ // case 1, search for a person
                searchProfile(list);
            }
            else if (input == 2){ // case 2, add friend
                addFriend(list);
            }
            else if (input == 3){ // case 3, remove friend
                removeFriend(list);
            }
            else if(input == 4){ // action 4, check if 2 people are friends
                checkIfFriend(list);
            }
        }
    }

    /**
     * Check if two people are friends.
     * @param list a Map object that contains the hash table
     */
    public static void checkIfFriend(Map list){
        Scanner reader = new Scanner(System.in);
        System.out.print("Person 1: ");
        String input1 = reader.next();
        System.out.print("Person 2: ");
        String input2 = reader.next();
        // check if the 2 people are in the hash table
        Person p1 = list.Chained_Hash_Search(input1);
        Person p2 = list.Chained_Hash_Search(input2);

        if (p1 !=null && p2!=null){ // if they are, check their friend lists
            if (p1.getFriendList().search(input2) !=null){
                System.out.print("Yes. " + input1 + " and " + input2 + " are friends\n");
            }
            else{ System.out.print("No. " + input1 + " and " + input2 + " are not friends\n");}

        }
        else {System.out.print("Oops! One of the persons does not exist\n");}
    }

    /**
     * Add a person as friend to someone's friend list.
     * @param list a Map object that contains the hash table
     */
    public static void addFriend(Map list) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Add this person: ");
        String input = reader.next();
        System.out.print("To this person's friend list:");
        String input2 = reader.next();
        // Check if the 2 people are in the hash table
        Person p1 = list.Chained_Hash_Search(input);
        Person p2 = list.Chained_Hash_Search(input2);

        if (p1 != null && p2 != null) { // if they are, add them together
            p1.getFriendList().addFirst(input2);
            p2.getFriendList().addFirst(input);
        }
    }

    /**
     * Remove a person from someone's friend list
     * @param list a Map object that contains the hash table
     */
    public static void removeFriend(Map list){
        Scanner reader = new Scanner(System.in);
        System.out.print("Remove this person: ");
        String input = reader.next();
        System.out.print("From this person's friend list:");
        String input2 = reader.next();
        // use chained hash to delete
        list.Chained_Hash_Delete(input,input2);

    }

    /**
     * Create a profile for a person
     * @param list a Map object that contains the hash table
     */
    public static void createProfile(Map list){
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter name:"); // get the person's name
        String input = reader.next();
        System.out.print(input + "'s profile is successfully created!\n");
        list.Chained_Hash_Insert(input); // insert the profile into the hash table
    }

    /**
     * Search for a profile in the hash table
     * @param list a Map object that contains the hash table
     */
    public static void searchProfile(Map list) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter a name you want to search:");
        String input = reader.next();
        Person p = list.Chained_Hash_Search(input);
        // check if that person is in the hash table
        if (p!= null) { // if yes, go to their friend list
            System.out.println("Name: " + p.getName());
            System.out.print(p.getName() + "'s friend list:\n");
            if (p.getFriendList().getSize() > 0) {
                p.getFriendList().printList(); // print friend list
            } else {
                System.out.print(p.getName() + " currently has no friends.\n");
            }
        }
    }

    /*********************************************
     ********      MAIN   *****   FUNCTION  *******
     *********************************************/
    public static void main(String[] args) {
	// write your code here
        Map profileList = new Map();
        int input = 1;
        while (input != 3) {
            input = Options();
            if (input == 1) {
                // create a profile
                createProfile(profileList);
            } else if (input == 2) {
                // go to list of profiles
                profileList.printTable();
                // other actions
                Actions(profileList);
            }
        }
    }

}
