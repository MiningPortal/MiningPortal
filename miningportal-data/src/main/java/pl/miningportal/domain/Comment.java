package pl.miningportal.domain;


import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@Data
public class Comment extends BaseEntityAuditable {

    //    @Id
//    private long userId;
//    @Id
//    private long postId;
//    @Id
//    private long voteId;
    @NonNull
    private String commentBody;
    @NonNull
    private int voteCount;
    @NonNull
    private int commentEnabled;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

//    @OneToMany(mappedBy = "vote", fetch = FetchType.LAZY)
//    private List<Vote> votes;
}
