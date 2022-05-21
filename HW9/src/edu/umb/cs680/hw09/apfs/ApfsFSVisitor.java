package edu.umb.cs680.hw09.apfs;

public interface ApfsFSVisitor {

    public void visit(ApfsDirectory dir);
    public void visit(ApfsFile file);
    public void visit(ApfsLink link);

}
