package pl.CityViewer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.CityViewer.model.TokyoComment;
import pl.CityViewer.repository.TokyoCommentRepo;

@Service
public class TokyoCommentService {

	@Autowired
	TokyoCommentRepo repo;

	public List<TokyoComment> getAllComments() {
		return repo.getAllComments();
	}
	public List<TokyoComment> getCommentsWhereParentIsNull() {
		return repo.getCommentsWhereParentIsNull();
	}

	public void addNewCommentResponse(String text, String name, String paId) {
		TokyoComment comment = new TokyoComment();
		comment.setText(text);
		comment.setCommentOwnerName(name);
		Long parentId = Long.valueOf(paId);
		comment.setParentComment(parentId);
		TokyoComment ParrentComment = repo.getCommentById(parentId);
		ParrentComment.getChildrenComments().add(comment);
		repo.addNewComment(comment);
		repo.updateComment(ParrentComment);
		
	}
	public void addNewComment(String text, String name)
	{
		TokyoComment comment = new TokyoComment();
		comment.setText(text);
		comment.setCommentOwnerName(name);
		repo.addNewComment(comment);
	}
	

}
