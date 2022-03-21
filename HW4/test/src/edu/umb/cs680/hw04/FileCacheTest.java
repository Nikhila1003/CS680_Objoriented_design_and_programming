package edu.umb.cs680.hw04;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class FileCacheTest {

    private FileCache fileCache;

    @Test
    public void fetchWithFIFOFileCache() {
        try {
            fileCache = new FIFOFileCache();
            Path p = Paths.get("forTest\\thisIsForTest");
            assertEquals(Files.readString(p), fileCache.fetch(p));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void fetchWithLFUFileCache() {
        try {
            fileCache = new LFUFileCache();
            Path p = Paths.get("forTest\\thisIsForTest");
            assertEquals(Files.readString(p), fileCache.fetch(p));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
