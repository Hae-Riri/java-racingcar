package com.racingcar.car;

import com.racingcar.dice.Dice;
import com.racingcar.game.car.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {
    private Car car;

    @BeforeEach
    void init() {
        car = new Car("test");
    }

    @DisplayName("자동차 이동 테스트")
    @ParameterizedTest
    @CsvSource({"0,1", "1,1", "2,1", "3,1", "4,2", "5,2", "6,2", "7,2", "8,2", "9,2"})
    void move(int input, int expected) {
        //when
        car.move(input);

        //then
        assertThat(car.getDistance()).isEqualTo(expected);
    }

    @Test
    @DisplayName("5글자 이상 자동차 이름 붙힐 시 테스트")
    public void exceedNameLength() {
        //given
        String name = "12345";

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Car(name);
        });
    }

    @DisplayName("자동차 다회차 이동")
    @ParameterizedTest
    @ValueSource(ints = {10, 17, 8})
    void multipleMove(int count) {
        //given
        List<Integer> diceInputs = new ArrayList<>();

        for(int i = 0; i < count; i++) {
            diceInputs.add(Dice.getNumber());
        }

        //when
        for(Integer input : diceInputs) {
            car.move(input);
        }

        //then
        int expected = (int)diceInputs.stream()
                .filter((value) -> value >= 4)
                .count();

        assertThat(car.getDistance()).isEqualTo(expected + 1);
    }
}
