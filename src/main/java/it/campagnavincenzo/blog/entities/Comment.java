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
 * Comment
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String comment;
	private Long commenterId;
	private Timestamp commentDate;
	private int deleted;

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

	public Comment(ResultSet result) throws SQLException {
		this.id = result.getLong("id");
		this.comment = result.getString("comment");
		this.commentDate = result.getTimestamp("comment_date");
		this.deleted = result.getInt("deleted");
		this.commenterId = result.getLong("commenter_id");
	}

}