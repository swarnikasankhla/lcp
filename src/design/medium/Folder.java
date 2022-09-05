package design.medium;

import java.util.HashMap;
import java.util.Map;

public class Folder {
    Map<String, Folder> children;
    Integer value;

    public Folder(int val){
        children = new HashMap<>();
        value = val;
    }
}
