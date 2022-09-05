package design.medium;

public class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(int i=0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!node.children.containsKey(c)){
                node.children.put(c, new TrieNode());
            }
            node=node.children.get(c);
            node.c=c;
            node.prefixCount++;
        }
        node.wordEnd=true;
        node.wordCount++;
    }

    public int countWordsEqualTo(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(!node.children.containsKey(c)){
                return 0;
            }
            node=node.children.get(c);
        }
        return node.wordEnd ? node.wordCount : 0;
    }

    public int countWordsStartingWith(String prefix) {
        TrieNode node = root;
        for(int i=0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            if(!node.children.containsKey(c)){
                return 0;
            }
            node=node.children.get(c);
        }
        return node.prefixCount;
    }

    public void erase(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            node.children.get(c).prefixCount--;
            if(node.children.get(c).prefixCount < 1) {
                node.children.remove(c);
                return;
            }else{
                node = node.children.get(c);
            }
        }
        node.wordCount--;
    }
}
