package pl.miningportal.domain;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table (name = "role")
@Data
public class Role extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String roleName;
    @NonNull
    private int rolePower;


}
