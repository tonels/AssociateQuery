package first.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import first.entity.SingleOnetoOne.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>, JpaSpecificationExecutor<Employee>{

	Employee findByName(String name);
	List<Employee> findByNameStartingWith(String name);
	
	void deleteByName(String name);
	
}
