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
        String predictResult= filename + "predict.arff";
        
        /**
      * @Voting main
     */
        votingtechniques voting = new votingtechniques("", null, null);
        voting.buildVotingModel(trainLocation );
        voting.evaluateVotingModel(validation);
        J48Model model = new J48Model("", "-C 0.25 -M 2", null);
        model.buildTree(trainLocation);
        model.evaluateDecisionTree(validation);
        
        
    }
}
