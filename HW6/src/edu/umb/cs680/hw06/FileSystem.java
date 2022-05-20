package edu.umb.cs680.hw06;

import java.util.ArrayList;

public class FileSystem {
    private ArrayList<Directory> rootDirs;
    private  static FileSystem instance = null;

    private FileSystem() {
        rootDirs = new ArrayList<>();
    }
    public static FileSystem getFileSystem() {
        if ( instance == null ) {
            instance = new FileSystem();
        }
        return  instance;
    }
    public ArrayList<Directory> getRootDirs() {
        return rootDirs;
    }
    public void appendRootDir(Directory root) {
        rootDirs.add(root);
    }
}
