public class Main extends Grid
{
    public static void main(String[] args)
    {

        System.out.println("Program is working on this-> data: \n\n");
            GlobalData global = new GlobalData();
            global.loadData();
        System.out.println("\n\n");

        //Calculations calc = new Calculations();
        //calc.Calculations();

        Grid grid1 = new Grid();
        grid1.grid(nNode);

        Matrix matrix = new Matrix();
        matrix.utworz();
    }
}