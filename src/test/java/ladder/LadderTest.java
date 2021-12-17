package ladder;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.view.ResultView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LadderTest {

    @Test
    @DisplayName("사다리 생성")
    void createLadder() {
        int ladderSize = 5;
        int playerCount = 3;
        Ladder ladder = new Ladder(ladderSize, playerCount);
        List<Line> lines = ladder.getLines();
        Assertions.assertThat(lines.size()).isEqualTo(ladderSize);
        ResultView.printLadder(ladder);
    }
}
