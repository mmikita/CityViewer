package pl.CityViewer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.CityViewer.model.TokyoComment;
import pl.CityViewer.service.TokyoCommentService;

@RestController
public class TokyoCommentRestController {

	@Autowired
	TokyoCommentService service;
	
	@RequestMapping(value = "/tokyoinfo", method = RequestMethod.GET)
	public ResponseEntity<List<TokyoComment>> getWarsComments() {
		// service.addSomeTestComments();
		// List<Comment> allComments = service.getAllComments();
		return ResponseEntity.ok(service.getCommentsWhereParentIsNull());
	}

	@RequestMapping(value = "/putTokyoComment/{text}/{name}/{parentId}", method = RequestMethod.PUT)
	public void putComment(@PathVariable("text") String text,
			@PathVariable("name") String name,
			@PathVariable("parentId") String parentId) {
		service.addNewCommentResponse(text, name, parentId);

	}

	@RequestMapping(value = "/putTokyoNewComment/{text}/{name}", method = RequestMethod.PUT)
	public void putNewComment(@PathVariable("text") String text,
			@PathVariable("name") String name) {
		service.addNewComment(text, name);

	}

}
