package heritage.restful.blog.controller;

import heritage.restful.blog.Blog;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class BlogController {

    @Autowired
    BlogRepository blogRepository;

    @GetMapping("/blog")
    public List<Blog> index() {
        return blogRepository.findAll();
    }

    @GetMapping("/blog/{id}")
    public Optional<Blog> show(@PathVariable String id) {
        int blogId = Integer.parseInt(id);
        return blogRepository.findById(blogId);
    }

    @PostMapping("/blog/search")
    public List<Blog> search(@RequestBody Map<String, String> body) {
        String searchTerm = body.get("text");
        return blogRepository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
    }

    @PostMapping("/blog")
    public Blog create(@RequestBody Map<String, String> body) {
        String title = body.get("title");
        String content = body.get("content");
        return blogRepository.save(new Blog(title, content));
    }

    @PutMapping("/blog/{id}")
    public Blog update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int blogId = Integer.parseInt(id);

        //
        Blog blog = blogRepository.findById(blogId).orElse(null);
        // returns java8 optional
        if (blog != null) {
            blog.setTitle(body.get("title"));
            blog.setContent(body.get("content"));
            return blogRepository.save(blog);
        } else {
            return null;
        }
    }


        @DeleteMapping("blog/{id}")
        public boolean delete (@PathVariable String id){
            int blogId = Integer.parseInt(id);
            blogRepository.delete(blogRepository.findById(blogId).orElse(null));
            return true;
        }
    }


