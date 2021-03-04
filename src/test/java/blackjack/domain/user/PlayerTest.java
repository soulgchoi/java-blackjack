package blackjack.domain.user;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardNumber;
import blackjack.domain.card.CardSymbol;
import blackjack.domain.card.UserDeck;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    private final Card one = new Card(CardNumber.from("J"), CardSymbol.from("클로버"));
    private final Card two = new Card(CardNumber.from("5"), CardSymbol.from("하트"));
    private final UserDeck userDeck = new UserDeck();
    {
        userDeck.add(one);
        userDeck.add(two);
    }

    @Test
    @DisplayName("플레이어 점수 테스트")
    void getPlayerPoint() {
        String name = "Sorong";
        Player player = new Player(name, userDeck);
        int playerScore = 15;
        assertThat(player.getScore()).isEqualTo(playerScore);
    }

    @Test
    @DisplayName("플레이어 드로우 성공 테스트")
    void getAvailableDraw() {
        String name = "Sorong";
        Player player = new Player(name, userDeck);
        assertThat(player.isAvailableDraw()).isTrue();
    }

    @Test
    @DisplayName("플레이어 드로우 실패 테스트")
    void getUnavailableDraw() {
        String name = "Sorong";
        Card card3 = new Card(CardNumber.from("J"), CardSymbol.from("다이아몬드"));
        userDeck.add(card3);
        Player player = new Player(name, userDeck);
        assertThat(!player.isAvailableDraw()).isTrue();
    }
}
