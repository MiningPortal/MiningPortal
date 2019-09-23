package pl.miningportal.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
@Data
@NoArgsConstructor
public class Role extends BaseEntityAuditable {


    @NonNull
    private String roleName;
    @NonNull
    private int rolePower;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();



    public Role(@NonNull String roleName, @NonNull int rolePower) {
        this.roleName = roleName;
        this.rolePower = rolePower;
    }

}
