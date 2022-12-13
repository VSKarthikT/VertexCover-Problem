import java.util.Scanner;

public class Mat_ip
{
    int Rows, Columns;
    int[][] Varray;
    public void ipmatrix()
    {
        Add_matrix AM = new Add_matrix();
        Scanner sc = new Scanner(System.in);
        System.out.println("Rows for matrix rep of graph:"); 
        Rows = sc.nextInt();
        System.out.println("columns for matrix rep of graph"); 
        Columns = sc.nextInt();
        if (Rows != Columns)
        {
            System.out.println("Rows and columns should be equal for graph rep:");
            System.exit(0);
        }
        Varray = new int[Rows][Columns];
        AM.add_values(sc, Varray, Rows, Columns);
    }
    
}
