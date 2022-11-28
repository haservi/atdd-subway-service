package nextstep.subway.line.acceptance;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import nextstep.subway.line.dto.LineRequest;
import org.springframework.http.MediaType;

public class LineAcceptanceFixture {

    public static ExtractableResponse<Response> 지하철_노선_생성_요청(String name, String color, Long upStationId, Long downStationId, int distance) {
        LineRequest request = new LineRequest(name, color, upStationId, downStationId, distance);
        return RestAssured.given().log().all()
                .body(request)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().post("/lines")
                .then().log().all().extract();
    }

    public static ExtractableResponse<Response> 지하철_노선_목록_조회_요청() {
        return RestAssured.given().log().all()
                .when().get("/lines")
                .then().log().all()
                .extract();
    }

    public static ExtractableResponse<Response> 지하철_노선_조회_요청(Long id) {
        return RestAssured.given().log().all()
                .pathParam("id", id)
                .when().get("/lines/{id}")
                .then().log().all()
                .extract();
    }

    public static ExtractableResponse<Response> 지하철_노선_수정_요청(Long 지하철역_아이디, LineRequest lineRequest) {
        return RestAssured.given().log().all()
                .pathParam("id", 지하철역_아이디)
                .body(lineRequest)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().put("/lines/{id}")
                .then().log().all()
                .extract();
    }

    public static ExtractableResponse<Response> 지하철_노선_삭제_요청(Long 지하철역_아이디) {
        return RestAssured.given().log().all()
                .pathParam("id", 지하철역_아이디)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().delete("/lines/{id}")
                .then().log().all()
                .extract();
    }

}
