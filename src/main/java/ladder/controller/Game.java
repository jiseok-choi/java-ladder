package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Game {

    public void play() {
        String inputPlayers = InputView.questionPlayers();
        Players players = Players.of(inputPlayers);

        String inputResult = InputView.questionResult();
        Answers answers = Answers.of(inputResult, players);

        String height = InputView.questionHeight();
        Height ladderHeight = Height.of(height);

        Ladder ladder = Ladder.of(ladderHeight, players);
        result(players, answers, ladder);
    }

    public void result(Players players, Answers answers, Ladder ladder) {
        ResultView.printPlayers(players);
        ResultView.printLadder(ladder);
        ResultView.printAnswer(answers);

        String findInput = InputView.questionFindResult();

        if (ResultView.isAllResult(findInput)) {
            ResultView.printResults(players, ladder, answers);
            return;
        }

        int idx = players.getPlayerIndex(new Player(findInput));
        ResultView.printResult(answers, ladder, idx);
    }
}
