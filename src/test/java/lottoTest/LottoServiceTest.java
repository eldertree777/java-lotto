package lottoTest;

import lotto.service.LottoService;
import lotto.model.ResultLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    @Test
    void getWinningRateTest() {
        LottoService lottoService = new LottoService();
        ResultLotto resultLotto = lottoService.buyLottos(1000);
        int buyCount = resultLotto.totallottoCount();
        int winningAmount = resultLotto.getWinningAmount();

        System.out.println(resultLotto.getWinningRate());
        System.out.println(winningAmount / buyCount * 1000);

        Assertions.assertThat(resultLotto.getWinningRate()).isEqualTo(winningAmount / buyCount * 1000);
    }
}
