import java.util.*;
class VendingMachine {
	protected List<Inventory> inventories = new ArrayList<>();
	protected int moneyBalance;

	public VendingMachine(List<Inventory> inventories) {
		this.inventories = inventories;
		this.moneyBalance = 0;
	}

	public int takeQuarter() {
		moneyBalance += 25;
		return moneyBalance;
	}

	public List<String> listInventory() {
		List<String> list = new ArrayList<>();
		for (Inventory item : inventories) {
			// if (item.isFilled) {
			list.add(item.product);
			// }
		}
		return list;
	}

	public List<String> listCanBuy() {
		List<String> list = new ArrayList<>();
		for (Inventory item : inventories) {
			if (item.canVend(moneyBalance)) {
				list.add(item.product);
			}
		}
		return list;
	}

	/*
	 * return the change
	 */
	public int vend(String product) {
		List<String> listCanBuy = listCanBuy();
		boolean vendSuccess = false;
		if (listCanBuy.contains(product)) {
			for (Inventory item : inventories) {
				if (item.product == product) {
					// System.out.println("found vend product: " + product);
					vendSuccess = item.vend(moneyBalance);
					moneyBalance -= item.getPrice();
					break;
				}
			}
		}
		// System.out.println("vend Success? " + vendSuccess + " product: " + product);
		return refund();
	}

	public int refund() {
    int refund = moneyBalance;
    moneyBalance = 0;
		return refund;
	}
}