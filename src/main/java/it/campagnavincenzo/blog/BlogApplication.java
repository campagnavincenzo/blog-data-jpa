package it.campagnavincenzo.blog;

import it.campagnavincenzo.blog.entities.Comment;
import it.campagnavincenzo.blog.entities.UserBlog;
import it.campagnavincenzo.blog.queries.interfaces.CommentRepo;
import it.campagnavincenzo.blog.queries.interfaces.PostRepo;
import it.campagnavincenzo.blog.queries.interfaces.TransVar;
import it.campagnavincenzo.blog.queries.interfaces.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class BlogApplication implements CommandLineRunner {

	@Autowired
	private PostRepo postRepo;
	@Autowired
	private CommentRepo commentRepo;
	@Autowired
	private TransVar transVar;
	@Autowired
	private UserRepo userRepo;

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		UserBlog first = new UserBlog();
		first.setName("first");
		first.setEmail("first@blog.com");
		first.setActive(0);
		first.setDeleted(0);

		log.info("Saving first User:::: {}", userRepo.save(first).getId());
		log.info("Printing first user::::");
		System.out.println(first.toString());

		//log.info("Inserting proceduere ::::");
		//postRepo.createInsertProcedure();
		//log.info("Inserting initial post with procedue :::: {}", postRepo.insertInitialPosts());
		//log.info("Counting posts :::: {}", postRepo.count());
		//postRepo.findAll().forEach(System.out::println);

		//Comment comm = new Comment();
		//comm.setComment("primo comment");
		//comm.setCommenterId((long) 222);
		//log.info("comment count :::: {}", commentRepo.count());
		//log.info("Insert first comment in Post 1 :::: {}", transVar.insertCommentAndPost(1, comm));
		//log.info("comment count :::: {}", commentRepo.count());

	}

}
