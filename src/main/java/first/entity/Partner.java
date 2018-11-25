package first.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/*和Grade和Partner是单向一对多关系，可实现单向的多对一级联，问题是，在
 * 级联添加时，一的一端，会重复值出现，设为Unique时，有重复值时，报错*/
@Entity
@Table(name="partner_info")
public class Partner implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="partner_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer partner_id;                    //主键
	
	@Column(name="partner_name")
	private String partner_name;					//姓名
	
	@JoinColumn(name="team_id")						//配置多对一映射
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Grade grade;                            
	
	public Integer getPartner_id() {
		return partner_id;
	}
	public void setPartner_id(Integer partner_id) {
		this.partner_id = partner_id;
	}
	
	public String getPartner_name() {
		return partner_name;
	}
	public void setPartner_name(String partner_name) {
		this.partner_name = partner_name;
	}
	
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}

}
