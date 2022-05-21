package edu.umb.cs680.hw08;

import edu.umb.cs680.hw08.apfs.ApfsDirectory;
import edu.umb.cs680.hw08.apfs.ApfsFSElement;
import edu.umb.cs680.hw08.apfs.ApfsFile;
import edu.umb.cs680.hw08.apfs.ApfsLink;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApfsDirectoryTest {
    static LocalDateTime localDateTime = LocalDateTime.now();
    ApfsDirectory root = new ApfsDirectory(null, "root", 0, localDateTime, "Owner", localDateTime);
    ApfsDirectory apps = new ApfsDirectory(root, "Apps", 0, localDateTime, "Owner", localDateTime);
    ApfsDirectory bin = new ApfsDirectory(root, "bin", 0, localDateTime, "Owner", localDateTime);
    ApfsDirectory home = new ApfsDirectory(root, "home", 0, localDateTime, "Owner", localDateTime);
    ApfsDirectory pictures = new ApfsDirectory(home, "pictures", 0, localDateTime, "Owner", localDateTime);
    ApfsFile x = new ApfsFile(apps, "x", 5, localDateTime, "Owner", localDateTime);
    ApfsFile y = new ApfsFile(bin, "y", 5, localDateTime, "Owner", localDateTime);
    ApfsFile a = new ApfsFile(pictures, "a", 5, localDateTime, "Owner", localDateTime);
    ApfsFile b = new ApfsFile(pictures, "b", 5, localDateTime, "Owner", localDateTime);
    ApfsFile c = new ApfsFile(home, "c", 5, localDateTime, "Owner", localDateTime);
    ApfsLink p = new ApfsLink(home, "x", 0, localDateTime, "Owner", localDateTime, x);
    ApfsLink q = new ApfsLink(pictures, "y", 0, localDateTime, "Owner", localDateTime, y);

    private String[] dirToStringArray(ApfsDirectory directory) {
        String parentName = null;
        ApfsDirectory parent = directory.getParent();
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
        ApfsDirectory actual = root;
        assertArrayEquals(expected, dirToStringArray(actual));
    }
    @Test
    public void verifyDirectoryEqualityHome() {
        String[] expected = {"true", "home", "0", localDateTime.toString(), "root", "3", "15"};
        ApfsDirectory actual = home;
        assertArrayEquals(expected, dirToStringArray(actual));
    }
    @Test
    public void verifyDirectoryEqualityBin() {
        String[] expected = {"true", "bin", "0", localDateTime.toString(), "root", "1", "5"};
        ApfsDirectory actual = bin;
        assertArrayEquals(expected, dirToStringArray(actual));
    }
    @Test
    public void verifyDirectoryEqualityApps() {
        String[] expected = {"true", "Apps", "0", localDateTime.toString(), "root", "1", "5"};
        ApfsDirectory actual = apps;
        assertArrayEquals(expected, dirToStringArray(actual));
    }
    @Test
    public void verifyIsDirectory() {
        assertTrue(root.isDirectory());
        assertFalse(x.isDirectory());
    }
    @Test
    public void verifyGetFiles() {
        ArrayList<ApfsFile> expected = new ArrayList<>();
        expected.add(x);
        assertEquals(expected, apps.getFiles());
    }
    @Test
    public void verifyGetSubDirectories() {
        ArrayList<ApfsDirectory> expected = new ArrayList<>();
        expected.add(pictures);
        assertEquals(expected, home.getSubDirectories());
    }
    @Test
    public void verifyGetChildren() {
        ArrayList<ApfsFSElement> expected = new ArrayList<>();
        expected.add(a);
        expected.add(b);
        expected.add(q);
        assertEquals(expected, pictures.getChildren());
    }
}
