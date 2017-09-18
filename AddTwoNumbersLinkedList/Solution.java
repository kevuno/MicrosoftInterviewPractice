/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean extra = false;
        ListNode copy_og_head_l1 = l1;
        ListNode copy_og_head_l2 = l2;
        ListNode last_node = null;
        boolean is_l1 = true;
        int l1_val = 0; int l2_val = 0;        
        
        while(l1 != null || l2 != null){
            
            l1_val = (l1 == null) ? 0 : l1.val;
            l2_val = (l2 == null) ? 0 : l2.val;            
            int sum = l1_val + l2_val;
            if (extra)
                sum++;
            
            System.out.println(sum);
            int first_digit_sum = sum % 10;
            
            extra = sum >= 10;
            
            
            if (l1 != null  && l2 == null){
                is_l1 = true;
                last_node = l1;
                l1.val = first_digit_sum;
                if (l1.next == null)
                    break;
                l1 = l1.next;
                
            }else if (l1 == null && l2 != null){
                is_l1 = false;
                last_node = l2;
                l2.val = first_digit_sum;
                if (l2.next == null)
                    break;
                l2 = l2.next;
                
            }else{
                is_l1 = true;
                last_node = l1;
                l1.val = first_digit_sum;
                l2.val = first_digit_sum;
                if (l1.next == null && l2.next == null)
                    break;
                l1 = l1.next;
                l2 = l2.next;
                
            }
            
        
        }
        System.out.println(extra);
        if (extra){
            if (is_l1){
                l1.next = new ListNode(1);
                return copy_og_head_l1;
            }
            
            l2.next = new ListNode(1);
            return copy_og_head_l2;
        } 
        
        return (is_l1) ? copy_og_head_l1 : copy_og_head_l2;
    }
}