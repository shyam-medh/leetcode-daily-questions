// Remove Nodes From Linked List

/*
You are given the head of a linked list.
Remove every node which has a node with a greater value anywhere to the right side of it.
Return the head of the modified linked list.

 
Example 1:
Input: head = [5,2,13,3,8]
Output: [13,8]
Explanation: The nodes that should be removed are 5, 2 and 3.
- Node 13 is to the right of node 5.
- Node 13 is to the right of node 2.
- Node 8 is to the right of node 3.


Example 2:
Input: head = [1,1,1,1]
Output: [1,1,1,1]
Explanation: Every node has value 1, so no nodes are removed.
 

Constraints:
The number of the nodes in the given list is in the range [1, 105].
1 <= Node.val <= 105
*/

//                                                        Solution: 👇

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
    public ListNode removeNodes(ListNode head) {
        // head = reverse(head);

        // Stack<Integer> st = new Stack<>();
        // st.push(-1);

        // while(head != null){
        //     if(st.peek() <= head.val){
        //         st.push(head.val);
        //     }
        //     head = head.next;
        // }

        // ListNode x = new ListNode(st.pop());
        // ListNode temp = x;
        // while(!st.isEmpty()){
        //     ListNode newNode = new ListNode(st.pop());
        //     temp.next = newNode;                    
        //     temp = newNode;
        //     if(st.peek() == -1){break;}
        // }

        // return x;

        // int max = Integer.MIN_VALUE;

        // while(head != null){
        //     if(head.val >= max){
        //         st.push(head.val);
        //         max = head.val;
        //     }
        //     head = head.next;
        // }

        // ListNode newHead = null;
        // while(!st.isEmpty()){
        //     newHead = new ListNode(st.pop(), newHead);
        // }
        // newHead = reverse(newHead);
        // return newHead;
        head = reverse(head);

        
        ListNode curr = head;
        int max = curr.val;

        while (curr.next != null) {
            if (curr.next.val < max) {
                curr.next = curr.next.next; 
            } else {
                curr = curr.next;
                max = curr.val;
            }
        }

        return reverse(head);
    }

    private ListNode reverse(ListNode head){
        ListNode curr = head, temp = null, prev = null;

        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}