package pl.miningportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.miningportal.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

    Post findByPostTitle(String postTitle);


}
