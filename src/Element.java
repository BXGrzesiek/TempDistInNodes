public class Element extends gData {

    public static int count = 0;
    public int id;
    public int node_id[];
    public double area;
    public double tConductivity;
    public double length;
    public double lMatrix[][] = new double[2][2]; // [2][2]
    public double lLoad[] = new double[2];     // [2]

    public Element(int node_id[], double varS, double varAlfa, double varL, double varK, int node_bigger_condition, double varQ, double varTInf)
    {
        this.id = count;
        this.node_id = node_id;
        this.area = varS;
        this.tConductivity = varAlfa;
        this.length = varL;
        count++;


        //Local Matrix
        double tmp_c = (varS * varK) / varL;
        this.lMatrix[0][0] = tmp_c;
        this.lMatrix[0][1] = tmp_c * -1;
        this.lMatrix[1][0] = tmp_c * -1;
        this.lMatrix[1][1] = tmp_c;

        if (node_bigger_condition == 2)
        {
            this.lMatrix[1][1] = tmp_c + (varAlfa * varS);
        } else {
            this.lMatrix[1][1] = tmp_c;
        }


        //Local Load
        if (node_bigger_condition == 0) {
            this.lLoad[0] = 0;
            this.lLoad[1] = 0;
        }

        if (node_bigger_condition == 1) {
            this.lLoad[0] = varQ * varS;
            this.lLoad[1] = 0;
        }

        if (node_bigger_condition == 2) {
            this.lLoad[0] = 0;
            this.lLoad[1] = (varAlfa * varS * varTInf)*-1;
        }
    }




    public void drawMatrix() {
        for (double[] aLMatrix : lMatrix) {
            for (double anALMatrix : aLMatrix) {
                System.out.print(anALMatrix + " \t");
            }
            System.out.println();
        }
    }
}