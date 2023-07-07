package it.campagnavincenzo.blog.queries.interfaces;

import it.campagnavincenzo.blog.entities.Comment;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CommentRepo
 */
public interface CommentRepo extends JpaRepository<Comment, Long> {

}