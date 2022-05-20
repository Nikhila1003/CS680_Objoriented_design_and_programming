package edu.umb.cs680.hw07;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

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
    Link p = new Link(home, "x", 0, localDateTime, x);
    Link q = new Link(pictures, "y", 0, localDateTime, y);

    private String[] fileToStringArray(File file) {
        String[] fileInfo = {Boolean.toString(file.isFile()), file.getName(), file.getParent().getName(),
                Integer.toString(file.getSize()), file.getCreationTime().toString()};

        return fileInfo;
    }
    @Test
    public void verifyIsFile() {
        assertFalse(root.isFile());
        assertTrue(x.isFile());
    }
    @Test
    public void verifyFileC() {
        String[] expected = {"true", "c", "home", "5", localDateTime.toString()};
        String[] actual = fileToStringArray(c);
        assertArrayEquals(expected, actual);
    }
}
