public class TestLists {
    public static void main(String[] args) {
        System.out.println("LinkedList demonstration:");
        LinkedListExample lList = new LinkedListExample(5);
        lList.printAll();

        lList.addAtTail(17);
        lList.printAll();
        lList.addAtTail(88);
        lList.printAll();

        lList.addAtHead(55);
        lList.printAll();
        lList.addAtHead(23);
        lList.printAll();

        lList.removeAtTail();
        lList.printAll();

        System.out.println("ArrayList demonstration:");

        ArrayListExample aList = new ArrayListExample(7);

        aList.addAtEnd(7);
        aList.printAll();
        aList.addAtEnd(3);
        aList.printAll();
        aList.addAtEnd(12);
        aList.printAll();
        aList.addAtEnd(1200);
        aList.printAll();

        System.out.println("Actual array size: " + aList.getRealArrayLength());
        System.out.println("Total elements stored: " + aList.getLength());

        aList.addAtEnd(1);
        aList.printAll();
        aList.addAtEnd(13);
        aList.printAll();
        aList.addAtEnd(125);
        aList.printAll();
        aList.addAtEnd(81);
        aList.printAll();

        System.out.println("Actual array size: " + aList.getRealArrayLength());
        System.out.println("Total elements stored: " + aList.getLength());
    }
}
