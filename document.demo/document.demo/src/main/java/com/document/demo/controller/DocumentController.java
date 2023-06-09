package com.document.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.document.demo.Service.DocumentService;
import com.document.demo.model.Comments;
import com.document.demo.model.Document;
import com.document.demo.model.Post;

@RestController
@RequestMapping("/api")
public class DocumentController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(DocumentController.class);

	@Autowired
	private DocumentService documentService;	
	

	@ResponseStatus(value = HttpStatus.OK)
	// @PostMapping("/upload",consumes=Media)
	@PostMapping("/upload")
	public void uploadFiles(@RequestParam("Document") MultipartFile file) {
		
		documentService.saveFile(file);
	}

	@GetMapping("/files/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable Integer id) {
		Document file = documentService.getFile(id).get();

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getDocName() + "\"")
				.body(file.getData());
	}

	@ResponseStatus(value = HttpStatus.OK)
	@DeleteMapping("/files/{id}")
	public void deleteFileById(@PathVariable Integer id) {
		documentService.deleteById(id);
	}

	@ResponseStatus(value = HttpStatus.OK)
	@DeleteMapping("/files")
	public void deleteAllFiles() {
		documentService.deleteAllFiles();
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.status(HttpStatus.CREATED).body(documentService.createPost(post));
    }
	
	@PostMapping("/comment")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Comments> createComment(Comments comment){
		return ResponseEntity.status(HttpStatus.CREATED).body(documentService.createComment(comment));
	}
}
