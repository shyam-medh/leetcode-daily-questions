// Palindrome Linked List

/*
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

Example 1:
Input: head = [1,2,2,1]
Output: true

Example 2:
Input: head = [1,2]
Output: false
 
Constraints:
The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
Follow up: Could you do it in O(n) time and O(1) space?
*/

//                                                  Solution: 👇

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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, prev = null, next = null, dummy = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = slow;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        while(prev != null){
            if(dummy.val != prev.val) return false;

            dummy = dummy.next;
            prev = prev.next;
        }

        return true;
    }
}