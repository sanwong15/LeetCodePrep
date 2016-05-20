import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* San Wong
* hswong1@uci.edu
*
* LeetCode 346 Moving Average From Data Stream
* 
* Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
* 
* For example,
* MovingAverage m = new MovingAverage(3);
* m.next(1) = 1
* m.next(10) = (1 + 10) / 2
* m.next(3) = (1 + 10 + 3) / 3
* m.next(5) = (10 + 3 + 5) / 3
*/


public class MovingAverageFromDataStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MovingAverage m = new MovingAverage(3);
		System.out.println(m.next(1));
		System.out.println(m.next(10));
		System.out.println(m.next(3));
		System.out.println(m.next(5));

		
	}
	
}

class MovingAverage{
	public Queue<Integer> q;
	public int size;
	public int sum;
	
	//Constructor
	public MovingAverage(int size){
		q = new LinkedList<>();
		this.size = size;
		this.sum = 0;
	}
	
	public double next(int val){
		if (q.size() == size){
			sum -= q.poll();
		}
		
		q.add(val);
		sum+=val;
		return sum/q.size();
	}
}
