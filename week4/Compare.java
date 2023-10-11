

// Complete the compareLists function below.

/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     int data;
 *     SinglyLinkedListNode next;
 * }
 *
 */
// static int lengthoflist(SinglyLinkedListNode head_) {
//     int size = 0 ;
//     SinglyLinkedListNode tmp = head_ ;
//     while ( tmp != null){
//         size ++ ;
//         tmp = tmp.next ;
//     }
//     return size ;
// }
static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null && head2 == null){
        return true ;
        }
        else if ((head1 != null && head2 == null ) || (head1 == null && head2 != null)){
        return false ;
        }
        if (head1.data != head2.data){
        return false ;
        }
        else {
        return compareLists(head1.next, head2.next) ;
        }
        }

