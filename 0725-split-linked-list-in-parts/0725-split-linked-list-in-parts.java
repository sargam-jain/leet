/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode current = head;
        while(current != null){
            length ++;
            current = current.next;
        }
        int partSize = length/k;
        int remainder = length % k;

        ListNode[] result = new ListNode[k];
        current = head;

        for(int i=0; i<k; i++){
            ListNode partHead = current;
            int currentPartSize = partSize + (remainder > 0 ? 1:0);
            remainder--;
            for(int j=0; j<currentPartSize - 1; j++){
                if(current != null) current = current.next;
            }
            if(current!=null){
            ListNode nextPart = current.next;
            current.next = null;
            current = nextPart;

        
        }
        result[i] = partHead;
    }
    return result;
}
}