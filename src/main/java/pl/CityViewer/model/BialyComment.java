package pl.CityViewer.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class BialyComment {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String uuid = UUID.randomUUID().toString();
	String text;
	public String getUuid() {
		return uuid;
	}

	private Long ParentComment;
	private Date date;
	private String commentOwnerName;

	@Override
	public int hashCode() {

		return Objects.hash(uuid);
	}

	@Override
	public boolean equals(Object obj) {

		return this == obj || obj instanceof BialyComment
				&& Objects.equals(uuid, ((BialyComment) obj).uuid);
	}

	public String getCommentOwnerName() {
		return commentOwnerName;
	}

	public void setCommentOwnerName(String commentOwnerName) {
		this.commentOwnerName = commentOwnerName;
	}
	public Long getParentComment() {
		return ParentComment;
	}

	public void setParentComment(Long parentComment) {
		ParentComment = parentComment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	// @OneToMany(mappedBy="ParentComment", cascade={CascadeType.ALL})
	@OneToMany(mappedBy = "ParentComment")
	List<BialyComment> childrenComments;

	public List<BialyComment> getChildrenComments() {
		return childrenComments;
	}

	public void setChildrenComments(List<BialyComment> childrenComments) {
		this.childrenComments = childrenComments;
	}

	public Long getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setId(Long id) {
		this.id = id;
	}



	// public String getUuid() {
	// return uuid;
	// }

	// @Override
	// public int hashCode() {
	//
	// return Objects.hash(uuid);
	// }
	//
	// @Override
	// public boolean equals(Object obj) {
	//
	// return this == obj || obj instanceof Comment
	// && Objects.equals(uuid, ((Comment) obj).uuid);
	// }
}
