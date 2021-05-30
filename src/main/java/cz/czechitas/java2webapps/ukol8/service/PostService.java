package cz.czechitas.java2webapps.ukol8.service;


import cz.czechitas.java2webapps.ukol8.entity.Post;
import cz.czechitas.java2webapps.ukol8.repository.PostRepository;
import net.bytebuddy.asm.Advice;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {
private final PostRepository postRepository;


@Autowired
public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    public Page<Post> list(LocalDate today, Pageable pageable) {
        return postRepository.findByPublishedIsLessThanEqual(LocalDate.now(), pageable);
    }

  public Post singlePost(String slug){
      return postRepository.findBySlug(slug);


  }

}
