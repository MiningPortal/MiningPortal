package pl.miningportal.domain;

import lombok.Data;
import org.omg.CORBA.StringHolder;

import javax.persistence.*;

@Data
@Entity
@Table (name = "head_thread")
public class HeadThread {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String headThreadName;
    private String headThreadBody;

}
