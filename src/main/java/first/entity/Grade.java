package first.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="grade_info")
public class Grade implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="team_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer teamId;
	
	@Column(name="team_name",unique=true,columnDefinition="varchar(50) not null ")
	private String teamName;
	
	public Integer getTeamId() {
		return teamId;
	}
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	

}
