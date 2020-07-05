package leetcode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import leetcode.linked.list.ListNode;

public class Tool {
	private Tool(){
		
	}
	
	public static ListNode generateListNodes(int[] array) {
		ListNode head = new ListNode(array[0]);
		ListNode cur = head;
		for (int i = 1; i < array.length; i++) {
			ListNode node= new ListNode(array[i]);
			cur.next = node;
			cur = cur.next;
		}
		return head;
	}
	
	public static ListNode generateListNodesWithCycle(int[] array, int cycledIndex) {
		if (cycledIndex < 0 || cycledIndex > array.length - 1) {
			throw new IllegalArgumentException("index not right!");
		}
		ListNode head = new ListNode(array[0]);
		ListNode cur = head;
		ListNode backNode = null;
		if (cycledIndex == 0) {
			backNode = head;
		}
		for (int i = 1; i < array.length; i++) {
			ListNode node= new ListNode(array[i]);
			cur.next = node;
			cur = cur.next;
			if (cycledIndex == i) {
				backNode = node;
			}
		}
		
		cur.next = backNode;
		
		return head;
	}
	
	public static void printList(ListNode head) {
		StringBuilder builder = new StringBuilder();
		ListNode cur = head;
		while (cur != null) {
			builder.append(cur.val + " -> ");
			cur = cur.next;
		}
		String result = builder.toString();
//		System.out.println(result.substring(0, result.lastIndexOf("->")));
		System.out.println(result.toString() + " null");
	}
	
	public static void printDilimeter() {
		System.out.println("=============================");
	}
//	可以使用反射来测试 TODO
	public static void testMethod2(Class<?> cls, String methodStr, int[] params) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		ListNode orgiListNode = Tool.generateListNodes(params);
		Tool.printList(orgiListNode);
		Tool.printDilimeter();
		Method targetMethod = cls.getMethod(methodStr, ListNode.class);

		Class<?> returnTypeClass = targetMethod.getReturnType();
		
		System.out.println(returnTypeClass.getName());
		if (targetMethod == null) {
			throw new IllegalArgumentException("no such method!");
		}
		Object obj = cls.newInstance();
//		反射使用不了，因为编译器不能确定class什么类型
//		 ListNode targetResult = returnTypeClass.cast(targetMethod.invoke(obj, Tool.generateListNodes(params)));
//		Tool.printList(targetResult);
	}
	
	public static void testMethod(Class<?> cls, String methodStr, int[] params) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		ListNode orgiListNode = Tool.generateListNodes(params);
		Tool.printList(orgiListNode);
		Tool.printDilimeter();
		Method targetMethod = cls.getMethod(methodStr, ListNode.class);
		
		Class<?> returnTypeClass = targetMethod.getReturnType();
		
		System.out.println(returnTypeClass.getName());
		if (targetMethod == null) {
			throw new IllegalArgumentException("no such method!");
		}
		Object obj = cls.newInstance();
		 ListNode targetResult = (ListNode) targetMethod.invoke(obj, Tool.generateListNodes(params));
		Tool.printList(targetResult);
	}
	
	public static void main(String[] args) {
//		ListNode head = generateListNodes(new int[] {1, 4, 5});
//		printList(head);
		
		printList(generateListNodesWithCycle(new int[] {1, 4, 5}, 1)); 
	}
	
}
