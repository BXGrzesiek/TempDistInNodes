import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GlobalData
{
    public static int k;
    public static int alfa;
    public static int S;
    public static int L;
    public static int q;
    public static double c;
    public static int nNode;
//    public static double L_1;
//    public static double L_2;
//    public int t_inf;


    public void loadData()
    {
        try
        {
            Scanner scanner = new Scanner(new File("plik.txt"));
            nNode = scanner.nextInt();             scanner.nextLine();
            System.out.println("Number of Nodes \t=\t"+nNode);
            k = scanner.nextInt();              scanner.nextLine();
            System.out.println("Variable k \t\t\t= \t"+k);
            L = scanner.nextInt();              scanner.nextLine();
            System.out.println("Variable L \t\t\t= \t"+L);
            alfa = scanner.nextInt();           scanner.nextLine();
            System.out.println("Variable alfa \t\t= \t"+alfa);
            S = scanner.nextInt();              scanner.nextLine();
            System.out.println("Variable S \t\t\t= \t"+S);
            q = scanner.nextInt();              scanner.nextLine();
            System.out.println("Variable q \t\t\t= \t"+q);

//            L_1 = scanner.nextDouble();         scanner.nextLine();
//            System.out.println("Variable L_1 \t\t= \t"+L_1);
//            L_2 = scanner.nextDouble();         scanner.nextLine();
//            System.out.println("Variable L_2 \t\t= \t"+L_2);
//            t_inf = scanner.nextInt();          scanner.nextLine();
//            System.out.println("t_inf \t= \t"+t_inf);
//            c=(S*k/L_1);
//            int C = (int) c;
//            System.out.println("C \t\t= \t" + C);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}