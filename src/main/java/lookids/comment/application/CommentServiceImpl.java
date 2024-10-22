package lookids.comment.application;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lookids.comment.domain.Comment;
import lookids.comment.dto.in.CommentCreateDto;
import lookids.comment.dto.out.CommentResponseDto;
import lookids.comment.infrastructure.CommentRepository;

@Service
@RequiredArgsConstructor //생성자 주입(?)
public class CommentServiceImpl implements CommentService {

	private final CommentRepository commentRepository;

	@Override
	public void createComment(CommentCreateDto commentCreateDto) {
		Comment comment = Comment.builder()
			.commentCode(commentCreateDto.getCommentCode())
			.feedCode(commentCreateDto.getFeedCode())
			.userUuid(commentCreateDto.getUserUuid())
			.content(commentCreateDto.getContent())
			.createdAt(commentCreateDto.getCreatedAt())
			.parentReviewUuid(commentCreateDto.getParentReviewUuid())
			.build();
		commentRepository.save(comment);
		//save() 메서드는 엔티티의 삽입(insert)과 수정(update)을 처리하는 중요한 메서드
	}

	@Override
	public CommentResponseDto getCommentById(Long id) {

		Comment getComment = commentRepository.findById(id).orElseThrow(
			() -> new IllegalArgumentException("데이터 없음")
		);

		return CommentResponseDto.builder()
			.commentCode(getComment.getCommentCode())
			.feedCode(getComment.getFeedCode())
			.userUuid(getComment.getUserUuid())
			.content(getComment.getContent())
			.creatdeAt(getComment.getCreatedAt())
			.parentReviewUuid(getComment.getParentReviewUuid())
			.build();
	}
}
