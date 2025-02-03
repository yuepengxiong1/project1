package linkedListWorker;
import linkedListPackage.IntNode;
public class runnableLinkedList {
    public static void main(String[] args) {
        System.out.println("Program Started");

        IntNode value1 = new IntNode(100, null,null);

        value1.addNodeAfter(101);
        value1.addNodeAfter(102);
        value1.addNodeAfter(103);

        System.out.println("Number of notes in the linked list at this time is: " + value1.countNodes());

        value1.searchNode(103);

        value1.deleteNodeAfter(103);
        value1.searchNode(103);

        IntNode targetNode = value1.searchNode(102);
        
    }
}
