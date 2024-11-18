/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datamining;

import java.io.BufferedWriter;
import java.io.FileWriter;
import weka.classifiers.functions.MultilayerPerceptron;
import java.util.Random;
import weka.classifiers.Evaluation;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author Tuyet Anh
 */
public class neuralnetworkmodel extends functions{
    MultilayerPerceptron neural;

    public neuralnetworkmodel() {
        super();
    }
    
    public neuralnetworkmodel(String filename, String m_options, String d_options) throws Exception{
        super(filename, m_options, d_options);
        
    }
    
    public void buildNeuralNetwork (String filename) throws Exception {
        setTrainset(filename);
        this.trainset.setClassIndex(this.trainset.numAttributes() -1);
        this.neural = new MultilayerPerceptron();
        neural.setOptions(this.model_options);
        neural.buildClassifier(this.trainset);
        
    }
    
    public void evaluateNeuralNetwork(String filename) throws Exception {
        setTestset(filename);
        this.testset.setClassIndex(this.testset.numAttributes()-1);
        Random rand = new Random(1);
        int folds = 10;
        Evaluation eval = new Evaluation (this.trainset);
        eval.crossValidateModel (neural, this.testset, folds, rand);
        System.out.println(eval.toSummaryString("\nEvaluation Results\n=================\n", false));
    }
    
    public void predictClassLabel (String fileIn, String fileOut) throws Exception{
        DataSource ds = new DataSource(fileIn);
        Instances unlabel = ds.getDataSet();
        unlabel.setClassIndex(unlabel.numAttributes() -1);
        for (int i=0; i<unlabel.numInstances(); i++){
            double predict = neural.classifyInstance(unlabel.instance(i));
            unlabel.instance(i).setClassValue(predict);
        }
        
        BufferedWriter outWriter = new BufferedWriter (new FileWriter(fileOut));
        outWriter.write(unlabel.toString());
        outWriter.newLine();
        outWriter.flush();
        outWriter.close();
    }
    
}
