/*
 * San Wong
 * hswong1@uci.edu
 * 
 * LeetCode: 122 Best Time to Buy and Sell Stock II
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times). However, you may not engage in multiple transactions
 * at the same time (ie, you must sell the stock before you buy again).
 * 
 */
public class BestTimeToBuySellStockTWO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {99,53,38,87,12,87,97,32,11,89};
		System.out.println("MaxProfit: " + maxProfit(prices));

	}
	
    public static int maxProfit(int[] prices) {
    	int profit = 0;
        
        for (int i=1; i<prices.length; i++){
            if(prices[i]>prices[i-1]){
                int diff = prices[i]-prices[i-1];
                profit+=diff;
            }
        }
        
        return profit;
    }

}
