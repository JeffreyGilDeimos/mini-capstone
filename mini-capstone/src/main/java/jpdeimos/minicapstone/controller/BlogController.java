package jpdeimos.minicapstone.controller;

import jpdeimos.minicapstone.dto.BlogDTO;
import jpdeimos.minicapstone.model.BlogRequest;
import jpdeimos.minicapstone.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/blog")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/getAll")
    public List<BlogDTO> getAllBlogs() {
        return blogService.getAllBlogs();
    }

    @PutMapping("/add")
    public List<BlogDTO> addBlog(@RequestBody BlogRequest blogRequest) {
        return blogService.addBlog(blogRequest);
    }

    @DeleteMapping("/delete/{blogId}")
    public List<BlogDTO> deleteBlog(@PathVariable UUID blogId) {
        return blogService.deleteBlog(blogId);
    }
}
