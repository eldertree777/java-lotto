package lotto.view;

import lotto.model.ResultLotto;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public static void viewLottos(ResultLotto resultLotto) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%d개를 구매했습니다.", resultLotto.totallottoCount())).append(LINE_SEPARATOR);
        List<List<Integer>> lottosNumbers = resultLotto.getLottosNumbers();

        for (List<Integer> lottosNumber : lottosNumbers) {
            stringBuilder.append(Arrays.toString(lottosNumber.toArray())).append(LINE_SEPARATOR);
        }

        stringBuilder.append(LINE_SEPARATOR);
        System.out.println(stringBuilder);
    }

    public static void viewResult(ResultLotto resultLotto) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("당첨 통계").append(LINE_SEPARATOR);
        stringBuilder.append("---------").append(LINE_SEPARATOR);
        stringBuilder.append(String.format("3개 일치 (5000원)- %d개", resultLotto.findMatchCount(3))).append(LINE_SEPARATOR);
        stringBuilder.append(String.format("4개 일치 (50000원)- %d개", resultLotto.findMatchCount(4))).append(LINE_SEPARATOR);
        stringBuilder.append(String.format("5개 일치 (1500000원)- %d개", resultLotto.findMatchCount(5))).append(LINE_SEPARATOR);
        stringBuilder.append(String.format("6개 일치 (2000000000원)- %d개", resultLotto.findMatchCount(6))).append(LINE_SEPARATOR);
        stringBuilder.append(String.format("총 수익률은 %.3f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", resultLotto.getWinningRate())).append(LINE_SEPARATOR);
        System.out.println(stringBuilder);
    }
}
