/*
*
* Our sad tale begins with a tight clique of friends. Together they went on a trip to the picturesque country of
* Molvania. During their stay, various events which are too horrible to mention occurred. The net result was that
* the last evening of the trip ended with a momentous exchange of “I never want to see you again!”s.
* A quick calculation tells you it may have been said almost 5050 million times!
* Back home in Scandinavia, our group of ex-friends realize that they haven’t split the costs incurred during the
* trip evenly. Some people may be out several thousand crowns. Settling the debts turns out to be a bit more
* problematic than it ought to be, as many in the group no longer wish to speak to one another, and even
* less to give each other money.
*
* Naturally, you want to help out, so you ask each person to tell you how much money she owes or is owed,
* and whom she is still friends with. Given this information, you’re sure you can figure out if it’s possible
* for everyone to get even, and with money only being given between persons who are still friends.
*
*
* The first line contains two integers,
*       n (2 ≤ n ≤ 10000 ), the number of friends
*   and m (0 ≤ m ≤ 500000 ), the number of remaining friendships
* The friends are named 0,1,…,n−1.
* Then n lines follow, each containing an integer o(−10 000 ≤ o ≤ 10 000) indicating how much each
* person owes (or is owed if o<0). The first of those lines gives the balance of person 0, the second
* line the balance of person 1, and so on. The sum of these values is zero.
* After this comes m lines giving the remaining friendships, each line containing two integers
* x, y (0 ≤ x < y ≤ n−1 ) indicating that persons x and y are still friends.
*
*
*
*
* 5 3   5 friends and 3 remaining friendships
*
* 100  p0 ows
* -75  p1 owed
* -25  p2 owed
* -42  p3 owed
*  42  p4 ows
*
* 0 1   p1 skuld = -75
* 1 2   p1
* 3 4
*
* */

public class Picturesque {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
