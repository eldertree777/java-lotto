package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoOutlet {
    private static final int LOTTO_PRICE = 1000;
    private static final String LACK_MONEY_MESSAGE = "해당 금액으로는 1장도 구매하실 수 없습니다.";
    private static final NumbersGenerator numbersGenerator = new RandomNumbersGeneratorImpl();

    public static int lottoCount(int money) {
        int lottoCount = calculateLottoCount(money);
        validateLottoCount(lottoCount);
        return lottoCount;
    }

    private static int calculateLottoCount(int money) {
        return money / LOTTO_PRICE;
    }

    private static void validateLottoCount(int lottoCount) {
        if (lottoCount < 1) {
            throw new IllegalArgumentException(LACK_MONEY_MESSAGE);
        }
    }

    public static Lotto generateLotto() {
        return new Lotto(numbersGenerator.generate());
    }

    public static List<Lotto> generateLottos(int count) {
        return Stream.generate(LottoOutlet::generateLotto)
                .limit(count)
                .collect(Collectors.toList());
    }

    public static int getWinnings(List<MatchNumber> matchNumbers) {
        return matchNumbers.stream()
                .mapToInt(matchNumber -> Rank.getWinningsAmount(matchNumber))
                .sum();
    }

    public static int getWinning(MatchNumber matchNumber) {
        return Rank.getWinningsAmount(matchNumber);
    }

    public static int getRank(MatchNumber matchNumber) {
        return Rank.getRank(matchNumber);
    }
}
