package edu.umb.cs680.hw07;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class LinkTest {
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

    @Test
    public void verifyIsLink() {
        assertFalse(root.isLink());
        assertFalse(x.isLink());
        assertTrue(p.isLink());
    }
    @Test
    public void verifyLinkY() {
        File expected = y;
        FSElement actual = q.getTarget();
        assertEquals(expected, actual);
    }
}
