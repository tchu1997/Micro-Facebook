package Facebook;

import java.util.LinkedList;
import Facebook.Person;

/**
 * This class creates a hash table that indexes each profile under the name
 */
public class Map {
    private final static int TABLE_SIZE = 11;
    private LinkedHash[] table = new LinkedHash[TABLE_SIZE];

    /**
     * Default constructor
     */
    public Map(){
        //create an empty table
        for (int i = 0; i < TABLE_SIZE; i++){
            table[i] = new LinkedHash();
        }
    }

    /**
     * Print the whole table from index 0 to 12. Each index contains
     * a linked list of Person objects.
     */
    public void printTable(){
        boolean checkIfEmpty = true;
        System.out.print("\nList of all profiles:\n");
        for (int i = 0; i < TABLE_SIZE; i++){
            // each index i contains a linked list
            LinkedHash items = table[i];
            if (items.getSize() > 0) { // if linked list not empty
                items.printList(); // print the list
                checkIfEmpty = false;
            }
        }
        if (checkIfEmpty){ // print error if list is empty
            System.out.println("There are no profiles currently");
        }
    }

    /**
     * Insert a profile in the hash table using chained hashing. If two
     * elements have the same index, the second one will be appended to the
     * head of the linked list, at the same index.
     * @param s The name of the person
     */
    public void Chained_Hash_Insert(String s){
            Person p = new Person(s);
            // divide the key by the table size, then get the remainder for the index
            int index = p.getKey() % TABLE_SIZE;
            LinkedHash list = table[index]; // get the linked list at that index
            list.addFirst(s); // add the new profile to the linked list
            table[index] = list; // update the linked list
    }

    /**
     * Search for an element/profile in the hash table. Return true if found, false if not.
     * @param n Name of the person to be searched
     * @return a Person object
     */
    public Person Chained_Hash_Search(String n){
        for(int i = 0; i < TABLE_SIZE; i++){
            LinkedHash items = table[i];
            Person profile = items.search(n);
            if (profile!=null){ // if the person is found
                return profile;
            }
        }
        // show error if cannot find the person
        System.out.print("Sorry we cannot find " + n + " in the profile list.\n");
        return null;
    }

    /**
     * Remove a person from someone's friend list.
     * @param n1 Name of person 1
     * @param n2 Name of person 2
     */
    public void Chained_Hash_Delete(String n1, String n2){
        // check if the two persons are in the hash table
        Person p1 = Chained_Hash_Search(n1);
        Person p2 = Chained_Hash_Search(n2);

        if (p1 !=null && p2 !=null){ // if they are in the hash table
            // remove each person off each other's friend list
            if (p1.getFriendList().remove(n2) && p2.getFriendList().remove(n1))
            { System.out.print(n1 + " and " + n2 + " are no longer friends.\n");}
            else{ // if one of them is not on the other's friend list
                System.out.print("Oops! One of the persons is not in the other's friend list.\n");
            }
        }

    }
}
