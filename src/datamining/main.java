/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package datamining;

/**
 *
 * @author Tuyet Anh
 */
public class main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
    // Tuyet My
    /**
     * @DecisionTree main
     */
        String filename = "D:\\Project\\Data-mining-project\\Preprocessing\\";
        String trainLocation = filename + "train_data.arff";
        String testLocation = filename + "test_data.arff";
//        String unlabelLocation = filename + "unlabel_data.arff";
//        String predictResult = filename + "predict_j48.arff";
//        J48Model model = new J48Model("", "-C 0.25 -M 2", null);
//        model.buildTree(trainLocation);
//        model.evaluateDecisionTree(testLocation);
//        model.predictClassLabel(unlabelLocation, predictResult);
//        System.out.println(model);
        // Past data: 91.7457 %
        // New data: 91.809
        
    /**
     * @NaiveBayes main
     */
//        String filename = "C:\\Users\\Admin\\OneDrive\\Documents\\NetBeansProjects\\Data-mining-project\\Preprocessing\\";
//        String trainLocation = filename + "train_data.arff";
//        String testLocation = filename + "test_data.arff";
//        String unlabelLocation = filename + "unlabel_data.arff";
//        String predictResult = filename + "predict_nb.arff";
//        NaiveBayesModel model = new NaiveBayesModel();
//        model.buildNaiveBayes(trainLocation);
//        model.evaluateNaiveBayes(testLocation);
//        model.predictClassLabel(unlabelLocation, predictResult);
//        System.out.println(model);
// // Past data: 87.413  %
// New data: 86.7805 %

    /**
     * @SVM main
     */
//        String filename = "C:\\Users\\Admin\\OneDrive\\Documents\\NetBeansProjects\\Data-mining-project\\Preprocessing\\";
//        String trainLocation = filename + "train_data.arff";
//        String testLocation = filename + "test_data.arff";
//        String unlabelLocation = filename + "unlabel_data.arff";
//        String predictResult = filename + "predict_svm.arff";
//
//        SVM_Model model = new SVM_Model("","-C 1.0 -L 0.001 -P 1.0E-12 -N 0 -V -1 -W 1 -K \"weka.classifiers.functions.supportVector.PolyKernel -E 1.0 -C 250007\" -calibrator \"weka.classifiers.functions.Logistic -R 1.0E-8 -M -1 -num-decimal-places 4\"",null);
//        model.buildSVM(trainLocation);
//        model.evaluateSVM(testLocation);
//        model.predictClassLabel(unlabelLocation, predictResult);
//        System.out.println(model); 
// past data : 85.5155 %
// new data: 85.7052 %
/**
     * @RandomForest main
     */   
//        
//        randomforestmodel model = new randomforestmodel("", 
//                                "-P 100 -I 100 -num-slots 1 -K 0 -M 1.0 -V 0.001 -S 1",null);
//        model.buildRandomForest(trainLocation);
//        model.evaluateRandomForest(testLocation);
//        model.predictClassLabel(unlabelLocation, predictResult);
//        model.evaluate("C:\\Users\\Tuyet Anh\\Downloads\\validation_data.arff", "C:\\Users\\Tuyet Anh\\Downloads\\predict_data.arff");
// past data: 92.7894 %
        /**
     * @NeuralNetwork main
     */ 
//        neuralnetworkmodel model = new neuralnetworkmodel("","-L 0.3 -M 0.2 -N 500 -V 0 -S 0 -E 20 -H a", null);
//        model.buildNeuralNetwork(trainLocation);
//        model.evaluateNeuralNetwork(testLocation);
        // past data: 88.172  %
        
          /**
     * @Gradientboosting main
     */
        gradientboostingmodel gb = new gradientboostingmodel("","-P 100 -S 1 -num-slots 1 -I 10 -W weka.classifiers.trees.REPTree -- -M 2 -V 0.001 -N 3 -S 1 -L -1 -I 0.0" , null);
        gb.buildcatboostmodel(trainLocation);
        gb.evaluateXGBoost(testLocation);
        // past data: 91.3978 %
        
        /**
      * @Voting main
     */
        
    }
}
