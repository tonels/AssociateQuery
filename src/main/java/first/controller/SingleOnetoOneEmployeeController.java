package first.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import first.entity.SingleOnetoOne.Employee;
import first.entity.SingleOnetoOne.ParkingSpace;
import first.repository.EmployeeRepository;
import first.repository.ParkingSpaceRepository;
import first.util.NBAPLayersName;
import first.util.ResultBeanUtil;
import first.util.SimpleName;

@Service
@Transactional
@RestController
@RequestMapping("/SingleEmp")
public class SingleOnetoOneEmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ParkingSpaceRepository parkingSpaceRepository;
	
	@GetMapping("/add1")
	ResultBeanUtil addEmp(){
		ParkingSpace ps = new ParkingSpace();
		ps.setLocation("115");
		ps.setLot(11543);
		
		Employee employee = new Employee();
		employee.setName(NBAPLayersName.getName());
		employee.setSalary(new BigDecimal(2315.42));
		employee.setPs(ps);
		
		employeeRepository.save(employee);
		return ResultBeanUtil.ok(employee);
	}
	
	@GetMapping("/add2")
	ResultBeanUtil add2(){
		ParkingSpace ps = new ParkingSpace();
		ps.setLocation("abc");
		ps.setLot(1552);
		parkingSpaceRepository.save(ps);
		return ResultBeanUtil.ok(ps.getLocation() + "添加成功");
	}
	@GetMapping("/add3")
	ResultBeanUtil add3(){
		ParkingSpace ps = new ParkingSpace();
		ps.setLocation("金桥");
		ps.setLot(1101);
		
		Employee em = new Employee();
		em.setName(NBAPLayersName.getName());
		em.setSalary(new BigDecimal(12301.013));
		em.setPs(ps);
		ps.setEl(em);
		parkingSpaceRepository.save(ps);
		return ResultBeanUtil.ok(ps.getLocation() + "添加成功");
	}
	
	@GetMapping("/add4")
	ResultBeanUtil add4(){
		ParkingSpace ps = new ParkingSpace();
		ps.setLocation("金狐");
		ps.setLot(1105);
		
		Employee em = new Employee();
		em.setName(NBAPLayersName.getName());
		em.setSalary(new BigDecimal(12301.013));
		em.setPs(ps);
		ps.setEl(em);
		employeeRepository.save(em);
		return ResultBeanUtil.ok(ps.getLocation() + "添加成功");
	}
	
	@GetMapping("/find1")
	ResultBeanUtil find1(String name){
		Employee e1= employeeRepository.findByName(name);
		return ResultBeanUtil.ok(e1);
	}
	
	//http://localhost:8080//SingleEmp/find2?name=G,
	/*
	 * {"code":"0000","msg":"SUCCESS",
	 * "result":[
	 * {"id":6,"name":"George Scottie","salary":2315.42,"ps":{"id":4,"lot":110,"location":"110号位置"}},
	 * {"id":8,"name":"Green Chris","salary":2315.42,"ps":{"id":6,"lot":110,"location":"111位置"}},
	 * {"id":12,"name":"Ginobili Chris","salary":2315.42,"ps":{"id":10,"lot":110,"location":"112置"}},
	 * {"id":17,"name":"Garnett Ray","salary":2315.42,"ps":{"id":15,"lot":11543,"location":"115"}}
	 * ],"status":true,"total":null,"totalCount":null}
	 * */
	
	/*控制台输出，可以取出级联表的信息
	 * 110号位置
		111位置
		112置
		115
	 * */
	
	@GetMapping("/find2")
	ResultBeanUtil find2(String name){
		List<Employee> e2= employeeRepository.findByNameStartingWith(name);
		e2.forEach((elist) ->System.out.println(elist.getPs().getLocation()));
		return ResultBeanUtil.ok(e2);
	}
	//配置双向映射时，级联查询会出错
	@GetMapping("/findall1")
	ResultBeanUtil findall1(){
		List<Employee> e2= employeeRepository.findAll();
		e2.forEach((elist) ->System.out.println(elist.getPs().getLocation()));
		return ResultBeanUtil.ok(e2);
	}
	@GetMapping("/findall2")
	ResultBeanUtil findall2(){
		List<ParkingSpace> l1 = parkingSpaceRepository.findAll();
		l1.forEach((list) ->System.out.println(list.getLot()));
		return ResultBeanUtil.ok(l1);
	}
	@GetMapping("/findone1")
	ResultBeanUtil findone1(){
		 Optional<ParkingSpace> findById = parkingSpaceRepository.findById(28);
		return ResultBeanUtil.ok(findById);
	}
	@GetMapping("/findone2")
	ResultBeanUtil findone2(){
		Optional<Employee> findById = employeeRepository.findById(50);
		return ResultBeanUtil.ok(findById);
	}
	
	//ps,非维护端端的增删改查
	@GetMapping("/find3")
	ResultBeanUtil find3(Integer lot){
	List<ParkingSpace> l1 = parkingSpaceRepository.findByLot(lot);
		l1.forEach((list) ->System.out.println(list.getLot()));
		return ResultBeanUtil.ok(l1);
	}
	
	
	
	/*
	 * No EntityManager with actual transaction available for current thread - 
	 * cannot reliably process 'remove' call; nested exception is javax.persistence.
	 * TransactionRequiredException: No EntityManager with actual transaction available for current thread
	 *  - cannot reliably process 'remove' call
	 * 是没配置级联的关系吗？在另一侧配置的一侧，删除时也是这种错误，为什么？
	 * 
	 * */
	@GetMapping("/rm2")
	ResultBeanUtil rm2(Integer lot){
		parkingSpaceRepository.deleteByLot(lot);
		return ResultBeanUtil.ok("删除成功");
	}
	@GetMapping("/rm3")
	ResultBeanUtil rm3(String location){
		parkingSpaceRepository.deleteByLocation(location);
		return ResultBeanUtil.ok("删除成功");
	}
	@GetMapping("/rm4")
	ResultBeanUtil rm4(Integer id){
		parkingSpaceRepository.deleteById(id);
		return ResultBeanUtil.ok("删除成功");
	}
	
	
	//删除,会报错
	@GetMapping("/rm5")
	ResultBeanUtil rm5(String name){
		employeeRepository.deleteByName(name);
		return ResultBeanUtil.ok(name + "已删除。。");
	}
	
	//删除，可以删除，目前来说，只能通过关联的字段来
		@GetMapping("/rm6")
		ResultBeanUtil rm6(Integer id){
			employeeRepository.deleteById(id);
			return ResultBeanUtil.ok(id + "已删除。。");
		}
		
	@GetMapping("/rmall")
	ResultBeanUtil rmall( ){
		employeeRepository.deleteAll();
		parkingSpaceRepository.deleteAll();
		return ResultBeanUtil.ok( "已删除。。");
	}
}
