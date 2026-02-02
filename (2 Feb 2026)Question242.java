// Valid Anagram

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.


Example 1:
Input: s = "anagram", t = "nagaram"
Output: true


Example 2:
Input: s = "rat", t = "car"
Output: false
 

Constraints:
1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
*/

//                                                     Solution: 👇

class Solution {
    public boolean isAnagram(String s, String t) {
        // char[] As = s.toCharArray();
        // char[] At = t.toCharArray();

        // Arrays.sort(As);
        // Arrays.sort(At);

        // if(As.length != At.length) return false;
        // for(int i=0; i<As.length; i++){
        //     if(As[i] != At[i]){ return false; }
        // }
        // return true;


        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        for(char c : t.toCharArray()){
            freq[c - 'a']--;
        }

        for(int x : freq){
            if(x != 0){
                return false;
            }
        }

        return true;
    }
}