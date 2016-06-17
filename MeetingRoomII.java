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
public class MeetingRoomII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interval meeting1 = new Interval(5,10);
		Interval meeting2 = new Interval(0,30);
		Interval meeting3 = new Interval(15,20);
		
		Interval[] intervals = {meeting1,meeting2,meeting3};
		
		System.out.println("How many meeting rooms do we need? : " + MeetingRoomsNeeded(intervals));

	}
	
	public static int MeetingRoomsNeeded(Interval[] intervals){
		int roomCount = 0;
		//When there is an overlap. we need a extra room. Becareful to check
		//if there are meeting that's over so that we can reuse the room.
		int len = intervals.length;
		if(intervals == null || len == 0) return 0;
		
		//Sort the intervals array with its starting time.
		Arrays.sort(intervals, new IntervalComparator());

		
		//In order to see if a room is released. We need an array of end time.
		int[] end = new int[len];
		for (int i=0; i<len; i++){
			end[i] = intervals[i].end;
		}
		
		Interval previousMeeting = intervals[0];
		int previousEndTimeIndex = 0;
		roomCount++; //We ned one room for the first meetig anyways
		for (int i=1; i<len; i++){
			Interval currentMeeting = intervals[i];
			//Check if there is an overlap
			if(previousMeeting.end > currentMeeting.start){
				//an overlap happens. We need one more room
				roomCount++;
			}
			
			//Check if any room is released from previous meetings
			
			for (int j = previousEndTimeIndex ; j<i; j++){
				if (end[previousEndTimeIndex] < currentMeeting.start){
					roomCount--;
					previousEndTimeIndex++;
				}
			}
			
			previousMeeting = currentMeeting;
		}
		
		return roomCount;
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

class IntervalComparator implements Comparator<Interval>{
	@Override
	public int compare(Interval a, Interval b){
		return a.start - b.start;
	}
}
*/
