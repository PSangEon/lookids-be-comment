package lookids.comment.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import lookids.comment.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
