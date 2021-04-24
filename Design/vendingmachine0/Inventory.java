import java.util.*;
public class Inventory {
	protected String product;
	protected int price;
	protected int size;
	protected boolean isFilled;
   // Notice size defines the capacity of the inventory, not the actual product amount.
   public Inventory(String product, int price, int size) {
		 this.product = product;
		 this.price = price;
		 this.size = size;
	 }

   // fill will always fill the inventory to its capacity.
   public void fill() { // the item is available? or back in stock???
		 isFilled = true; // capacity???
	 }

   // return the product name.
   public String getProduct() {
		 if (!isFilled) {
			 return null;
		 } else {
			 isFilled = false;		 
			 return product;
		 }
   }

   // return the product price.
   public int getPrice() {
		 return price;
   }

   // return if the product can be vended with the given amount of money.
   public boolean canVend(int money) {
		 return (isFilled && money >= price);
   }

   // return if the product is actually vended.
   public boolean vend(int money) {     
		 if (canVend(money)) {
			 getProduct();
			 return true;
		 }
		 return false;
   }
}