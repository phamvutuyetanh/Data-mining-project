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
        String filename = "New_data\\";
        String trainLocation = filename + "train_data.arff";
        String train2= filename+ "unlabel_data.arff";
        String testLocation = filename + "test_data.arff";
        String validation= filename+ "validation_data.arff";
//        String predictResult= filename + "predict.arff";
//        J48Model model = new J48Model("", "-C 0.25 -M 2", null);
//        model.buildTree(trainLocation);
//        model.evaluateDecisionTree(testLocation);
//        model.predictClassLabel(unlabelLocation, predictResult);
//        System.out.println(model);
    /**
     * @NaiveBayes main
     */
//        String filename = "C:\\Users\\Admin\\OneDrive\\Documents\\NetBeansProjects\\Data-mining-project\\Preprocessing\\";
//        String trainLocation = filename + "train_data.arff";
//        String testLocation = filename + "test_data.arff";
//        String unlabelLocation = filename + "unlabel_data.arff";
//        String predictResult = filename + "predict_nb.arff";
//        NaiveBayesModel model = new NaiveBayesModel("", "-D", null);
//        model.buildNaiveBayes(trainLocation);
//        model.evaluateNaiveBayes(testLocation);
//        model.predictClassLabel(unlabelLocation, predictResult);
//        System.out.println(model);


    /**
     * @SVM main
     */
//        String filename = "C:\\Users\\Admin\\OneDrive\\Documents\\NetBeansProjects\\Data-mining-project\\Preprocessing\\";
//        String trainLocation = filename + "train_data.arff";
//        String testLocation = filename + "test_data.arff";
//        String unlabelLocation = filename + "unlabel_data.arff";
//        String predictResult = filename + "predict_svm.arff";
//
//        SVM_Model model = new SVM_Model("","-C 20.0 -L 0.001 -P 1.0E-12 -N 0 -V -1 -W 1 -K \"weka.classifiers.functions.supportVector.RBFKernel -C 250007 -G 0.01\" -calibrator \"weka.classifiers.functions.Logistic -R 1.0E-8 -M -1 -num-decimal-places 4\"",null);
//        model.buildSVM(trainLocation);
//        model.evaluateSVM(testLocation);
//        model.predictClassLabel(unlabelLocation, predictResult);
//        System.out.println(model); 


    // Tuyet Anh
/**
     * @RandomForest main
     */   
//        
//        randomforestmodel model = new randomforestmodel("", 
//                                "-P 100 -I 100 -num-slots 1 -K 0 -M 1.0 -V 0.001 -S 1",null);
//        model.buildRandomForest(trainLocation);
//        model.evaluateRandomForest(testLocation);
//        model.predictClassLabel(unlabelLocation, predictResult);
//        model.evaluate("C:\\Users\\Tuyet Anh\\Downloads\\label_data.arff", "C:\\Users\\Tuyet Anh\\Downloads\\predict_j48.arff");
        /**
     * @NeuralNetwork main
     */ 
//        neuralnetworkmodel model = new neuralnetworkmodel("","-L 0.3 -M 0.2 -N 500 -V 0 -S 0 -E 20 -H a", null);
//        model.buildNeuralNetwork(trainLocation);
//        model.predictClassLabel(unlabelLocation, predictResult);
//        model.evaluateNeuralNetwork(testLocation);

        
          /**
     * @Gradientboosting main
     */
//        gradientboostingmodel gb = new gradientboostingmodel("","-P 100 -S 1 -num-slots 1 -I 10 -W weka.classifiers.trees.RandomForest -- -P 100 -I 100 -num-slots 1 -K 0 -M 1.0 -V 0.001 -S 1" , null);
//        gb.buildgradientboostmodel(trainLocation);
//        //gb.predictClassLabel(unlabelLocation, predictResult);
//        gb.evaluateBoost(testLocation);

        
        /**
      * @Voting main
     */
//        votingtechniques voting = new votingtechniques("", null, null);
//        voting.buildVotingModel(trainLocation );
//        voting.evaluateVotingModel(testLocation);
        
        // Dinh Hang
        votingtechniques voting = new votingtechniques("", null, null);
        voting.buildVotingModel(trainLocation );
        System.out.println("Performance of voting");
        voting.evaluateVotingModel(validation);
        J48Model model = new J48Model("", "-C 0.25 -M 2", null);
        model.buildTree(trainLocation);
        System.out.println("Performance of J48");
        model.evaluateDecisionTree(validation);
        
    
        
    }
}
