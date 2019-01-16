public class Matrix {

    public static int nrows = GlobalData.nNode;
    public static int ncols = GlobalData.nNode;
    public static int[][] data;

//    public void matrix(int nNode) {
//        ncols = nNode;
//        nrows = nNode;
//    }

    public int[][] utworz()
    {
        this.data = new int[this.ncols][this.nrows];
        int j;
        for (int i = 0; i < this.ncols; i++)
        {
            System.out.print("| ");
            for (j= 0; j < this.nrows; j++)
            {
                this.data[i][j] = 0;
                System.out.print(this.data[i][j]);
            }
            System.out.println(" |");
        }
        return this.data;
    }
}