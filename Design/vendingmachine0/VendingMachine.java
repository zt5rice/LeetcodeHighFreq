import java.util.*;
class VendingMachine {
	private int money;
	protected List<Inventory> inventories  = new ArrayList<>(); //!!!

  public VendingMachine(List<Inventory> inventories) {
		this.inventories = inventories;
		this.money = 0; // initialization
  }

  public int takeQuarter() {
		money += 25;
		return money; //!!!
	}

  // return all the product names in the machine, even it has been sold out.
  public List<String> listInventory() {
		List<String> productNames = new ArrayList<>();
		for (Inventory invent : inventories) {
			productNames.add(invent.product);
		}
		return productNames;
  }

  // return all the buyable product names based on the money and inventory status.
  public List<String> listCanBuy() {
		List<String> productNamesCanBuy = new ArrayList<>();
		for (Inventory invent : inventories) {
			if (invent.canVend(money)) {
				productNamesCanBuy.add(invent.product);				
			}
		}
		return productNamesCanBuy;
  }

  // return the change, note there is no guarantee that the product has not been sold out.
  public int vend(String product) {
		for (Inventory invent : inventories) {
			if (invent.product.equals(product) && invent.canVend(money)) {
				invent.vend(money);
				money -= invent.getPrice();
				break;			
			}
		}
		return refund();
  }

  // return the money fed by the current customer.
  public int refund() {
		int refund = money;
		money = 0;
		return refund;
  }
  }