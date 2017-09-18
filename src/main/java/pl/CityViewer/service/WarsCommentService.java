package pl.CityViewer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.CityViewer.model.WarsComment;
import pl.CityViewer.repository.WarsCommentRepo;

@Service
public class WarsCommentService {

	@Autowired
	WarsCommentRepo repo;



	public List<WarsComment> getAllComments() {
		return repo.getAllComments();
	}
	public List<WarsComment> getCommentsWhereParentIsNull() {
		return repo.getCommentsWhereParentIsNull();
	}

	public void addNewCommentResponse(String text, String name, String paId) {
		WarsComment comment = new WarsComment();
		comment.setText(text);
		comment.setCommentOwnerName(name);
		Long parentId = Long.valueOf(paId);
		comment.setParentComment(parentId);
		WarsComment ParrentComment = repo.getCommentById(parentId);
		ParrentComment.getChildrenComments().add(comment);
		repo.addNewComment(comment);
		repo.updateComment(ParrentComment);
		
	}
	public void addNewComment(String text, String name)
	{
		WarsComment comment = new WarsComment();
		comment.setText(text);
		comment.setCommentOwnerName(name);
		repo.addNewComment(comment);
	}
	

}
