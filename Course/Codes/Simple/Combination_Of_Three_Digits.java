import java.util.Scanner;
public class Combination_Of_Three_Digits {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter three digits(between 0-9): ");
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        int arr[] = {a,b,c};
        System.out.print("Possible combinations: ");
        for(int i=0; i<3;i++){
            for(int j=0; j<3; j++){
                for(int k=0; k<3; k++){
                    if(i!=j && j!=k && k!=i)
                        System.out.print(arr[i]+""+arr[j]+""+arr[k]+"  ");
                }
            }
        }
    }
}
