package kyungminseo.crud.post;

import kyungminseo.crud.entity.PostEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class PostService {
    private static final Logger logger = LoggerFactory.getLogger(PostDao.class);
    private final PostDao postDao;

    public PostService(@Autowired PostDao postDao) {
        this.postDao = postDao;
    }
    public void createPost(PostDto postDto) {
        this.postDao.createPost(postDto);
    }
    public PostDto readPost(int id) {
        PostEntity postEntity = this.postDao.readPost(id);
        return new PostDto(
                Math.toIntExact(postEntity.getId()),
                postEntity.getTitle(),
                postEntity.getContent(),
                postEntity.getWriter(),
                postEntity.getBoardEntity() == null ? 0 : Math.toIntExact(postEntity.getBoardEntity().getId())
        );
    }
    public void updatePost(int id, PostDto postDto) {
        this.postDao.updatePost(id, postDto);
    }
    public void deletePost(int id) {
        this.postDao.deletePost(id);
    }
}
