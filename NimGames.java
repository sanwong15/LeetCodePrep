/*
San Wong
hswong1@uci.edu

LeetCode 292 Nim Game.
You are playing the following Nim Game with your friend:
There is a heap of stones on the table, each time one of you take turns to
remove 1 to 3 stones.
The one who removes the last stone will be the winner.
You will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game.
Write a function to determine whether you can win the game given the number of stones in the heap.

For example, if there are 4 stones in the heap,
then you will never win the game: no matter 1, 2, or 3 stones you remove,
the last stone will always be removed by your friend.
if n = 4. You lose
if n=5 to 7 (i.e 4+3). you can take one and leave your friend 4. You win
if n=8. You have to take at least one, which leave your friend 7. You lose.
if n=9, You take one. Leave your friend 8, You win.
if n=10, You take 2, Leave your friend 8, You win.
if n=11. You take 3, Leave your friend 8, You win.

	Conclusion: As long as n%4!=0. You win

*/

public class NimGame{
	public boolean canWin(int n){
		if (n<=3 && n>0) return true;

		if (n<=0) return false;

		if (n%4 != 0){
			return true;
		}else{
			return false;
		}
	}
}