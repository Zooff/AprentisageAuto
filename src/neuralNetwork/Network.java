package neuralNetwork;

import java.util.Random;

import graphicalInterface.Constant;

public class Network {
	
	
	private int nbInput;
	private double output;
	private double weight[];
	
	private int epoch;
	
	
	public Network(int e){
		epoch = e;
		nbInput = 200 * 150;
		weight = new double[nbInput];
		initialiseWeight();
	}

	
	public void train(){
	
		for (int i = 0; i < epoch; i++){
			
		}
	}
	
	public void classify(int[][] matrix){
		double[] input = new double[nbInput];
		
		for (int i = 0; i< Constant.DRAW.getImg().getHeight(); i++){
			for (int j = 0; j< Constant.DRAW.getImg().getWidth(); j++){
				input[i*j] = matrix[i][j];
			}
		}		
		feedForward(input);
		
	}
	
	void feedForward(double input[]){
		double d = 0;
		for (int i = 0; i< nbInput; i++){
			d += input[i] * weight[i];
		}
		output = sigmoid(d);
	}
	
	void initialiseWeight(){
		Random r = new Random();
		for(int i = 0; i< nbInput; i++){
			weight[i] = r.nextGaussian();
		}
	}
	
	double sigmoid(double x){
		return 1/(1 + Math.exp(-1 * x));
	}
	
	void result(double x){
	}


	public int getNbInput() {
		return nbInput;
	}


	public void setNbInput(int nbInput) {
		this.nbInput = nbInput;
	}


	public double getOutput() {
		return output;
	}


	public void setOutput(double output) {
		this.output = output;
	}


	public double[] getWeight() {
		return weight;
	}


	public void setWeight(double[] weight) {
		this.weight = weight;
	}


	public int getEpoch() {
		return epoch;
	}


	public void setEpoch(int epoch) {
		this.epoch = epoch;
	}
	
	
}
