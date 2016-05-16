import java.util.ArrayList;
import java.util.List;

public class NestedListWeightSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Example 1:
		 *Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
         * Example 2:
         * Given the list [1,[4,[6]]], return 27.
         */
		
		//Construct for Example 2 [1,[4,[6]]], return 27
		List<NestedInteger> testCase1 = getTestCase1();
		System.out.printf("Example1:  sum of %s:  %d \n", "[[1,1],2,[1,1]]", weightSum(testCase1));
		
		
		//Construct for Example 2 [1,[4,[6]]], return 27
		List<NestedInteger> testCase2 = getTestCase2();
		System.out.printf("Example2:  sum of %s:  %d \n", "[1,[4,[6]]]", weightSum(testCase2));
		

	}
	
	public static int weightSum(List<NestedInteger> list){
		int sum = 0;
		for (NestedInteger e: list){
			sum += sumOfEachList(e,1);
		}
		return sum;
	}// End of weightSum
	
	public static int sumOfEachList(NestedInteger e, int depth){
		int result = 0;
		
		if(e.isInteger()){
			result += e.getInteger()*depth;
		}else{
			//If it is not an Integer, it is a List
			List<NestedInteger> list = e.getList();
			for (NestedInteger listElement : list){
				result += sumOfEachList(listElement, depth+1);
			}
		}
		
		return result;
	}//End of sumOfEachList
	
	public static List<NestedInteger> getTestCase2(){
		//[1,[4,[6]]]
		NestedInteger six = new NestedInteger();
		six.self = "6";
		//We define the firstNestedList to be the most inner nested list
		List<NestedInteger> firstNestedList = new ArrayList<NestedInteger>();
		firstNestedList.add(six);
		
		//Create a NestedInteger Object for the first nested list
		NestedInteger firstNestedObject = new NestedInteger();
		firstNestedObject.self = firstNestedList;
		
		//The outter nested contain element "4"
		NestedInteger four = new NestedInteger();
		four.self = "4";
		
		List<NestedInteger> secondNestedList = new ArrayList<NestedInteger>();
		secondNestedList.add(four);
		secondNestedList.add(firstNestedObject);
		
		//Create a NestedInteger Object for the second nested list
		NestedInteger secondNestedObject = new NestedInteger();
		secondNestedObject.self = secondNestedList;
		
		NestedInteger one = new NestedInteger();
		one.self = "1";
		
		List<NestedInteger> MostOutterList = new ArrayList<NestedInteger>();
		MostOutterList.add(one);
		MostOutterList.add(secondNestedObject);
		
		return MostOutterList;
		}
	
	public static List<NestedInteger> getTestCase1(){
		// Construct [[1,1],2,[1,1]]
		// Start with most inner nested list
		NestedInteger FirstOne_1 = new NestedInteger();
		FirstOne_1.self = "1";
		NestedInteger FirstOne_2 = new NestedInteger();
		FirstOne_2.self = "1";

		List<NestedInteger> firstNestedList = new ArrayList<NestedInteger>();
		firstNestedList.add(FirstOne_1);
		firstNestedList.add(FirstOne_2);

		NestedInteger firstNestedObject = new NestedInteger();
		firstNestedObject.self = firstNestedList;

		NestedInteger SecondOne_1 = new NestedInteger();
		SecondOne_1.self = "1";
		NestedInteger SecondOne_2 = new NestedInteger();
		SecondOne_2.self = "1";

		List<NestedInteger> SecondNestedList = new ArrayList<NestedInteger>();
		SecondNestedList.add(SecondOne_1);
		SecondNestedList.add(SecondOne_2);

		NestedInteger SecondNestedObject = new NestedInteger();
		SecondNestedObject.self = SecondNestedList;

		NestedInteger two = new NestedInteger();
		two.self = "2";

		List<NestedInteger> MostOutterList = new ArrayList<NestedInteger>();
		MostOutterList.add(firstNestedObject);
		MostOutterList.add(two);
		MostOutterList.add(SecondNestedObject);
			
		return MostOutterList;

	}

}

class NestedInteger{
	Object self;
	
	public boolean isInteger(){
		if (self instanceof String){
			return true;
		}
		return false;
	}
	
	public Integer getInteger(){
		return Integer.valueOf(self.toString());
	}
	
    public List<NestedInteger> getList() {
        if (!isInteger()) { 
            return (List<NestedInteger>) self;
        } 
 
        return null; 
    }
	
	
	
}
