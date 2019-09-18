package pl.miningportal.domain;


import lombok.Data;
import lombok.NonNull;

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


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @OneToMany(mappedBy = "comment", fetch = FetchType.LAZY)
    private List<Vote> votes;

}
