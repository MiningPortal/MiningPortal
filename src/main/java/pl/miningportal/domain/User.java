package pl.miningportal.domain;

import lombok.Data;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private Long userId;

    private String email;
    private String nickname;
    private String password;

    private int emailVerificationStatus; //can keep status not only 0/1
    private int userEnabled;

    private String aboutMe;
    private String avatarURL;
    private LocalDateTime lastLoginDate;

}
