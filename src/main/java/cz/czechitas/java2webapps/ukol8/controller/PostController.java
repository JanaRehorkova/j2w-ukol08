package cz.czechitas.java2webapps.ukol8.controller;

import cz.czechitas.java2webapps.ukol8.entity.Post;
import cz.czechitas.java2webapps.ukol8.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
    public class PostController {
    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ModelAndView recentPosts(@PageableDefault(sort = "published",size = 20,direction = Sort.Direction.DESC) Pageable pageable) {
        return new ModelAndView("index")
                .addObject("posty", service.list(LocalDate.now(), pageable));
    }

    @GetMapping("/{slug}")
    public ModelAndView konkretniPost(@PathVariable String slug) {
        return new ModelAndView("detail")
                .addObject("selectedPost", service.singlePost(slug));


    }
}