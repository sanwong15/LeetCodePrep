import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * San Wong
 * hswong1@uci.edu
 * 
 * LeetCode 347: Top K Freq Elements
 * 
 * Given a non-empty array of integers, return the k most freq elements
 * Example: [1,1,1,2,2,3], k=2, return [1,2]
 */
public class TopKFreqElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1,2,2,3};
		List<Integer> result = new ArrayList<Integer>();
		result = topKFrequent(nums,2);
		System.out.println("Printing out the ArrayList");
		for (Integer e: result){
			System.out.println(e);
		}

	}
	
    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        
    	for(int i=0; i<nums.length; i++){
        	if(!map.containsKey(nums[i])){
        		map.put(nums[i], 1);
        	}else{
        		int currentCount = map.get(nums[i]);
        		map.remove(nums[i]);
        		map.put(nums[i], currentCount+1);
        	}
        }
    	
    	/*
    	System.out.println("Before Sorting");
    	Set set = map.entrySet();
    	Iterator iterator = set.iterator();
    	while(iterator.hasNext()){
    		Map.Entry me = (Map.Entry)iterator.next();
    		System.out.print(me.getKey()+ " : ");
    		System.out.println(me.getValue());
    	}
    	*/
    	
    	Map<Integer,Integer> sortedMap = sortByValues(map);
    	Set set2 = sortedMap.entrySet();
    	Iterator iterator2 = set2.iterator();
    	List<Integer> result = new ArrayList<Integer>();
    	
    	int j = 1;
    	while(iterator2.hasNext() && j<=k){
    		Map.Entry me2 = (Map.Entry)iterator2.next();
    		//System.out.print(me2.getKey() + " : ");
    		//System.out.println(me2.getValue());
    		result.add((Integer) me2.getKey());
    		j++;
    	}
    	
    	
    	/*
    	System.out.println("After sorting");
    	while(iterator2.hasNext()){
    		Map.Entry me2 = (Map.Entry)iterator2.next();
    		System.out.print(me2.getKey() + " : ");
    		System.out.println(me2.getValue());
    	}
    	*/
    	return result;
    	
    }
    
    public static HashMap sortByValues(HashMap map){
    	List list = new LinkedList(map.entrySet());
    	
    	//Define Comparator
    	Collections.sort(list, new Comparator(){
    		public int compare(Object o1, Object o2){
    			return ((Comparable)((Map.Entry)(o2)).getValue()).compareTo(((Map.Entry)(o1)).getValue());
    		}
    	});
    	
    	//Copy the sorted list in HashMap
    	HashMap sortedHashMap = new LinkedHashMap();
    	for (Iterator it = list.iterator(); it.hasNext();){
    		Map.Entry entry = (Map.Entry) it.next();
    		sortedHashMap.put(entry.getKey(), entry.getValue());
    	}
    	return sortedHashMap;
    }

}
