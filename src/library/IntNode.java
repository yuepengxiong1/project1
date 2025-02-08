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
      System.out.println("Node: " + this.link + "\n" + "Data: " + data + "\n" + "Item: " + item);
      IntNode storeNode = this.link;
      //i did this to make it more sense. we are linking nodes together here and defining sequence number with an item,
      this.link = new IntNode(item, link, data);

      

      

      //add code to consider if the current node already have a next node. rearrange the links
   }
   
   
   // Precondition: This instance of the IntNode class exists.
   // In other words, the object whose method is activated exists as a node in the linked list. 
   // Postcondition: The specific node, which comes immediately after the node whose method is activated, 
   // is removed from the linked list.
   public void removeNodeAfter( )   
   {
      //set this node of next to be pointing 2 locations after this one, and the same for the one 2 location after to point to this one
      //if the element 2 locations away from this one is empty, then we just unlink this from the next one.
	   this.link = null;
   } 
   
   
   // Precondition: This instance of the IntNode class exists.
   // Postcondition: The sequenceNumber of this node is returned, after setting detectionFlag to false.
   public int getsequenceNumber(boolean detectionFlg)   
   {
      detectionFlg = false;
      return sequenceNumber;
      
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
      //need 2 sliders, slider1 checks for sequencesNymber equal to target, slider2 will follow that from node to node
      IntNode iterateIntNode = head;
	   //in the IntNode head, we are going to find a sequence number that is equal to target
      //loop head from first one then iterate to the next one
      
      while(iterateIntNode.sequenceNumber != target){

         if(iterateIntNode.sequenceNumber == target){
            return iterateIntNode;
         } else {
            //set iterate IntNode to become the next one in line
            iterateIntNode = new IntNode(iterateIntNode.sequenceNumber, iterateIntNode.link, this.data);
         }
      }
      
      return null;
   }

   
   // Precondition: The head of the linked list is different than null, and its sequenceNumber is smaller than target.
   // Postcondition: The link to the specific node, which comes before the node that is the first in the linked list 
   // to have a sequenceNumber greater than target, is returned. 
   // If no such node is found, the link to the last node in the linked list is returned. 
   public IntNode locatePredecessor(IntNode head, int target)
   {
	    //want the link that comes before a node, return the link of the node from before
       //2 slider references
       //ex: we have first element where the sequenceNumber is 5, target is 6. We move from 5 to 7 because 5<6. 
       //one slider: one that switches between node to node
       //the other slider will check

       IntNode node = this.link;
       displayNodeData(node);

       return node;
      
      
   }
  
}
           