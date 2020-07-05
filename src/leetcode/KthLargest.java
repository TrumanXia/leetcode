package leetcode;

import java.util.PriorityQueue;

//  ◊œ»≈≈–Ú£¨≤È’“kth
public class KthLargest {
	private PriorityQueue<Integer> queue;
	private int k;
	public KthLargest(int k, int[] nums) {
		queue  = new PriorityQueue<Integer>(k);
		this.k = k;
		for (int num : nums) {
			add(num);
		}
	}

	public int add(int val) {
		if (queue.size() < this.k) {
			queue.offer(val);
		} else if (queue.peek() < val) {
			queue.poll();
			queue.offer(val);
		}
		return queue.peek();
	}
	
	public static void main(String[] args) {
		int[] base = new int[]{4,5,8,2};
//		System.out.println(new KthLargest(3, new int[]{2, 4, 5}).add(4));
		System.out.println(new KthLargest(3, base).add(3));
//		System.out.println(new KthLargest(3, base).add(5));
//		System.out.println(new KthLargest(3, base).add(10));
//		System.out.println(new KthLargest(3, base).add(9));
//		System.out.println(new KthLargest(3, base).add(4));
	}
}
