package edu.umb.cs680.hw09;

import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;
import edu.umb.cs680.hw09.apfs.util.ApfsFileSearchVisitor;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ApfsFileSearchVisitorTest {

    static LocalDateTime localDateTime = LocalDateTime.now();
    ApfsDirectory root = new ApfsDirectory(null, "root", 0, localDateTime, "Owner", localDateTime);
    ApfsDirectory apps = new ApfsDirectory(root, "Apps", 0, localDateTime, "Owner", localDateTime);
    ApfsDirectory bin = new ApfsDirectory(root, "bin", 0, localDateTime, "Owner", localDateTime);
    ApfsDirectory home = new ApfsDirectory(root, "home", 0, localDateTime, "Owner", localDateTime);
    ApfsDirectory pictures = new ApfsDirectory(home, "pictures", 0, localDateTime, "Owner", localDateTime);
    ApfsFile x = new ApfsFile(apps, "x", 10, localDateTime, "Owner", localDateTime);
    ApfsFile y = new ApfsFile(bin, "y", 15, localDateTime, "Owner", localDateTime);
    ApfsFile a = new ApfsFile(pictures, "a", 20, localDateTime, "Owner", localDateTime);
    ApfsFile b = new ApfsFile(pictures, "b", 20, localDateTime, "Owner", localDateTime);
    ApfsFile c = new ApfsFile(home, "c", 25, localDateTime, "Owner", localDateTime);
    ApfsLink p = new ApfsLink(home, "x", 0, localDateTime, "Owner", localDateTime,x);
    ApfsLink q = new ApfsLink(pictures, "y", 0, localDateTime, "Owner", localDateTime, y);

    private String[] fileToStringArray(ApfsFile file) {
        String[] fileInfo = {Boolean.toString(file.isFile()), file.getName(), file.getParent().getName(),
                Integer.toString(file.getSize()), file.getCreationTime().toString(),
                file.getOwnerName(), file.getLastModifiedTime().toString()};

        return fileInfo;
    }

    @Test
    public void testFileB() {
        ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("b");
        String[] expected = { "true", "b", "pictures", "20", localDateTime.toString(), "Owner", localDateTime.toString() };
        root.accept(visitor);
        ApfsFile actual = visitor.getFoundFiles().get(0);
        assertArrayEquals(expected, fileToStringArray(actual));
    }
    @Test
    public void testFileC() {
        ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("c");
        String[] expected = { "true", "c", "home", "25", localDateTime.toString(), "Owner", localDateTime.toString() };
        root.accept(visitor);
        ApfsFile actual = visitor.getFoundFiles().get(0);
        assertArrayEquals(expected, fileToStringArray(actual));
    }
}
