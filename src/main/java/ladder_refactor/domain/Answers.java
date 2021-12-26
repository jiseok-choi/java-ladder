package ladder_refactor.domain;



import ladder_refactor.exception.LadderInputException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Answers {

    private static final String ERR_RESULT_SIZE = "결과 개수를 확인해주세요.";
    private static final String ERR_RESULT = "결과가 존재하지 않습니다.";
    private static final String SPACE = " ";
    private static final String EMPTY = "";
    private static final String DELIMITER = ",";
    private final List<String> results;

    private Answers(List<String> results) {
        this.results = results;
    }

    public static Answers of(String text, Players players) {
        List<String> results = Arrays.asList(text.replaceAll(SPACE, EMPTY).split(DELIMITER));
        valid(results, players);
        return new Answers(results);
    }

    private static void valid(List<String> results, Players players) {
        if (results.size() != players.count()) {
            throw new LadderInputException(ERR_RESULT_SIZE);
        }
    }

    public List<String> getResults() {
        return Collections.unmodifiableList(results);
    }

    public String getResult(int location) {
        try {
            return this.results.get(location);
        } catch (RuntimeException e) {
            throw new LadderInputException(ERR_RESULT);
        }
    }
}