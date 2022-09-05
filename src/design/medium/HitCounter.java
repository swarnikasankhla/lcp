package design.medium;

import javafx.util.Pair;
import lombok.Data;

import java.util.Deque;
import java.util.LinkedList;
@Data
class HitCounter {
    Deque<Pair<Integer, Integer>> hits;
    static final int HIT_WINDOW = 300;
    int totalHits;
    public HitCounter() {
        hits = new LinkedList<>();
        totalHits = 0;
    }

    public void hit(int timestamp) {
        int hitCount=0;
        if(hits.peekLast() != null && hits.peekLast().getKey() == timestamp){
            hitCount = hits.pollLast().getValue();
        }
        hitCount++;
        hits.offerLast(new Pair<Integer, Integer>(timestamp, hitCount));
        totalHits++;
    }

    public int getHits(int timestamp) {
        while(hits.peekFirst() != null && timestamp - hits.peekFirst().getKey() >= HIT_WINDOW){
            totalHits = totalHits - hits.pollFirst().getValue();
        }
        return totalHits;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */

//binary search can be used to speed up getHits if all hits are stored, but it will not scale well for a lot of hits
