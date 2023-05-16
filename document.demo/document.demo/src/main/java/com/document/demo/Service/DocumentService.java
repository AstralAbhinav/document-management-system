package com.document.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.document.demo.feignClient.FeignClient;
import com.document.demo.model.Comments;
import com.document.demo.model.Document;
import com.document.demo.model.Post;
import com.document.demo.repository.DocRepository;

@Service
public class DocumentService {

	@Autowired
	private DocRepository docRepository;
	
	@Autowired
	FeignClient client;
	

	public Document saveFile(MultipartFile file) {

		String docName = file.getOriginalFilename();
		try {
			Document document = new Document(docName, file.getContentType(), file.getBytes());
			return docRepository.save(document);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Optional<Document> getFile(Integer fileId) {
		return docRepository.findById(fileId);
	}

	public List<Document> getFiles() {
		return docRepository.findAll();
	}

	public void deleteById(Integer id) {
		try {
			docRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteAllFiles() {
		try {
			docRepository.deleteAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Post createPost(Post post) {
        return client.createPost(post);
    }
		 
	
	public Comments createComment(Comments comment){
		
		return client.createComment(comment);
		}


}
