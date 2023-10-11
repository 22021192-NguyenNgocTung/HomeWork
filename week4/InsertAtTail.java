

// Complete the insertNodeAtTail function below.

/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     int data;
 *     SinglyLinkedListNode next;
 * }
 *
 */
static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode temp=head;
        if(temp == null){
        head = new SinglyLinkedListNode(data);
        return head;
        }
        while(temp.next!=null){
        temp=temp.next;
        }
        temp.next=new SinglyLinkedListNode(data);
        return head;
}

