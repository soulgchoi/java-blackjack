package blackjack.controller;

import blackjack.domain.card.CardDeck;
import blackjack.domain.user.Dealer;
import blackjack.domain.user.DealerResult;
import blackjack.domain.user.Player;
import blackjack.domain.user.Players;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class BlackJackController {

    public void run() {
        CardDeck cardDeck = new CardDeck();
        Dealer dealer = new Dealer(cardDeck.generateUserDeck());
        Players players = new Players(cardDeck, InputView.requestPlayers());
        OutputView.showInitiate(dealer, players);

        processPlayers(cardDeck, players);
        processDealer(cardDeck, dealer);

        endBlackJack(dealer, players);
    }

    private void processPlayers(CardDeck cardDeck, Players players) {
        for (Player player : players.getPlayers()) {
            playerDraw(cardDeck, player);
        }
    }

    private void playerDraw(CardDeck cardDeck, Player player) {
        while (player.isAvailableDraw() && isYes(player)) {
            player.draw(cardDeck.draw());
            OutputView.showPlayerCard(player);
        }
    }

    private boolean isYes(Player player) {
        return InputView.requestMoreDraw(player.getName());
    }

    private void processDealer(CardDeck cardDeck, Dealer dealer) {
        while (dealer.isAvailableDraw()) {
            dealer.draw(cardDeck.draw());
            OutputView.showDealerDraw();
        }
    }

    private void endBlackJack(Dealer dealer, Players players) {
        OutputView.showScoreResult(dealer, players);
        DealerResult dealerResult = new DealerResult(dealer, players.getPlayers());
        OutputView.showDealerTable(dealerResult);
        OutputView.showPlayerTable(dealer, players);
    }
}
