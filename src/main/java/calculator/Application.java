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

        // [출력] 계산 결과를 "결과 : {합계}" 형식으로 출력
        System.out.println("결과 : " + result);

        // Console.close()를 닫히도록 처리
        Console.close();
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

        // [덧셈] 및 [예외 처리]를 통합한 sum 메소드 호출
        return sum(numbers);
    }

    private static int sum(String[] numbers) {
        int total = 0;
        for (String s : numbers) {
            // 빈 문자열이 남아있을 경우 무시
            if (s.isEmpty()) {
                continue;
            }

            // 숫자로 변환하고 양수인지 검증
            int number = toPositiveNumber(s);
            total += number;
        }
        return total;
    }

    private static int toPositiveNumber(String s) {
        int number;
        try{
            // 공백을 제거하고 숫자로 변환 시도
            number = Integer.parseInt(s.trim());
        } catch (NumberFormatException e) { // NumberFormatException 처리 블록 추가
            // 숫자가 아닌 값이 입력된 경우
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다: " + s);
        }

        // 음수 검증
        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + number);
        }
        return number;
    }
}
