public abstract class Entry {
  protected Directory parent;
  protected long created;
  protected long lastUpdated;
  protected long lastAccessed;
  protected String name;
  
  public Entry(String name, Directory parent) {
      this.name = name;
      this.parent = parent;
      //created = System.currentTimeMillis();
  }

  public boolean delete() {
      if (parent == null) {
          return false;
      }
      return parent.deleteEntry(this);
  }

  public abstract int size();

  public String getFullPath() {
      if (parent == null) {
          return name;
      } else {
          return parent.getFullPath() + "/" + name;
      }
  }

  public void changeName(String n) {
      this.name = n;
  }

  public String getName() {
      return name;
  }
  
  public long getLastUpdatedTime() {
      return lastUpdated;
  }
}