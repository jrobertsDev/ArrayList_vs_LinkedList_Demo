public class LinkedListExample {
    //Node is a special class representing all we need for each individual piece of the list
    //its role is to know what data it holds, and where to find the next Node
    class Node {
        int data;
        Node next;
        //constructor
        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    //We want to keep track of the head and tail, basically the first and final pieces
    //this is to make operations working with the end and front of the list most efficient
    private Node head;
    private Node tail;
    private int length;

    public LinkedListExample(int data) {
        //when we start off with a single Node, the head and tail are the same Node
        head = new Node(data);
        tail = head;
        length = 1;
    }

    public void addAtHead(int data) {
        Node newHead = new Node(data);
        //have the newly added head point at the current head
        newHead.next = head;
        //update head so it looks at the newly added Node instead
        head = newHead;
        length++;
    }

    public void addAtTail(int data) {
        Node newTail = new Node(data);
        //have the current tail point to the newly added Node
        tail.next = newTail;
        //update tail so it looks at the newly added Node instead
        tail = newTail;
        length++;
    }

    public int removeAtTail() {
        //store the value we're returning before it's lost to the void and eaten by garbage collector
        int returnValue = tail.data;

        //in the case that we only have one Node, removing the tail means removing everything
        if (length == 1) {
            head = null;
            tail = null;
            return returnValue;
        }
        //we're going to jump from Node to Node, until we reach the Node just BEFORE the tail
        //we don't have any faster way to access it unfortunately, and it will become the new tail
        Node current = head;
        for (int i = 0; i < length-1;i++) {
            current = current.next;
        }
        //break the connection to the current tail by setting the next-to-last Node's pointer to next to null
        current.next = null;
        //redefine the tail as the formerly next-to-last Node
        tail = current;

        length--;
        
        return returnValue;
    }

    public int getData(int index) {
        Node current = head;
        //cycle through each Node, starting at the head, until we reach the desired index
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int getLength() {
        return length;
    }

    public void printAll() {
        String output = "";
        Node current = head;
        for (int i = 0; i < length; i++) {
            //an arrow will be placed before each element, except before the first
            if (i > 0) {
                output += "->";
            }
            output += "(" + Integer.toString(current.data) + ")";
            current = current.next;
        }
        System.out.println(output);
    }
}
