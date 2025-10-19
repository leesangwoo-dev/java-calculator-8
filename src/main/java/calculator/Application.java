package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // [입력] 사용자에게 입력 메시지를 출력
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        // [입력] Console.readLine()을 사용하여 입력 받기
        String input = Console.readLine();

        int result = add(input);

    }

    private static int add(String text) {
        // [처리] 입력 문자열이 공백("")인 경우 0을 반환한다.
        if (text == null || text.isEmpty()) {
            return 0;
        }

        // [커스텀 분리] 커스텀 구분자 패턴 (//(.)\n(.*)) 확인
        Matcher m = Pattern.compile("//(.)\\\\n(.*)").matcher(text);

        String[] numbers;
        if (m.find()) {
            // 커스텀 구분자 패턴이 있는 경우
            String customDelimiter = m.group(1); // 캡처 그룹 1: 커스텀 구분자 (예: ;)
            String numberString = m.group(2);    // 캡처 그룹 2: 실제 숫자 문자열 (예: 1;2;3)

            // 커스텀 구분자를 사용해 분리 (정규식에서는 문자 그대로의 구분자 사용)
            numbers = numberString.split(customDelimiter);
        } else {
            // [분리] 커스텀 구분자 패턴이 없는 경우, 쉼표(,) 또는 콜론(:)을 사용하여 문자열을 분리
            numbers = text.split(",|:");
        }

        for (String number : numbers) {
            System.out.println(number);
        }

        return 0;
    }
}
