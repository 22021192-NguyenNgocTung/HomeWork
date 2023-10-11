


static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        SinglyLinkedListNode tmp = new SinglyLinkedListNode(data) ;
        if ( llist == null){
        llist = tmp ;
        return llist ;
        }
        tmp.next = llist ;
        llist = tmp ;
        return llist ;
        }

