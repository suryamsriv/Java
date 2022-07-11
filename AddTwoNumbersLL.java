// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Example 1:
// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [7,0,8]
// Explanation: 342 + 465 = 807.
// Example 2:

// Input: l1 = [0], l2 = [0]
// Output: [0]
// Example 3:

// Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
// Output: [8,9,9,9,0,0,0,1]


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

class AddTwoNumbersLL {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        int carry = 0;
        int sum = 0;
        int v1 = 0, v2 = 0;
        var current = node;
        while(l1 != null || l2 != null)
        {
            v1 = l1 != null ? l1.val : 0;
            v2 = l2 != null ? l2.val : 0;
            sum = v1 + v2 + carry;
            
            if(sum / 10 > 0 ) {
                carry = sum / 10;
                sum = sum % 10;
            }   
            else {
                carry = 0;
            }
            current.val = sum; 
            carry += sum / 10;
            
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            
            if(l1 != null || l2 != null) {
                current.next = new ListNode();
                current = current.next;
            }
        }
        if(carry != 0)
        {
            current.next = new ListNode();
            current = current.next;
            current.val = carry;      
        } 
        return node;
    }
}