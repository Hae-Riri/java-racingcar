package step4;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class OutputView {

    private static final String PATH = "-";
    private static final String PRINT_COLON = " : ";
    private static final int START_POSITION = 0;

    private OutputView() {}

    public static void printResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printRacingCars(List<RacingCar> racingCars) {
        racingCars.forEach(OutputView::printRacingCar);
        System.out.println();
    }

    private static void printRacingCar(RacingCar racingCar) {
        String result = IntStream.range(START_POSITION, racingCar.currentPosition())
                        .mapToObj(position -> PATH)
                        .collect(Collectors.joining());
        System.out.println(racingCar.getName() + PRINT_COLON + result);
    }

    public static void printRacingGameWinner(String winners) {
        System.out.println(winners + " 가 최종 우승했습니다.");
    }
}