package com.saad.joblisting.repository;

import com.saad.joblisting.model.Post;

import java.util.List;

public interface SearchRepository {
    List<Post> findByText(String text);

}
