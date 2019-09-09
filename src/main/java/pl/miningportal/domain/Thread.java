package pl.miningportal.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Thread {

    @Id
    @GeneratedValue
    private long threadId;

    @Id
    private long userId;
    @Id
    private long headThreadId;

    private String threadTopic;
    private String content;
    private String iconSrc;

}
