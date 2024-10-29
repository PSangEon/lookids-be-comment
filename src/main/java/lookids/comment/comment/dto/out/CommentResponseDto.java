package lookids.comment.comment.dto.out;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lookids.comment.comment.domain.Comment;
import lookids.comment.comment.vo.out.CommentResponseVo;

@Getter
@NoArgsConstructor
public class CommentResponseDto {

	private String commentCode;
	private String feedCode;
	private String userUuid;
	private String content;
	private LocalDateTime createdAt;
	private String parentCommentCode;

	@Builder
	public CommentResponseDto(String commentCode, String feedCode, String userUuid, String content,
		LocalDateTime createdAt, String parentCommentCode) {
		this.commentCode = commentCode;
		this.feedCode = feedCode;
		this.userUuid = userUuid;
		this.content = content;
		this.createdAt = createdAt;
		this.parentCommentCode = parentCommentCode;
	}

	public static CommentResponseDto toDto(Comment comment) {
		return CommentResponseDto.builder()
			.commentCode(comment.getCommentCode())
			.feedCode(comment.getFeedCode())
			.userUuid(comment.getUserUuid())
			.content(comment.getContent())
			.createdAt(comment.getCreatedAt())
			.parentCommentCode(comment.getParentCommentCode())
			.build();
	}

	public CommentResponseVo toVo() {
		return CommentResponseVo.builder()
			.commentCode(this.commentCode)
			.feedCode(this.feedCode)
			.userUuid(this.userUuid)
			.content(this.content)
			.createdAt(this.createdAt)
			.parentCommentCode(this.parentCommentCode)
			.build();
	}

}
