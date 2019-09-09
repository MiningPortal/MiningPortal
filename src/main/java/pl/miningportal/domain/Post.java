package pl.miningportal.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue
    private long postId;

    @Id
    private long threedId;
    @Id
    private long userId;
    @Id
    private long voteId;

    private String postTitle;
    private String postBody;
    private int postEnabled;

    private int voteCount;


}
