



    /*
     * Complete the 'reverse' function below.
     *
     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
     * The function accepts INTEGER_SINGLY_LINKED_LIST llist as parameter.
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

    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
            // Write your code here
            List<Integer> arr = new ArrayList<>() ;
            SinglyLinkedListNode tmp = llist ;
            int size = 0 ;
            while ( tmp != null){
            arr.add(tmp.data) ;
            tmp = tmp.next ;
            size ++ ;
            }
            tmp = llist ;
            while ( tmp != null) {
            tmp.data = arr.get(size - 1) ;
            size -- ;
            tmp = tmp.next ;
            }

            return llist ;
            }


