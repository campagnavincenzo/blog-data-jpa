package it.campagnavincenzo.blog.queries.interfaces;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import it.campagnavincenzo.blog.dto.PostSummary;
import it.campagnavincenzo.blog.dto.PostSummaryDto;
import it.campagnavincenzo.blog.entities.Post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

/**
 * PostRepo
 */
public interface PostRepo extends JpaRepository<Post, Long> {

	List<Post> findByOwnerId(Long id);

	List<Post> findByPostTitleContaining(String postTitle);

	Post findByIdAndDeleted(Long id, int deleted);

	List<Post> findByPostDateAfter(Timestamp postDate);

	/** @ query */

	@Transactional
	@Modifying
	@Query(value = "update post set deleted = 1 where id = ?", nativeQuery = true)
	int deletePostById(Long id);

	@Query(value = "Select * from post where id = ? and deleted = 0", nativeQuery = true)
	Optional<Post> findById(Long Id);

	@Query(value = "select * from post where deleted=0 order by post_date desc limit 2", nativeQuery = true)
	Optional<List<Post>> getLastTwo();

	@Query(value = "select * from post where deleted =1", nativeQuery = true)
	Optional<List<Post>> getAllDeleted();

	/** paging and sorting */
	Optional<List<Post>> findAllByOrderByPostDateDesc();

	Optional<List<Post>> findByOwnerId(Long id, Sort sort);

	@Query(value = "select * from post where deleted =0", countQuery = "select count(*) from post where deleted =0", nativeQuery = true)
	Page<Post> getAllPaging(Pageable page);

	/** projections */
	@Query(value = "select p from Post p where p.id = ?1 and p.deleted = 0")
	Optional<PostSummary> getPostSummaryById(Long id);

	@Query(value = "select new it.campagnavincenzo.blog.dto.PostSummaryDto (p.postTitle, p.body) from Post p where p.id =?1 and p.deleted = 0")
	Optional<PostSummaryDto> getPostSUmmaryDtoById(Long id);

	
	/** procedure */
	//@Transactional
	//@Modifying
	//@Query(value = "CREATE OR REPLACE FUNCTION first_insert() RETURNS integer AS $$ BEGIN Insert into post (post_title, body, owner_id, deleted, post_date) values ('primo title', 'primo body', 111, 0, CURRENT_TIMESTAMP), ('secondo title', 'secondo body', 111, 0, CURRENT_TIMESTAMP),('terzo title', 'terzo body', 111, 0, CURRENT_TIMESTAMP); RETURN 1 ; END; $$ LANGUAGE sql;", nativeQuery = true)
	//void createInsertProcedure();
    
 
	//@Procedure(procedureName = "first_insert")
	//int insertInitialPosts();
}