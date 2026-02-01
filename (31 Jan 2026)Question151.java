// Reverse Words in a String

/*
Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.


Example 1:
Input: s = "the sky is blue"
Output: "blue is sky the"


Example 2:
Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.


Example 3:
Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 

Constraints:
1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.
Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
*/

//                                                       Solution: 👇

// class Solution {
//     public String reverseWords(String s) {
//         String [] c = s.trim().split("\\s+");
//         int left = 0, right = c.length - 1;

//         while(left < right){
//             String temp = c[left];
//             c[left] = c[right];
//             c[right] = temp;
//             left++;  right--;
//         }

//         StringBuilder result = new StringBuilder();
//         for(String cc : c){
//             if(result.length() > 0) result.append(' ');
//             result.append(cc);
//         }

//         return result.toString();
//     }
// }

class Solution {
    public String reverseWords(String s) {
        StringBuilder ans=new StringBuilder();
        int i=s.length()-1;
        while(i>=0){
            while(i>=0 && s.charAt(i)==' '){
                i--;
            }

            if(i<0) break;
            int end=i;

            while(i>=0 && s.charAt(i)!=' '){
                i--;
            }

            String result=s.substring(i+1,end+1);

            if(ans.length()>0){
                ans.append(" ");
            }
            ans.append(result);
        }
        return ans.toString();
    }
}