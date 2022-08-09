package design.easy;

import java.util.Deque;
import java.util.LinkedList;

class CompressedStringIterator {
    Deque<Pair<String, Integer>> compressed;
    String compressedString;
    public CompressedStringIterator(String compressedString) {
        this.compressedString = compressedString;
        compressed = new LinkedList<>();
        enqueueCharacters();
    }

    public char next() {
        char next = ' ';
        if(compressed.size() > 0){
            Pair<String, Integer> charCount = compressed.pollFirst();
            if(charCount.getCount() > 1){
                compressed.offerFirst(new Pair(charCount.getCharacter(), charCount.getCount()-1));
            }
            next = charCount.getCharacter();
        }
        return next;
    }

    public boolean hasNext() {
        if(compressed.size() > 0){
            return true;
        }
        else{
            return false;
        }
    }

    private void enqueueCharacters(){
        for(char c : compressedString.toCharArray()){
            if(Character.isDigit(c)){
                Pair<String, Integer> charCount = compressed.removeLast();
                int count = charCount.getCount() * 10 + Character.getNumericValue(c);
                compressed.offer(new Pair(charCount.getCharacter(), count));

            }else{
                compressed.offer(new Pair(c, 0));
            }

        }
    }
}

 class Pair<String, Integer>{
    char character;
    int count;

    public Pair(char character, int count){
        this.character = character;
        this.count = count;
    }

    public char getCharacter(){
        return character;
    }

    public int getCount(){
        return count;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
