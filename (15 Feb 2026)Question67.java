// Add Binary

/*
Given two binary strings a and b, return their sum as a binary string.


Example 1:
Input: a = "11", b = "1"
Output: "100"


Example 2:
Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:
1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.
*/

//                                                       Solution: 👇

class Solution {
    public String addBinary(String a, String b) {
        char[] arr1 = a.toCharArray(), arr2 = b.toCharArray();

        StringBuilder sb = new StringBuilder();

        int i=arr1.length - 1; int j = arr2.length - 1;
        int carry = 0;

        while(i >= 0 || j >= 0 || carry> 0){
            int aNum = i >= 0 ? arr1[i] - '0' : 0;
            int bNum = j >= 0 ? arr2[j] - '0' : 0;

            int sum = aNum + bNum + carry;
            int digit = sum % 2;
            carry = sum / 2;
            i--;
            j--;

            sb.append((char)(digit + '0'));
        }

        return sb.reverse().toString();
    }
}