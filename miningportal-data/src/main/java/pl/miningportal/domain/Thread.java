package pl.miningportal.domain;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "thread")
@Data
public class Thread extends BaseEntityAuditable {


    @NonNull
    private String threadTopic;
    @NonNull
    private String threadContent;
    @NonNull
    private String threadIconSrc;

}
