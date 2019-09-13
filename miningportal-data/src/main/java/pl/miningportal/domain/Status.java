package pl.miningportal.domain;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;

@Data
@Entity
public class Status extends BaseEntityAuditable {


    @NonNull
    private String statusName;
    @NonNull
    private String statusIconSrc;


}
