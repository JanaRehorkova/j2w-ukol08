package cz.czechitas.java2webapps.ukol8.repository;

import cz.czechitas.java2webapps.ukol8.entity.Post;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {


    Page<Post> findByPublishedIsLessThanEqual(LocalDate datum, Pageable pageable);

    Post findBySlug(String slug);

    Page<Post> getAllByPublishedBeforeAndPublishedNotNullOrderByPublishedDesc(LocalDate datum, Pageable pageable);
}



