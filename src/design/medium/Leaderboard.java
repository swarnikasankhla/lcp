package design.medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Leaderboard {
    Map<Integer, Integer> playerScore;
    Map<Integer, Integer> sortedScore;

    public Leaderboard() {
        playerScore = new HashMap<>();
        sortedScore = new TreeMap<>(Collections.reverseOrder());
    }

    public void addScore(int playerId, int score) {
        if(playerScore.containsKey(playerId)){
            int oldScore = playerScore.get(playerId);
            int newScore = oldScore + score;

            playerScore.put(playerId, newScore);

            int oldCount = sortedScore.get(oldScore);
            if(oldCount == 1){
                sortedScore.remove(oldScore);
            }else{
                sortedScore.put(oldScore, oldCount-1);
            }
            sortedScore.put(newScore, sortedScore.getOrDefault(newScore, 0)+1);
        }else{
            playerScore.put(playerId, score);
            sortedScore.put(score, sortedScore.getOrDefault(score, 0) + 1);
        }
    }


    public int top(int K) {
        int sum = 0;
        for(Map.Entry<Integer, Integer> entry: sortedScore.entrySet()){
            int score = entry.getKey();
            int scoreCount = entry.getValue();
            if(scoreCount <= K){
                sum = sum + (score * scoreCount);
                K = K - scoreCount;
            }else{
                while(K > 0){
                    sum = sum + score;
                    K--;
                }
            }
            if(K == 0) break;
        }
        return sum;
    }

    public void reset(int playerId) {
        int oldScore = playerScore.get(playerId);
        playerScore.remove(playerId);
        int oldCount = sortedScore.get(oldScore);
        if(oldCount == 1){
            sortedScore.remove(oldScore);
        }else{
            sortedScore.put(oldScore, oldCount-1);
        }
    }

}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
