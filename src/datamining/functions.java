/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datamining;
import java.io.File;
import java.io.IOException;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import weka.core.converters.CSVSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.instance.RemovePercentage;
/**
 *
 * @author Tuyet Anh
 */
public class functions {
    DataSource source;
    Instances dataset;
    String [] model_options;
    String [] data_options;
    Instances trainset;
    Instances testset;
    Instances label;
    Instances unlabel; 
    
    public functions (){
        
    }
    public functions (String filename, String m_options, String d_options) throws Exception{ 
        if (!filename.isEmpty()){
            this.source = new DataSource(filename);
            this.dataset = source.getDataSet();
        }
        if (m_options != null){
            this.model_options = weka.core.Utils.splitOptions(m_options);
                    }
        if (d_options != null){
            this.data_options = weka.core.Utils.splitOptions(d_options);
                    }
    }
    
    
      
    public Instances dividedatatraditional (Instances originalSet, double percent, boolean isTest ) throws Exception {
        RemovePercentage rp = new RemovePercentage();
        rp.setPercentage(percent);
        rp.setInvertSelection(isTest);
        rp.setInputFormat(originalSet);
        return Filter.useFilter(originalSet, rp);
        
    }
    
    public void setTrainset (String filename) throws Exception {
        DataSource trainSource = new DataSource(filename);
        this.trainset = trainSource.getDataSet();
    }
    
    public void setTestset (String filename) throws Exception {
        DataSource testSource = new DataSource(filename);
        this.testset = testSource.getDataSet();
    }
    
    public void evaluate (String fileactual, String filepredict) throws Exception{
        DataSource ds = new DataSource(fileactual);
        Instances label = ds.getDataSet();
        label.setClassIndex(this.trainset.numAttributes() -1);
        DataSource ds1 = new DataSource(filepredict);
        Instances unlabel = ds1.getDataSet();
        unlabel.setClassIndex(this.trainset.numAttributes() -1);
        int correctPredictions = 0;
        for (int i = 0; i < unlabel.numInstances(); i++) {
            Instance label_e = label.instance(i);
            Instance predict = unlabel.instance(i);
            double actualClass = label_e.classValue();
            double predictedClass = predict.classValue();
            if (actualClass == predictedClass) {
                correctPredictions++;
            }
            }
        System.out.println("Accuracy is ");
        double accuracyy = (double) correctPredictions / unlabel.numInstances();
        double accuracy =  accuracyy *100;
        System.out.println(accuracy);
    }

    @Override
    public String toString() {
        return dataset.toSummaryString();
    }
            
}
