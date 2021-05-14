import java.util.HashMap;

public class Logger {
    private HashMap<String, Integer> msgDict;

    /** Initialize your data structure here. */
    public Logger() {
        msgDict = new HashMap<String, Integer>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp,
     * otherwise returns false.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {

        if (!this.msgDict.containsKey(message)) {
            this.msgDict.put(message, timestamp);
            return true;
        }

        Integer oldTimestamp = this.msgDict.get(message);
        if (timestamp - oldTimestamp >= 10) {
            this.msgDict.put(message, timestamp);
            return true;
        } else
            return false;
    }

    public static void main(String[] args) {
        Logger logger = new Logger();
        logger.shouldPrintMessage(1, "foo"); // return true, next allowed timestamp for "foo" is 1 + 10 = 11
        logger.shouldPrintMessage(2, "bar"); // return true, next allowed timestamp for "bar" is 2 + 10 = 12
        logger.shouldPrintMessage(3, "foo"); // 3 < 11, return false
        logger.shouldPrintMessage(8, "bar"); // 8 < 12, return false
        logger.shouldPrintMessage(10, "foo"); // 10 < 11, return false
        logger.shouldPrintMessage(11, "foo"); // 11 >= 11, return true, next allowed timestamp for "foo" is
                                              // 11 + 10 = 21
    }
}

/**
 * Your Logger object will be instantiated and called as such: Logger obj = new
 * Logger(); boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 * https://leetcode.com/problems/logger-rate-limiter/
 */