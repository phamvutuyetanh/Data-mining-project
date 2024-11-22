/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datamining;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;
import weka.classifiers.Evaluation;
import weka.classifiers.meta.AdditiveRegression;
import weka.classifiers.trees.REPTree;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.meta.Bagging;
/**
 *
 * @author Tuyet Anh
 */
public class gradientboostingmodel extends functions{
    Bagging model;
    public gradientboostingmodel() {
    }

    public gradientboostingmodel(String filename, String m_options, String d_options) throws Exception {
        super(filename, m_options, d_options);
    }
    
    public void buildgradientboostmodel (String filename) throws Exception{
        setTrainset(filename);
        this.trainset.setClassIndex(this.trainset.numAttributes() -1);
        this.model = new Bagging();
        model.setClassifier(new REPTree());
        model.setNumIterations(100);
        model.setOptions(this.model_options);
        model.buildClassifier(this.trainset);
    }
    
    public void evaluateBoost (String filename) throws Exception {
        setTestset(filename);
        this.testset.setClassIndex(this.testset.numAttributes()-1);
        Random rand = new Random(1);
        int folds = 10;
        Evaluation eval = new Evaluation (this.trainset);
        eval.crossValidateModel (model, this.testset, folds, rand);
        System.out.println(eval.toSummaryString("\nEvaluation Results\n=================\n", false));
    }
    
    public void predictClassLabel (String fileIn, String fileOut) throws Exception{
        DataSource ds = new DataSource(fileIn);
        Instances unlabel = ds.getDataSet();
        unlabel.setClassIndex(unlabel.numAttributes() -1);
        for (int i=0; i<unlabel.numInstances(); i++){
            double predict = model.classifyInstance(unlabel.instance(i));
            unlabel.instance(i).setClassValue(predict);
        }
        
        BufferedWriter outWriter = new BufferedWriter (new FileWriter(fileOut));
        outWriter.write(unlabel.toString());
        outWriter.newLine();
        outWriter.flush();
        outWriter.close();
    }
}
