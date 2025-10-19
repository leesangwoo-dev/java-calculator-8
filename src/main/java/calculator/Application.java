package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // [입력] 사용자에게 입력 메시지를 출력
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        // [입력] Console.readLine()을 사용하여 입력 받기
        String input = Console.readLine();
        System.out.println(input);
    }
}
