package com.esprit.microservice.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.esprit.microservice.Entity.Article;
import com.esprit.microservice.Service.IArticleService;

import com.fasterxml.jackson.databind.JsonMappingException;

import io.micrometer.core.ipc.http.HttpSender.Response;





@RestController
public class ArticleRestApi {
	private String title="hello I'm the Article Microservice";
	

	@Autowired
	IArticleService ArticleService; 

	
	
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity<Response>  addArticle(@RequestPart("file") MultipartFile file,@RequestParam("Article") String s)throws JsonParseException, JsonMappingException, Exception {
		 return ArticleService.add(file,s);
	}
	
	@PutMapping("/update-Article/{id}")
	@ResponseBody
	Article updateArticle(@RequestBody Article s){
		return ArticleService.updateArticle(s);
	}
	
	
	
	@RequestMapping("/hello")
	
	public String sayHello(){
		
		System.out.println(title);
		return title;
	}
	
	@DeleteMapping(value="/id", produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteArticle(@PathVariable(value="id") int  id){
	return new ResponseEntity<>(ArticleService.deleteArticle(id),HttpStatus.OK);

	}
}
