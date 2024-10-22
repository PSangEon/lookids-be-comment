package lookids.comment.vo.in;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class CommentCreateVo {
	private String commentCode;
	private String feedCode;
	private String userUuid;
	private String content;
	private LocalDateTime createdAt;
	private String parentReviewUuid;
}

/*
 * VO는 주로 애플리케이션의 여러 계층 간에 데이터를 전달하는 데 사용됩니다.
 * 서비스 계층과 프레젠테이션 계층 사이에서 여러 데이터를 하나의 객체로 묶어 간단하게 전달
 * */