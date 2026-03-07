// Add Two Numbers II

/*
You are given two non-empty linked lists representing two non-negative integers. 
The most significant digit comes first and each of their nodes contains a single digit. 
Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 
Example 1:
Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]


Example 2:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]


Example 3:
Input: l1 = [0], l2 = [0]
Output: [0]
 

Constraints:
The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
 

Follow up: Could you solve it without reversing the input lists?
*/

//                                               Solution: 👇


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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    //     l1 = reverse(l1);
    //     l2 = reverse(l2);

    //     ListNode head = null;
    //     ListNode temp = null;

    //     int carry = 0;

    //     while(l1 != null || l2 != null || carry != 0){

    //         int sum = carry;

    //         if(l1 != null){
    //             sum += l1.val;
    //             l1 = l1.next;
    //         }

    //         if(l2 != null){
    //             sum += l2.val;
    //             l2 = l2.next;
    //         }

    //         int digit = sum % 10;
    //         carry = sum / 10;

    //         ListNode newNode = new ListNode(digit);

    //         if(head == null){
    //             head = newNode;
    //             temp = newNode;
    //         }
    //         else{
    //             temp.next = newNode;
    //             temp = temp.next;
    //         }
    //     }

    //     return reverse(head);
    // }

    // public ListNode reverse(ListNode head){

    //     ListNode temp = head;
    //     ListNode prev = null;

    //     while(temp != null){
    //         ListNode front = temp.next;
    //         temp.next = prev;
    //         prev = temp;
    //         temp = front;
    //     }

    //     return prev;

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }

        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;

        while(!s1.isEmpty() || !s2.isEmpty() || carry != 0){

            int sum = carry;

            if(!s1.isEmpty())
                sum += s1.pop();

            if(!s2.isEmpty())
                sum += s2.pop();

            ListNode node = new ListNode(sum % 10);

            node.next = head;
            head = node;

            carry = sum / 10;
        }

        return head;
    }
}