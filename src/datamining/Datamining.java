/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package datamining;

/**
 *
 * @author Tuyet Anh
 */
public class Datamining {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        MyKnoledegeModel model = new MyKnoledegeModel("C:\\Program Files\\Weka-3-9-6\\data\\iris.arff");
        System.out.println(model);
        // model.changedata("C:/Users/Tuyet Anh/Downloads/wind_dataset.csv", "C:/Users/Tuyet Anh/Downloads/wind_dataset.arff");
        // System.out.println("Hi");
        // MyKnoledegeModel model2 = new MyKnoledegeModel("C:\\Users\\Tuyet Anh\\Downloads\\wind_dataset.arff");
        // System.out.println(model2);
        
    }
    
}
