package edu.umb.cs680.hw06;

import java.time.LocalDateTime;

public class FSElement {
    protected String name;
    protected int size;
    protected LocalDateTime creationTime;
    protected Directory parent;

    public FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }
    public Directory getParent() {
        return this.parent;
    }
    public int getSize() {
        return this.size;
    }
    public String getName() {
        return this.name;
    }
    public LocalDateTime getCreationTime() {
        return this.creationTime;
    }
    public void setParent(Directory parent) {
        this.parent = parent;
    }
    public boolean isDirectory() {
        return false;
    }
    public boolean isFile() {
        return false;
    }
}
