package pl.miningportal.domain;


import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "comment")
@Data
public class Comment extends BaseEntityAuditable {


    @NonNull
    private String commentBody;
    @NonNull
    private int voteCount;
    @NonNull
    private int commentEnabled;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ToString.Exclude
    @OneToMany(mappedBy = "comment", fetch = FetchType.LAZY)
    private List<Vote> votes;

}