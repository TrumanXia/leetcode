package leetcode.linked.list;

import java.lang.reflect.InvocationTargetException;

import leetcode.Tool;

public class ReverseList {
	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode prev = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode nextTemp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = nextTemp;
		}
		return prev;
	}
	
//	递归的想法如果思考？
	public static ListNode recursiveReverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
//			return 
		}
		ListNode prev = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode nextTemp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = nextTemp;
		}
		return prev;
	}
	
	public static void main(String[] args) {
//		ListNode orgiListNode = Tool.generateListNodes(new int[] {1,4,5,6});
//		Tool.printList(orgiListNode);
//		Tool.printDilimeter();
//		ListNode reversedNode = reverseList(orgiListNode);
//		Tool.printList(reversedNode);
		try {
			Tool.testMethod(ReverseList.class, "reverseList", new int[] {1,4,5,6});
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException
				| IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}

