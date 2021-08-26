public class Example {
    static int i = 10;
    static String s = "static";
    
    static void display()
    {
       System.out.println("i = "+ i);
       System.out.println("s = "+ s);
    }
    void func()
    {
        display();
    }
  
    
    public static void main(String args[])
    {
        Example obj = new Example();
  
        obj.func();
        display();
     }
}
