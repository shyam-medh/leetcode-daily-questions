// Range Sum Query - Immutable

/*
Given an integer array nums, handle multiple queries of the following type:
1. Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.

Implement the NumArray class:
- NumArray(int[] nums) Initializes the object with the integer array nums.
- int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 

Example 1:
Input
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]

Explanation
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
 

Constraints:
1 <= nums.length <= 104
-105 <= nums[i] <= 105
0 <= left <= right < nums.length
At most 104 calls will be made to sumRange.
*/

//                                                        Solution: 👇

class NumArray {
    int[] arr;
    int[] sumz ;// Prefix sum array
    int sum = 0;

    public NumArray(int[] nums) {
        arr = nums;
        sumz = new int[nums.length];
        summ(arr);
    }
    
    public int sumRange(int left, int right) {
        // Case 1: If range starts from index 0
        // Then directly return prefix sum at right
        if(left == 0){
            return sumz[right];
        } 
        // Case 2: Normal case
        // rangeSum = prefix[right] - prefix[left-1]
        else{
            return sumz[right] - sumz[left-1];
        }
    }

    public int summ(int arr[]){ // Function to build prefix sum array
        int n = arr.length; 
        sum = 0;
        for(int i=0; i<n; i++){
            sum += arr[i];
            sumz[i] = sum;
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */