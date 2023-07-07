package it.campagnavincenzo.blog.appconfig;

import java.util.Optional;

import it.campagnavincenzo.blog.entities.UserBlog;
import it.campagnavincenzo.blog.queries.interfaces.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

/**
 * UserAuditorAware
 */
public class UserAuditorAware implements AuditorAware<Long> {

	@Autowired
	private UserRepo userRepo;

	@Override
	public Optional<Long> getCurrentAuditor() {
		return Optional.of(userRepo.findById(Long.valueOf(1)).map(UserBlog::getId).orElse(Long.valueOf(0)));
	}

}