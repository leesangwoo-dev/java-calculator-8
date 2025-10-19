package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // [입력] 사용자에게 입력 메시지를 출력
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        // [입력] Console.readLine()을 사용하여 입력 받기
        String input = Console.readLine();

        int temp = 10;
        // [처리] 입력 문자열이 공백("")인 경우 0을 반환한다.
        if (input == null || input.isEmpty()) {
            temp =  0;
        }
        System.out.println(temp);
    }
}
