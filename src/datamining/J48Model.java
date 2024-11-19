/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datamining;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
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
        Evaluation eval = new Evaluation(this.trainset);
        eval.evaluateModel(tree, this.testset);
        System.out.println(eval.toSummaryString("\n Evaluation\n-------------\n",
                false));
    }
    
    @Override
    public String toString() {
        return tree.toSummaryString();
    }
    
}
