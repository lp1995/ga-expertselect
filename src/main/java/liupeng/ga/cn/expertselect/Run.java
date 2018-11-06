package liupeng.ga.cn.expertselect;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class Run 
{
    public static void main( String[] args )
    {
    	
    	//设置初始专家
    	ArrayList<ExpertInfo> experts = ExpertInfo.generateExperts(100);
		FitnessCalc.setExpertInfos(experts);
		
    	//初始种群
    	Population pop = new Population(100,true);
    	//迭代
    	GAlgorithm ga = new GAlgorithm();
    	for(int i=0;i<100;i++){
    		pop = ga.evolvePopulation(pop);
    	}
    	//输出结果
        System.out.println( "----最优解的适应度值----" );
        Individual indi = pop.getFittest();
        System.out.println(indi.getFitness());
    }
}
