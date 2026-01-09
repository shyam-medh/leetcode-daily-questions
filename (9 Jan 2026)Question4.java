// Median of Two Sorted Arrays

/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).
 

Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.


Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

Constraints:
nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
*/

//                                                        Solution: 👇

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;

        int[] arr = new int[l1 + l2];

        for(int i=0; i<l1; i++){
            arr[i] = nums1[i];
        }
        for(int i=0; i<l2; i++){
            arr[i+l1] = nums2[i];
        }

        Arrays.sort(arr);

        int mid = arr.length / 2;

        double ans = ( arr.length % 2 != 0 ) ? (float)arr[mid] : (float)(arr[mid] + arr[mid -1]) / 2.0;
        return ans;
    }
}