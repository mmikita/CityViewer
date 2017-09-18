package pl.CityViewer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.CityViewer.model.BialyComment;
import pl.CityViewer.service.BialyCommentService;

@RestController
public class BialyCommentRestController {

	@Autowired
	BialyCommentService service;

	@RequestMapping(value = "/bialyinfo", method = RequestMethod.GET)
	public ResponseEntity<List<BialyComment>> getTestComments() {
		// service.addSomeTestComments();
		// List<Comment> allComments = service.getAllComments();
		return ResponseEntity.ok(service.getCommentsWhereParentIsNull());
	}

	@RequestMapping(value = "/dotest", method = RequestMethod.GET)
	public ResponseEntity<List<BialyComment>> zrob() {
		// service.addSomeTestComments();
		// List<Comment> allComments = service.getAllComments();
		service.addSomeTestComments();
		return ResponseEntity.ok(service.getCommentsWhereParentIsNull());
	}

	@RequestMapping(value = "/putcomment/{text}/{name}/{parentId}", method = RequestMethod.PUT)
	public void putComment(@PathVariable("text") String text,
			@PathVariable("name") String name,
			@PathVariable("parentId") String parentId) {
		service.addNewCommentResponse(text, name, parentId);

	}

	@RequestMapping(value = "/putnewcomment/{text}/{name}", method = RequestMethod.PUT)
	public void putNewComment(@PathVariable("text") String text,
			@PathVariable("name") String name) {
		service.addNewComment(text, name);

	}

}
