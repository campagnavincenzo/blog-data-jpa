package it.campagnavincenzo.blog.queries.interfaces;

import it.campagnavincenzo.blog.entities.Comment;
import it.campagnavincenzo.blog.entities.Post;

/**
 * TransVar
 */
public interface TransVar {

	public Post insertCommentAndPost(long idPost, Comment comment);
}