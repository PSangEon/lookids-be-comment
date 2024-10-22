package lookids.comment.presentation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lookids.comment.application.CommentService;
import lookids.comment.dto.in.CommentCreateDto;
import lookids.comment.vo.in.CommentCreateVo;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/vi/")
public class CommentController {

	private final CommentService commentService;   //final들어가면 변경 불가능!!!!!!!

	// @Operation(summary = "createComment API", description = "creatComment API 입니다." ,tags = {"Commetn"})
	@PostMapping("Comment")
	public void createComment(@RequestBody CommentCreateVo commentCreateVo) {
		CommentCreateDto commentCreateDto = CommentCreateDto.builder()
			.commentCode(commentCreateVo.getCommentCode())
			.feedCode(commentCreateVo.getFeedCode())
			.userUuid(commentCreateVo.getUserUuid())
			.content(commentCreateVo.getContent())
			.createdAt(commentCreateVo.getCreatedAt())
			.parentReviewUuid(commentCreateVo.getParentReviewUuid())
			.build();

		commentService.createComment(commentCreateDto);
	}
}
