package design.medium;

import java.util.HashMap;
import java.util.Map;

class TrieNode{
    Character c;
    Map<Character, TrieNode> children;
    Boolean wordEnd;
    Integer wordCount;
    Integer prefixCount;

    public TrieNode(){
        this.c='\0';
        this.children = new HashMap<>();
        this.wordEnd  = false;
        this.wordCount = 0;
        this.prefixCount = 0;
    }

}