package pl.CityViewer.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import pl.CityViewer.model.TokyoComment;

@Repository
public class TokyoCommentRepo {

	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<TokyoComment> getAllComments() {
		Query query = entityManager.createQuery("Select c from TokyoComment c");
		return query.getResultList();
	}

	@Transactional
	public void addNewComment(TokyoComment c) {
		entityManager.persist(c);

	}

	@SuppressWarnings("unchecked")
	public List<TokyoComment> getCommentsWhereParentIsNull() {
		Query query = entityManager.createQuery(
				"Select c from TokyoComment c where c.ParentComment is NULL");
		return query.getResultList();
	}
	public TokyoComment getCommentById(Long id) {
		TokyoComment comment = entityManager.find(TokyoComment.class, id);

		return comment;
	}
	@Transactional
	public void updateComment(TokyoComment comment) {
		entityManager.merge(comment);
		
	}

}
