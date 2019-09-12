package pl.miningportal.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.miningportal.domain.*;
import pl.miningportal.domain.Thread;
import pl.miningportal.repository.*;


import java.time.LocalDateTime;

@Component
@Profile("dev")
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
    private static final String tUserEmail = "tuser@mail.com";
    private static final String tUserNickname = "nickname";
    private static final String tUserPassword = "password";
    private static final int tUserVerificationStatus = 11;
    private static final int tUserEnabled = 1;
    private static final String tUserAboutMe = "sth about me";
    private static final String tUserAvatarSrc = "avatar.jpg";

    //comment sample data
    private static final String tCommentBody = "Sample comment body";
    private static final int tCommentVoteCount = 11;
    private static final int tCommentEnabled = 1;

    //head tread sample data
    private static final String tHeadTreadName = "Sample head tread name";
    private static final String tHeadTreadBody = "Sample head tread body";
    private static final String tHeadTreadIconSrc = "headTread.icon";

    //post sample data
    private static final String tPostTitle = "post title 1";
    private static final String tPostBody = "post body 1";
    private static final int tPostEnabled = 1;
    private static final int tVoteCount = 11;

    //role sample data
    private static final String tRoleName = "role test";
    private static final int tRolePower = 10;

    //status sample data
    private static final String tStatusName = "sample status 1";
    private static final String tStatusIconSrc = "status.jpg";

    //tread sample data
    private static final String tThreadTopic = "sample thread topic";
    private static final String tThreadContent = "sample content";
    private static final String tThreadIconSrc = "thread.src";

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
    }

    private void LoadUser() {
        User user = new User(tUserEmail, tUserNickname, tUserPassword, tUserVerificationStatus, tUserEnabled, tUserAboutMe, tUserAvatarSrc, localDateTime);
        userRepository.save(user);
    }

    private void LoadComment() {
        Comment comment = new Comment(tCommentBody, tCommentVoteCount, tCommentEnabled);
        commentRepository.save(comment);
    }

    private void LoadHeadThread() {
        HeadThread headThread = new HeadThread(tHeadTreadName, tHeadTreadBody, tHeadTreadIconSrc);
        headThreadRepository.save(headThread);
    }

    private void LoadPost() {
        Post post = new Post(tPostTitle, tPostBody, tPostEnabled, tVoteCount);
        postRepository.save(post);
    }

    private void LoadRole() {
        Role role = new Role(tRoleName, tRolePower);
        roleRepository.save(role);
    }

    private void LoadStatus() {
        Status status = new Status(tStatusName, tStatusIconSrc);
        statusRepository.save(status);
    }

    private void LoadThread() {
        Thread thread = new Thread(tThreadTopic, tThreadContent, tThreadIconSrc);
        threadRepository.save(thread);
    }

    private void LoadVote() {
        Vote vote = new Vote(tVoteDirection);
        voteRepository.save(vote);
    }

}
