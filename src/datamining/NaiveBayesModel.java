package datamining;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
/**
 *
 * @author Tuyet My
 */
public class NaiveBayesModel extends functions {
    NaiveBayes nbayes;

    public NaiveBayesModel() {
        super();
    }

    public NaiveBayesModel(String filename, String m_options, String d_options) throws Exception {
        super(filename, m_options, d_options);
    }
    
    public void buildNaiveBayes(String filename) throws Exception{
        // Input train file
        setTrainset(filename);
        this.trainset.setClassIndex(this.trainset.numAttributes() - 1);
        // Train model
        this.nbayes = new NaiveBayes();
        nbayes.buildClassifier(this.trainset);
    }
    
    public void evaluateNaiveBayes(String filename) throws Exception{
        // Input test set
        setTestset(filename);
        this.testset.setClassIndex(this.testset.numAttributes() - 1);
        //Evaluate model by 10-fold cross-validation
        Random rnd = new Random(1);
        int folds = 10;
        Evaluation eval = new Evaluation(this.trainset);
        eval.crossValidateModel(this.nbayes,this.testset, folds, rnd);
        System.out.println(eval.toSummaryString("\nEvaluation\n-----------------\n",
                false));
    }
    
    public void predictClassLabel(String fileIn, String fileOut) throws Exception{
        // Read the unlabel file
        DataSource ds = new DataSource(fileIn);
        Instances unlabel = ds.getDataSet();
        unlabel.setClassIndex(unlabel.numAttributes() - 1);
        
        //Predict label
        for (int i = 0; i < unlabel.numInstances(); i++) {
            double predict = this.nbayes.classifyInstance(unlabel.instance(i));
            unlabel.instance(i).setClassValue(predict);
        }
        
        //Export into fileOut file
        BufferedWriter outWriter = new BufferedWriter(new FileWriter(fileOut));
        outWriter.write(unlabel.toString());
        outWriter.newLine();
        outWriter.flush();
        outWriter.close();  
    }

    @Override
    public String toString() {
        return this.nbayes.toString();
    }
    
    
}
