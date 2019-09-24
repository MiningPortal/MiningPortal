package pl.miningportal.domain;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "vote")
@Data
public class Vote extends BaseEntityAuditable {


    @NonNull
    private int direction;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

}
