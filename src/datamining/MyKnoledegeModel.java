/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datamining;
import java.io.File;
import java.io.IOException;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import weka.core.converters.CSVSaver;
import weka.core.converters.ConverterUtils.DataSource;
/**
 *
 * @author Tuyet Anh
 */
public class MyKnoledegeModel {
    DataSource source;
    Instances dataset;
    
    public MyKnoledegeModel (){
        
    }
    public void changedata(String filename, String fileSource) throws IOException{
        CSVLoader loader = new CSVLoader();
        loader.setSource(new File(filename));
        Instances data = loader.getDataSet();
        ArffSaver saver = new ArffSaver();
        saver.setInstances(data);
        saver.setFile(new File(fileSource));
        saver.writeBatch();
        
    }
    public MyKnoledegeModel (String filename) throws Exception{
        this.source = new DataSource(filename);
        this.dataset = source.getDataSet();
   
    }

    @Override
    public String toString() {
        return dataset.toSummaryString();
    }
            
}
