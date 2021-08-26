import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] a) {
        Deque<Integer> s = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0 || s.isEmpty() || s.peekLast() < 0)
                s.offerLast(a[i]);
            else if (s.peekLast() <= -a[i])
                if (s.pollLast() < -a[i]) i--;
        }
        int[] res = new int[s.size()];
        for (int i = s.size() - 1; i >= 0; i--) {
            res[i] = s.pollLast();
        }
        
        return res;
    }

    public static void main(String[] args) {
        AsteroidCollision sol = new AsteroidCollision();
        int[] a, res;

        a = new int[]{5,10,-5};
        res = sol.asteroidCollision(a);
        System.out.println("Asteroid : " + Arrays.toString(a));
        System.out.println("Result   : " + Arrays.toString(res));
    }
}
/*abstract
735. Asteroid Collision
Medium

We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

 

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
Example 4:

Input: asteroids = [-2,-1,1,2]
Output: [-2,-1,1,2]
Explanation: The -2 and -1 are moving left, while the 1 and 2 are moving right. Asteroids moving the same direction never meet, so no asteroids will meet each other.
 

Constraints:

2 <= asteroids.length <= 104
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0

at the end, all the negative star has to be on the left, and all the positive star has to be on the right.
from the left, a negative star will pass through if no positive star on the left;
keep track of all the positive stars moving to the right, the right most one will be the 1st confront the challenge of any future negative star.
if it survives, keep going, otherwise, any past positive star will be exposed to the challenge, by being popped out of the stack.
*/