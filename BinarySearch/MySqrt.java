public class MySqrt {
    public int mySqrt(int x) {
        if (x < 2) return x;

        long num;
        int pivot, left = 2, right = x / 2;
        while (left <= right) {
          pivot = left + (right - left) / 2;
          num = (long)pivot * pivot;
          if (num > x) right = pivot - 1;
          else if (num < x) left = pivot + 1;
          else return pivot;
        }

        return right;
  }

  public static void main(String[] args) {
      MySqrt sol = new MySqrt();
      int x, res;

      x = 10;
      res = sol.mySqrt(x);
      System.out.println("[x , sqrt(x)] : " + x + " , " + res);
  }
}
/*abstract
https://leetcode.com/problems/sqrtx/

*/