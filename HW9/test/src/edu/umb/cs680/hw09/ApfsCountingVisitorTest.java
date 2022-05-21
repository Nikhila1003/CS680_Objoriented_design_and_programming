package edu.umb.cs680.hw09;

import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;
import edu.umb.cs680.hw09.apfs.util.ApfsCountingVisitor;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ApfsCountingVisitorTest {

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

    @Test
    public void testVisitorRoot() {
        ApfsCountingVisitor visitor = new ApfsCountingVisitor();
        root.accept(visitor);
        assertEquals(5,visitor.getDirNumber());
        assertEquals(5,visitor.getFileNumber());
        assertEquals(2,visitor.getLinkNumber());
    }
    @Test
    public void testVisitorBin() {
        ApfsCountingVisitor visitor = new ApfsCountingVisitor();
        bin.accept(visitor);
        assertEquals(1,visitor.getDirNumber());
        assertEquals(1,visitor.getFileNumber());
        assertEquals(0,visitor.getLinkNumber());
    }
    @Test
    public void testVisitorPictures() {
        ApfsCountingVisitor visitor = new ApfsCountingVisitor();
        bin.accept(visitor);
        assertEquals(1,visitor.getDirNumber());
        assertEquals(1,visitor.getFileNumber());
        assertEquals(0,visitor.getLinkNumber());
    }
}
