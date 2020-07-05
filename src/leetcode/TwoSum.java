package leetcode;

import java.util.HashMap;
import java.util.Map;


class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = nums.length - 1; i >= 0; i --) {
        	int component = target - nums[i];
            if (map.containsKey(component)) {
            	return new int[] {map.get(component), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no solution");
    }
    
    public static void main(String[] args) {
    	
		System.out.println(twoSum(new int[]{2,7,10,20}, 9));
	}
}