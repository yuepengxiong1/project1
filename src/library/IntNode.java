package library;

public class IntNode
{
   private int sequenceNumber;
   private int data;
   private IntNode link;   

   
   // Precondition:
   // Postcondition: All instance variables of the IntNode class are initialized.
   public IntNode(int initialsequenceNumber, IntNode initialLink, int initialdata)
   {
        sequenceNumber = initialsequenceNumber;
        link = initialLink;
        data = initialdata;
   }

   
   // Precondition: This instance of the IntNode class exists.
   // In other words, the object whose method is activated exists as a node in the linked list. 
   // Postcondition: A new node with attributes item and data is created. Item serves as sequenceNumber.
   // The new node is added to the linked list at a position that comes immediately after the node whose method is activated.
   public void addNodeAfter(int data, int item)   
   {
      //i did this to make it more sense. we are linking nodes together here
	   IntNode nodeFromBefore = this.link;
      new IntNode(data, nodeFromBefore, item);

   }
   
   
   // Precondition: This instance of the IntNode class exists.
   // In other words, the object whose method is activated exists as a node in the linked list. 
   // Postcondition: The specific node, which comes immediately after the node whose method is activated, 
   // is removed from the linked list.
   public void removeNodeAfter( )   
   {
	   this.link = null;
   } 
   
   
   // Precondition: This instance of the IntNode class exists.
   // Postcondition: The sequenceNumber of this node is returned, after setting detectionFlag to false.
   public int getsequenceNumber(boolean detectionFlg)   
   {
      //if the parameter of the boolean flag is passed in true, we gonna return the sequence number
      if (detectionFlg == true){
         return sequenceNumber;
      }

      //otherwise we just return -1
      return -1;

   }
   
  
   // Precondition: This instance of the IntNode class exists.
   // Postcondition: The link of this node is returned.
   public IntNode getLink( )
   {
      //just returns the link of this node
	    return this.link;                                          
   } 
    
   
   // Precondition: The linked list contains at least one element.
   // Postcondition: The (sequence number, data) pairs of each node in the linked list, starting with the head,
   // are displayed on the monitor. 
   public void displayNodeData(IntNode head)
   {
      System.out.println("The (sequence number, data) pairs in the linked list are: (" + sequenceNumber + "," + data + ")");
   }
   
   
   // Precondition: The head of the linked list is different than null, and its sequenceNumber is different than target.
   // Postcondition: The link to the specific node, which comes before the node whose sequenceNumber is equal to target, 
   // is returned. If the linked list does not contain a node with sequenceNumber equal to target, then null is returned.   
   public IntNode findPrevious(IntNode head, int target)
   {
      IntNode iterateIntNode = head;
	   //in the IntNode head, we are going to find a sequence number that is equal to target
      //loop head from first one then iterate to the next one
   
      if(iterateIntNode.sequenceNumber == target){
         return iterateIntNode;
      } else {
         //set iterate IntNode to become the next one in line
         iterateIntNode = new IntNode(this.getsequenceNumber(true), this, this.data);
      }
      return null;
   }

   
   // Precondition: The head of the linked list is different than null, and its sequenceNumber is smaller than target.
   // Postcondition: The link to the specific node, which comes before the node that is the first in the linked list 
   // to have a sequenceNumber greater than target, is returned. 
   // If no such node is found, the link to the last node in the linked list is returned. 
   public IntNode locatePredecessor(IntNode head, int target)
   {
	    
   }
  
}
           