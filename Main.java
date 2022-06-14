import java.io.*;
import java.util.Random;

/***************************************************************
 Filename: ComparingFromFile
 Created by: melat
 Created on: 18/02/2022
 Comment: Comparing the time complexity, while and for loop, to get the average value from external file
 ***************************************************************/
public class Main {
    public static void main(String[] args) {

        fileWriter("Comparing.txt");
        System.out.println("Average using for loop " + averageValue("Comparing.txt"));
        System.out.println("Average using while loop " + averageUsingWhile("Comparing.txt"));
    }

    private static void fileWriter(String fileName) {
        Random rand = new Random(0);
        int size = 1000;
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            for (int i = 0; i < size; i++) {
                int num = rand.nextInt(1000) + 1;
                pw.println(num);
            }
            pw.close();
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }//fileWriter()

    //this method returns average value from the "comparison.txt" file 
    //Time Complexity = 4N + 6
    private static int averageValue(String fileName) {
        int sum = 0, size = 1000;
        try {
            FileReader fr = new FileReader(fileName); //1
            BufferedReader br = new BufferedReader(fr);//1

            for (int i = 0; i < size; i++) { //N
                String reader = br.readLine(); //N
                int num = Integer.parseInt(reader); //N
                sum += num; //N
            }
            br.close(); //1
            fr.close(); //1

        } catch (Exception e) { //1
            System.out.println(e);
        }
        return sum / size; //1
    }

    private static int averageUsingWhile(String fileName){

        //Time Complexity = 4N + 5
        int sum = 0, count = 0; //1
        try {
            FileReader fr = new FileReader(fileName); //1
            BufferedReader br = new BufferedReader(fr); //1
            String line = br.readLine(); //1
            while (line != null){ //N
                int num = Integer.parseInt(line); //N
                sum+= num; //N
                count++; //N
                line = br.readLine(); //N
            }
        } catch (Exception e) {
            System.out.println(e); //N
        }
        return sum / count; //1
    }

}
