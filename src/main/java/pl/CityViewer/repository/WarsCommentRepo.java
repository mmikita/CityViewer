package pl.CityViewer.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import pl.CityViewer.model.WarsComment;

@Repository
public class WarsCommentRepo {

	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<WarsComment> getAllComments() {
		Query query = entityManager.createQuery("Select c from WarsComment c");
		return query.getResultList();
	}

	@Transactional
	public void addNewComment(WarsComment c) {
		entityManager.persist(c);

	}

	@SuppressWarnings("unchecked")
	public List<WarsComment> getCommentsWhereParentIsNull() {
		Query query = entityManager.createQuery(
				"Select c from WarsComment c where c.ParentComment is NULL");
		return query.getResultList();
	}
	public WarsComment getCommentById(Long id) {
		WarsComment comment = entityManager.find(WarsComment.class, id);

		return comment;
	}
	@Transactional
	public void updateComment(WarsComment comment) {
		entityManager.merge(comment);
		
	}

}
