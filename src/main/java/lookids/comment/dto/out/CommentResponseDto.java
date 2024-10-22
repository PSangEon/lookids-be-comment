package lookids.comment.dto.out;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentResponseDto {

	private String commentCode;
	private String feedCode;
	private String userUuid;
	private String content;
	private LocalDateTime createdAt;
	private String parentReviewUuid;

	@Builder
	public CommentResponseDto(String commentCode, String feedCode, String userUuid, String content,
		LocalDateTime creatdeAt, String parentReviewUuid) {
		this.commentCode = commentCode;
		this.feedCode = feedCode;
		this.userUuid = userUuid;
		this.content = content;
		this.createdAt = creatdeAt;
		this.parentReviewUuid = parentReviewUuid;

	}

}
