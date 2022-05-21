package edu.umb.cs680.hw09.apfs;

import edu.umb.cs680.hw09.fs.FSElement;
import edu.umb.cs680.hw09.fs.FileSystem;

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
        return new ApfsDirectory(null, "root", 0, LocalDateTime.now(), "Owner", LocalDateTime.now());
    }

    public ApfsDirectory getRootDir() {
        return (ApfsDirectory) getRootDirs().get(0);
    }

}
