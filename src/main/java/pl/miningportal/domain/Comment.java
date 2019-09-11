package pl.miningportal.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Comment extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Id
//    private long userId;
//    @Id
//    private long postId;
//    @Id
//    private long voteId;

    private String postBody;
    private int voteCount;
    private int commentEnabled;


}