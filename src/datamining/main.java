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
     */
    public static void main(String[] args) throws Exception {
        
        randomforestmodel model = new randomforestmodel("", 
                                "-P 100 -I 100 -num-slots 1 -K 0 -M 1.0 -V 0.001 -S 1",null);
        model.buildRandomForest("C:\\Users\\Tuyet Anh\\Downloads\\train_data.arff");
       // System.out.println("Hi");
        model.evaluateRandomForest("C:\\Users\\Tuyet Anh\\Downloads\\test_data.arff");
        model.predictClassLabel("C:\\Users\\Tuyet Anh\\Downloads\\unlabel_data.arff", "C:\\Users\\Tuyet Anh\\Downloads\\predict_data.arff");
        model.evaluate("C:\\Users\\Tuyet Anh\\Downloads\\validation_data.arff", "C:\\Users\\Tuyet Anh\\Downloads\\predict_data.arff");
    }
    
}
