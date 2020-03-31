package Facebook;

/**
 * This class creates a LinkedList of Person objects
 */
public class LinkedHash {
    private Person nil;
    private Person head;

    /**
     * Default constructor
     */
    public LinkedHash(){ // creates an empty linked list
        nil = new Person();
        head = nil;
        head.setNext(nil);
    }

    /**
     * Get the size of the linked list
     * @return an integer
     */
    public int getSize(){
        int count = 0;
        Person x = head;
        while (x!=nil){
            x = x.getNext();
            count = count + 1;
        }
        return count;
    }

    /**
     * Print the whole linked list
     */
    public void printList(){
        Person x = head;
        while (x != nil) {
            System.out.print(x.getName() + "\n");
            x = x.getNext();
        }
    }

    /**
     * Add a node to the head of a linked list
     * @param s
     */
    public void addFirst(String s) {
        Person p = new Person(s);
        p.setNext(head);
        head = p;
    }

    /**
     * Search for a node in a linked list
     * @param s Name of the person to be searched
     * @return a Person object
     */
    public Person search(String s){
        Person x = head;
        while (x!=nil){
            if (x.getName().equals(s)){
                return x; // return the object if fount
            }
            x = x.getNext();
        }
        return null; // return null if the node cant be found
    }

    /**
     * Remove a specific node in a linked list. Return true
     * if function successfully removes the node, else return false.
     * @param s Name of the person to be removed
     * @return true or false
     */
    public boolean remove(String s){
        if (head==nil){ // if linked list is empty
            System.out.print(s + "'s friend list is empty.\n");
            return false;
        }
        if (head.getName().equals(s)){ // check the first node/head
            head = head.getNext();
            return true;
        }
        Person x = head;
        while (x!=nil){ // check other nodes
            if (x.getNext().getName().equals(s)){
                Person z = x.getNext();
                x.setNext(z.getNext());
                return true;
            }
            else {
                x = x.getNext();
            }
        }
        return false;
    }
}
