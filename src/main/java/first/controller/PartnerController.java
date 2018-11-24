package first.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import first.entity.Grade;
import first.entity.Partner;
import first.repository.GradeRepository;
import first.repository.PartnerRepository;
import first.util.ResultBeanUtil;

@Service
@Transactional
@RestController
@RequestMapping("/partner")
public class PartnerController {
	
	@Autowired
	private PartnerRepository partnerRepository;
	
	@Autowired
	private GradeRepository gradeRepository;
	
	//添加成员，指定成员的分组
	@GetMapping("/add")
	ResultBeanUtil add1(){
		Grade grade = new Grade();
		grade.setTeamName("初中4班");
		
		Partner p1 = new Partner();
		p1.setPartner_name("王六风");
		p1.setGrade(grade);
		
		partnerRepository.save(p1);
		return ResultBeanUtil.ok(p1);
	}
	
	//添加成员，指定ID，这里会报错，detached entity passed to persist: first.entity.Grade，原因是Id的生成策略不允许手动set赋予值
	/*@GetMapping("/add2")
	ResultBeanUtil add2(){
		Grade grade = new Grade();
		grade.setTeamId(8);
		
		Partner p1 = new Partner();
		p1.setPartner_name("张大夫");
		
		p1.setGrade(grade);
		
		partnerRepository.save(p1);
		return ResultBeanUtil.ok(p1);
	}*/
	/*批量插入成员*/
	@GetMapping("/addBanch")
	ResultBeanUtil add2(){
		String[] s = {"初中1班","初中2班","初中3班","初中4班","初中5班",};
		Map<String,String> map = new HashMap<String, String>();
		for (int i = 0; i < s.length; i++) {
			Grade grade = new Grade();
			grade.setTeamName(s[i]);
			
			Partner p1 = new Partner();
			p1.setPartner_name("张三风");
			p1.setGrade(grade);
			partnerRepository.save(p1);
		}
		return ResultBeanUtil.ok();
	}
	
	

	@GetMapping("/find")
	ResultBeanUtil find(){
		List<Partner> list = partnerRepository.findAll();
		return ResultBeanUtil.ok(list);
	}
	
	
}
