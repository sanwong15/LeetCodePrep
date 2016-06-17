import java.util.Arrays;

/*San Wong
 * hswong1@uci.edu
 * 
 * Leetcode 253: Meeting Rooms II
 * Given an array of meeting time intervals consisting of start and end times
 *  [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms
 *  required.
 *  
 *  For example,
 *  Given [[0, 30],[5, 10],[15, 20]],
 *  return 2.
 */

public class MeetingRoomIIExtra {

	public static void main(String[] args) {
		
		Interval meeting1 = new Interval(5,10);
		Interval meeting2 = new Interval(0,30);
		Interval meeting3 = new Interval(15,20);
		
		Interval[] intervals = {meeting1,meeting2,meeting3};
		
		System.out.println("How many meeting rooms do we need?: " + roomCount(intervals));

	}
	
	public static int roomCount(Interval[] intervals){
		int len = intervals.length;
		if (len == 0 || intervals == null) return 0;
		
		int[] start = new int[len];
		int[] end = new int[len];
		
		for (int i=0; i<len; i++){
			start[i] = intervals[i].start;
			end[i] = intervals[i].end;
		}
		
		//Sorting takes O(nlogn) time (which is the upper bound here)
		Arrays.sort(start); // 0 5 15
		Arrays.sort(end); // 10 20 30
		
		int room = 0;
		int activeMeetings = 0;
		int i=0;
		int j=0;
		
		//Compare take O(n) time
		while (i<len && j<len){
			if(start[i] < end[j]){
				activeMeetings++;
				room = Math.max(activeMeetings, room);
				i++;
			}else{
				//when start[i] > end[j]
				activeMeetings--;
				j++;
			}
		}
		
		return room;
		
	}

}

/*
For Reference:
class Interval{
	int start;
	int end;
	
	public Interval(){
		start = 0;
		end = 0;
	}
	
	 public Interval(int s, int e){
	 	start = s;
	 	end = e;
	 }
}
*/
