// Cinema Seat ALlocation

/*
A cinema has n rows of seats, numbered from 1 to n. Each row has 10 seats, numbered from 1 to 10.
You are given a 2D integer array reservedSeats, where reservedSeats[i] = [rowi, seati] means that seat seati in row rowi is already reserved.
A four-person group must be assigned to four seats in the same row. The group can be seated in one of the following seat blocks:
- seats 2, 3, 4, 5
- seats 4, 5, 6, 7
- seats 6, 7, 8, 9
A block can be used only if none of its seats are reserved. Each seat can be assigned to at most one group.
Return an integer denoting the maximum number of four-person groups that can be assigned.
 

Example 1:
Input: n = 3, reservedSeats = [[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]
Output: 4
Explanation: The figure above shows an optimal allocation of four groups. Seats marked in blue are already reserved, and each set of four contiguous seats marked in orange is assigned to one group.


Example 2:
Input: n = 2, reservedSeats = [[2,1],[1,8],[2,6]]
Output: 2


Example 3:
Input: n = 4, reservedSeats = [[4,3],[1,4],[4,6],[1,7]]
Output: 4
 

Constraints:
1 <= n <= 109
1 <= reservedSeats.length <= min(10 * n, 104)
reservedSeats[i] == [rowi, seati]
1 <= rowi <= n
1 <= seati <= 10
All reservedSeats[i] are distinct.
*/

//                                                      Solution 👇

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, HashSet<Integer>> mp = new HashMap<>();
        
        for(int[] reservedSeat : reservedSeats){
            int row = reservedSeat[0];
            int seat = reservedSeat[1];

            if(!mp.containsKey(row)){
                mp.put(row, new HashSet<>());
            }

            mp.get(row).add(seat);
        }
        int result = (n - mp.size()) * 2;

        for(Map.Entry<Integer, HashSet<Integer>> entry : mp.entrySet()){
            HashSet<Integer> bookedSeats = entry.getValue();

            boolean groupA = !bookedSeats.contains(2) && !bookedSeats.contains(3) && !bookedSeats.contains(4) && !bookedSeats.contains(5);
            boolean groupB = !bookedSeats.contains(4) && !bookedSeats.contains(5) && !bookedSeats.contains(6) && !bookedSeats.contains(7);
            boolean groupC = !bookedSeats.contains(6) && !bookedSeats.contains(7) && !bookedSeats.contains(8) && !bookedSeats.contains(9);

            if(groupA && groupC) result += 2;
            else if(groupA || groupB || groupC) result += 1;
        }

        return result;
    }


}