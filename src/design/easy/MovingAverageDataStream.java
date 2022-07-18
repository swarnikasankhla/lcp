package design.easy;

import java.util.LinkedList;
import java.util.Queue;

class MovingAverageDataStream {
    int streamSize;
    Queue<Integer> stream;
    int lastSum;

    /** Initialize your data structure here. */
    public MovingAverageDataStream(int size) {
        streamSize = size;
        stream = new LinkedList<>();
    }

    public double next(int val) {
        if(streamSize == 0) return lastSum;
        int prevNum = updateStream(val);
        return getAverage(prevNum, val);
    }

    private int updateStream(int nextNum){
        int prevNum = 0;
        if(stream.size() == streamSize){
            prevNum = stream.poll();
        }
        stream.offer(nextNum);
        return prevNum;
    }

    private double getAverage(int prevNum, int nextNum){
        lastSum = lastSum - prevNum;
        lastSum = lastSum + nextNum;
        return lastSum * 1.0 / stream.size();
    }
}