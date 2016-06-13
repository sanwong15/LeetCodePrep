/*
* San Wong
* hswong1@uci.edu
* 
* LeetCode 347 Top K Freq Elements
*/

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer,Integer> countMap = new HashMap<Integer,Integer>();
        
        if(nums == null || nums.length ==0){
            return result;
        }
        
        for (int n: nums){
            if (!countMap.containsKey(n)){
                countMap.put(n,1);
            }else{
                int count = countMap.get(n);
                count++;
                countMap.remove(n);
                countMap.put(n,count);
            }
        }
        
        //Now I have a put everything in the HashMap
        //Get top k 
        PriorityQueue<Pair> q = new PriorityQueue<Pair>(new newComparator());
        int count = 0; //count keep tracks how many elements are in the priority queue
        for (int element:countMap.keySet()){
            int freq = countMap.get(element);
            Pair pair = new Pair(element,freq);
            if(count<k){
                q.add(pair);
            }else if(pair.freq > q.peek().freq){
                q.poll();
                q.add(pair);
            }
            count++;
        }
        
        for(Pair pair:q){
            result.add(pair.element);
        }
        
        return result;
        
    }
    
    //newComparator
    private class newComparator implements Comparator<Pair>{
        @Override
        public int compare(Pair a, Pair b){
            return a.freq-b.freq;
        }
    }
    
    
}

class Pair{
    int element;
    int freq;
    
    Pair(int element, int freq){
        this.element = element;
        this.freq = freq;
    }
}