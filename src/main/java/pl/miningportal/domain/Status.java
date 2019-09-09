package pl.miningportal.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Status {

    @Id
    private long statusId;

    private String statusName;

}
