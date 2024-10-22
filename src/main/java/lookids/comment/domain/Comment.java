package lookids.comment.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 50)
	private String commentCode;

	@Column(nullable = false, length = 50)
	private String feedCode;

	@Column(nullable = false, length = 50)
	private String userUuid;

	@Column(nullable = false, length = 100)
	private String content;

	@Column(nullable = false)
	private LocalDateTime createdAt;

	@Column(nullable = true, length = 50)
	private String parentReviewUuid;

	@Builder
	public Comment(
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
