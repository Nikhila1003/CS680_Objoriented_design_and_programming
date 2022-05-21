package edu.umb.cs680.hw08.fs;

import java.util.ArrayList;

public abstract class FileSystem {
    protected String name;
    protected int capacity;
    protected int id;
    protected ArrayList<FSElement> rootDirs = new ArrayList<>();

    public FSElement init(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        FSElement root = createDefaultRoot();
        if(root.isDirectory() && capacity >= root.getSize()) {
            setRoot(root);
            this.id = root.hashCode();
            return root;
        } else {
            return null;
        }
    }

    protected String getName() {
        return this.name;
    }

    protected int getCapacity() {
        return this.capacity;
    }

    protected int getId() {
        return this.id;
    }

    protected ArrayList<FSElement> getRootDirs() {
        return this.rootDirs;
    }

    protected void setRoot(FSElement root) {
        this.rootDirs.add(root);
    }

    protected abstract FSElement createDefaultRoot();
}
