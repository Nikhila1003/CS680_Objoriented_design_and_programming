package edu.umb.cs680.hw04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LFUFileCache extends FileCache{

    protected void cacheFile(Path path) {
        try {
            String data = Files.readString(path);
            cache.put(path, data);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    protected void replace(Path path) {
        try {
            Path removePath = cache.keySet().iterator().next(); 
            cache.remove(removePath);
            String data = Files.readString(path);
            cache.put(path, data);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
