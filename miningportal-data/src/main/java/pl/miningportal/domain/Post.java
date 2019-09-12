package pl.miningportal.domain;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "post")
@Data
public class Post extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private long threadId;
//    private long userId;
//    private long voteId;

    @NonNull
    private String postTitle;
    @NonNull
    private String postBody;
    @NonNull
    private int postEnabled;
    @NonNull
    private int voteCount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "thread_id")
    private Thread thread;

//    @OneToMany (mappedBy = "post", fetch = FetchType.LAZY)
//    private List<Comment> comments;
//
//    @OneToMany (mappedBy = "vote", fetch = FetchType.LAZY)
//    private List<Vote> votes;


}
