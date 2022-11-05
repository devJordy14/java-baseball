package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> opponent = generateOpponent();
        List<Integer> player = receiveInputOfPlayer();

    }

    public static List<Integer> generateOpponent(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> receiveInputOfPlayer(){
        System.out.print("숫자를 입력해주세요 : ");
        String inputString = Console.readLine();
        List<Integer> integerList = changeStringToIntegerList(inputString);
        checkDuplicationFromIntegerList(integerList);
        return integerList;
    }

    public static Boolean checkDuplicationFromIntegerList(List<Integer> checkList){
        List<Integer> newList = new ArrayList<>();
        for (Integer number : checkList) {
            if (!newList.contains(number)) {
                newList.add(number);
            }
        }
        if(newList != checkList){
            throw new IllegalArgumentException("중복된 숫자가 입력되었습니다.\n프로그램을 종료합니다.");
        }
        return true;
    }

    public static List<Integer> changeStringToIntegerList(String numberString){
        try {
            List<Integer> integerList = Arrays.stream(numberString.split("")).map(Integer::parseInt).collect(Collectors.toList());
            return integerList;
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.\n프로그램을 종료합니다.");
        }
    }
}

