import java.util.*;

public class BlackJackHand {
  protected ArrayList<Card> cards = new ArrayList<>();
  public int score() {
    int[] scores = possibleScores();
    if (scores[1] > 21) {
      return scores[0];
    } else {
      return scores[1];
    }
  }
  // possible scores returns int[0]: min, int[1]: max
  // min: scores[0], max: scores[1]
  private int[] possibleScores() {
    int[] scores = new int[2];
    if (cards.size() == 0) {
      return scores;
    }
    for (Card card : cards) {
      if (!card.isAce() && !card.isFaceCard()) {
        // card is 2-10
        scores[0] += card.value();
        scores[1] += card.value();
      } else if (card.isFaceCard()) {
        // card is faceCard
        scores[0] += card.faceCardValue();
        scores[1] += card.faceCardValue();
      } else {
        // card is ace
        scores[0] += card.aceMinMaxValue()[0];
        scores[1] += card.aceMinMaxValue()[1];
      }
    }
    return scores;
  }
  // add Card[] c into cards
  public void addCards(Card[] c) {
    for (Card card : c) {
      cards.add(card);
    }
  }

  public boolean busted() {
    return score() > 21;
  }
  public boolean isBlackJack() {
    if (cards.size() != 2) {
      return false;
    }
    Card first = cards.get(0);
    Card second = cards.get(1);
    return ((first.isAce() && second.isValueTen()) || 
            (second.isAce() && first.isValueTen()));
  }
	public void print() {
		for (Card card : cards) {
			card.print();
		}
	}
}