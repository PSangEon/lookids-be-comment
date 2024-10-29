package lookids.comment.comment.application;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lookids.comment.comment.domain.Comment;
import lookids.comment.comment.dto.in.CommentRequestDto;
import lookids.comment.comment.dto.out.CommentResponseDto;
import lookids.comment.comment.infrastructure.CommentRepository;
import lookids.comment.common.dto.PageResponseDto;
import lookids.comment.common.entity.BaseResponseStatus;
import lookids.comment.common.exception.BaseException;

@Transactional
@Service
@RequiredArgsConstructor //생성자 주입(?)
public class CommentServiceImpl implements CommentService {

	private final CommentRepository commentRepository;

	@Override
	public void createComment(CommentRequestDto commentRequestDto) {

		commentRepository.save(commentRequestDto.toEntity());
		//save() 메서드는 엔티티의 삽입(insert)과 수정(update)을 처리하는 중요한 메서드
	}

	@Override
	public PageResponseDto getCommentList(String feedCode, int page, int size) {
		Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
		Page<Comment> commentList = commentRepository.findAllByFeedCodeAndCommentStatus(feedCode, true, pageable);

		List<CommentResponseDto> responseDtoList = commentList.stream().map(CommentResponseDto::toDto).toList();

		return PageResponseDto.toDto(page, commentList.getTotalPages(), commentList.hasNext(), responseDtoList);
	}

	@Override
	public void deleteComment(String commentCode) {
		Comment comment = commentRepository.findByCommentCode(commentCode).orElseThrow(
			() -> new BaseException(BaseResponseStatus.NO_EXIST_DATA)
		);

		comment.deleteComment();
		commentRepository.save(comment);
	}

	// @Override
	// public CommentResponseDto getCommentById(Long id) {
	//
	// 	Comment getComment = commentRepository.findById(id).orElseThrow(
	// 		() -> new IllegalArgumentException("데이터 없음")
	// 	);
	//
	// 	return CommentResponseDto.builder()
	// 		.commentCode(getComment.getCommentCode())
	// 		.feedCode(getComment.getFeedCode())
	// 		.userUuid(getComment.getUserUuid())
	// 		.content(getComment.getContent())
	// 		.createdAt(getComment.getCreatedAt())
	// 		.parentReviewUuid(getComment.getParent_commetn_code())
	// 		.build();
	// }
}
