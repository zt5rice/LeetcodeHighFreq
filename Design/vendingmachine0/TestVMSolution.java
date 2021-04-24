import java.util.*;
public class TestVMSolution {
    public static void main(String[] args) {
        try {
            TestVMSolution sol = new TestVMSolution();
            sol.test();            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public void test() throws Exception {
        List<Inventory> ls = new ArrayList<>();
        List<String> msg = new ArrayList<>();
        Inventory water = new Inventory("water", 175, 1);
        water.fill();
        ls.add(water);
        Inventory coke = new Inventory("coke", 225, 1);
        coke.fill();
        ls.add(coke);
        VendingMachine vm = new VendingMachine(ls);

        check(vm.listInventory().size() == 2);
        check(vm.listCanBuy().size() == 0);
        for (int i = 1; i < 8; i++) {
            check(vm.takeQuarter() == i * 25);
        }
        check(vm.listCanBuy().size() == 1);
        check(vm.vend("water") == 0);
        for (int i = 1; i < 8; i++) {
            check(vm.takeQuarter() == i * 25);
        }
        check(vm.listInventory().size() == 2);
        check(vm.listCanBuy().size() == 0);
        check(vm.vend("water") == 175);
        for (int i = 1; i < 15; i++) {
            check(vm.takeQuarter() == i * 25);
        }
        check(vm.refund() == 350);
    }

    public void check(boolean pass) {
        if (!pass)
            throw new RuntimeException("Test failed");
    }
}