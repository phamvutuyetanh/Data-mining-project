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
        
        functions Model = new functions("Preprocessing\\train_data.arff", null, null);
        Model.trainset = Model.dividedatatraditional(Model.dataset, 20,false);
        Model.testset = Model.dividedatatraditional(Model.dataset,20, true);
        System.out.print(Model);
        System.out.println(Model.trainset.toSummaryString());
        System.out.println(Model.testset.toSummaryString());
    }
    
}
