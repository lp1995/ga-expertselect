package liupeng.ga.cn.expertselect;

/**
 * 个体
 *
 * @author lixiaolin
 * @createDate 2016-06-22 15:10
 */
public class Individual {

	//基因的长度，也就是候选专家的个数
    private int length;
    //基因序列
    private byte[] genes;
    // 个体的适应度
    private double fitness = 0;

    public Individual(int length){
    	this.length = length;
    	this.genes = new byte[length];
    }
    
    // 创建一个随机的 基因个体
    public void generateIndividual() {
        for (int i = 0; i < size(); i++) {
            byte gene = (byte) Math.round(Math.random());
            genes[i] = gene;
        }
    }

    public int getLength(){
    	return length;
    }
    
    public void setLength(int len) {
    	this.length = len;
    }

    public byte getGene(int index) {
        return genes[index];
    }

    public void setGene(int index, byte value) {
        genes[index] = value;
        fitness = 0;
    }

    public int size() {
        return length;
    }

    public double getFitness() {
        if (fitness == 0) {
            fitness = FitnessCalc.calcFitness(this);
        }
        return fitness;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size(); i++) {
            sb.append(getGene(i));
        }
        return sb.toString();
    }
    
    public static void main(String ...arg){
    	Individual indi = new Individual(10);
    	indi.generateIndividual();
    	System.out.println(indi.toString());
    }

}