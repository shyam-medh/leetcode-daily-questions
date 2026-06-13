// Longest Valid Parentheses

/*
Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.


Example 1:
Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".


Example 2:
Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".


Example 3:
Input: s = ""
Output: 0
 

Constraints:
0 <= s.length <= 3 * 104
s[i] is '(', or ')'.
*/

//                                            Solution 👇

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int max = 0;
        int left = -1;
        for(int j=0; j<s.length(); j++){
            if(s.charAt(j) == '(') st.push(j);
            else{
                if(st.isEmpty()) left = j;
                else{
                    st.pop();
                    if(st.isEmpty()) max = Math.max(max, j - left);
                    else max = Math.max(max, j - st.peek());
                }
            }
        }

        return max;
    }
}