package lookids.comment.comment.presentation;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lookids.comment.comment.application.CommentService;
import lookids.comment.comment.dto.in.CommentRequestDto;
import lookids.comment.comment.vo.in.CommentRequestVo;
import lookids.comment.common.dto.PageResponseDto;
import lookids.comment.common.entity.BaseResponse;
import lookids.comment.common.entity.BaseResponseStatus;
import lookids.comment.common.vo.PageResponseVo;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {

	private final CommentService commentService;   //final들어가면 변경 불가능!!!!!!!

	@Operation(summary = "createComment API", description = "createComment API 입니다.", tags = {"Comment"})
	@PostMapping
	public BaseResponse<Void> createComment(@RequestBody CommentRequestVo commentRequestVo) {

		commentService.createComment(CommentRequestDto.toDto(commentRequestVo));
		return new BaseResponse<>(BaseResponseStatus.SUCCESS);
	}

	@Operation(summary = "readCommentList API", description = "readCommentList API 입니다.", tags = {"Comment"})
	@GetMapping()
	public BaseResponse<PageResponseVo> readCommentList(@RequestParam(value = "feedCode") String feedCode,
		@RequestParam(value = "page", defaultValue = "0") int page,
		@RequestParam(value = "size", defaultValue = "20") int size) {  //한번에 몇개를 가지고 올지..20개를 갖고 올거.
		log.info("요청받음 : {}", feedCode);
		// 조회할 피드코드를 서비스 함수에 파라미터로 넘겨줌

		PageResponseDto pageResponseDto = commentService.getCommentList(feedCode, page, size);

		return new BaseResponse<>(pageResponseDto.toVo());
	}

	@Operation(summary = "isDeleteCommentList API", description = "isDelete API 입니다. 완전삭제 아", tags = {"Comment"})
	@DeleteMapping("/{commentCode}")
	public BaseResponse<Void> deleteComment(@PathVariable String commentCode) {
		commentService.deleteComment(commentCode);
		return new BaseResponse<>(BaseResponseStatus.SUCCESS);
	}

}
