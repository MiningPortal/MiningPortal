package pl.miningportal.domain;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@Table(name = "head_thread")
public class HeadThread extends BaseEntityAuditable {


    @NonNull
    private String headThreadName;
    @NonNull
    private String headThreadBody;
    @NonNull
    private String headTreadIconSrc;

}
