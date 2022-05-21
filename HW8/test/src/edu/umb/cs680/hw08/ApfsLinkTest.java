package edu.umb.cs680.hw08;

import edu.umb.cs680.hw08.apfs.ApfsDirectory;
import edu.umb.cs680.hw08.apfs.ApfsFSElement;
import edu.umb.cs680.hw08.apfs.ApfsFile;
import edu.umb.cs680.hw08.apfs.ApfsLink;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ApfsLinkTest {
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

    @Test
    public void verifyIsLink() {
        assertFalse(root.isLink());
        assertFalse(x.isLink());
        assertTrue(p.isLink());
    }
    @Test
    public void verifyLinkY() {
        ApfsFile expected = y;
        ApfsFSElement actual = q.getTarget();
        assertEquals(expected, actual);
    }
}
