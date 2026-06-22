// Maximum Number of Balloons

/*
Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
You can use each character in text at most once. Return the maximum number of instances that can be formed.

 
Example 1:
Input: text = "nlaebolko"
Output: 1


Example 2:
Input: text = "loonbalxballpoon"
Output: 2


Example 3:
Input: text = "leetcode"
Output: 0
 

Constraints:
1 <= text.length <= 104
text consists of lower case English letters only.
*/

//                                                           Solution 👇

class Solution {
    public int maxNumberOfBalloons(String text) {
        int b=0, a=0, l=0, o=0, n=0;

        for(char c : text.toCharArray()){
            if(c == 'b') b++;
            else if(c == 'a') a++;
            else if(c == 'l') l++;
            else if(c == 'o') o++;
            else if(c == 'n') n++;
        }

        return Math.min(Math.min(b, a), Math.min(Math.min(l/2, o/2), n));
    }
}