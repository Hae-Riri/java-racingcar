import calculator.Calculator;
import calculator.Validator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import racing.Car;
import racing.CarGenerator;
import racing.Racing;

public class Application {

    public static void main(String[] args) throws IOException {
//        calculateString();
        carRacing();
    }

    private static void carRacing() throws IOException {
        //입력 받아서 차 생성
        CarGenerator carGenerator = new CarGenerator();
        List<Car> cars = carGenerator.createCars();

        //레이스 실행
        Racing racing = new Racing(cars);
        racing.race();
    }

    public static void calculateString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Validator validator = new Validator();
        String[] input = validator.stringCheck(br.readLine());

        Calculator calculator = new Calculator();
        System.out.println(calculator.execute(input));
    }
}
