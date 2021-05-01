import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;



public class CountAndSay {
    public String countAndSay(int n) {

        LinkedList<Integer> prevSeq = new LinkedList<Integer>();
        prevSeq.add(1);
        // Using -1 as the delimiter
        prevSeq.add(-1);
    
        List<Integer> finalSeq = this.nextSequence(n, prevSeq);
        StringBuffer seqStr = new StringBuffer();
        for (Integer digit : finalSeq) {
          seqStr.append(String.valueOf(digit));
        }
        return seqStr.toString();
      }
    
      protected LinkedList<Integer> nextSequence(int n, LinkedList<Integer> prevSeq) {
        if (n <= 1) {
          // remove the delimiter before return
          prevSeq.pollLast();
          return prevSeq;
        }
    
        LinkedList<Integer> nextSeq = new LinkedList<Integer>();
        Integer prevDigit = null;
        Integer digitCnt = 0;
        for (Integer digit : prevSeq) {
          if (prevDigit == null) {
            prevDigit = digit;
            digitCnt += 1;
          } else if (digit == prevDigit) {
            // in the middle of the sub-sequence
            digitCnt += 1;
          } else {
            // end of a sub-sequence
            nextSeq.add(digitCnt);
            nextSeq.add(prevDigit);
            // reset for the next sub-sequence
            prevDigit = digit;
            digitCnt = 1;
          }
        }
    
        // add the delimiter for the next recursion
        nextSeq.add(-1);
        return this.nextSequence(n - 1, nextSeq);
      }
      
      public static void main(String[] args) {
          CountAndSay sol = new CountAndSay();
          int n;
          String res;

          n = 1;
          res = sol.countAndSay(n);
          System.out.println("Input  : " + n);
          System.out.println("Output : " + res);

          n = 4;
          res = sol.countAndSay(n);
          System.out.println("Input  : " + n);
          System.out.println("Output : " + res);
      }
}
