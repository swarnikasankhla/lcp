package design.medium;

import java.util.LinkedList;
import java.util.List;

public class EncodeDecode {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for(String str : strs){     //O(n)
            int len = str.length();
            result.append(len).append("#").append(str);
        }
        return result.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new LinkedList<>();
        int i=0;
        int length = s.length();
        while(i < length){
            int j = i;
            while(s.charAt(j) != '#'){
                j++;
            }
            int strLen = Integer.valueOf(s.substring(i, j));
            i = j + 1 + strLen;
            result.add(s.substring(j+1, i));
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
