package blackjack.domain.user;

import blackjack.domain.card.Card;
import blackjack.domain.card.UserDeck;

public class User {

    private final UserDeck userDeck;
    int DRAWABLE_NUMBER;

    public User(UserDeck userDeck) {
        this.userDeck = userDeck;
    }

    public void draw(Card card) {
        userDeck.add(card);
    }

    public boolean isBustCondition() {
        return this.getScore() == UserDeck.BUST_CONDITION;
    }

    public boolean isAvailableDraw() {
        return !this.isBustCondition() && this.getScore() < DRAWABLE_NUMBER;
    }

    public UserDeck getUserDeck() {
        return userDeck;
    }

    public int getScore() {
        return userDeck.deckScore();
    }

    public int compare(User user) {
        return this.getScore() - user.getScore();
    }
}
