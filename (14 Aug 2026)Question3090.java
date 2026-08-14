// Maximum Length Substring With Two Occurrences

/*
Given a string s, return the maximum length of a substring such that it contains at most two occurrences of each character.
 
Example 1:
Input: s = "bcbbbcba"
Output: 4
Explanation:
The following substring has a length of 4 and contains at most two occurrences of each character: "bcbbbcba".


Example 2:
Input: s = "aaaa"
Output: 2
Explanation:
The following substring has a length of 2 and contains at most two occurrences of each character: "aaaa".
 

Constraints:
2 <= s.length <= 100
s consists only of lowercase English letters.
*/

//                                                        Solution 👇

class Solution {
    public int maximumLengthSubstring(String s) {
        int maxLen = 0;
        int i = 0;
        int[] arr = new int[26];

        for(int j=0; j<s.length(); j++){
            arr[s.charAt(j) - 'a']++;

            while(arr[s.charAt(j) - 'a'] > 2){
                arr[s.charAt(i++) - 'a']--;
            }

            maxLen = Math.max(maxLen, j-i+1);
        }
        return maxLen;
    }
}