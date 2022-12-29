package com.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarTest {

    // 차 이름이 5글자 이하인지에 대한 테스트
    @Test
    void checkNameTest(){
        Car car = new Car("carName");
        // RuntimeException 발생 시 종료
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> car.checkName());
    }


    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    @DisplayName("자동차는 3 이하의 값이면 이동하지 못한다.")
    void notMoveTest(int rand){
        Car car1 = new Car("car1");
        car1.move(rand);
        assertThat(car1.getLocation()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    @DisplayName("자동차는 4 이상의 값이면 이동한다.")
    void moveTest(int rand){
        Car car1 = new Car("car1");
        car1.move(rand);
        assertThat(car1.getLocation()).isEqualTo(1);
    }

    // 차의 현재 location 출력 테스트
    @Test
    void printLocationTest(){
        Car car1 = new Car("car1");
        // 한 칸 이동
        car1.move(9);
        assertThat(car1.toStringLocation()).isEqualTo("car1 : -");
    }
}
