package pl.miningportal.domain;

import lombok.*;

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

    private LocalDateTime lastLoginDate ;


    @Builder
    public User(String createdBy,
                LocalDateTime creationDate,
                String lastModifiedBy,
                LocalDateTime lastModifiedDate,
                @NonNull String email,
                @NonNull String nickname,
                @NonNull String password,
                int emailVerificationStatus,
                int userEnabled,
                String aboutMe,
                String avatarSrc,
                LocalDateTime lastLoginDate) {
        super(createdBy,creationDate,lastModifiedBy,lastModifiedDate);

        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.emailVerificationStatus = emailVerificationStatus;
        this.userEnabled = userEnabled;
        this.aboutMe = aboutMe;
        this.avatarSrc = avatarSrc;
        this.lastLoginDate = lastLoginDate;
    }
}
