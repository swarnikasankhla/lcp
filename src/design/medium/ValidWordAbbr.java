package design.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class ValidWordAbbr {
    Map<String, Set<String>> dict;
    public ValidWordAbbr(String[] dictionary) {
        dict = new HashMap<>();
        for(String s : dictionary){
            String abbr = abbreviate(s);
            Set<String> words = dict.getOrDefault(abbr, new HashSet<>());
            words.add(s);
            dict.put(abbr, words);
        }
    }

    public boolean isUnique(String word) {
        String abbr = abbreviate(word);
        if(!dict.containsKey(abbr)) return true;
        if(dict.containsKey(abbr)){
            if(dict.get(abbr).size() < 2 && dict.get(abbr).contains(word)) return true;
        }
        return false;
    }

    private String abbreviate(String word){
        if(word.length() <= 2)  return word;
        String abbr = "";
        int count = 0;
        for(int i=0; i<word.length(); i++){
            if(i==0){
                abbr += word.charAt(i);
            }
            else if(i < word.length()-1){
                count++;
            }
            else{
                abbr += String.valueOf(count) + word.charAt(i);
            }
        }
        return abbr;
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
