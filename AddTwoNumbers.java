/**
 * San Wong
 * hswong1@uci.edu
 * 
 * 2. Add Two Numbers
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultHead = new ListNode(0);
        ListNode pointer = resultHead;
        int carryOver = 0;
        while (l1!=null || l2!=null){
            int newValue = 0;
            if (l1 == null){
                newValue = l2.val+carryOver;
            }else if (l2 == null){
                newValue = l1.val+carryOver;
            }else{
                newValue = l1.val+l2.val+carryOver;
            }
            
            carryOver = 0;
            if(newValue >=10){
                carryOver = newValue/10;
                newValue = newValue%10;
            }
            
            pointer.next = new ListNode(newValue);
            pointer = pointer.next;
            
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
       
        }
        
        if(carryOver>0){
            pointer.next = new ListNode(carryOver);
        }
        
        return resultHead.next;
    }
}