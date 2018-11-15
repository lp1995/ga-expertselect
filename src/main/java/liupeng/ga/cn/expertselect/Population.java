package liupeng.ga.cn.expertselect;
/**
 * 种群
 *
 * @author lixiaolin
 * @createDate 2016-06-22 16:32
 */
public class Population {
    private Individual[] individuals;

    /**
     * 创建一个种群
     *
     * @param populationSize 种群初始规模
     * @param initialise     是否初始化
     */
    public Population(int populationSize) {
        individuals = new Individual[populationSize];
    }

    public Individual getIndividual(int index) {
        return individuals[index];
    }

    
    
    /**
     * 获取种群中最优个体
     *
     * @return
     */
    public Individual getFittest() {
        Individual fittest = individuals[0];
        for (int i = 0; i < size(); i++) {
            if (fittest.getFitness() <= getIndividual(i).getFitness()) {
                fittest = getIndividual(i);
            }
        }
        return fittest;
    }

    public int size() {
        return individuals.length;
    }

    public void saveIndividual(int index, Individual indiv) {
        individuals[index] = indiv;
    }
    
    public static void main(String ...arg){
    	for (int i=0;i<20;i++){
    		System.out.println((int)(Math.random()*10));
    	}
    	
    }

}