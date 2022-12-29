package com.racing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class GameTest {

    @Test
    void initTest(){
        Game game = new Game();
        game.init("car1,car2,car3");
        // init에서 3개의 자동차를 선언했으므로 길이가 3이여야 함
        assertThat(game.cars).hasSize(3);
        // 각 자동차는 이동거리가 0인 자동차이고 각각의 이름은 car1, car2, car3 이므로 아래와 같은 출력값을 가져야 한다.
        assertThat(game.cars.get(0).printLocation()).isEqualTo("car1 : ");
        assertThat(game.cars.get(1).printLocation()).isEqualTo("car2 : ");
        assertThat(game.cars.get(2).printLocation()).isEqualTo("car3 : ");
    }

    @Test
    void runTest(){
        Game game = new Game();
        game.init("car1,car2,car3");
        game.run(5);
        // runCount는 run 메서드가 호출될때 사용된 n 횟수를 다 더한 값이다.
        assertThat(game.runCount).isEqualTo(5);
    }

    @Test
    void maxLocationTest(){
        Game game = new Game();
        game.init("car1,car2");
        game.run(5);

        // 자동차 location의 max 값 직접 구함
        int findMax = Math.max(game.cars.get(0).location, game.cars.get(1).location);
        assertThat(findMax).isEqualTo(game.maxLocation());
    }

    @Test
    void getWinnerTest(){
        Game game = new Game();
        game.init("car1,car2");
        game.run(5);

        ArrayList<Car> winners = game.getWinner();

        ArrayList<Car> cmpWinners = makeCmpWinners(game);

        assertThat(winners).isEqualTo(cmpWinners);
    }

    public ArrayList<Car> makeCmpWinners(Game game){
        ArrayList<Car> cmpWinners = new ArrayList<>();
        int maxLocation = game.maxLocation();
        if(game.cars.get(0).location == maxLocation){
            cmpWinners.add(game.cars.get(0));
        }
        if(game.cars.get(1).location == maxLocation){
            cmpWinners.add(game.cars.get(1));
        }
        return cmpWinners;
    }
}
