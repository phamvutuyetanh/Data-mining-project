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
        
        gradientboostingmodel model = new gradientboostingmodel("", 
                                "-P 100 -S 1 -num-slots 1 -I 10 -W weka.classifiers.trees.REPTree -- -M 2 -V 0.001 -N 3 -S 1 -L -1 -I 0.0",
        null);
        model.buildcatboostmodel("C:\\Users\\Tuyet Anh\\OneDrive - VietNam National University - HCM INTERNATIONAL UNIVERSITY\\Documents\\Weka_data\\train_data.arff");
      //  System.out.println("Hi");
        model.evaluateXGBoost("C:\\Users\\Tuyet Anh\\OneDrive - VietNam National University - HCM INTERNATIONAL UNIVERSITY\\Documents\\Weka_data\\test_data.arff");
        model.predictClassLabel("C:\\Users\\Tuyet Anh\\OneDrive - VietNam National University - HCM INTERNATIONAL UNIVERSITY\\Documents\\Weka_data\\unlabel_data.arff", "C:\\Users\\Tuyet Anh\\OneDrive - VietNam National University - HCM INTERNATIONAL UNIVERSITY\\Documents\\Weka_data\\predict_data_gd.arff");
        model.evaluate("C:\\Users\\Tuyet Anh\\OneDrive - VietNam National University - HCM INTERNATIONAL UNIVERSITY\\Documents\\Weka_data\\actual_data.arff", "C:\\Users\\Tuyet Anh\\OneDrive - VietNam National University - HCM INTERNATIONAL UNIVERSITY\\Documents\\Weka_data\\predict_data_gd.arff");
    }
    
}
