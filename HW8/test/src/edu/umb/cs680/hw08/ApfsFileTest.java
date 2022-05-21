package edu.umb.cs680.hw08;

import edu.umb.cs680.hw08.apfs.ApfsDirectory;
import edu.umb.cs680.hw08.apfs.ApfsFile;
import edu.umb.cs680.hw08.apfs.ApfsLink;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ApfsFileTest {
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

    private String[] fileToStringArray(ApfsFile file) {
        String[] fileInfo = {Boolean.toString(file.isFile()), file.getName(), file.getParent().getName(),
                Integer.toString(file.getSize()), file.getCreationTime().toString(),
                file.getOwnerName(), file.getLastModifiedTime().toString()};

        return fileInfo;
    }
    @Test
    public void verifyIsFile() {
        assertFalse(root.isFile());
        assertTrue(x.isFile());
    }
    @Test
    public void verifyFileC() {
        String[] expected = {"true", "c", "home", "5", localDateTime.toString(), "Owner", localDateTime.toString()};
        String[] actual = fileToStringArray(c);
        assertArrayEquals(expected, actual);
    }
}
