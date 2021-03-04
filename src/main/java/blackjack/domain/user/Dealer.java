package blackjack.domain.user;

import blackjack.domain.card.UserDeck;

public class Dealer extends User {

    private final int DEALER_CRITERIA = 16;

    public Dealer(UserDeck userDeck) {
        super(userDeck);
    }

    @Override
    public boolean isAvailableDraw() {
        return !super.isBustCondition() && super.getPoint() <= DEALER_CRITERIA;
    }
}
