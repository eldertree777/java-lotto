package lotto.model;

import java.util.Arrays;

public enum Winnings {
    NO_MATCH(0, 0),
    ONW_MATCH(1, 0),
    TWO_MATCH(2, 0),
    THREE_MATCH(3, 5_000),
    FOUR_MATCH(4, 50_000),
    FIVE_MATCH(5, 1_500_000),
    SIX_MATCH(6, 2_000_000_000);

    private final int matchCount;
    private final int winningsAmount;

    Winnings(int matchCount, int winningsAmount) {
        this.matchCount = matchCount;
        this.winningsAmount = winningsAmount;
    }

    public static int getWinningsAmount(int matchCount) {
        return Arrays.stream(Winnings.values())
                .filter(value -> value.matchCount == matchCount)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("비정상적인 매칭된 로또수를 입력하셨습니다."))
                .winningsAmount;
    }
}
