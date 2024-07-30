package kyungminseo.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("post")
public class PostRestController {
    private static final Logger logger = LoggerFactory.getLogger(PostRestController.class);
    private final List<PostDto> postList;

    public PostRestController() {
        this.postList = new ArrayList<>();
    }

    // create Post 1
    //http://localhost:8080/post
    //POST /post
    @PostMapping()
    public void createPost(@RequestBody PostDto postDto) {
        logger.info(postDto.toString());
        this.postList.add(postDto);
    }

    // create Post 2
    //http://localhost:8080/post
    //GET /post
    @GetMapping()
    public List<PostDto> readPostAll() {
        logger.info("in read post all");
        return this.postList;
    }


    //GET post/0/
    //GET post?id=1/
    @GetMapping("{id}")
    public  PostDto readPost(@PathVariable int id) {
        logger.info("in read post");
        return this.postList.get(id);
    }

    @PutMapping("{id}")
    public PostDto updatePost(
            @PathVariable int id,
            @RequestBody PostDto postDto
    ) {
        logger.info("in update post");
        PostDto targetPost = this.postList.get(id);
        if (postDto.getTitle() != null) {
            targetPost.setTitle(postDto.getTitle());
        }
        if (postDto.getContent() != null) {
            targetPost.setContent(postDto.getContent());
        }
        if (postDto.getWriter() != null) {
            targetPost.setWriter(postDto.getWriter());
        }
        this.postList.set(id, targetPost);

        return this.postList.get(id);
    }

    @DeleteMapping("{id}")
    public void deletePost(@PathVariable int id) {
        this.postList.remove(id);
    }
}

