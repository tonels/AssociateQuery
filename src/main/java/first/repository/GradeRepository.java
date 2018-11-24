package first.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import first.entity.Grade;

public interface GradeRepository extends JpaRepository<Grade,Integer>, JpaSpecificationExecutor<Grade> {

}
