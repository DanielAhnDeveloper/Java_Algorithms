package ask.cetificate.advanced;

import java.io.FileInputStream;
import java.util.Scanner;



//A Java program to print topological sorting of a DAG
//import java.io.*;
//import java.util.*;

//This class represents a directed graph using adjacency
//list representation
public class TopologicalSort
//public class Solution
{
	         class LinkedList {
		         // ù��° ��带 ����Ű�� �ʵ�
		         private Node head;
		         private Node tail;
		         private int size = 0;
		         private class Node{
		             // �����Ͱ� ����� �ʵ�
		             private Object data;
		             // ���� ��带 ����Ű�� �ʵ�
		             private Node next;
		             public Node(Object input) {
		                 this.data = input;
		                 this.next = null;
		             }
		             // ����� ������ ���� ����ؼ� Ȯ���غ� �� �ִ� ���
		             public String toString(){
		                 return String.valueOf(this.data);
		             }
		         }
		         public void addFirst(Object input){
		             // ��带 �����մϴ�.
		             Node newNode = new Node(input);
		             // ���ο� ����� ���� ���� �ص带 �����մϴ�.
		             newNode.next = head;
		             // ���� ���ο� ��带 �����մϴ�.
		             head = newNode;
		             size++;
		             if(head.next == null){
		                 tail = head;
		             }
		         }
		         public void addLast(Object input){
		             // ��带 �����մϴ�.
		             Node newNode = new Node(input);
		             // ����Ʈ�� ��尡 ���ٸ� ù��° ��带 �߰��ϴ� �޼ҵ带 ����մϴ�.
		             if(size == 0){
		                 addFirst(input);
		             } else {
		                 // ������ ����� ���� ���� ������ ��带 �����մϴ�.
		                 tail.next = newNode;
		                 // ������ ��带 �����մϴ�.
		                 tail = newNode;
		                 // ������Ʈ�� ������ 1 ���� ��ŵ�ϴ�.
		                 size++;
		             }
		         }
		         Node node(int index) {
		             Node x = head;
		             for (int i = 0; i < index; i++)
		                 x = x.next;
		             return x;
		         }
		         public void add(int k, Object input){
		             // ���� k�� 0�̶�� ù��° ��忡 �߰��ϴ� ���̱� ������ addFirst�� ����մϴ�.
		            // if(k == 0){
		             //    addFirst(input);
		            // } else {
		                 Node temp1 = node(k-1);
		                 // k ��° ��带 temp2�� �����մϴ�.
		                 Node temp2 = temp1.next;
		                 // ���ο� ��带 �����մϴ�.
		                 Node newNode = new Node(input);
		                 // temp1�� ���� ���� ���ο� ��带 �����մϴ�.
		                 temp1.next = newNode;
		                 // ���ο� ����� ���� ���� temp2�� �����մϴ�.
		                 newNode.next = temp2;
		                 size++;
		                 // ���ο� ����� ���� ��尡 ���ٸ� ���ο� ��尡 ������ ����̱� ������ tail�� �����մϴ�.
		                 if(newNode.next == null){
		                     tail = newNode;
		                 }
		       //      }
		         }
		         public String toString() {
		             // ��尡 ���ٸ� []�� �����մϴ�.
		             if(head == null){
		                 return "[]";
		             }       
		             // Ž���� �����մϴ�.
		             Node temp = head;
		             String str = "[";
		             // ���� ��尡 ���� ������ �ݺ����� �����մϴ�.
		             // ������ ���� ���� ��尡 ���� ������ �Ʒ��� ������ ������ ���� ���ܵ˴ϴ�.
		             while(temp.next != null){
		                 str += temp.data + ",";
		                 temp = temp.next;
		             }
		             // ������ ��带 ��°���� ���Խ�ŵ�ϴ�.
		             str += temp.data;
		             return str+"]";
		         }
		         public Object removeFirst(){
		             // ù��° ��带 temp�� �����ϰ� head�� ���� �ι�° ���� �����մϴ�.
		             Node temp = head;
		             head = temp.next;
		             // �����͸� �����ϱ� ���� ������ ���� �ӽ� ������ ����ϴ�. 
		             Object returnData = temp.data;
		             temp = null;
		             size--;
		             return returnData;
		         }
		         public Object remove(int k){
		             if(k == 0)
		                 return removeFirst();
		             // k-1��° ��带 temp�� ������ �����մϴ�.
		             Node temp = node(k-1);
		             // ���� ��带 todoDeleted�� ����� �Ӵϴ�. 
		             // ���� ��带 ���� �����ϸ� ���� �� ���� ���� �� ��带 ������ �� �����ϴ�.  
		             Node todoDeleted = temp.next;
		             // ���� �� ����� ���� ���� ���� �� ��带 �����մϴ�.
		             temp.next = temp.next.next;
		             // ������ �����͸� �����ϱ� ���ؼ� returnData�� �����͸� �����մϴ�.
		             Object returnData = todoDeleted.data; 
		             if(todoDeleted == tail){
		                 tail = temp;
		             }
		             // cur.next�� ���� �մϴ�.
		             todoDeleted = null; 
		             size--;
		             return returnData;
		         }
		         public Object removeLast(){
		             return remove(size-1);
		         }
		         public int size(){
		             return size;
		         }
		         public Object get(int k){
		             Node temp = node(k);
		             return temp.data;
		         }
		         public int indexOf(Object data){
		             // Ž�� ����� �Ǵ� ��带 temp�� �����մϴ�.
		             Node temp = head;
		             // Ž�� ����� ���° ������Ʈ�� �ִ����� �ǹ��ϴ� ������ index�� ����մϴ�.
		             int index = 0;
		             // Ž�� ���� Ž�� ����� ���� ���մϴ�. 
		             while(temp.data != data){
		                 temp = temp.next;
		                 index++;
		                 // temp�� ���� null�̶�� ���� �� �̻� Ž�� ����� ���ٴ� ���� �ǹ��մϴ�.�� �� -1�� �����մϴ�.
		                 if(temp == null)
		                     return -1;
		             }
		             // Ž�� ����� ã�Ҵٸ� ����� �ε��� ���� �����մϴ�.
		             return index;
		         }
		      
		         // �ݺ��ڸ� �����ؼ� �������ݴϴ�.
		         public ListIterator listIterator() {
		             return new ListIterator();
		         }
		          
		         class ListIterator{
		             private Node lastReturned;
		             private Node next;
		             private int nextIndex;
		              
		             ListIterator(){
		                 next = head;
		                 nextIndex = 0;
		             }
		              
		             // �� �޼ҵ带 ȣ���ϸ� next�� �������� ���� next.next�� ����˴ϴ�. 
		             public Object next() {
		                 lastReturned = next;
		                 next = next.next;
		                 nextIndex++;
		                 return lastReturned.data;
		             }
		              
		             public boolean hasNext() {
		                 return nextIndex < size();
		             }
		              
		             public void add(Object input){
		                 Node newNode = new Node(input);
		                 if(lastReturned == null){
		                     head= newNode;
		                     newNode.next = next;
		                 } else {
		                     lastReturned.next = newNode;
		                     newNode.next = next;
		                 }
		                 lastReturned = newNode;
		                 nextIndex++;
		                 size++;
		             }
		              
		             public void remove(){
		                 if(nextIndex == 0){
		                     throw new IllegalStateException();
		                 }
		                 LinkedList.this.remove(nextIndex-1);
		                 nextIndex--;
		             }
		              
		         }
		      
		     }         
	         	
	
	
	 private int V;   // No. of vertices
	 private LinkedList adj[]; // Adjacency List
	
	 //Constructor
	 TopologicalSort(int v)
	 {
	     V = v;
	     adj = new LinkedList[v];
	     for (int i=0; i<v; ++i)
	         adj[i] = new LinkedList();
	 }
	
//	 // Function to add an edge into the graph
//	 void addEdge(int v,int w)
//	 { 
//		 adj[v].add(w); 
//	 }
//	
//	 // A recursive function used by topologicalSort
//	 void topologicalSortUtil(int v, boolean visited[],  Stack stack)
//	 {
//	     // Mark the current node as visited.
//	     visited[v] = true;
//	     Integer i;
//	
//	     // Recur for all the vertices adjacent to this
//	     // vertex
//	     Iterator<Integer> it = adj[v].iterator();
//	     while (it.hasNext())
//	     {
//	         i = it.next();
//	         if (!visited[i])
//	             topologicalSortUtil(i, visited, stack);
//	     }
//	
//	     // Push current vertex to stack which stores result
//	     stack.push(new Integer(v));
//	 }
//	
//	 // The function to do Topological Sort. It uses
//	 // recursive topologicalSortUtil()
//	 void topologicalSort()
//	 {
//	     Stack stack = new Stack();
	
//	     // Mark all the vertices as not visited
//	     boolean visited[] = new boolean[V];
//	     for (int i = 0; i < V; i++)
//	         visited[i] = false;
//	
//	     // Call the recursive helper function to store
//	     // Topological Sort starting from all vertices
//	     // one by one
//	     for (int i = 0; i < V; i++)
//	     {
//	         if (visited[i] == false)
//	             topologicalSortUtil(i, visited, stack);
//	     }
//	     
//	     // Print contents of stack
//	     while (stack.empty()==false)
//	     {
//	         System.out.print(stack.pop() + " ");
//	     }
//	 }

	 
	 // Driver method
//         public static void main(String[] args)throws Exception 
//         {
//	         int T, N;
//	         long answer;
//	
// 	         //System.setIn(new FileInputStream("E:/WS_java/java_basic/src/ask/cetificate/advanced/topological_input.txt"));
//
//	         Scanner sc = new Scanner(System.in);
//	        
//	         T = sc.nextInt();
//	         
//	         for (int test_case = 1; test_case <= T; test_case++) 
//	         {
//	                  N = sc.nextInt();
//	                  int[] a = new int[N];
//	                  
//	                  for(int i=0; i < N; i++)
//	                  {
//	                          a[i] = sc.nextInt();
//	                  }
//	                 
//
//	                  
//			TopologicalSort g = new TopologicalSort(6);
//			
//			
//			
//			g.addEdge(5, 2);
//			g.addEdge(5, 0);
//			g.addEdge(4, 0);
//			g.addEdge(4, 1);
//			g.addEdge(2, 3);
//			g.addEdge(3, 1);
//				
//
//	                  // RESULT
//	                  System.out.println("#"+test_case+" ");
//	                  
//	                  g.topologicalSort();
//	         }
//         }	 
         
	 
	public static void main(String args[])
	{
		// Create a graph given in the above diagram
		TopologicalSort g = new TopologicalSort(6);
		
		// first time
//		g.addEdge(5, 2);
//		
//		
//		g.addEdge(5, 0);
//		g.addEdge(4, 0);
//		g.addEdge(4, 1);
//		g.addEdge(2, 3);
//		g.addEdge(3, 1);
//			
//		System.out.println("Following is a Topological " +  "sort of the given graph");
//		g.topologicalSort();
	}
         
         

}





