



    /*
     * Complete the 'insertNodeAtPosition' function below.
     *
     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
     * The function accepts following parameters:
     *  1. INTEGER_SINGLY_LINKED_LIST llist
     *  2. INTEGER data
     *  3. INTEGER position
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

    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
            // Write your code here
            if (position > 1) insertNodeAtPosition(llist.next, data, position-1);

            if (position == 1) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(data);
            SinglyLinkedListNode tmp = llist.next;
            llist.next = node;
            node.next = tmp;
            }
            return llist;
            }

