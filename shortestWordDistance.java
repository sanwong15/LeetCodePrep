import java.util.HashMap;

/*
 * San Wong
 * hswong1@uci.edu
 * 
 * LeetCode 243: Shortest Word Distance
 * Given a list of words and two words word1 and word2, 
 * return the shortest distance between these two words in the list.
 * 
 * For example, Assume that
 * words = ["practice", "makes", "perfect", "coding", "makes"].
 * 
 * Given word1 = "coding", word2 = "practice", return 3.
 * Given word1 = "makes", word2 = "coding", return 1.
 */
public class shortestWordDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] test = {"practice", "makes", "perfect", "coding", "makes"};
		wordList list = new wordList(test);
		System.out.println("words = ['practice', 'makes', 'perfect', 'coding', 'makes']");
		System.out.println("Given word1 = 'coding', word2 = 'practice', Expected to return 3");
		System.out.println("Result: "+ list.distance("coding", "practice"));
		
		System.out.println("Given word1 = 'makes', word2 = 'coding', Expected to return 1");
		System.out.println("Result: " + list.distance("makes", "coding"));
	}

}

class wordList{
	public HashMap<String,Integer> map;
	
	//Constructor
	public wordList(String[] s){
		map = new HashMap<String, Integer>();
		
		//Construct the map
		for (int i=0; i<s.length;i++){
			map.put(s[i],i);
		}
	}
	
	public int distance(String word1, String word2){
		int dist = 0;
		
		if (map.containsKey(word1) && map.containsKey(word2)){
			int index1 = map.get(word1);
			int index2 = map.get(word2);
			dist = Math.abs(index2-index1);
			
			return dist;
		}
		
		return -1;
	}
}
