package first.controller;

//单向一对多问题，级联
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import first.entity.Grade;
import first.repository.GradeRepository;
import first.repository.PartnerRepository;
import first.util.ResultBeanUtil;

@Service
@Transactional
@RestController
@RequestMapping("/grade")
public class GradeController {
	
	@Autowired
	private PartnerRepository partnerRepository;
	
	@Autowired
	private GradeRepository gradeRepository;
	
	@GetMapping("/add1")
	ResultBeanUtil add1(){
		Grade grade = new Grade();
		grade.setTeamName("初中2班");
		gradeRepository.save(grade);
		return ResultBeanUtil.ok(grade);
	}
	
	@GetMapping("/add2")
	ResultBeanUtil add2(){
		Grade grade = new Grade();
		grade.setTeamName("初中2班");
		gradeRepository.save(grade);
		return ResultBeanUtil.ok(grade);
	}
	
	/*查询所有*/
	@GetMapping("/find1")
	ResultBeanUtil find1(){
		List<Grade> list = gradeRepository.findAll();
		return ResultBeanUtil.ok(list);
	}

}
