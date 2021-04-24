import java.util.*;
public class Inventory {
	protected String product;
	protected int price;
	protected int size;
	protected boolean isFilled;

	public Inventory(String product, int price, int size) {
		this.product = product;
		this.price = price;
		this.size = size;
	}

	public void fill() {
		isFilled = true;
	}

	public String getProduct() {
		if (!isFilled) {
			return null;
		} else {
      		isFilled = false;
			return product;
		}
	}

	public int getPrice() {
		return price;
	}

	public boolean canVend(int money) {
		return (money >= price && isFilled);
	}

	public boolean vend(int money) {
		if (canVend(money)) {
			getProduct();
			return true;
		}
		return false;
	}
}