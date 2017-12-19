/*
 *
 * There are N stones placed on the ground, forming a sequence. The stones are labeled from 1 to N.
 * Alice and Bob in turns take exactly two consecutive stones on the ground until there are no consecutive stones on
 * the ground. That is, each player can take stone i and stone i+1, where 1≤i≤N−1.
 * If the number of stone left is odd, Alice wins. Otherwise, Bob wins.
 * Assume both Alice and Bob play optimally and Alice plays first, do you know who the winner is?
 *
 * The input contains an integer N (1≤N≤10000000), the number of stones.
 * Output the winner, “Alice” or “Bob” (without the quotes), on a line.
 *
 * */
public class TakeTwoStones  {
    public static void main(String[] args){
        Kattio io = new Kattio(System.in);

        if((io.getLong() & 0b1L) == 0){
            System.out.print("Bob");
        } else{
            System.out.print("Alice");
        }

        /*
        *  10 stones
        *  A 1 2
        *  B 3 4
        *  A 5 6
        *  B 7 8
        *  A 9 10
        *
        *  1 stone
        *  A 1
        *
        *  2 stones
        *  A 1 2
        *  B
        *
        *  5 stones
        *  A 1 2
        *  B 3 4
        *  A 5
        * */

    }

}
