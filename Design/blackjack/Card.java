public class Card {
  protected int faceValue;
  protected Suit suit;
  private boolean available = true;

  public Card(int c, Suit s) {
    faceValue = c;
    suit = s;
  }
  public int value() {
    return faceValue;
  }
  public Suit suit() {
    return suit;
  }
  public boolean isAce() {
    return faceValue == 1;
  }
  public int[] aceMinMaxValue() {
    return new int[]{1, 11};
  }
  public boolean isFaceCard() {
    return faceValue >= 11 && faceValue <= 13;
  }
  public int faceCardValue() {
    return 10;
  }
  public boolean isValueTen() {
    return isFaceCard() || faceValue == 10;
  }
  public boolean isAvailable() {
    return available;
  }
  public void markUnavailable() {
    available = false;
  }
  public void markAvailable() {
    available = true;
  }
  public void print() {
		String[] faceValues = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		//System.out.print(faceValues[faceValue - 1]);
		switch (suit) {
		case Club:
			//System.out.print("c");
			break;
		case Heart:
			//System.out.print("h");
			break;
		case Diamond:
			//System.out.print("d");
			break;
		case Spade:
			//System.out.print("s");
			break;			
		}
		//System.out.print(" ");
	}
}