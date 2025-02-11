package unused.linkedListPackage;

public class IntNode {
    private int key;
    
    private IntNode next, previous;

    public IntNode(int key, IntNode previous, IntNode next){
        this.key = key;
        this.next = next;
        this.previous = previous;
    }

    public void addNodeAfter(int key){
        IntNode tmpRef = this.next;

        //key = key sent from argument, i want to add this node
        //this = current value now (which will be the previous value when we add key)
        //tmpRef = Stored reference of Next, We take old previous node of next, assign it to the new key, now previous will be "this".

        this.next = new IntNode(key, this, tmpRef); //our next new value is now this key, it has this previous value, it has this next value

        //link the old next reference to the new key. key.next is now tmpRef
        if(tmpRef != null){
            tmpRef.previous = this.next;
        }

    }

    public void deleteNodeAfter(int key){

        if(this.next != null){
            //our next value is the next value's next. assign this next with the one that is 2 keys away.
            this.next = this.next.next; //its pointer now becomes the next next
            
            //if the element that is 1 steps away from this one exists then:
            if(this.next != null){
                //set our new next value to be the previous of where we are now
                this.next.previous = this; 
            }
        } else {
            System.out.println("Sorry no nodes were deleted");
        }
        //and therefore, by skipping the value, we deleted the node
    }

    public void addNodeBefore(int key){
        IntNode tmpRef = this.previous; //stores previous node of the current node, to be used to put for the new node
        
        this.previous = new IntNode(key,tmpRef, this);

        //link the old previous reference to the new key, key.prev is now the new tmpRef
        if(tmpRef != null){
            tmpRef.next = this.previous;
        }
    }

    public IntNode searchNode(int targetKey) {
        IntNode anchor = this;

        while(anchor != null){
            if(anchor.key == targetKey){
                System.out.println("Target Node Found right of the current node.");
                return anchor;
            } else {
                anchor = anchor.next;
            }
        }

        while(anchor != null){
            if(anchor.key == targetKey){
                System.out.println("Target Node Found left of the current node.");
                return anchor;
            } else {
                anchor = anchor.previous;
            }
        }

        System.out.println("Target node not Found");
        return null;

    }

    public int countNodes(){
        //this always reference where we are now.
        IntNode countAnchor = this;
        int count = 0;

        while (countAnchor != null){
            count++;
            countAnchor = countAnchor.next;
        }

        countAnchor = this.previous;

        while (countAnchor != null){
            count++;
            countAnchor= countAnchor.previous;
        }

        return count;

    }

    public IntNode returnNextNext(){
        return this.next.next;
    }
}
