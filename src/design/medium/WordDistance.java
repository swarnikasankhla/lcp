package design.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WordDistance {
    Map<String, List<Integer>> wordLocation;
    public WordDistance(String[] wordsDict) {
        wordLocation = new HashMap<>();
        for(int i=0; i < wordsDict.length; i++){
            List<Integer> location = wordLocation.getOrDefault(wordsDict[i], new ArrayList<Integer>());
            location.add(i);
            wordLocation.put(wordsDict[i], location);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> location1 = wordLocation.get(word1);
        List<Integer> location2 = wordLocation.get(word2);

        int index1=0;
        int index2=0;
        int minDistance = Integer.MAX_VALUE;

        while(index1 < location1.size() && index2 < location2.size()){
            minDistance = Math.min(minDistance, Math.abs(location1.get(index1)-location2.get(index2)));
            if(minDistance == 1) break;
            if(location1.get(index1) < location2.get(index2)){
                index1++;
            }
            else{
                index2++;
            }
        }
        return minDistance;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
