package ask.ds.linkedlist;

import java.util.HashSet;

public class DeleteNode
{
	// HashSet: O(n)
	// 1   2   1   2   3
	// ok ok ng ng ok
	
	public static void deleteDuplicatesWithHashSet(LinkedListNode node)
	{
		HashSet<Integer> set = new HashSet<Integer>(); 
		// do not allow same data and order  cf. HashMap
		
		LinkedListNode previous = null;
		
		while (node != null)
		{
			if (set.contains(node.data))
			{
				previous.next = node.next;
			} 
			else
			{
				set.add(node.data);
				previous = node;
			}
			node = node.next;
		}
	}

	
	// Two Pointers: O(n^2)
	// 1  2  1  2  3
	// 1  2      2  3 (1st)
	// 1  2          3 (2nd)
	
	public static void deleteDuplicatesWithPointers(LinkedListNode node)
	{

		if(node == null) return;
				
		LinkedListNode current = node;
		
		while (current != null)
		{
			LinkedListNode checkNode = current;			
			
			while(checkNode.next != null)
			{
				if(current.data == checkNode.next.data)
				{
					checkNode.next = checkNode.next.next; // skipped(remove): 1 2 () 2 
				}
				else
				{
					checkNode = checkNode.next; // normal case: ...2 3
				}
			}
			current = current.next;
		}	
	}
	
	
	// deleteInDesignatedNode
	public static boolean deleteInDesignatedNode(LinkedListNode node)
	{
		if(node == null || node.next == null) 
			return false;
		
		LinkedListNode next = node.next;
		
		node.data = next.data;
		node.next = next.next;
		
		return true;
	}
	
	
	// MAIN
	public static void main(String[] args)
	{
		LinkedListNode node = new LinkedListNode(0, null, null); 
		// AssortedMethods.randomLinkedList(1000, 0, 2);
		LinkedListNode head = node;
		LinkedListNode second = node;

		for (int i = 1; i < 8; i++)
		{
			second = new LinkedListNode(i % 2, null, null);
			node.setNext(second);
			second.setPrevious(node);
			node = second;
		}

		System.out.println(head.printForward());
		
		deleteDuplicatesWithHashSet(head);
		System.out.println(head.printForward());
		
		deleteDuplicatesWithPointers(head);
		System.out.println(head.printForward());
	}
}


/**

�ڷᱸ�� (Collection)
- �ټ��� �����͸� ���� �߰�, ����, �˻� ���� �۾��� �� �� �ֵ��� ǥ��ȭ�� ����� �����ϴ� Ŭ������, Ŭ�������� ����
- �������̸� �Һ��� ũ�⸦ ���� �迭���� �޸� �������̸� �������� ũ�⸦ ����
- ������ ���� ����ġ ���� ��� ����ϸ� ���ϴ�. �� �������� ���鿡���� �迭�� ȿ����
 
 
JCF(Java Collection Framework)
- �������� �����͸� �����ϰ� ������ �� �ִ� �ڷᱸ��
- ������ ����/���� ��Ŀ� ���� List/ Set/ Map������ ����
 
1. Set �迭
- ����Ǵ� �������� ������ �������� ����
- ������ ������ ���� ��ü�� �ߺ������� ������� ����
- HashSet
 
2. List �迭
- ����Ǵ� �������� ������ ������
- index�� ����
- ������ ������ ���� ��ü�� �ߺ������� �����
- Vector, ArrayList
 
3. Map �迭
- ����Ǵ� �������� ������ �������� ����
- key�� ����-> key�� value�� �������� �Ѱ��� �����͸� �̷�� �ȴ�. (key, value)
- ������ ������ ���� ��ü�� �ߺ������� �����(value), �� key�� �ߺ� �Ұ�
- HashMap, HashTable

**/