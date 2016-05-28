import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.Iterator;

public class HashMapSortedByKeys {

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
	      
	      Map<Integer,String> map = new TreeMap<Integer, String>(hmap);
	      System.out.println("Result after sorted by keys");
	      Set set2 = map.entrySet();
	      Iterator i2 = set2.iterator();
	      
	      while(i2.hasNext()){
	    	  Map.Entry me2 = (Map.Entry)i2.next();
	    	  System.out.print(me2.getKey() + " : ");
	    	  System.out.println(me2.getValue());
	      }
	      

	}


}
