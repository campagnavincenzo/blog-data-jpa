package it.campagnavincenzo.blog.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class UserBlog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String email;
	private String name;
	private Integer deleted;
	private Integer active;

	@CreatedDate
	@Column(name = "create_time", updatable = false)
	private Long createTime;
	@LastModifiedDate
	@Column(name = "modify_time")
	private Long modifyTime;
	@CreatedBy
	@Column(name = "created_by", updatable = false)
	private Long createdBy;
	@LastModifiedBy
	@Column(name = "modify_by")
	private Long modifyBy;
}
