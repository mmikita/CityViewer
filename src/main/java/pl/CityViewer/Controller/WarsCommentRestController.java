package pl.CityViewer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.CityViewer.model.WarsComment;
import pl.CityViewer.service.WarsCommentService;

@RestController
public class WarsCommentRestController {

	@Autowired
	WarsCommentService service;
	
	@RequestMapping(value = "/warsinfo", method = RequestMethod.GET)
	public ResponseEntity<List<WarsComment>> getWarsComments() {
		// service.addSomeTestComments();
		// List<Comment> allComments = service.getAllComments();
		return ResponseEntity.ok(service.getCommentsWhereParentIsNull());
	}

	@RequestMapping(value = "/putwarscomment/{text}/{name}/{parentId}", method = RequestMethod.PUT)
	public void putComment(@PathVariable("text") String text,
			@PathVariable("name") String name,
			@PathVariable("parentId") String parentId) {
		service.addNewCommentResponse(text, name, parentId);

	}

	@RequestMapping(value = "/putwarsnewcomment/{text}/{name}", method = RequestMethod.PUT)
	public void putNewComment(@PathVariable("text") String text,
			@PathVariable("name") String name) {
		service.addNewComment(text, name);

	}

}
