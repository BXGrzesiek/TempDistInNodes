public class Main {

    private final static double eps = 1e-12; // stała przybliżenia zera

    public static void main(String[] args) {

        //Data retrived from file
        System.out.println("Program is working on this-> data: \n\n");
        gData global = new gData();
        System.out.println("DANE: ");
        global.loadData();
        newline();


        //GLOBAL DATA
        double s = gData.tmpForFile[0];
        double alfa = gData.tmpForFile[1];
        double l = gData.tmpForFile[2];
        int noNodes = (int) gData.tmpForFile[3];
        double k = gData.tmpForFile[4];
        double q = gData.tmpForFile[5];
        double tInf = gData.tmpForFile[6];



        //Start
        int eCounter = noNodes - 1;


        //Create Nodes
        Node[] nArray = new Node [noNodes];
        for(int i = 0; i< noNodes; i++)
        {
            if(i == 0)
                nArray[i] = new Node(1);
            else if(i== noNodes -1)
                nArray[i] = new Node(2);
            else
                nArray[i] = new Node(0);
        }


        //Create Elements
        Element eArray[] = new Element[eCounter];
        double eLength = l / eCounter;
        //System.out.println(eLength);


        for(int i = 0; i< eCounter; i++) {
            int nIdForElement[] = {nArray[i].returnId(), nArray[i+1].returnId()};

            if(nArray[i].returnCondition() == 1 || nArray[i+1].returnCondition() == 1)
                eArray[i] = new Element(nIdForElement, s, alfa, eLength, k, 1, q, tInf);
            else if(nArray[i].returnCondition() == 2 || nArray[i+1].returnCondition() == 2)
                eArray[i] = new Element(nIdForElement, s, alfa, eLength, k, 2, q, tInf);
            else
                eArray[i] = new Element(nIdForElement, s, alfa, eLength, k, 0, q, tInf);
        }


        //GLOBAL Matrix
        double gMatrix[][] = new double[noNodes][noNodes];

        for(int i=0; i<noNodes; i++) {
            for(int j=0; j<noNodes; j++) {
                gMatrix[i][j] = 0.0;  //inicjuje zerem
            }
        }newline();


        for(int i=0; i < eCounter; i++){
            gMatrix   [eArray[i].node_id[0]]  [eArray[i].node_id[0]]    +=  eArray[i].lMatrix[0][0];
            gMatrix   [eArray[i].node_id[0]]  [eArray[i].node_id[1]]    +=  eArray[i].lMatrix[0][1];
            gMatrix   [eArray[i].node_id[1]]  [eArray[i].node_id[0]]    +=  eArray[i].lMatrix[1][0];
            gMatrix   [eArray[i].node_id[1]]  [eArray[i].node_id[1]]    +=  eArray[i].lMatrix[1][1];
        }
//        System.out.println(eArray[eCounter].lMatrix[1][1]);

//GLOBAL LOAD
        double gLoad[] = new double[10];

        for(int i=0; i < noNodes; i++)
        {
            gLoad[i] = 0;
        }

        for(int i=0; i < eCounter; i++){
            if(eArray[i].lLoad[0] != 0){
                gLoad[0] = eArray[i].lLoad[0];
            }
            if(eArray[i].lLoad[1] != 0){
                gLoad[noNodes-1] = eArray[i].lLoad[1];
            }
        }


        //TEMPERATURE - GAUSS JORDAN
        double tmpMatrixForGauss[][] = new double[noNodes][noNodes];
        double globalTemperature[]  = new double[noNodes];
        for( int i = 0; i < noNodes; i++) tmpMatrixForGauss[i] = new double[noNodes + 1];

        for(int i=0; i < noNodes; i++)
        {
            for(int j=0; j < noNodes+1; j++)
            {
                if(j == noNodes)
                {
                    tmpMatrixForGauss[i][j] = -gLoad[i];
                } else
                {
                    tmpMatrixForGauss[i][j] = gMatrix[i][j];
                }
            }
        }

        gauss(noNodes, tmpMatrixForGauss, globalTemperature);


        // Display Local Elements
        for(int i=0; i<eCounter ; i++){
            System.out.print("Element: " + i + " consists of nodes " + eArray[i].node_id[0] + " and " + eArray[i].node_id[1] + " items.\n");
            eArray[i].drawMatrix();
            newline();
        }newline();
        //wyświetlenie gotowej macierzy

//        double tmp_c = (s * k) / eLength;

        // Display global matrix with loads
        System.out.println("GLOBAL MATRIX:");
        for(int i=0; i<noNodes; i++){
            //System.out.print("| \t");
            for(int j=0; j<noNodes; j++){

//                if (j==noNodes-1)
//                {
//                    System.out.print(gMatrix[i][j] + tmp_c + (alfa * s));
//                }else {
                    System.out.print(gMatrix[i][j] + "\t\t");
//                }
            }
            System.out.print("\t\t{ " + gLoad[i] + " }");
            newline();
        }newline();
        newline();

        //Display Temperature
        System.out.println("TEMPERATURE VECTOR \n");

        for(int i=0; i < noNodes; i++){
            System.out.println("Temperature in the node " + i + " is : "  + globalTemperature[i]);
        }
    }

    public static boolean gauss(int n, double[][] AB, double[] X) {
        double m,s;

        // eliminacja współczynników
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                if(Math.abs(AB[i][i]) < eps) return false;
                m = -AB[j][i] / AB[i][i];
                for(int k = i + 1; k <= n; k++)
                    AB[j][k] += m * AB[i][k];
            }
        }

        // wyliczanie niewiadomych
        for(int i = n - 1; i >= 0; i--) {
            s = AB[i][n];
            for(int j = n - 1; j >= i + 1; j--)
                s -= AB[i][j] * X[j];
            if(Math.abs(AB[i][i]) < eps) return false;
            X[i] = s / AB[i][i];
        } return true;
    }

    public static void newline(){
        System.out.println();
    }
}