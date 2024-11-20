package com.saad.joblisting.controller;


import com.saad.joblisting.repository.PostRepository;
import com.saad.joblisting.model.Post;
import com.saad.joblisting.repository.SearchRepository;
import com.saad.joblisting.repository.SearchRepositoryImpl;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class PostController {

    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepository srepo;


    @Operation(hidden = true)
    @RequestMapping("/")
    @CrossOrigin
    public void redirect( HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/allPosts")
    @CrossOrigin
    public List<Post> getAllPosts(){

        return repo.findAll();


    }

    @GetMapping("/posts/{text}")
    @CrossOrigin
    public List<Post> search(@PathVariable String text){

        return srepo.findByText(text);
    }

    @PostMapping("/post")
    @CrossOrigin
    public void addPost(@RequestBody Post p ){

        repo.save(p);
    }





}
