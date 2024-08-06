package org.example.testassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SpringBootApplication
public class TestAssignmentApplication {

  private static final List<Integer> numbers1 = Arrays.asList(1, 2, 3);
  private static final List<Integer> numbers2 = Arrays.asList(3, 4);

  private static final String[] STRING_ARR = {"aaa", "bb", "c", "dddd"};

  public static void main(String[] args) {
    SpringApplication.run(TestAssignmentApplication.class, args);

    // 3.1 모든 숫자 쌍의 배열 리스트를 반환하여라.
    // ex) numbers1 = [1,2,3], numbers2 = [3,4] -> [(1,3), (1,4), (2,3), (2,4), (3,3), (3,4)]

    // 3.2 모든 숫자 쌍의 곱이 가장 큰 값을 반환하여라.
    // ex) numbers1 = [1,2,3], numbers2 = [3,4] -> 12

    int number = numbers1.stream()
        .flatMap(x -> numbers2.stream().map(y -> x * y))
        .mapToInt(a -> a)
        .max().orElse(0);

    System.out.println(number);

    // 5.1 모든 문자열의 길이를 더한 결과를 출력하여라.
    int result = Arrays.stream(STRING_ARR)
        .mapToInt(String::length)
        .reduce(Integer::sum)
        .orElse(0);

    System.out.println(result);

    // 5.2 문자열 중에서 가장 긴 것의 길이를 출력하시오.
    int result2 = Arrays.stream(STRING_ARR)
        .mapToInt(String::length)
        .max().orElse(0);

    System.out.println(result2);

    // 5.3 임의의 로또번호(1~45)를 정렬해서 출력하시오.
    List<Integer> lotteryNum = Stream.generate(() -> new Random().nextInt(45) + 1)
        .distinct()
        .limit(6)
        .sorted()
        .toList();

    System.out.println(lotteryNum);

    // 5.4 두 개의 주사위를 굴려서 나온 눈의 합이 6인 경우를 모두 출력하시오.
    Stream<Integer> randomDice = IntStream.rangeClosed(1, 6).boxed();
    randomDice.flatMap(i -> Stream.of(1, 2, 3, 4, 5, 6).map(i2 -> new int[]{i, i2}))
        .filter(iArr -> iArr[0] + iArr[1] == 6)
        .forEach(iArr -> System.out.println(Arrays.toString(iArr)));
  }

}