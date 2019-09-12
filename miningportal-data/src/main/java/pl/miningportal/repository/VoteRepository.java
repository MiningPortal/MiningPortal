package pl.miningportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.miningportal.domain.Vote;

public interface VoteRepository extends JpaRepository <Vote, Long> {
}
