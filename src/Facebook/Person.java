package Facebook;

import java.util.LinkedList;
import static java.lang.Integer.MIN_VALUE;

/**
 * This class creates Person objects that represent the profiles
 */
public class Person {
    private String name;
    private int key;
    private LinkedHash friendList;
    private Person next;

    /**
     * Default Constructor
     */
    public Person(){
        this.name = "";
        this.friendList = null;
        this.next = null;
        this.key = MIN_VALUE;
    }

    /**
     * Another constructor that creates a Person object for
     * a person by the name. It takes the first letter of their name
     * and converts it to a number, which will be used as the key.
     * @param s Name of a person
     */
    public Person(String s){
        this.name = s;
        this.friendList = new LinkedHash();
        this.next = null;
        this.key = 0;
        for (int i = 0; i < s.length(); i++){
            this.key = this.key + (int) s.charAt(i);
        }
    }

    /**
     * Set a Person object to the next of another Person object
     * @param p a Person object
     */
    public void setNext(Person p){
        this.next = p;
    }

    /**
     * Get the next of a Person object
     * @return a Person object
     */
    public Person getNext(){return this.next;}

    /**
     * Get the key of a Person object
     * @return an integer
     */
    public int getKey(){
        return key;
    }

    /**
     * Get the name of a Person object
     * @return a string
     */
    public String getName(){
        return name;
    }

    /**
     * Get the friend list of a Person object
     * @return a LinkedHash object
     */
    public LinkedHash getFriendList(){
        return friendList;
    }


}
