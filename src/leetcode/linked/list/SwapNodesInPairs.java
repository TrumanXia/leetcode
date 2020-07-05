package leetcode.linked.list;

import leetcode.Tool;

public class SwapNodesInPairs {
	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode firstNode = head;
		ListNode secondNode = head.next;
		
		firstNode.next = swapPairs(secondNode.next);
		secondNode.next = firstNode;
		
		return secondNode;
    }
	
	public static void main(String[] args) {
		ListNode orgiListNode = Tool.generateListNodes(new int[] {1,4,5,6});
		Tool.printList(orgiListNode);
		Tool.printDilimeter();
		ListNode reversedNode = swapPairs(orgiListNode);
		Tool.printList(reversedNode);
	}
}
