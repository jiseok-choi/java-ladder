package ladder;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Location;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LadderTest {

    @Test
    @DisplayName("사다리 생성")
    void createLadder() {
        int ladderSize = 5;
        int playerCount = 3;
        Ladder ladder = new Ladder(ladderSize, playerCount);
        List<Line> lines = ladder.getLines();
        Assertions.assertThat(lines.size()).isEqualTo(ladderSize);
    }

    @Test
    @DisplayName("사다리 타기")
    void climbLadder() {
        int ladderSize = 5;
        int playerCount = 3;
        Ladder ladder = new Ladder(ladderSize, playerCount);
        Location resultLocation = ladder.climb(new Location(2));
        assertTrue(resultLocation.equals(new Location(1)) ||
                resultLocation.equals(new Location(2)) ||
                resultLocation.equals(new Location(3))
        );
    }
}
