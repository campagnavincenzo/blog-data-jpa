package it.campagnavincenzo.blog.queries;

import it.campagnavincenzo.blog.entities.Comment;
import it.campagnavincenzo.blog.entities.Post;
import it.campagnavincenzo.blog.queries.interfaces.CommentRepo;
import it.campagnavincenzo.blog.queries.interfaces.PostRepo;
import it.campagnavincenzo.blog.queries.interfaces.TransVar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TransVarImp
 */
@Service
public class TransVarImp implements TransVar {

	@Autowired
	private PostRepo postRepo;
	@Autowired
	private CommentRepo commentRepo;

	@Override
	@Transactional
	public Post insertCommentAndPost(long idPost, Comment comment) {
		commentRepo.save(comment);
		Post toUPdate = postRepo.findById(idPost).get();

		if (toUPdate.getCommentId() != null && comment.getId() != 0) {
			String comments = toUPdate.getCommentId().concat(comment.getId() + ",");
			toUPdate.setCommentId(comments);
		} else {
			toUPdate.setCommentId(String.valueOf(comment.getId()).concat(","));
		}

		return postRepo.save(toUPdate);
	}

}