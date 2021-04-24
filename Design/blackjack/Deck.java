import java.util.*;

public class Deck {
  // all cards, dealt or not
  private List<Card> cards = new ArrayList<>();
  // dealtIndex means the next card to deal
  // also means the number of cards have been dealt.
  private int dealtIndex = 0;
  public Deck() {
    for (int i = 1; i <= 13; i++) {
      for (Suit suit : Suit.values()) {
        cards.add(new Card(i, suit));
      }
    }
    this.setDeckOfCards(cards);
    this.shuffle();
  }
  public void setDeckOfCards(List<Card> deckOfCards) {
    cards = deckOfCards;
  }
  // shuffle cards
  // shuffle from right to left is easier
  public void shuffle() {
    for (int i = cards.size(); i >= 1; i--) {
      // random range [0, i - 1]
      int randomIndex = (int) (Math.random() * i);
      swap(cards, i - 1, randomIndex);
    }
  }
  private void swap(List<Card> cards, int left, int right) {
    Card temp = cards.get(left);
    cards.set(left, cards.get(right));
    cards.set(right, temp);
  }

  public int remainingCards() {
      return cards.size() - dealtIndex;      
  }
  // dealer that take orders from player.
  public List<Card> dealHand(int number) {
    if (remainingCards() < number) {
      return null;
    }
    List<Card> list = new ArrayList<>();
    int i = 0;
    while (i < number) {
      Card card = dealCard();
      if (card != null) {
        list.add(card);
        i++;
      }
    }
    return list;
  }  
  // the action that: take one card from card deck
  public Card dealCard() {
    if (remainingCards() == 0) {
      return null;
    }
    Card card = cards.get(dealtIndex);
    card.markUnavailable();
    dealtIndex++;
    return card;
  }
  public void print() {
    for (Card card : cards) {
      card.print();
    }
  }
}
/*
java.lang.NullPointerException
Deck.remainingCards():28
Deck.dealHand():32
TestSolution.testDeck():16
NativeMethodAccessorImpl.invoke0():-2
NativeMethodAccessorImpl.invoke():62
*/