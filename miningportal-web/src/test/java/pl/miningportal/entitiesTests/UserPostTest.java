package pl.miningportal.entitiesTests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import pl.miningportal.domain.Post;
import pl.miningportal.domain.User;
import pl.miningportal.repository.PostRepository;
import pl.miningportal.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest // for database
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserPostTest {

    @Autowired
    TestEntityManager entityManager; // for DB operation

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    private static  User user =  User.builder()
            .email("damian@gmail.com")
            .nickname("kaktusx22")
            .password("okon")
            .createdBy("sam se zrobilem")
            .creationDate(LocalDateTime.now())
            .build();

    private static Post firstPost = new Post("Title of Post", "Body of Post", 1, 10);
    private static Post secondPost = new Post("Title of Post second", "Body of Post", 1, 10);
    private static Set<Post> posts = new HashSet<>();


    @BeforeEach
     void setUp() {
       // MockitoAnnotations.initMocks(this);
     }

    @Test
    public void aWhenUserFindByEmail() {

        entityManager.persist(user); // storing entity
        entityManager.flush(); // runs query to database

        User found = userRepository.findByEmail(user.getEmail());
        assertThat(found.getNickname()).isEqualTo(user.getNickname());
        assertThat(found.getPassword()).isEqualTo(user.getPassword());

    }
    @Test
    public void bAddManyPostToOneUser() {
        // create user
        User userr =  User.builder()
                .email("damian@gmail.com")
                .nickname("kaktusx22")
                .password("okon")
                .createdBy("sam se zrobilem")
                .creationDate(LocalDateTime.now())
                .build();
        userr.addPost(firstPost);
        userr.addPost(secondPost);

        firstPost.setId(1L);
        secondPost.setId(2L);
       posts.add(firstPost);
       posts.add(secondPost);

       // save post
        entityManager.persist(firstPost);
        entityManager.persist(secondPost);
        entityManager.persist(user);
        // execute query to save
        entityManager.flush();

        Post found = postRepository.findById(1L).get();
        // check if first element is not null
        Object firstElementBody = posts.stream().findFirst().get();
        Assertions.assertNotNull(firstElementBody);
        // check if first element is correct
        assertThat(found.getPostBody()).isEqualTo(firstPost.getPostBody());
        // is holding two posts?
        Assertions.assertEquals(posts.size(), 2);
        // find post first post -> Title of Post
        postRepository.findByPostTitle(firstPost.getPostTitle());
        Assertions.assertNotNull(postRepository.findByPostTitle(firstPost.getPostTitle()));
        assertThat(postRepository.findByPostTitle(firstPost.getPostTitle()).getPostTitle().equals("Title of Post"));
        // find second post
        Optional<Post> secondPost = postRepository.findById(2L);
        Assertions.assertNotNull(secondPost);

        String secondPostTitle = secondPost.get().getPostTitle();
       assertThat(secondPostTitle.equals("Title of Post second"));

       // check if user has many post
        Assertions.assertEquals(userr.getPosts().size(), 2);
    }






}






















