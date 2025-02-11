
//sorry for the comments. i wanted to see how this program is functioning.

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
   
      //System.out.println("Current Node link to next node (this.link): " + this.link + "\n" + "Data to add: " + data + "\n" + "Item to add: " + item);
      IntNode hasNextNode = this.link;
      //check where to insert the node
      //IntNode storeNode = this.link; //purpose to hold the last intnode that was seen. to be used to check for sequenceNumber from before
      //IntNode nextNode = this.link.link; //will store the next node. 

      //if this.link has a link that is nothing (meaning the next node is empty), then add a new link
      if(hasNextNode == null){
         IntNode addNewNode = new IntNode(item, null, data); // data, null (because its the last item on the list), item)
         link = addNewNode;
        // System.out.println("this.link: " + this.link);
      } else if (this.link.sequenceNumber <= item && item < this.link.link.sequenceNumber) { //if starting node has seqNumber that is less than the data we are putting in, and our next node does not exits, we add an entry at the end
         IntNode addNodeInBetween = new IntNode(item, this.link.link, data);
         this.link = addNodeInBetween;
      } 

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

      //check if there is a node 2 spaces away
      IntNode twoNodesAway = this.link.link;

      //if twoNodesWay has a node that is not null (meaning this node that is 2 away exits)
      if(twoNodesAway != null){
         //set this link to the one that is 2 away
         this.link = twoNodesAway;
      } else {
         //otherwise we cut the link to the next node and link it to nothing
         this.link = null;
      }
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
      IntNode nodeSlider = head; //passes in the variable containing all of our values. we start at the top.
      int counter = 0; //for the print statements and formating it
      //System.out.println(nodeSlider.link);

      //while node is not null, we print out the nodes
      while (nodeSlider != null){

         //i dont know if this is the correct way of doing this to output to how its like in the pdf file
         if (counter == 0){
            System.out.print("The (sequence number, data) pairs in the linked list are: (" + nodeSlider.sequenceNumber + "," + nodeSlider.data + ")");
         } else {
            System.out.print(" (" + nodeSlider.sequenceNumber + "," + nodeSlider.data + ")");
         }
         
         //set the slider to link to the next node
         nodeSlider = nodeSlider.link;

         //if our slider is null, we exit. idk if this is needed or not. probably not
         if(nodeSlider == null){
            System.out.println("");
            return;
         }
         counter++;
      }
      
   }
   
   
   // Precondition: The head of the linked list is different than null, and its sequenceNumber is different than target.
   // Postcondition: The link to the specific node, which comes before the node whose sequenceNumber is equal to target, 
   // is returned. If the linked list does not contain a node with sequenceNumber equal to target, then null is returned.   
   public IntNode findPrevious(IntNode head, int target)
   {
      //need 2 sliders, slider1 checks for sequencesNymber equal to target, slider2 will follow that from node to node
      IntNode iterateIntNode = head; //used to iterate
      IntNode nodeFromBefore = head; //used to store the node from the iterateNode varaible
	   //in the IntNode head, we are going to find a sequence number that is equal to target
      //loop head from first one then iterate to the next one
      
      while(iterateIntNode.sequenceNumber != target){
        // System.out.println("Current SeqNum:" + iterateIntNode.sequenceNumber + " Target: " + target);
         if(iterateIntNode.sequenceNumber == target){
            return nodeFromBefore;
         } else {
            //set iterate IntNode to become the next one in line
            nodeFromBefore = iterateIntNode;
            iterateIntNode = iterateIntNode.link;

            //i felt like the try catch the best of what i am trynna do here. this is here for the case if we get to the end
            // of the list and we try to get iterate.seqNum again but it will throw an error b/c its DNE
            try {
               if (iterateIntNode.sequenceNumber == target){
                  return nodeFromBefore;
               }
            } catch (Exception e) {
               //System.out.println("No node was found");
               return null;
            }     
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

       IntNode iterateIntNode = head;
       //IntNode nextNode = head.link;

       //look through the list of nodes to see where to place our new node

       

      while(iterateIntNode.sequenceNumber < target){
         //System.out.println("Current SeqNum:" + iterateIntNode.sequenceNumber + " Target: " + target);

         //return the last node of the list
         if(iterateIntNode.link == null){
            return iterateIntNode;
         }

         //if our node right now is smaller or equal to our target and our target is less than the next node's seqNumber, return the node from before

         if((iterateIntNode.sequenceNumber < target) && target <= iterateIntNode.link.sequenceNumber){
            return iterateIntNode;
         } else {
            //set iterate IntNode to become the next one in line
            iterateIntNode = iterateIntNode.link;
            //nextNode = iterateIntNode.link.link;
         }
      }

      return null;
      
      
   }
  
}
           