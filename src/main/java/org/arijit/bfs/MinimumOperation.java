package org.arijit.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * iven a initial number x and two operations which are given below:

Multiply number by 2.
Subtract 1 from the number.
The task is to find out minimum number of operation required to convert number x into y using only above two operations. We can apply these operations any number of times.

Input : x = 4, y = 7
Output : 2
 * @author ARIJIT
 *
 */
public class MinimumOperation {

	public static int minOperation(int x, int y) {
		LinkedList<Integer> q = new LinkedList<>();
		// it will keep track for the elements which we have already traveresed.
		Set<Integer> visitedSet = new HashSet<Integer>();
		q.add(x);
		int nodeCount = q.size();
		int operation =0;
		while(!q.isEmpty()) {
			if(nodeCount==0) {
				nodeCount = q.size();
				operation++;
			}
			int a = q.poll();
			if(a==y)
				return operation;
			int x1  = a*2;
			if(!visitedSet.contains(x1))
				q.add(x1);
			x1 = a-1;
			if(!visitedSet.contains(x1))
				q.add(x1);			
			nodeCount--;
		}
		return -1;
	}
	public static void main(String args[]) {
		int x = 4;
		int y=19;
		int minOperation = minOperation(x, y);
		System.out.println("MinOperation : "+minOperation);
	}
	
}

