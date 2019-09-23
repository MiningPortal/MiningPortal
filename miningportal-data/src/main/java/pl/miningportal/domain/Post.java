package pl.miningportal.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "post")
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

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "user_id") // by default would be user_user_id
    private User user;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "thread_id")
    private Thread thread;

    @ToString.Exclude
    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    private List<Comment> comments;

    @ToString.Exclude
    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    private List<Vote> votes;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "posts_statuses",
            joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "status_id", referencedColumnName = "id")
    )
    private Set<Status> statuses = new HashSet<>();


// https://kobietydokodu.pl/15-relacje-jeden-do-wielu-wiele-do-jednego/



    public void addStatus(Status status) {
        statuses.add(status);
    }

    public void addStatuses(Set<Status> status) {
        statuses.forEach(this::addStatus);
    }



}
