public class GaussJordan
{
    double dzielnik;
    int n = 4;

    void gaussJordan()
    {

//        double data[Matrix.ncols][Matrix.nrows]
//        {
//            {    2,  1,  1,  1, 0   },
//            {   -1, -2, -1,  1, 1   },
//            {    1,  1, -2, -3, 2   },
//            {    0,  4, -2,  4, 2   },
//            {    0,  4, -3,  4, 2   },
//        };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //Gauss Jordan:

                if (i == j)
                    continue;

                //Gauss:
                //if(i>=j)
                //continue;

                dzielnik = Matrix.data[j][i] / Matrix.data[i][i];
                for (int k = 0; k < n + 1; k++) {
                    //Matrix.data[j][k] = Matrix.data[j][k] - dzielnik * Matrix.data[i][k];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.println(" " + Matrix.data[i][j] + " ");
                if (j + 1 == 5) {
                    System.out.println("\n");
                }
            }
        }

        return 0;
    }
}
