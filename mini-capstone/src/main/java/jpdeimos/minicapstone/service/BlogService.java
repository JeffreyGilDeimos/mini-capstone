package jpdeimos.minicapstone.service;

import jpdeimos.minicapstone.dto.BlogDTO;
import jpdeimos.minicapstone.entity.BlogEntity;
import jpdeimos.minicapstone.exception.UserAlreadyExist;
import jpdeimos.minicapstone.model.BlogRequest;
import jpdeimos.minicapstone.repository.BlogRepository;
import jpdeimos.minicapstone.util.DateTimeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final ModelMapper modelMapper;
    private final DateTimeUtil dateTimeUtil;


    public List<BlogDTO> getAllBlogs() {
        // Get all data from database
        List<BlogEntity> allBlogs = blogRepository.findAll(Sort.by(Sort.Direction.ASC, "createdDate"));

        // Initialize DTO
        List<BlogDTO> allBlogsDTO = new ArrayList<>();

        allBlogs.forEach(blog -> {
            allBlogsDTO.add(modelMapper.map(blog, BlogDTO.class));
        });
        return allBlogsDTO;
    }

    public List<BlogDTO> addBlog(BlogRequest newBlog) {
        // Save new blog to database
        blogRepository.save(BlogEntity
                .builder()
                .blogId(UUID.randomUUID())
                .blogName(newBlog.getBlogName())
                .blogAuthor(newBlog.getBlogAuthor())
                .imageLink(null)
                .description(newBlog.getDescription())
                .createdDate(dateTimeUtil.currentDate())
                .modifiedDate(dateTimeUtil.currentDate())
                .build());

        return getAllBlogs();
    }


    public List<BlogDTO> deleteBlog(UUID blogId) {
        // Get blogs
        BlogEntity blog = blogRepository.findByBlogId(blogId);

        // Check if blog exist
        if(blog == null) throw new UserAlreadyExist("Blog doesn't exist.");

        // Delete blogs
        blogRepository.deleteByBlogId(blogId);

        return getAllBlogs();
    }
}

