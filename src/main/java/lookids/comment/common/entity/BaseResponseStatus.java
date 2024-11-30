package lookids.comment.common.entity;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BaseResponseStatus {

	/**
	 * 200: 요청 성공
	 **/
	SUCCESS(HttpStatus.OK, true, 200, "요청에 성공하였습니다."),

	NO_EXIST_DATA(HttpStatus.NOT_FOUND, false, 404, "데이터를 찾을 수 없습니다."),

	/**
	 * 900: 기타 에러
	 */
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, false, 900, "Internal server error"), SSE_SEND_FAIL(
		HttpStatus.INTERNAL_SERVER_ERROR, false, 901, "알림 전송에 실패하였습니다."),

	// Comment
	NO_EXIST_COMMENT(HttpStatus.NOT_FOUND, false, 4001, "존재하지 않는 댓글입니다"), NO_DELETE_COMMENT_AUTHORITY(
		HttpStatus.BAD_REQUEST, false, 4002, "댓글 삭제 권한이 없습니다"), NO_DELETE_RE_COMMENT_AUTHORITY(HttpStatus.BAD_REQUEST,
		false, 4003, "대댓글 삭제 권한이 없습니다"), NO_EXIST_RE_COMMENT(HttpStatus.NOT_FOUND, false, 4003,
		"존재하지 않는 대댓글입니다"), NO_EXIST_PIN_AUTHORITY(HttpStatus.BAD_REQUEST, false, 4004,
		"고정 권한이 없습니다"), DUPLICATED_COMMENT(HttpStatus.INTERNAL_SERVER_ERROR, false, 4001, "댓글 생성 오류");

	private final HttpStatus httpStatusCode;
	private final boolean isSuccess;
	private final int code;
	private final String message;
}