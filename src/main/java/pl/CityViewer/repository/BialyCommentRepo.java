package pl.CityViewer.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import pl.CityViewer.model.BialyComment;

@Repository
public class BialyCommentRepo {

	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<BialyComment> getAllComments() {
		Query query = entityManager.createQuery("Select c from BialyComment c");
		return query.getResultList();
	}

	@Transactional
	public void addNewComment(BialyComment c) {
		entityManager.persist(c);

	}

	@SuppressWarnings("unchecked")
	public List<BialyComment> getCommentsWhereParentIsNull() {
		Query query = entityManager.createQuery(
				"Select c from BialyComment c where c.ParentComment is NULL");
		return query.getResultList();
	}
	public BialyComment getCommentById(Long id) {
		BialyComment comment = entityManager.find(BialyComment.class, id);

		return comment;
	}
	@Transactional
	public void updateComment(BialyComment comment) {
		entityManager.merge(comment);
		
	}

}
