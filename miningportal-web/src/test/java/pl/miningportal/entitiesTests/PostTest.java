package pl.miningportal.entitiesTests;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import pl.miningportal.domain.Comment;
import pl.miningportal.domain.Post;
import pl.miningportal.repository.CommentRepository;
import pl.miningportal.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest // for database
@RunWith(SpringRunner.class)
public class PostTest {

    @Autowired
    PostRepository postRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    TestEntityManager entityManager; // for DB operation
    private static Comment comment1;
    private static Comment comment2;
    private static Post postForComment;


    @Before
    public void setUp() {
          comment1 = new Comment("Comment Body", 5, 1);
          comment2 = new Comment("Comment Body second", 3, 1);
          postForComment = new Post("Title of post", "Body of Post", 1, 5);
          postForComment.setId(1L);
          /*List<Comment> comments = new ArrayList<>();
          comments.add(comment1);
          comments.add(comment2);*/

          entityManager.persist(comment1);
          entityManager.persist(comment2);
          entityManager.persist(postForComment);
    }


 /*   @Test
    public void whenFindByID_thenReturnPost() {
        Post find = postRepository.findById(1L).get();
        Assertions.assertThat(find.getPostTitle().equals(postForComment.getPostTitle()));
    }*/
/*    @Test
    public void addManyCommentsToOnePost() {

        comment1.setPost(postForComment);
        comment2.setPost(postForComment);
        entityManager.persist(comment1);
        entityManager.persist(comment2);
        entityManager.persist(postForComment);
        commentRepository.save(comment1);
        commentRepository.save(comment2);
        System.out.println("POST FOR COMMENT " +  postForComment.getComments().size());

    }*/



}
