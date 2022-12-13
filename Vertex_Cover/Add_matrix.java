import java.util.Scanner;

public class Add_matrix {


    public void add_values(Scanner sc, int[][] Varray, int rows, int cols)
    {
        System.out.println("Enter array rep of graph");
          
          for (int i = 0; i < rows; i++)
          {
              for (int j = 0; j < cols; j++)
              {
                 Varray[i][j] = sc.nextInt();
                 if(Varray[i][j]!=1 && Varray[i][j]!=0)
                 {
                	 System.out.println("Wrong Input Given as the adjacency matrix will accept only zeros & ones");
                	 System.exit(0);
                 }
              }
          }

    }
    
}
