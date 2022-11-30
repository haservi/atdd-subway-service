package nextstep.subway.auth.acceptance;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import nextstep.subway.AcceptanceTest;
import nextstep.subway.auth.dto.TokenRequest;
import nextstep.subway.auth.dto.TokenResponse;
import nextstep.subway.member.domain.MemberRepository;
import nextstep.subway.member.dto.MemberResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import static nextstep.subway.auth.acceptance.AuthAcceptanceFixture.*;
import static nextstep.subway.member.MemberAcceptanceTest.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AuthAcceptanceTest extends AcceptanceTest {

    private static final String EMAIL = "email@email.com";
    private static final String PASSWORD = "password";
    private static final String WRONG_PASSWORD = "wrong";
    private static final int AGE = 20;

    private TokenRequest 정상_토큰_요청;
    private TokenRequest 불량_토큰_요청;

    @BeforeEach
    public void set_up() {
        super.setUp();
        // given
        회원_생성을_요청(EMAIL, PASSWORD, AGE);
        정상_토큰_요청 = new TokenRequest(EMAIL, PASSWORD);
        불량_토큰_요청 = new TokenRequest(EMAIL, WRONG_PASSWORD);
    }

    @DisplayName("Bearer Auth 확인")
    @Test
    void myInfoWithBearerAuth() {
        // when
        ExtractableResponse<Response> 로그인_요청_응답 = 로그인_요청(정상_토큰_요청);
        // then
        로그인_요청_성공(로그인_요청_응답);
    }

    @DisplayName("Bearer Auth 로그인 실패")
    @Test
    void myInfoWithBadBearerAuth() {
        // when
        ExtractableResponse<Response> 로그인_요청_응답 = 로그인_요청(불량_토큰_요청);
        // then
        로그인_요청_실패(로그인_요청_응답);
    }

    @DisplayName("Bearer Auth 유효하지 않은 토큰")
    @Test
    void myInfoWithWrongBearerAuth() {
        // when
        ExtractableResponse<Response> 내_회원_정보_조회_응답 = 내_회원_정보_조회_요청("invalid_access_token");
        // then
        내_회원_정보_조회_응답_실패(내_회원_정보_조회_응답);
    }

}
