package edu.umb.cs680.hw08.apfs;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ApfsDirectory extends ApfsFSElement {
    private ArrayList<ApfsFSElement> children;

    public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName, LocalDateTime lastModifiedTime) {
        super(parent, name, size, creationTime, ownerName, lastModifiedTime);
        if(parent != null) {
            parent.appendChild(this);
        }
        this.children = new ArrayList<>();
    }

    public ArrayList<ApfsFSElement> getChildren() {
        return this.children;
    }

    public void appendChild(ApfsFSElement child) {
        this.children.add(child);
        child.setParent(this);
    }

    public int countChildren() {
        return getChildren().size();
    }

    public ArrayList<ApfsDirectory> getSubDirectories() {
        ArrayList<ApfsDirectory> subDirectories = new ArrayList<>();
        for (ApfsFSElement apfsFSElement : getChildren()) {
            if (apfsFSElement instanceof ApfsDirectory)
                subDirectories.add((ApfsDirectory) apfsFSElement);
        }
        return subDirectories;
    }

    public ArrayList<ApfsFile> getFiles() {
        ArrayList<ApfsFile> files = new ArrayList<>();
        for (ApfsFSElement apfsFSElement : getChildren()) {
            if (apfsFSElement instanceof ApfsFile)
                files.add((ApfsFile) apfsFSElement);
        }
        return files;
    }

    public ArrayList<ApfsLink> getLinks() {
        ArrayList<ApfsLink> links = new ArrayList<>();
        for (ApfsFSElement apfsFSElement : getChildren()) {
            if (apfsFSElement instanceof ApfsLink)
                links.add((ApfsLink) apfsFSElement);
        }
        return links;
    }

    public int getTotalSize() {
        int totalSize = 0;
        for (ApfsFSElement apfsFSElement : getChildren()) {
            if (apfsFSElement instanceof ApfsDirectory)
                totalSize += ((ApfsDirectory) apfsFSElement).getTotalSize();
            else
                totalSize += apfsFSElement.getSize();
        }
        return totalSize;
    }

    public boolean isDirectory() {
        return true;
    }

}
