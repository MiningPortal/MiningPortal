package pl.miningportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.miningportal.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
