package edu.umb.cs680.hw14.apfs;

import edu.umb.cs680.hw14.fs.FSElement;
import edu.umb.cs680.hw14.fs.FileSystem;

import java.time.LocalDateTime;

public class APFS extends FileSystem {

    private static APFS instance = null;

    public static APFS getInstance() {
        if(instance == null) {
            instance = new APFS();
        }
        return instance;
    }

    protected FSElement createDefaultRoot() {
        return new ApfsDirectory(null, "root", 0, LocalDateTime.now(), "S.Kona001", LocalDateTime.now());
    }

    public ApfsDirectory getRootDir() {
        return (ApfsDirectory) getRootDirs().get(0);
    }

}
