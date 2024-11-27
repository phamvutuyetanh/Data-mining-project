package datamining;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.SMO;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author Tuyet My
 */
public class SVM_Model extends functions{
    SMO svm;

    public SVM_Model() {
    }

    public SVM_Model(String filename, String m_options, String d_options) throws Exception {
        super(filename, m_options, d_options);
    }
    
    public void buildSVM(String filename) throws Exception{
        // Input train set
        setTrainset(filename);
        this.trainset.setClassIndex(this.trainset.numAttributes() - 1);
        // Train model
        this.svm = new SMO();
        svm.setOptions(this.model_options);
        svm.buildClassifier(this.trainset);
    }
    
    public void evaluateSVM(String filename) throws Exception{
        // Input test set
        setTestset(filename);
        this.testset.setClassIndex(this.testset.numAttributes() - 1);
        //Evaluate model by 10-fold cross-validation
        Random rnd = new Random(1);
        int folds = 10;
        Evaluation eval = new Evaluation(this.trainset);
        eval.crossValidateModel(this.svm,this.testset, folds, rnd);
        
        // Print basic evaluation metrics
        System.out.println(eval.toSummaryString("\nEvaluation\n-----------------\n", false));
        // Print precision, recall, F1-score, and other class details
        System.out.println(eval.toClassDetailsString("\nClass Details\n-----------------\n"));
    }
    
    public void predictClassLabel(String fileIn, String fileOut) throws Exception{
        // Read the unlabel file
        DataSource ds = new DataSource(fileIn);
        Instances unlabel = ds.getDataSet();
        unlabel.setClassIndex(unlabel.numAttributes() - 1);
        
        //Predict label
        for (int i = 0; i < unlabel.numInstances(); i++) {
            double predict = this.svm.classifyInstance(unlabel.instance(i));
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
        return this.svm.toString();
    }
    
}
