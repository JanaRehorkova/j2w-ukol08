package cz.czechitas.java2webapps.ukol8.entity;

import net.bytebuddy.asm.Advice;
import org.aspectj.lang.annotation.After;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @UniqueElements
    private String slug;

    @NotNull
    private String title;

    @NotNull
    private String author;

    @NotNull
    private String perex;

    @NotNull
    private String body;

    @NotNull
    private LocalDate published;

    public Post() {
    }

    public Post(Long id, String slug, String title, String author, String perex, String body, LocalDate published) {
        this.id = id;
        this.slug = slug;
        this.title = title;
        this.perex = perex;
        this.body = body;
        this.author=author;
        this.published = published;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPerex() {
        return perex;
    }

    public void setPerex(String perex) {
        this.perex = perex;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDate getPublished() {
        return published;
    }

    public void setPublished(LocalDate published) {
        this.published = published;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
