

class Result {
    /*
     * Complete the 'deleteNode' function below.
     *
     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
     * The function accepts following parameters:
     *  1. INTEGER_SINGLY_LINKED_LIST llist
     *  2. INTEGER position
     */

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */

    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
        // Write your code here
        if (position > 1 ) deleteNode(llist.next, position - 1) ;
        else if (position == 1 ) {
            SinglyLinkedListNode tmp = llist.next ;
            llist.next = tmp.next ;
            tmp = null ;
        }
        else if (position == 0) {
            llist = llist.next ;
        }
        return llist ;
    }

}

