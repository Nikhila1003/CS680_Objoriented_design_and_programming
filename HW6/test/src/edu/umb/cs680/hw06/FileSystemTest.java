package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class FileSystemTest {
    static LocalDateTime localDateTime = LocalDateTime.now();
    Directory root = new Directory(null, "root", 0, localDateTime);
    Directory apps = new Directory(null, "Apps", 0, localDateTime);
    @Test
    public void verifyGetRootDirs() {
        FileSystem fileSystem = FileSystem.getFileSystem();
        fileSystem.appendRootDir(root);
        fileSystem.appendRootDir(apps);
        ArrayList<Directory> expected = new ArrayList<>();
        expected.add(root);
        expected.add(apps);
        assertEquals(expected, fileSystem.getRootDirs());
    }
}
