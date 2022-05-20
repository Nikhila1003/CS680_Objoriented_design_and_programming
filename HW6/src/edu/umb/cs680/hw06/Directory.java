package edu.umb.cs680.hw06;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Directory extends FSElement {

    private ArrayList<FSElement> children;

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
        if(parent != null) {
            parent.appendChild(this);
        }
        this.children = new ArrayList<>();
    }
    public ArrayList<FSElement> getChildren() {
        return children;
    }
    public void appendChild(FSElement child) {
        children.add(child);
        child.setParent(this);
    }
    public int countChildren() {
        return getChildren().size();
    }
    public ArrayList<Directory> getSubDirectories() {
        ArrayList<Directory> subDirectories = new ArrayList<>();
        for (FSElement fsElement : getChildren()) {
            if (fsElement instanceof Directory) {
                subDirectories.add((Directory) fsElement);
            }
        }
        return subDirectories;
    }
    public ArrayList<File> getFiles() {
        ArrayList<File> files = new ArrayList<>();
        for ( FSElement fsElement : getChildren()) {
            if (fsElement instanceof  File) {
                files.add((File) fsElement);
            }
        }
        return files;
    }
    public int getTotalSize() {
        int totalSize = 0;
        for (FSElement fsElement : getChildren()) {
            if (fsElement instanceof Directory)
                totalSize += ((Directory) fsElement).getTotalSize();
            else
                totalSize += fsElement.getSize();
        }
        return totalSize;
    }
    public boolean isDirectory() {
        return true;
    }
}
