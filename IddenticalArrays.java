import java.util.Scanner;

public class IddenticalArrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] firstArray = new int [3][3];
        int[][] secondArray = new int [3][3];

        System.out.print("Enter m1 (a 3 by 3 matrix) row by row: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                firstArray[i][j] = input.nextInt();
            }
        }    
        System.out.print("Enter m2 (a 3 by 3 matrix) row by row: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                secondArray[i][j] = input.nextInt();
            }
        }
        if (equals(firstArray, secondArray)){
            System.out.println("The two arrays are identical.");
        }else{
            System.out.println("The twoarrays are not identical");
        }
    }

    public static boolean equals(int[][] m1, int[][] m2){
        if (m1.length != m2.length || m1[0].length != m2[0].length) {
            return false;
        }
        
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                if (m1[i][j] != m2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
