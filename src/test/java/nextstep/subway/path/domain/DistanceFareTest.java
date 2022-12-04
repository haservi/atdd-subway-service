package nextstep.subway.path.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("거리에 따른 추가 요금 테스트")
class DistanceFareTest {

    @DisplayName("거리에 따른 추가 요금을 확인할 수 있다.")
    @ParameterizedTest(name = "#{index} - {0}km 이동하면 요금은 {1}원 이다.")
    @CsvSource(value = {"10=1250", "15=1350", "50=2050", "66=2250"}, delimiter = '=')
    void distance_extra_fare(int distance, int fare) {
        assertThat(DistanceFare.calculateDistanceFare(distance)).isEqualTo(fare);
    }

}