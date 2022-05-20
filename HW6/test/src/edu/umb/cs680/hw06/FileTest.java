package edu.umb.cs680.hw06;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileTest {
    static LocalDateTime localDateTime = LocalDateTime.now();
    Directory root = new Directory(null, "root", 0, localDateTime);
    Directory apps = new Directory(root, "Apps", 0, localDateTime);
    Directory bin = new Directory(root, "bin", 0, localDateTime);
    Directory home = new Directory(root, "home", 0, localDateTime);
    Directory pictures = new Directory(home, "pictures", 0, localDateTime);
    File x = new File(apps, "x", 5, localDateTime);
    File y = new File(bin, "y", 5, localDateTime);
    File a = new File(pictures, "a", 5, localDateTime);
    File b = new File(pictures, "b", 5, localDateTime);
    File c = new File(home, "c", 5, localDateTime);
    @Test
    public void verifyIsFile() {
        assertFalse(root.isFile());
        assertTrue(x.isFile());
    }
}
