


    /*
     * Complete the 'reversePrint' function below.
     *
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

    public static void reversePrint(SinglyLinkedListNode llist) {
            SinglyLinkedListNode tmp = llist ;
            int size = 0 ;
            while (tmp != null) {
            size++ ;
            tmp = tmp.next ;
            }
            int[] arr = new int[size] ;
            int dem = 0 ;
            for (SinglyLinkedListNode p = llist ; p != null ; p = p.next ){
            arr[dem] = p.data ;
            dem++ ;
            }
            for ( int i = size - 1  ; i >= 0  ; i--){
            System.out.println(arr[i]) ;
            }
            }


