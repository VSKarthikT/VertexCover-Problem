public class Vcover {
    public int ver_cover(int ver, int Mat[][], int Rows)
    {
        int arr[][] = new int [Rows][Rows];
        int counter,maximum=0;
        int c1=0,row,col;
        int count = 0; 
        int min=Rows;
        int deg[] = new int [Rows];
        int ver_maxdeg[] = new int [Rows];
        int vertex_cover[] = new int[Rows];
        int left=0,right;
        for(row=0; row<Rows; row++)
        {
            for(col=0; col<Rows; col++)
            {
                arr[row][col]=Mat[row][col];
            }
        }
        //removing the incident edges from corresponding vertex
        for(col=0; col<Rows; col++)
        {
            if(arr[ver][col]==1)
            {
                arr[ver][col]=0;
                arr[col][ver]=0;
            }
        }
        //till all the edges are deleted from the vertex
        while(true)
        {
            int l=0;
            int c2=0;
            for(row=0; row<Rows; row++)
            {
                counter=0;
                for(col=0; col<Rows; col++)
                {
                    if(arr[row][col]==1)
                    {
                        c2++;
                        counter++;
                    }
                }
                deg[row]=counter;
            }
            //if all edges are successfully deleted from the vertex then stop
            if(c2==0)
            break;
            //finding the maximum degree
            maximum=deg[0];
            for(row=1; row<Rows; row++)
            {
                if(maximum<deg[row])
                maximum=deg[row];
            }
            //finding the vertices of maximum degree
            for(row=0; row<Rows; row++)
            {
                if(maximum==deg[row])
                	ver_maxdeg[l++]=row;
            }
            /*Choosing the vertex that has at least one edge which is not covered by others which is having maximum number of edges.
            Otherwise choosing an arbitrary edge.*/
            for(row=0; row<l; row++)
            {
                c1=0;
                for(col=0; col<Rows; col++)
                {
                    if(arr[ver_maxdeg[row]][col]==1)
                    {
                        for(right=0; right<l; right++)
                        {
                            if(col==ver_maxdeg[right])
                            c1++;
                        }
                    }
                }
                
                if(c1<maximum)
                break;
            }
            if(row==l)
            row=0;
            vertex_cover[left++]=ver_maxdeg[row];
            //remove the incident edges of selected vertex
            for(col=0; col<Rows; col++)
            {
                if(arr[ver_maxdeg[row]][col]==1)
                {
                    arr[ver_maxdeg[row]][col]=0;
                    arr[col][ver_maxdeg[row]]=0;
                }
            }
        }
        vertex_cover[left++]=ver;
        //printing the vertex cover
        int tempvrtx = ver + 1;
        System.out.println("\n vertex cover of v=" + tempvrtx);
        System.out.print(" {");
        count = 0;
        for(row=0;row<left;row++)
        {
            int temp = vertex_cover[row] + 1;
            System.out.print(" " + temp);
            count++;
        }
        System.out.println("}");
        if(count < min)
        	min = count;
        return min;
    }
}
