/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datamining;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.meta.Vote;
import weka.classifiers.trees.J48;
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
    
    public votingtechniques() {
    }

    public votingtechniques(String filename, String m_options, String d_options) throws Exception {
        super(filename, m_options, d_options);
    }
    
    public void buildVotingModel( String filename) throws Exception {
        setTrainset(filename);
        this.trainset.setClassIndex(this.trainset.numAttributes()-1);
        voting = new Vote();
        Classifier [] classifer = { new NaiveBayes(), new J48(), new RandomForest()};
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
