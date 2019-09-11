package pl.miningportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.miningportal.domain.HeadThread;

public interface HeadThreadRepository extends JpaRepository<HeadThread, Long> {
}
