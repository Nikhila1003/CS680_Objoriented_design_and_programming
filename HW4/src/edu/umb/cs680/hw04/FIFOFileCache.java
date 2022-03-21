package edu.umb.cs680.hw04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class FIFOFileCache extends FileCache {

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
            Map.Entry<Path, String> entry = cache.entrySet().iterator().next();
            String data = Files.readString(path);
            Path removePath = entry.getKey();
            cache.remove(removePath);
            cache.put(path, data);
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

}
