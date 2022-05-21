package edu.umb.cs680.hw14;

import edu.umb.cs680.hw14.apfs.ApfsDirectory;
import edu.umb.cs680.hw14.apfs.ApfsFile;
import edu.umb.cs680.hw14.apfs.ApfsLink;
import edu.umb.cs680.hw14.apfs.ApfsFSElement;
import edu.umb.cs680.hw14.fs.FSElement;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApfsDirectoryTest {

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
    ApfsLink p = new ApfsLink(home, "x", 0, localDateTime, "Owner", localDateTime,home);
    ApfsLink q = new ApfsLink(pictures, "y", 0, localDateTime, "Owner", localDateTime, y);

    @Test
    public void testGetChildrenRootAlphabeticalComparator() {
        LinkedList<ApfsFSElement> expected = new LinkedList<>();
        expected.add(apps);
        expected.add(bin);
        expected.add(home);
        assertEquals(expected, root.getChildren());
    }
    @Test
    public void testGetChildrenRootReverseAlphabeticalComparator() {
        LinkedList<ApfsFSElement> expected = new LinkedList<>();
        expected.add(home);
        expected.add(bin);
        expected.add(apps);
        assertEquals(expected, root.getChildren(Comparator.comparing(element -> element.getName(), Comparator.reverseOrder())));
    }
    @Test
    public void testGetChildrenAppsAlphabeticalComparator() {
        LinkedList<ApfsFSElement> expected = new LinkedList<>();
        expected.add(x);
        assertEquals(expected, apps.getChildren());
    }
    @Test
    public void testGetChildrenForHomeInReverseAlphabeticalComparator() {
        LinkedList<ApfsFSElement> expected = new LinkedList<>();
        expected.add(p);
        expected.add(pictures);
        expected.add(c);
        assertEquals(expected, home.getChildren(Comparator.comparing(element -> element.getName(), Comparator.reverseOrder())));
    }
}
