package it.campagnavincenzo.blog.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

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
 * Post
 */
@Data
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String postTitle;
	private String body;
	private Timestamp postDate;
	private Integer deleted;
	private Long ownerId;
	@Column(nullable = true)
	private String commentId;

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

	public Post(ResultSet result) throws SQLException {
		this.id = result.getLong("id");
		this.postTitle = result.getString("post_title");
		this.body = result.getString("body");
		this.postDate = result.getTimestamp("post_date");
		this.deleted = result.getInt("deleted");
		this.ownerId = result.getLong("owner_id");
		this.commentId = result.getString("comment_id");
	}

}