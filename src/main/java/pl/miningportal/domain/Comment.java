package pl.miningportal.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue
    private long commentId;
    @Id
    private long userId;
    @Id
    private long postId;
    @Id
    private long voteId;

    private String postBody;
    private int voteCount;
    private int commentEnabled;


}
