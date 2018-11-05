package liupeng.ga.cn.expertselect;

/**
 * 专家信息
 *
 * @author liupeng
 * @createDate 2018-11-01 15:20
 */
public class ExpertInfo {
	private String name;
	private int age;
	private String expertNumber;
	private double score;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getExpertNumber() {
		return expertNumber;
	}
	public void setExpertNumber(String expertNumber) {
		this.expertNumber = expertNumber;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
}
