package pl.miningportal.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Post extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private long threedId;
//
//    private long userId;
//
//    private long voteId;

    private String postTitle;
    private String postBody;
    private int postEnabled;

    private int voteCount;


}
