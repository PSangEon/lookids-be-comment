package lookids.comment.common.exception;

import lombok.Getter;
import lookids.comment.common.entity.BaseResponseStatus;

@Getter
public class BaseException extends RuntimeException {

	private final BaseResponseStatus status;

	public BaseException(BaseResponseStatus status) {
		this.status = status;
	}
}