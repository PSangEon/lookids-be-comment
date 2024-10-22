package lookids.comment.dto.in;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentCreateDto {

	private String commentCode;
	private String feedCode;
	private String userUuid;
	private String content;
	private LocalDateTime createdAt;
	private String parentReviewUuid;

	@Builder
	public CommentCreateDto(
		String commentCode,
		String feedCode,
		String userUuid,
		String content,
		LocalDateTime createdAt,
		String parentReviewUuid
	) {
		this.commentCode = commentCode;
		this.feedCode = feedCode;
		this.userUuid = userUuid;
		this.content = content;
		this.createdAt = createdAt;
		this.parentReviewUuid = parentReviewUuid;
	}
}
