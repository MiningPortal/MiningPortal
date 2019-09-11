package pl.miningportal.domain;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@Table (name = "head_thread")
public class HeadThread extends Auditable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String headThreadName;
    @NonNull
    private String headThreadBody;

}
