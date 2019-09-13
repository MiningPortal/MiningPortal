package pl.miningportal.domain;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "vote")
@Data
public class Vote extends BaseEntityAuditable {


    //    private long postId;
//    private long commentId;
    @NonNull
    private int direction;


    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

}
