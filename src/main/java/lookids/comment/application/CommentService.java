package lookids.comment.application;

import lookids.comment.dto.in.CommentCreateDto;
import lookids.comment.dto.out.CommentResponseDto;

public interface CommentService {
	void createComment(CommentCreateDto commentCreateDto);

	CommentResponseDto getCommentById(Long id);
}
