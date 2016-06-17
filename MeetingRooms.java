import java.util.Arrays;
import java.util.Comparator;

/*
 * San Wong
 * hswong1@uci.edu
 * 
 * LeetCode 252: Meeting Rooms
 * Given an array of meeting time intervals consisting of start and end times
 *  [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 *  
 *  For example,
 *  Given [[0, 30],[5, 10],[15, 20]], return false. 
 */
public class MeetingRooms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interval meeting1 = new Interval(5,10);
		Interval meeting2 = new Interval(0,30);
		Interval meeting3 = new Interval(15,20);
		
		Interval[] intervals = {meeting1,meeting2,meeting3};
		
		System.out.println("Are there any overlapping meetings?:  " + freeToAttend(intervals));

	}
	
	public static boolean freeToAttend(Interval[] intervals){
		if(intervals == null || intervals.length ==0) return true;
		
		//Sort the Array base on the starting time.
		Arrays.sort(intervals, new IntervalComparator());
		
		Interval previousMeeting = intervals[0];
		for (int i=1; i<intervals.length; i++){
			Interval currentMeeting = intervals[i];
			if(currentMeeting.start<previousMeeting.end){
				return false;
			}
			
			previousMeeting = currentMeeting;
		}
		
		return true;
	}
	
	
	


}

class Interval{
	int start;
	int end;
	
	//Constructor
	public Interval(){
		start = 0;
		end = 0;
	}
	
	public Interval(int s, int e){
		start = s;
		end = e;
	}
}

class IntervalComparator implements Comparator<Interval>{
	@Override
	public int compare (Interval a, Interval b){
		return a.start-b.start;
	}
}
