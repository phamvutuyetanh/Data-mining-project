/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datamining;

import datamining.functions;
import datamining.gradientboostingmodel;
import datamining.neuralnetworkmodel;
import datamining.randomforestmodel;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Random;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.meta.Bagging;
import weka.classifiers.meta.Vote;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.REPTree;
import weka.classifiers.trees.RandomForest;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SelectedTag;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author Tuyet Anh
 */
public class votingtechniques extends functions{
    Vote voting;
    Evaluation eval;
    RandomForest modelA;
    J48 model2;
    Bagging modelC;
    public votingtechniques() {
    }

    public votingtechniques(String filename, String m_options, String d_options) throws Exception {
        super(filename, m_options, d_options);
    }
    
    public void buildVotingModel(String filename) throws Exception {
        setTrainset(filename);
        this.trainset.setClassIndex(this.trainset.numAttributes() - 1);
        this.modelA = new RandomForest();
        String [] optionA = weka.core.Utils.splitOptions("-P 100 -I 100 -num-slots 1 -K 0 -M 1.0 -V 0.001 -S 1");
        this.modelA.setOptions(optionA);
        
        this.model2 = new J48();
        String [] option = weka.core.Utils.splitOptions("-C 0.25 -M 2");
        this.model2.setOptions(option);
  
        this.modelC = new Bagging();
        String [] optionsC = weka.core.Utils.splitOptions("-P 100 -S 1 -num-slots 1 -I 10 -W weka.classifiers.trees.REPTree -- -M 2 -V 0.001 -N 3 -S 1 -L -1 -I 0.0" );
        modelC.setClassifier(new REPTree());
        modelC.setNumIterations(100);
        this.modelC.setOptions(optionsC);
   
        voting = new Vote();
        Classifier [] classifer = { this.modelA, this.model2, this.modelC};
        voting.setClassifiers(classifer);
        voting.setCombinationRule(new SelectedTag(Vote.MAJORITY_VOTING_RULE,Vote.TAGS_RULES));
        voting.buildClassifier(trainset);
    }
    public void evaluateVotingModel(String filename) throws Exception {
        setTestset(filename);
        this.testset.setClassIndex(this.testset.numAttributes() -1);
        Random rand = new Random(1);
        int folds = 10;
        eval = new Evaluation(this.trainset);
        eval.crossValidateModel(voting, testset, folds, rand);
        System.out.println(eval.toSummaryString("\nEvaluation Results\n=================\n", false));
        
    }
    
    public void predictClassLabel(String fileIn, String fileout) throws Exception{
         DataSource ds = new DataSource(fileIn);
         Instances unlabel = ds.getDataSet();
         unlabel.setClassIndex(unlabel.numAttributes()-1);
         for (int i =0; i < unlabel.numInstances(); i++){
             double predict = voting.classifyInstance(unlabel.instance(i));
             unlabel.instance(i).setClassValue(predict);
         }
         BufferedWriter outWriter = new BufferedWriter (new FileWriter(fileout));
         outWriter.write(unlabel.toString());
         outWriter.newLine();
         outWriter.flush();
         outWriter.close();
         
    }
    
}
