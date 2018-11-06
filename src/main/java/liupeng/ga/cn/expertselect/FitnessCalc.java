package liupeng.ga.cn.expertselect;

import java.util.ArrayList;

/**
 * 计算适应度
 *
 * @author liupeng
 * @createDate 2018-11-01 15:20
 */
public class FitnessCalc {
	
    private static byte[] solution = new byte[100];
    //用于存放对应专家的信息
    private static ArrayList<ExpertInfo> expertInfos ;

    /**
     * 设置候选结果为一个 byte array
     *
     * @param newSolution 基因数组
     */
    public static void setSolution(byte[] newSolution) {
        solution = newSolution;
    }

    /**
     * 将01字符串转换为01数组
     *
     * @param newSolution 基因字符串
     */
    public static void setSolution(String newSolution) {
        solution = new byte[newSolution.length()];
        for (int i = 0; i < newSolution.length(); i++) {
            String character = newSolution.substring(i, i + 1);
            if (character.contains("0") || character.contains("1")) {
                solution[i] = Byte.parseByte(character);
            } else {
                solution[i] = 0;
            }
        }
    }

    /**
     * 通过和solution比较 ，计算个体的适应值
     * @param individual 待比较的个体
     * @return  返回适应度
     */
    public static int getFitness(Individual individual) {
        int fitness = 0;
        for (int i = 0; i < individual.size() && i < solution.length; i++) {
            if (individual.getGene(i) == solution[i]) {
                fitness++;
            }
        }
        return fitness;
    }
    
    
    public static double calcFitness(Individual indi){
    	double fitness = 0;
    	for(int i=0;i<indi.getLength();i++){
    		if(indi.getGene(i)==1){
    			fitness = fitness + expertInfos.get(i).getScore();
    		}
    	}
    	return fitness;
    }

    //最优的适应值，即为基因序列的长度
    public static int getMaxFitness() {
        int maxFitness = solution.length;
        return maxFitness;
    }

	public static ArrayList<ExpertInfo> getExpertInfos() {
		return expertInfos;
	}

	public static void setExpertInfos(ArrayList<ExpertInfo> expertInfos) {
		FitnessCalc.expertInfos = expertInfos;
	}
	
	public static void main(String ...arg){
		ArrayList<ExpertInfo> experts = ExpertInfo.generateExperts(10);
		ExpertInfo.printFitness(experts);
		FitnessCalc.setExpertInfos(experts);
		Individual indi = new Individual(10);
		indi.generateIndividual();
		System.out.println(indi.toString());
		
		double a = FitnessCalc.calcFitness(indi);
		System.out.println(a);
	}
}