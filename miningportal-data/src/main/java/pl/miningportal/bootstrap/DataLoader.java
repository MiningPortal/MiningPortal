package pl.miningportal.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.miningportal.domain.*;
import pl.miningportal.domain.Thread;
import pl.miningportal.repository.*;


import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Component
@Profile("dev")
@Transactional
public class DataLoader implements CommandLineRunner {

    private LocalDateTime localDateTime = LocalDateTime.now();

    private UserRepository userRepository;
    private CommentRepository commentRepository;
    private HeadThreadRepository headThreadRepository;
    private PostRepository postRepository;
    private RoleRepository roleRepository;
    private StatusRepository statusRepository;
    private ThreadRepository threadRepository;
    private VoteRepository voteRepository;

    public DataLoader(UserRepository userRepository, CommentRepository commentRepository, HeadThreadRepository headThreadRepository, PostRepository postRepository, RoleRepository roleRepository, StatusRepository statusRepository, ThreadRepository threadRepository, VoteRepository voteRepository) {
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
        this.headThreadRepository = headThreadRepository;
        this.postRepository = postRepository;
        this.roleRepository = roleRepository;
        this.statusRepository = statusRepository;
        this.threadRepository = threadRepository;
        this.voteRepository = voteRepository;
    }

    //user sample data
    private static final String USER_1_EMAIL = "tuser@mail.com";
    private static final String USER_1_NICKNAME = "nickname";
    private static final String USER_1_PASSWORD = "password";
    private static final int USER_1_VERIFICATION_STATUS = 11;
    private static final int USER_1_USER_ENABLED = 1;
    private static final String USER_1_USER_ABOUT_ME = "sth about me";
    private static final String USER_1_USER_AVATAR_SRC = "avatar.jpg";

    //comment sample data
    private static final String COMMENT_1_COMMENT_BODY = "Sample comment body";
    private static final int COMMENT_1_VOTE_COUNT = 11;
    private static final int COMMENT_1_COMMENT_ENABLED = 1;

    //head tread sample data
    private static final String HEAD_THREAD_1_HEAD_THREAD_NAME = "Sample head tread name";
    private static final String HEAD_THREAD_1_HEAD_THREAD_BODY = "Sample head tread body";
    private static final String HEAD_THREAD_1_HEAD_THREAD_ICON_SRC = "headTread.icon";

    //post sample data
    private static final String POST_1_POST_TITLE = "post title 1";
    private static final String POST_1_POST_BODY = "post body 1";
    private static final int HEAD_THREAD_1_POST_ENABLED = 1;
    private static final int HEAD_THREAD_1_VOTE_COUNT = 11;

    //role sample data
    private static final String ROLE_ADMIN = "admin";
    private static final int ROLE_ADMIN_POWER = 10;
    private static final String ROLE_MODERATOR = "moderator";
    private static final int ROLE_MODERATOR_POWER = 9;

    //status sample data
    private static final String STATUS_HOT = "hot";
    private static final String STATUS_HOT_ICON_SRC = "hot-status.jpg";

    //tread sample data
    private static final String THREAD_1_THREAD_TOPIC = "sample thread topic";
    private static final String THREAD_1_THREAD_CONTENT = "sample content";
    private static final String THREAD_1_THREAD_ICON_SRC = "thread.src";

    //vote sample data
    private static final int tVoteDirection = 1;

    @Override
    public void run(String... args) throws Exception {
        LoadUser();
        LoadComment();
        LoadHeadThread();
        LoadPost();
        LoadRole();
        LoadStatus();
        LoadThread();
        LoadVote();


        User user1 = userRepository.findById(1L).get();
        Role role_admin = roleRepository.findById(1L).get();
        Role role_moderator = roleRepository.findById(2L).get();

        user1.addRole(role_admin);
        user1.addRole(role_moderator);
        userRepository.save(user1);

        userRepository.delete(user1);
    }

    private void LoadUser() {

        User user_1 = User.builder()
                .email(USER_1_EMAIL)
                .nickname(USER_1_NICKNAME)
                .password(USER_1_PASSWORD)
                .createdBy("DataLoader.class")
                .creationDate(LocalDateTime.now())
                .build();

        userRepository.save(user_1);


    }

    private void LoadComment() {
        Comment comment = new Comment(COMMENT_1_COMMENT_BODY, COMMENT_1_VOTE_COUNT, COMMENT_1_COMMENT_ENABLED);
        commentRepository.save(comment);
    }

    private void LoadHeadThread() {
        HeadThread headThread = new HeadThread(HEAD_THREAD_1_HEAD_THREAD_NAME, HEAD_THREAD_1_HEAD_THREAD_BODY, HEAD_THREAD_1_HEAD_THREAD_ICON_SRC);
        headThreadRepository.save(headThread);
    }

    private void LoadPost() {
        Post post = new Post(POST_1_POST_TITLE, POST_1_POST_BODY, HEAD_THREAD_1_POST_ENABLED, HEAD_THREAD_1_VOTE_COUNT);
        postRepository.save(post);
    }

    private void LoadRole() {
        Role role_admin = new Role(ROLE_ADMIN, ROLE_ADMIN_POWER);
        roleRepository.save(role_admin);

        Role role_moderator = new Role(ROLE_MODERATOR, ROLE_MODERATOR_POWER);
        roleRepository.save(role_moderator);
    }

    private void LoadStatus() {
        Status status = new Status(STATUS_HOT, STATUS_HOT_ICON_SRC);
        statusRepository.save(status);
    }

    private void LoadThread() {
        Thread thread = new Thread(THREAD_1_THREAD_TOPIC, THREAD_1_THREAD_CONTENT, THREAD_1_THREAD_ICON_SRC);
        threadRepository.save(thread);
    }

    private void LoadVote() {
        Vote vote = new Vote(tVoteDirection);
        voteRepository.save(vote);
    }

}
