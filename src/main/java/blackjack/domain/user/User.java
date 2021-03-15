package blackjack.domain.user;

import blackjack.domain.card.Card;
import blackjack.domain.card.UserDeck;
import blackjack.domain.state.State;
import blackjack.domain.state.StateFactory;
import java.util.List;

public abstract class User {

    private final UserDeck userDeck;
    private final State state;

    public User(UserDeck userDeck) {
        this.userDeck = userDeck;
        this.state = StateFactory.draw(userDeck);
    }

    public void draw(Card card) {
        userDeck.draw(card);
    }

    public int score() {
        return userDeck.score();
    }

    public boolean isFinished() {
        return state.isFinished();
    }

    public List<Card> cards() {
        return userDeck.getUserCards();
    }

    public int compare(User user) {
        return this.score() - user.score();
    }
}
