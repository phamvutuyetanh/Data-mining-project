/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datamining;

import java.io.BufferedWriter;
import java.io.FileWriter;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.Evaluation;

import java.util.Random;
/**
 *
 * @author Tuyet Anh
 */
public class randomforestmodel extends functions{
    RandomForest rf;
    public randomforestmodel() {
    }

    public randomforestmodel(String filename, String m_options, String d_options) throws Exception {
        super(filename, m_options, d_options);
    }
    
    public void buildRandomForest(String trainFilename) throws Exception {
        setTrainset(trainFilename);
        this.trainset.setClassIndex(this.trainset.numAttributes() - 1);
        this.rf = new RandomForest();
        rf.setOptions(this.model_options);
        rf.buildClassifier(this.trainset);
    }
    
    public void evaluateRandomForest(String testFilename) throws Exception {
        setTestset(testFilename);
        this.testset.setClassIndex(this.testset.numAttributes() - 1);
        Random rand = new Random(1);
        int folds = 10;

        Evaluation eval = new Evaluation(this.trainset);
        eval.crossValidateModel(this.rf, this.testset, folds, rand);
        System.out.println(eval.toSummaryString("\nEvaluation Results\n=================\n", false));
    }
    
    public void predictClassLabel(String inputFilename, String outputFilename) throws Exception {
        DataSource source = new DataSource(inputFilename);
        Instances unlabel = source.getDataSet();
        unlabel.setClassIndex(unlabel.numAttributes() - 1);

        for (int i = 0; i < unlabel.numInstances(); i++) {
            double predict = rf.classifyInstance(unlabel.instance(i));
            unlabel.instance(i).setClassValue(predict);
        }

        BufferedWriter outWriter = new BufferedWriter(new FileWriter(outputFilename));
        outWriter.write(unlabel.toString());
        outWriter.newLine();
        outWriter.flush();
        outWriter.close();
    }
    
}
