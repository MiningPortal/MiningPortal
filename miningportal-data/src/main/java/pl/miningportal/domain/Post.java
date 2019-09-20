package pl.miningportal.domain;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "post")
@Data
public class Post extends BaseEntityAuditable {


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

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    private List<Comment> comments;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    private List<Vote> votes;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "posts_statuses",
            joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "status_id", referencedColumnName = "id")
    )
    private Set<Status> statuses = new HashSet<>();

    public void addStatus(Status status) {
        statuses.add(status);
    }

    public void addStatuses(Set<Status> status) {
        statuses.forEach(this::addStatus);
    }

}
