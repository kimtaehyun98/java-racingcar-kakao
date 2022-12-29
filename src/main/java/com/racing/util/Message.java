package com.racing.util;

public enum Message {
    START_GAME("숫자 야구 게임을 시작합니다."),
    USER_INPUT("숫자를 입력해주세요 : "),
    CORRECT_ANSWER("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART_GAME("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    END_GAME("숫자 야구 게임을 종료합니다."),

    ERROR_INPUT_SIZE("입력받은 숫자가 세자리가 아닙니다."),
    ERROR_INPUT_ARRANGE("입력받은 숫자들 중 1 ~ 9가 아닌 수가 존재합니다."),
    ERROR_INPUT_DUPLICATE("입력받은 숫자 중 중복되는 수가 있습니다."),
    ERROR_INPUT_RESTART("재시작 카운트는 1 또는 2로 입력해야합니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}