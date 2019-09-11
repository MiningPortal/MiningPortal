package pl.miningportal.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.miningportal.domain.User;
import pl.miningportal.repository.UserRepository;

@Component
@Profile("dev")
public class DataLoader implements CommandLineRunner {

    UserRepository userRepository;

    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private static final String USER_MAIL = "user@mail.com";
    private static final String USER_PASSWORD = "user";


    @Override
    public void run(String... args) throws Exception {

        LoadUser();

    }

    private void LoadUser() {

        User user = new User(USER_MAIL, USER_PASSWORD);
        userRepository.save(user);
    }
}
