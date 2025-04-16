package pl.juhas.bnabd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.juhas.bnabd.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
