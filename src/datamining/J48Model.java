package datamining;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
/**
 *
 * @author Tuyet My
 */
public class J48Model extends functions{
    J48 tree;

    public J48Model(String filename, String m_options, String d_options) throws Exception {
        super(filename, m_options, d_options);
    }
    
    public void buildTree(String trainFileName) throws Exception{
        // Create train test data
        setTrainset(trainFileName);
        this.trainset.setClassIndex(this.trainset.numAttributes() - 1);
        // Create parameter for tree
        this.tree = new J48();
        this.tree.setOptions(this.model_options);
        // Build model
        this.tree.buildClassifier(this.trainset);
    }
    
    public void evaluateDecisionTree(String testFileName) throws Exception{
        setTestset(testFileName);
        this.testset.setClassIndex(this.testset.numAttributes() - 1);
        Random rnd = new Random(1);
        int folds = 10;
        Evaluation eval = new Evaluation(this.trainset);
        eval.evaluateModel(this.tree, this.testset);
        eval.crossValidateModel(this.tree,this.testset, folds, rnd);
        
        // Print basic evaluation metrics
        System.out.println(eval.toSummaryString("\nEvaluation\n-----------------\n", false));
        // Print precision, recall, F1-score, and other class details
        System.out.println(eval.toClassDetailsString("\nClass Details\n-----------------\n"));
    }
    
    public void predictClassLabel (String fileIn, String fileOut) throws Exception{
        DataSource ds = new DataSource(fileIn);
        Instances unlabel = ds.getDataSet();
        unlabel.setClassIndex(unlabel.numAttributes() -1);
        for (int i=0; i<unlabel.numInstances(); i++){
            double predict = this.tree.classifyInstance(unlabel.instance(i));
            unlabel.instance(i).setClassValue(predict);
        }
        
        BufferedWriter outWriter = new BufferedWriter (new FileWriter(fileOut));
        outWriter.write(unlabel.toString());
        outWriter.newLine();
        outWriter.flush();
        outWriter.close();
    }
    @Override
    public String toString() {
        return tree.toSummaryString();
    }
    
}
