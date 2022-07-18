package design.easy;

import java.util.HashMap;
import java.util.Map;

class LoggerRateLimit {
    Map<String, Integer> messageLimit;
    final int TIME_LIMIT = 10;
    /** Initialize your data structure here. */
    public LoggerRateLimit() {
        messageLimit = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        int messageTime = messageLimit.getOrDefault(message, 0);
        if(messageTime > timestamp) {
            return false;
        }else{
            messageLimit.put(message, timestamp + TIME_LIMIT);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
