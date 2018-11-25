package first.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import first.entity.SingleOnetoOne.ParkingSpace;

public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace,Integer>, JpaSpecificationExecutor<ParkingSpace> {
	List<ParkingSpace> findByLot(Integer lot);
	void deleteByLot(Integer lot);
	void deleteByLocation(String location);
}
