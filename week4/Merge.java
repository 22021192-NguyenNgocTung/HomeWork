

// Complete the mergeLists function below.

/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     int data;
 *     SinglyLinkedListNode next;
 * }
 *
 */
static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode tmp = head1 ;
        while ( tmp.next != null){
        tmp = tmp.next ;
        }
        tmp.next = head2 ;
        for (SinglyLinkedListNode p = head1 ; p != null ; p =p.next) {
        for ( SinglyLinkedListNode q = p.next ; q != null ; q = q.next) {
        if ( p.data > q.data ){
        int a= p.data ;
        p.data = q.data ;
        q.data = a ;
        }
        }
        }
        return head1 ;

        }

