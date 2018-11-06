package liupeng.ga.cn.expertselect;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 专家信息
 *
 * @author liupeng
 * @createDate 2018-11-01 15:20
 */
public class ExpertInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String expertNumber;
	private double score;
	
	public ExpertInfo(double fitness){
		this.score = fitness;
	}
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
	
	public static ArrayList<ExpertInfo> generateExperts(int length){
		ArrayList<ExpertInfo> experts = new ArrayList<ExpertInfo>();
		for(int i=0;i<length;i++){
			ExpertInfo expert = new ExpertInfo(Math.random());
			experts.add(expert);
		}
		return experts;
	}
	
	public static void printFitness(ArrayList<ExpertInfo> experts){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<experts.size();i++){
			sb.append(experts.get(i).getScore());
		}
		System.out.println(sb.toString());
	}
	
	public static void main(String ...arg){
		ArrayList<ExpertInfo> experts = ExpertInfo.generateExperts(10);
		ExpertInfo.printFitness(experts);
	}
	

	
	//序列化
} 
