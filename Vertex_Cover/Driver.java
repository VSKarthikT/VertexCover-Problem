public class Driver
{
    public static void main(String[] args) 
    {
        Mat_ip MI = new Mat_ip();
        Vcover VC = new Vcover();
        int min = 7 , index = 0;
        MI.ipmatrix();
        // Creating empty 2-D matrix 
        int[][] Mat = MI.Varray;
        int val[] = new int [MI.Rows];
        for (int i=0; i<MI.Rows; i++)
        {
            val[i] = VC.ver_cover(i, Mat, MI.Rows);
            if(val[i]<= min)
            {
            	min = val[i];
            	index = i+1;
            }
        }
        System.out.println("\nOptimal Solution found by starting at vertex = " +index+ " and by choosing edges = " +min+ " in total");
    }
}