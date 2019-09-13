package pl.miningportal.domain;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Data
public class User extends BaseEntityAuditable {


    @NonNull
    private String email;
    @NonNull
    private String nickname;
    @NonNull
    private String password;

    @NonNull
    private int emailVerificationStatus; //can keep status not only 0/1
    @NonNull
    private int userEnabled;

    @NonNull
    private String aboutMe;
    @NonNull
    private String avatarSrc;
    @NonNull
    private LocalDateTime lastLoginDate;

}
