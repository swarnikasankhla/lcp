package design.medium;

public class FileSystem {
    Folder root;

    public FileSystem() {
        root = new Folder(0);
    }

    public boolean createPath(String path, int value) {
        Folder node = root;

        String[] folders =  path.substring(1, path.length()).split("/");
        int len = folders.length;

        for(int i=0; i <= len-2; i++){
            if(!node.children.containsKey(folders[i])){
                return false;
            }
            node = node.children.get(folders[i]);
        }

        if(node.children.containsKey(folders[len-1])) {
            return false;
        }
        else{
            node.children.put(folders[len-1], new Folder(value));
            return true;
        }
    }

    public int get(String path) {
        Folder node = root;

        String[] folders =  path.substring(1, path.length()).split("/");
        int len = folders.length;
        for(int i=0; i<=len-2; i++){
            if(!node.children.containsKey(folders[i])) return -1;
            node = node.children.get(folders[i]);
        }

        if(!node.children.containsKey(folders[len-1]) ){
            return -1;
        }else{
            return node.children.get(folders[len-1]).value;
        }
    }
}
