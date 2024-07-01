import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.util.StringTokenizer;

class InvalidDataException extends Exception{
    void message(){
        System.out.println("Invalid data exception has occured");
    }
}

class DataProcessor{
    public List<Double> readValuesFromFile(String filePath) throws FileNotFoundException, IOException, InvalidDataException{
        List<Double> values = new ArrayList<>();
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br =new BufferedReader(fr);
            String line=null;
            while((line=br.readLine())!=null){
                StringTokenizer st = new StringTokenizer(line," ");
                while (st.hasMoreTokens()){
                    String token = st.nextToken();
                    try {
                        double value = Double.parseDouble(token);
                        values.add(value);
                    }
                    catch (NumberFormatException e) {
                        throw new InvalidDataException();
                    }   
                }
            }
        }  
        catch(FileNotFoundException fnf){
            throw new FileNotFoundException();
        }     
        catch(IOException e) {
            throw new IOException();
        }
        return values;
    }
       
    public List<Double> validateData(List<Double> values) throws InvalidDataException {
        List<Double> validValues = new ArrayList<>();
        for (Double value : values) {
            if (value == null || value.isNaN()) {
                throw new InvalidDataException();
            } else {
                validValues.add(value);
            }
        }
        return validValues;
    }  
    double calculateAverage(List<Double> validValues){
        double sum = 0, i=0;
        for (Double value : validValues) {
            sum += value;
            i++;
        }
        return (sum / i);
    }
    void writeResultToFile(double average, String outputPath) throws IOException{
        try {
            FileWriter fw = new FileWriter(outputPath);
            fw.write("Average: "+ average);
            fw.close();
        }
        catch(IOException IOe){
            throw new IOException();
        }
    }
}
public class calculateAverage_From_File {
    public static void main(String[] args) {
        List<Double> values = new ArrayList<>();
        DataProcessor dp = new DataProcessor();
        Scanner input = new Scanner(System.in);
        String text;
        try {
            FileWriter f = new FileWriter("W6Q1ReadFile.txt");
            System.out.print("Enter text in file: ");
            text = input.nextLine();
            f.write(text);
            f.close();
            System.out.println("Text written successfully");
            values = dp.readValuesFromFile("W6Q1ReadFile.txt");
            dp.validateData(values);
            double avg = dp.calculateAverage(values);
            dp.writeResultToFile(avg, "W6Q1WriteFile.txt");
        }
        catch(InvalidDataException iDE){
            iDE.message();
        }
        catch(FileNotFoundException fNFE){
            System.out.println("FileNotFound Exception has occured.");
        }
        catch(IOException iOE){
            System.out.println("IO Exception has occured.");
        }
    }
}