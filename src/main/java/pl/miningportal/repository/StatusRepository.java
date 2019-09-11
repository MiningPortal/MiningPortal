package pl.miningportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.miningportal.domain.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {

}
