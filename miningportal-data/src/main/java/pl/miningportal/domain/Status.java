package pl.miningportal.domain;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Status extends BaseEntityAuditable {


    @NonNull
    private String statusName;
    @NonNull
    private String statusIconSrc;

    @ManyToMany(mappedBy = "statuses")
    private Set<Post> posts = new HashSet<>();

}
