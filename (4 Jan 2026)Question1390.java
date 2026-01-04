// Four Divisors

/*
Given an integer array nums, return the sum of divisors of the integers in that array that have exactly four divisors. 
If there is no such integer in the array, return 0.
 

Example 1:
Input: nums = [21,4,7]
Output: 32
Explanation: 
21 has 4 divisors: 1, 3, 7, 21
4 has 3 divisors: 1, 2, 4
7 has 2 divisors: 1, 7
The answer is the sum of divisors of 21 only.


Example 2:
Input: nums = [21,21]
Output: 64


Example 3:
Input: nums = [1,2,3,4,5]
Output: 0
 

Constraints:
1 <= nums.length <= 104
1 <= nums[i] <= 105
*/


//                                                  Solution: 👇

class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for(int num : nums){
            List<Integer> res = new ArrayList<>();

            for(int j=1; j*j<=num; j++){
                if(num % j == 0){
                    res.add(j);
                    if(j != num / j) res.add(num / j);
                }
                if(res.size() > 4) break;
            }
            if(res.size() == 4){
                for(int k : res){
                    sum += k;
                }
            }
        }
        return sum;
    }
}