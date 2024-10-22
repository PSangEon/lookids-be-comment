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

	private final CommentService commentService;

	// @Operation(summary = "createComment API", description = "creatComment API 입니다." ,tags = {"Commetn"})
	@PostMapping("Comment")
	public void createComment(@RequestBody CommentCreateVo commentCreateVo) {
		CommentCreateDto commentCreateDto = new CommentCreateDto();

		commentService.createComment(

		);
	}
}
