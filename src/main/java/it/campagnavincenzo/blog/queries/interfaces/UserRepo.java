package it.campagnavincenzo.blog.queries.interfaces;

import it.campagnavincenzo.blog.entities.UserBlog;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepo
 */
public interface UserRepo extends JpaRepository<UserBlog, Long> {

}