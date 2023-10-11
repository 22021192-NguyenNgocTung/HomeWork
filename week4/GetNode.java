



    /*
     * Complete the 'getNode' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_SINGLY_LINKED_LIST llist
     *  2. INTEGER positionFromTail
     */

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * } 1 2 3 4 2
     *
     */

    public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
            // Write your code here
            SinglyLinkedListNode tmp = llist ;
            int size = 0 ;
            while (tmp != null ) {
            size++ ;
            tmp = tmp.next ;
            }
            tmp = llist ;
            while (size - positionFromTail - 1 > 0){
            tmp = tmp.next ;
            size -- ;
            }
            return tmp.data ;

            }


