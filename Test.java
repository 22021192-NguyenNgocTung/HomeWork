public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode tmp1 = head ;
        ListNode tmp2 = head ;
        while (tmp1 != null  && tmp2 != null && tmp2.next != null ){
            tmp1 = tmp1.next ;
            tmp2 = tmp2.next.next ;
            if ( tmp1 == tmp2) {
                return true ;
            }
        }
        return false ;
    }
}