//public class TopologicalSort
////public class Solution
//{     
//         public static void main(String[] args)throws Exception {
//                  int T, N;
//                  long answer;
// 
//                 System.setIn(new FileInputStream("E:/WS_java/java_basic/src/ask/cetificate/advanced/inversion_input.txt"));
// 
//                  Scanner sc = new Scanner(System.in);
//                 
//                  long t1,t2;
//                  T = sc.nextInt();
//                  
//                  for (int test_case = 1; test_case <= T; test_case++) 
//                  {
//                           N = sc.nextInt();
//                           int[] a = new int[N];
//                           for(int i=0;i<N;i++){
//                                   a[i] = sc.nextInt();
//                           }
//                          
////                           t1 = System.currentTimeMillis();
//                           answer = countingInversions(a);
////                           t2 = System.currentTimeMillis();
//                           System.out.println("#"+test_case+" "+answer);// +" ("+(t2-t1)+" milliseconds)");
//                  }
//         }
// 
//         private static long countingInversions(int[] a) 
//         {
//                  int n = a.length;
//                  int[] buf = new int[n];           
//                  long cnt = count(a,0,n-1,buf);
//                 
//                  return cnt;
//         }
//        
//         private static long count(int[] a, int s, int e, int[] buf)
//         {
//                  if((e-s)<1) {
//                           return 0;
//                  }       
//                 
//                  int m = (s+e) / 2;
//                  long leftCount = count(a,s,m,buf);
//                  long rightCount = count(a,m+1,e,buf);
//                  long mergeCount = merge(a,s,m,e,buf);
//                  
//                  System.arraycopy(buf, s, a, s, (e-s)+1);
//                 
//                  return leftCount + rightCount + mergeCount;
//         }
//        
//         private static long merge(int[]a,int s, int m, int e, int[] buf)
//         {
//                  //System.out.println("merge("+s+" "+e+")");
//                  int left=s;
//                  int right=m+1;
//                  long count=0;
//                  
//                  for(int k=s;k<=e;k++){
//                           if(left<=m && ( (right>e) || (a[left] <= a[right]) ) ){
//                                   buf[k] = a[left++];                                 
//                           }else{
//                                   buf[k] = a[right++];
//                                   count = count + (m-left+1);
//                           }
//                  }
//                  return count;
//         }
//        
//        
//}