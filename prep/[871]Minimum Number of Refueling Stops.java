//A car travels from a starting position to a destination which is target miles 
//east of the starting position. 
//
// There are gas stations along the way. The gas stations are represented as an 
//array stations where stations[i] = [positioni, fueli] indicates that the iᵗʰ 
//gas station is positioni miles east of the starting position and has fueli liters 
//of gas. 
//
// The car starts with an infinite tank of gas, which initially has startFuel 
//liters of fuel in it. It uses one liter of gas per one mile that it drives. When 
//the car reaches a gas station, it may stop and refuel, transferring all the gas 
//from the station into the car. 
//
// Return the minimum number of refueling stops the car must make in order to 
//reach its destination. If it cannot reach the destination, return -1. 
//
// Note that if the car reaches a gas station with 0 fuel left, the car can 
//still refuel there. If the car reaches the destination with 0 fuel left, it is 
//still considered to have arrived. 
//
// 
// Example 1: 
//
// 
//Input: target = 1, startFuel = 1, stations = []
//Output: 0
//Explanation: We can reach the target without refueling.
// 
//
// Example 2: 
//
// 
//Input: target = 100, startFuel = 1, stations = [[10,100]]
//Output: -1
//Explanation: We can not reach the target (or even the first gas station).
// 
//
// Example 3: 
//
// 
//Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,4
//0]]
//Output: 2
//Explanation: We start with 10 liters of fuel.
//We drive to position 10, expending 10 liters of fuel.  We refuel from 0 
//liters to 60 liters of gas.
//Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
//and refuel from 10 liters to 50 liters of gas.  We then drive to and reach 
//the target.
//We made 2 refueling stops along the way, so we return 2.
// 
//
// 
// Constraints: 
//
// 
// 1 <= target, startFuel <= 10⁹ 
// 0 <= stations.length <= 500 
// 1 <= positioni < positioni+1 < target 
// 1 <= fueli < 10⁹ 
// 
//
// Related Topics Array Dynamic Programming Greedy Heap (Priority Queue) 👍 4768
// 👎 92

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        stations = Arrays.copyOf(stations, stations.length + 1);
        stations[stations.length - 1] = new int[] {target, 0};

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int currentFuel = startFuel;
        int prevPosition = 0;
        int stops = 0;

        for (int[] station : stations) {
            int position = station[0];
            int fuel = station[1];

            int distanceToTravel = position - prevPosition;

            currentFuel -= distanceToTravel;

            while (currentFuel < 0 && !maxHeap.isEmpty()) {
                currentFuel += maxHeap.poll();
                stops++;
            }

            if (currentFuel < 0) {
                return -1;
            }

            maxHeap.offer(fuel);

            prevPosition = position;
        }

        return stops;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
