package pl.miningportal.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class User extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String nickname;
    private String password;

    private int emailVerificationStatus; //can keep status not only 0/1
    private int userEnabled;

    private String aboutMe;
    private String avatarURL;
    private LocalDateTime lastLoginDate;

}
