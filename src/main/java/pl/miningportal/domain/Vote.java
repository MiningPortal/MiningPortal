package pl.miningportal.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Vote {

    @Id
    @GeneratedValue
    private long voteId;

    @Id
    private long postId;
    @Id
    private long commentId;

    private boolean voteStatus;

}
