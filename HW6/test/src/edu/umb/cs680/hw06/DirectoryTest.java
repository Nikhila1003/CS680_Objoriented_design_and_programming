package edu.umb.cs680.hw06;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DirectoryTest {
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

    private String[] dirToStringArray(Directory directory) {
        String parentName = null;
        Directory parent = directory.getParent();
        if (parent != null) {
            parentName = parent.getName();
        }
        String[] dirInfo = { Boolean.toString(directory.isDirectory()), directory.getName(),
                Integer.toString(directory.getSize()), directory.getCreationTime().toString(),parentName,
                Integer.toString(directory.countChildren()),Integer.toString(directory.getTotalSize()) };

        return dirInfo;
    }
    @Test
    public void verifyDirectoryEqualityRoot() {
        String[] expected = {"true", "root", "0", localDateTime.toString(), null, "3", "25"};
        Directory actual = root;
        assertArrayEquals(expected, dirToStringArray(actual));
    }
    @Test
    public void verifyDirectoryEqualityHome() {
        String[] expected = {"true", "home", "0", localDateTime.toString(), "root", "2", "15"};
        Directory actual = home;
        assertArrayEquals(expected, dirToStringArray(actual));
    }
    @Test
    public void verifyDirectoryEqualityBin() {
        String[] expected = {"true", "bin", "0", localDateTime.toString(), "root", "1", "5"};
        Directory actual = bin;
        assertArrayEquals(expected, dirToStringArray(actual));
    }
    @Test
    public void verifyDirectoryEqualityApps() {
        String[] expected = {"true", "Apps", "0", localDateTime.toString(), "root", "1", "5"};
        Directory actual = apps;
        assertArrayEquals(expected, dirToStringArray(actual));
    }
    @Test
    public void verifyIsDirectory() {
        assertTrue(root.isDirectory());
        assertFalse(x.isDirectory());
    }
    @Test
    public void verifyGetFiles() {
        ArrayList<File> expected = new ArrayList<>();
        expected.add(x);
        assertEquals(expected, apps.getFiles());
    }
    @Test
    public void verifyGetSubDirectories() {
        ArrayList<Directory> expected = new ArrayList<>();
        expected.add(pictures);
        assertEquals(expected, home.getSubDirectories());
    }
    @Test
    public void verifyGetChildren() {
        ArrayList<FSElement> expected = new ArrayList<>();
        expected.add(a);
        expected.add(b);
        assertEquals(expected, pictures.getChildren());
    }
}
