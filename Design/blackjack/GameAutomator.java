import java.util.*;

public class GameAutomator {
  private Deck deck = new Deck();
  private BlackJackHand[] hands;
  private static final int HIT_UNTIL = 16;
  // generate num of Players
  public GameAutomator(int numPlayers) {
    hands = new BlackJackHand[numPlayers];
    for (int i = 0; i < numPlayers; i++) {
      hands[i] = new BlackJackHand();
    }
  }
  // return winners with max score
  public List<Integer> getWinners() {
    List<Integer> winners = new ArrayList<>();
    int winningScore = 0;
    for (int i = 0; i < hands.length; i++) {
      BlackJackHand hand = hands[i];
      // not busted, score <= 21
      if (!hand.busted()) {
        if (hand.score() > winningScore || (hand.isBlackJack() && !hands[winners.get(0)].isBlackJack())) {
          // update winningScore, isBlackJack() can update score 21.
          winningScore = hand.score();
          winners.clear();
          winners.add(i);
        } else if (hand.score() == winningScore || (hand.isBlackJack() && hands[winners.get(0)].isBlackJack())) {
          // equal score, or multiple isBlackJack()
          winners.add(i);
        }
      }
    }
    return winners;
  }

  public int getScore(int playerID) {
    return hands[playerID].score();
  }

  // return false if the game cannot be successfully simulated. 
  public boolean simulate() {
    //dealHand  
    return playAllHands();
  }
  public boolean playAllHands() {
    for (BlackJackHand hand : hands) {
      if (!playHand(hand)) {
        return false;
      }
    }
    return true;
  }

  public boolean playHand(BlackJackHand hand) {
    //List<Card> list = new ArrayList<>();
    List<Card> list = hand.cards;
    while (hand.score() < HIT_UNTIL) {
      // get one more card
      if (deck == null) {
         return false;
        //return true;
      } else {
        Card card = deck.dealCard();
        if (card == null) {
          return false;
        }
        list.add(card);        
      }
    }
    Card[] cards = new Card[list.size()];
    ListIterator<Card> iterator = list.listIterator();
    int i = 0;
    while (iterator.hasNext()) {
      cards[i++] = iterator.next();
    }
    hand.addCards(cards);
    return true;
  }

  public void initializeDeck() {
    List<Card> cards = new ArrayList<>();
    // generate 52 cards, 13 in each suit
    for (int i = 1; i <= 13; i++) {
      // loop each suit
      for (int j = 0; i <= 3; j++) {
        Suit suit = Suit.getSuitFromValue(j);
        Card card = new Card(i, suit);
        cards.add(card);
      }
    }
    deck = new Deck();
    // add all cards
    deck.setDeckOfCards(cards);
    // shuffle
    deck.shuffle();
  }
  public void printHandsAndScore() {
    for (int i = 0; i < hands.length; i++) {
      // player index, player score
      //System.out.print("Hand" + i + "(" + hands[i].score() + "):");
      // player cards detail
      hands[i].print();
      //System.out.println("");
    }
  }
}
/*
java.lang.NullPointerException
GameAutomator.playHand():55
GameAutomator.playAllHands():45
GameAutomator.simulate():41
TestSolution.testAutomator():40
NativeMethodAccessorImpl.invoke0():-2
*/