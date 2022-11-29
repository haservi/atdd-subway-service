package nextstep.subway.exception;

public enum ErrorMessage {

    LINE_ID_NOT_FOUND("노선 아이디 값을 찾을 수 없습니다. lineId: %s"),
    STATION_ID_NOT_FOUND("지하철 아이디 값을 찾을 수 없습니다. stationId: %s"),
    INTERNAL_SERVER_ERROR("알 수 없는 오류입니다."),
    SAME_SUBWAY_SECTION_ERROR("상행선과 하행선이 동일할 수 없습니다."),
    DISTANCE_CANNOT_BE_ZERO("거리는 0이하가 될 수 없습니다."),
    DISTANCE_BETWEEN_STATION_OVER("역 사이의 거리가 같거나 큽니다."),
    UP_STATION_AND_DOWN_STATION_ENROLLMENT("상행역과 하행역이 모두 등록되어 있습니다."),
    UP_STATION_AND_DOWN_STATION_NOT_FOUND("상행역과 하행역이 모두 등록되어 있지 않습니다."),
    ONE_SECTION_NOT_DELETE("지하철 구간이 1개인 경우 삭제할 수 없습니다."),
    STATION_NOT_CONTAINS_NOT_DELETE("삭제하려는 지하철 역이 올바르지 않습니다."),
    NOT_SEARCH_SAME_START_ARRIVE_STATION("출발역과 도착역이 같은 경우 최단 경로를 조회할 수 없습니다."),
    NOT_CONNECT_START_ARRIVE_STATION("출발역과 도착역은 서로 연결이 되어있어야 최단 경로를 조회할 수 있습니다."),
    ;
    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
