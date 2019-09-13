package pl.miningportal.domain;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "role")
@Data
public class Role extends BaseEntityAuditable {


    @NonNull
    private String roleName;
    @NonNull
    private int rolePower;


}
