import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GlobalData
{

    public int k;
    public int alfa;
    public int S;
    public int L;
    public double L_1;
    public double L_2;
    public int q;
    public int t_inf;
    public double c;

    public void loadData()
    {
        try
        {
            Scanner scanner = new Scanner(new File("plik.txt"));
            k = scanner.nextInt();              scanner.nextLine();
            System.out.println("k \t\t= \t"+k);
            alfa = scanner.nextInt();           scanner.nextLine();
            System.out.println("alfa \t= \t"+alfa);
            S = scanner.nextInt();              scanner.nextLine();
            System.out.println("S \t\t= \t"+S);
            L = scanner.nextInt();              scanner.nextLine();
            System.out.println("L \t\t= \t"+L);
            L_1 = scanner.nextDouble();         scanner.nextLine();
            System.out.println("L_1 \t= \t"+L_1);
            L_2 = scanner.nextDouble();         scanner.nextLine();
            System.out.println("L_2 \t= \t"+L_2);
            q = scanner.nextInt();              scanner.nextLine();
            System.out.println("q \t\t= \t"+q);
            t_inf = scanner.nextInt();          scanner.nextLine();
            System.out.println("t_inf \t= \t"+t_inf);
            c=(S*k/L_1);
            int C = (int) c;
            System.out.println("C = " + C);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}