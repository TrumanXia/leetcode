package leetcode.linked.list;

import java.util.HashSet;
import java.util.Set;

import leetcode.Tool;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode cur = head;
		boolean flag = false;
		Set<ListNode> sets = new HashSet<ListNode>();
		while(cur.next != null) {
			if (sets.contains(cur)) {
				flag = true;
				break;
			} else {
				sets.add(cur);
			}
			cur = cur.next;
		}
		return flag;
	}
	
	public boolean hasCycle2(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		boolean flag = false;
		ListNode slow = head;
		ListNode fast = head.next;
//		当快慢指针没有遇到一起的时候
		while(slow != fast) {
			if (fast == null || fast.next == null) {
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}
	
//	 public ListNode detectCycle(ListNode head) {
//	        
//	    }
//	
	public static void main(String[] args) {
		System.out.println(new LinkedListCycle().hasCycle2(
				Tool.generateListNodesWithCycle(new int[] {1, 4,5}, 1)));
	}
}
