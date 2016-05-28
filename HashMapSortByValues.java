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
 * Try to understand how to sort a HashMap with its value
 */
public class HashMapSortByValues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	      HashMap<Integer, String> hmap = new HashMap<Integer, String>();
	      hmap.put(5, "A");
	      hmap.put(11, "C");
	      hmap.put(4, "Z");
	      hmap.put(77, "Y");
	      hmap.put(9, "P");
	      hmap.put(66, "Q");
	      hmap.put(0, "R");
	      
	      Set set = hmap.entrySet();
	      Iterator i1 = set.iterator();
	      while(i1.hasNext()){
	    	  Map.Entry me = (Map.Entry)i1.next();
	    	  System.out.print(me.getKey() + " : ");
	    	  System.out.println(me.getValue());
	      }
	      
	      System.out.println("HahsMap After sorting by values");
	      Map<Integer,String> map = sortByValues(hmap);
	      Set set2 = map.entrySet();
	      Iterator i3 = set2.iterator();
	      while(i3.hasNext()){
	    	  Map.Entry me2 = (Map.Entry)i3.next();
	    	  System.out.print(me2.getKey() + " : ");
	    	  System.out.println(me2.getValue());
	      }

	}
	
	public static HashMap sortByValues(HashMap map){
		List list = new LinkedList(map.entrySet());
	    Collections.sort(list, new Comparator() {
	            public int compare(Object o1, Object o2) {
	               return ((Comparable) ((Map.Entry) (o1)).getValue())
	                  .compareTo(((Map.Entry) (o2)).getValue());
	            }
	       });
	    
	    HashMap sortedHashMap = new LinkedHashMap();
	    for (Iterator i2 = list.iterator(); i2.hasNext();){
	    	Map.Entry entry = (Map.Entry)i2.next();
	    	sortedHashMap.put(entry.getKey(), entry.getValue());
	    }
	    
	    return sortedHashMap;
	}

}
