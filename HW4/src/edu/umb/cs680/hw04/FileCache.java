package edu.umb.cs680.hw04;

import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class FileCache {

    protected Map<Path, String> cache = new LinkedHashMap<>();

    public String fetch(Path path) {
        if (isCached(path)) {
            return cache.get(path);
        } else {
            if (!isCacheFull()) {
                cacheFile(path);    
                return cache.get(path);
            } else {
                replace(path);
                return cache.get(path);
            }
        }
    }

    protected boolean isCached(Path path) {
        if(cache.containsKey(path)) {
            return true;
        }
        return false;
    }

    protected boolean isCacheFull() {
        if(cache.size() == 5) {
            return true;
        } 
        return false;
    }

    protected abstract void cacheFile(Path path);

    protected abstract void replace(Path path);

    public static void main(String[] args) {
        System.out.println("This is FileCache class");
    }

}
