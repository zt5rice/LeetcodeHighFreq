import java.util.*;

public class FileSystem {
  private final Directory root;

  public FileSystem() {
    root = new Directory("/", null);
  }
  
  private List<Entry> resolve(String path) {
    assert path.startsWith("/");
    String[] components = path.substring(1).split("/");
    List<Entry> entries = new ArrayList<Entry>(components.length + 1);
    entries.add(root);
  
    Entry entry = root;
    for (String component : components) {
        if (entry == null || !(entry instanceof Directory)) {
            //throw new IllegalArgumentException("invalid path:" + path);
            return new ArrayList<>();
        }
        if (!component.isEmpty()) {
            entry = ((Directory)entry).getChild(component);
            entries.add(entry);
        }
    }
    return entries;
}

  public void mkdir(String path) {
    List<Entry> entries = resolve(path);
    //因为最后一个是null
    if (entries.get(entries.size() - 1) != null) {
        //throw new IllegalArguementException("Directory already exist: " + path);
        return;
    }
    String[] components = path.split("/");
    final String dirName = components[components.length - 1];
    final Directory parent = (Directory)entries.get(entries.size() - 2);
    Directory newDir = new Directory(dirName, parent);
    parent.addEntry(newDir);
  }
  
  public void createFile(String path) {
    assert !path.endsWith("/");
    List<Entry> entries = resolve(path);
    if (entries.get(entries.size() - 1) != null) {
        //throw new IllegalArguementException("File already exists: " + path);
        return;
    }
    final String fileName = path.substring(path.lastIndexOf("/") + 1);
    final Directory parent = (Directory)entries.get(entries.size() - 2);
    File file = new File(fileName, parent, 0);
    parent.addEntry(file);
  }
  
  public void delete(String path) {
    List<Entry> entries = resolve(path);
    if (entries.get(entries.size() - 1) == null) {
        return;
    }
    Entry entry = (Directory)entries.get(entries.size() - 1);
    entry.delete();
  }
  
  public List<Entry> list(String path) { 
    List<Entry> entries = resolve(path);
    entries.remove(entries.size() - 1);
    return entries;
  }
  
  public int count() {
    return root.numberOfFiles();
  }
}
/*abstract
    foo     bar
    |   \
    bar  foo
    |
    bar

*/