package pl.CityViewer.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.CityViewer.model.BialyComment;
import pl.CityViewer.repository.BialyCommentRepo;

@Service
public class BialyCommentService {

	@Autowired
	BialyCommentRepo repo;

	public void addSomeTestComments() {
		BialyComment parent = new BialyComment();
		parent.setText("Tata");
		BialyComment parent2 = new BialyComment();
		parent2.setText("Tata2");

		BialyComment son = new BialyComment();
		son.setText("syn");

		BialyComment daughter = new BialyComment();
		daughter.setText("corka");

		son.setDate(new Date());
		daughter.setDate(new Date(1980 - 12 - 21));

		repo.addNewComment(parent);
		son.setParentComment(parent.getId());
		daughter.setParentComment(parent.getId());
		parent.setChildrenComments(Arrays.asList(son, daughter));
		repo.addNewComment(son);
		repo.addNewComment(daughter);
		BialyComment sonson = new BialyComment();
		sonson.setText("syn syna");

		sonson.setDate(new Date());
		sonson.setParentComment(son.getId());
		repo.addNewComment(sonson);
		BialyComment dd = new BialyComment();
		dd.setText("corka syna");

		dd.setDate(new Date(2001 - 22 - 22));
		dd.setParentComment(son.getId());
		repo.addNewComment(dd);
		son.setChildrenComments(Arrays.asList(sonson, dd));
		repo.addNewComment(parent2);

	}

	public List<BialyComment> getAllComments() {
		return repo.getAllComments();
	}
	public List<BialyComment> getCommentsWhereParentIsNull() {
		return repo.getCommentsWhereParentIsNull();
	}

	public void addNewCommentResponse(String text, String name, String paId) {
		BialyComment comment = new BialyComment();
		comment.setText(text);
		comment.setCommentOwnerName(name);
		Long parentId = Long.valueOf(paId);
		comment.setParentComment(parentId);
		BialyComment ParrentComment = repo.getCommentById(parentId);
		ParrentComment.getChildrenComments().add(comment);
		repo.addNewComment(comment);
		repo.updateComment(ParrentComment);
		
	}
	public void addNewComment(String text, String name)
	{
		BialyComment comment = new BialyComment();
		comment.setText(text);
		comment.setCommentOwnerName(name);
		repo.addNewComment(comment);
	}
	

}
