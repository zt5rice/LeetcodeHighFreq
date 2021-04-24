public class TestFSSolution {
    public static void main(String[] args) {
        TestFSSolution sol = new TestFSSolution();
        try {
            sol.testFileSystem();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void testFileSystem() throws Exception {
        FileSystem fs = new FileSystem();
        fs.mkdir("/foo");
        fs.mkdir("/foo/bar");
        fs.createFile("/bar");
        fs.createFile("/foo/foo");
        fs.createFile("/foo/bar/bar");
        check(fs.count() == 5);
        System.out.println(fs.list("/").size());
        //check(fs.list("/").size() == 2); // not working
         fs.delete("/foo/bar");
         check(fs.count() == 3);
         System.out.println(fs.list("/").size());
         check(fs.list("/").size() == 2); // not working
    }
    public void check(boolean pass) {
        if (!pass) throw new RuntimeException("Test failed");
    }
}
//https://github.com/Mol1122/leetcode/blob/4a91eab814a1238149fae16807d1b0ef5cfb542d/%E9%A2%98%E5%9E%8B%E6%80%BB%E7%BB%93/OOD/In-Memory%20File%20System.java