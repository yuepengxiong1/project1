import library.IntNode;

public class intrusionDetectorClass {

	static IntNode head = null;
	
	public static void main(String[] args) {
		
		System.out.println("Prj1 is running.\n");
		
		
		head = new IntNode(13, head, 230185386);		
	    head.displayNodeData(head);

		
	    removeDuplicate(13);
		if (head != null)
	       head.displayNodeData(head);
		else
		{
		   System.out.print("The linked list is empty.\n");
		   System.out.print(" \n");
		}
		addNodeInOder(13, 308329763);
	    head.displayNodeData(head);
	    
		removeDuplicate(14); 
	    head.displayNodeData(head);
		addNodeInOder(14, 248041794);
	    head.displayNodeData(head);

		removeDuplicate(14); 
	    head.displayNodeData(head);
		addNodeInOder(14, 295106305);
	    head.displayNodeData(head);
	    
		removeDuplicate(15); 
	    head.displayNodeData(head);
		addNodeInOder(15, 325615905);
	    head.displayNodeData(head);
	    
		removeDuplicate(16); 
	    head.displayNodeData(head);
		addNodeInOder(16, 652976466);
	    head.displayNodeData(head);
	    
		removeDuplicate(17); 
	    head.displayNodeData(head);
		addNodeInOder(17, 847897267);
	    head.displayNodeData(head);

		removeDuplicate(17); 
	    head.displayNodeData(head);
		addNodeInOder(17, 927847798);
	    head.displayNodeData(head);
	  
	    System.out.println("End of run.\n");
	    
	}
	
	
	// Precondition: head refers the first node in the linked list, or is null when the linked list is empty.
	// The linked list contains at least one element.
	// Postcondition: If the linked list contains a node with sequenceNumber equal to target, 
	// then that node is removed from the linked list. Otherwise, no changes are made.
	public static IntNode removeDuplicate(int target)   
	{
		//if the IntNode object is nothing then return the IntNode object: null
	    if (head == null)
	    	return head;
		
		System.out.println("Running removeDuplicate() on target " + target + "\n");
		
		IntNode previous = null;
		
		//if the target is equal to the sequence number
		//System.out.println("Target: " + target + " head.getSe: " + head.getsequenceNumber(true));// added for personal use, to see what happens

	    if (target == head.getsequenceNumber(true))
	    {
	    	head = head.getLink(); //set head to be the sequence number containing its data
	    }	
	    else
			//set previous to be head(list, target to find). setting the head to be where sequenceNumber is equal to what node it is in with
	        previous = head.findPrevious(head, target);
	    
			//if the previous is not nothing then
	    if (previous != null) 
			//remove the node after 
	        previous.removeNodeAfter();
	    	    
	    return head;
	} 
	
	
	// Precondition: head refers the first node in the linked list, or is null when the linked list is empty.
	// Postcondition: A new node with attributes target and data is created. Target serves as sequenceNumber.
	// The new node is added to the linked list so that its sequenceNumber preserves the ascending order of the linked list
	// relative to the sequenceNumber.
	public static IntNode addNodeInOder(int target, int data)   
	{
        IntNode previous = null;
		
        System.out.println("Running addNodeInOrder() on target " + target + " and data " + data + "\n");
        
		//if the head is an empty object
        if (head == null)
        {
           head = new IntNode(target, head, data);	 //create an entry with target, on variable, with data
           return head;	 //return the variable
        }
        
		//if target is less than our sequence number
        if (target < head.getsequenceNumber(true))
			//we make head to be a new IntNode to where target is now our first pair of numbers
        	head = new IntNode(target, head, data);
        else
			//else, we locate the the node from before to see if it exists, output the variable and store it into previous
		    previous = head.locatePredecessor(head, target);
		
		//if previous is an empty IntNode
		if (previous != null)
			//add a node after on the variable
		   previous.addNodeAfter(data, target);
		
		return head;
	}

}
