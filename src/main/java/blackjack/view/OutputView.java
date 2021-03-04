package blackjack.view;

import blackjack.domain.card.Card;
import blackjack.domain.user.Dealer;
import blackjack.domain.user.DealerResult;
import blackjack.domain.user.Player;
import blackjack.domain.user.Players;
import blackjack.domain.user.Result;
import blackjack.domain.user.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String NEWLINE = System.lineSeparator();
    private static final String STRING_DELIMITER = ", ";
    private static final String INITIAL_CARD_MESSAGE = "딜러와 %s에게 카드를 2장씩 나누었습니다.";
    private static final String DEALER_CARD = "딜러 카드: %s";
    private static final String PLAYER_CARD = "%s 카드: %s";
    private static final String DEALER_RESULT = "딜러: %s";
    private static final String PLAYER_RESULT = "%s: %s";
    private static final String SCORE_RESULT = " - 결과: ";
    private static final String DEALER_DRAW_MESSAGE = "딜러는 16이하라 한장의 카드를 더 받았습니다.";
    private static final String FINAL_RESULT = "## 최종 승패";
    private static final String BUST_MESSAGE = "BUST";


    private OutputView() {
    }

    public static void showInitiate(Dealer dealer, Players players) {
        showPlayerNames(players);
        showCards(dealer, players);
    }

    private static void showCards(Dealer dealer, Players players) {
        String dealerCard = dealer.getUserDeck().getUserCards().get(1).getCard();
        System.out.printf(DEALER_CARD + NEWLINE, dealerCard);
        for (Player player : players.getPlayers()) {
            showPlayerCard(player);
        }
    }

    private static void showPlayerNames(Players players) {
        List<String> playerNames = new ArrayList<>();
        for (Player player : players.getPlayers()) {
            playerNames.add(player.getName());
        }
        String nameCollect = String.join(STRING_DELIMITER, playerNames);
        System.out.printf(INITIAL_CARD_MESSAGE + NEWLINE, nameCollect);
    }

    public static void showPlayerCard(Player player) {
        String cards = combineAllCard(player);
        System.out.printf(PLAYER_CARD + NEWLINE, player.getName(), cards);
    }

    private static String combineAllCard(User user) {
        List<String> allCards = new ArrayList<>();
        for (Card card : user.getUserDeck().getUserCards()) {
            allCards.add(card.getCard());
        }
        return String.join(STRING_DELIMITER, allCards);
    }

    public static void showDealerDraw() {
        System.out.println(DEALER_DRAW_MESSAGE);
    }

    public static void showScoreResult(Dealer dealer, Players players) {
        System.out.println();
        showDealerEntireCard(dealer);
        showPlayersEntireCard(players);
    }

    private static void showPlayersEntireCard(Players players) {
        for (Player player : players.getPlayers()) {
            String dealerCards =
                String.format(PLAYER_RESULT, player.getName(), combineAllCard(player))
                    + SCORE_RESULT
                    + getConventionScore(player);
            System.out.println(dealerCards);
        }
    }

    private static void showDealerEntireCard(Dealer dealer) {
        String dealerCards =
            String.format(DEALER_RESULT, combineAllCard(dealer)) + SCORE_RESULT
                + getConventionScore(
                dealer);
        System.out.println(dealerCards);
    }

    private static String getConventionScore(User user) {
        int userScore = user.getScore();
        if (userScore == 0) {
            return BUST_MESSAGE;
        }
        return Integer.toString(userScore);
    }

    public static void showDealerTable(DealerResult dealerResult) {
        System.out.println(NEWLINE + FINAL_RESULT);
        String conventionResult = getDealerResult(dealerResult);
        String conventionResultMessage = String.format(DEALER_RESULT, conventionResult);
        System.out.println(conventionResultMessage);
    }

    private static String getDealerResult(DealerResult dealerResult) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> element : dealerResult.getDealerResult().entrySet()) {
            stringBuilder.append(validValue(element));
        }
        return stringBuilder.toString();
    }

    private static String validValue(Map.Entry<String, Integer> element) {
        if (element.getValue() > 0) {
            return element.getValue() + element.getKey();
        }
        return "";
    }

    public static void showPlayerTable(Dealer dealer, Players players) {
        for (Player player : players.getPlayers()) {
            String playerName = player.getName();
            String gameIndividualResult = Result.getResult(player, dealer);
            String individualResultMessage = String
                .format(PLAYER_RESULT, playerName, gameIndividualResult);
            System.out.println(individualResultMessage);
        }
    }
}
