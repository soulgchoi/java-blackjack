package blackjack.domain.state;

import blackjack.domain.card.UserDeck;
import blackjack.domain.user.User;

public class Hit extends Running {

    public State draw(User user) {
        if (user.score() > UserDeck.BLACK_JACK_NUMBER) {
            return new Bust();
        }
        return new Hit();
    }

    public State stay() {
        return new Stay();
    }
}
