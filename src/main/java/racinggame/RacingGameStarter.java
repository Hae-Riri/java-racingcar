package racinggame;

import racinggame.domain.RacingGame;
import racinggame.dto.GameResultDto;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class RacingGameStarter {
	public static void main(String[] args) {
		InputView inputView = new InputView();
		ResultView resultView = new ResultView();

		String carNames = inputView.printAndGetCarName();
		int moveCount = inputView.printAndGetMoveCount();

		RacingGame racingGame = new RacingGame();
		GameResultDto gameResult = racingGame.start(carNames, moveCount);

		resultView.printGameResult(gameResult);
		resultView.printWinnerNames(gameResult);
	}
}