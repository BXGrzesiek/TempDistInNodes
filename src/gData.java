import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class gData extends Main
{
    public static double tmpForFile[] = new double[7];

    public void loadData()
    {
        try
        {
            Scanner scanner = new Scanner(new File("plik.txt"));
            tmpForFile[0] = scanner.nextInt();              scanner.nextLine();
            System.out.println("Variable S \t\t\t= \t"+ tmpForFile[0]);
            tmpForFile[1] = scanner.nextInt();           scanner.nextLine();
            System.out.println("Variable alfa \t\t= \t"+ tmpForFile[1]);
            tmpForFile[2]= scanner.nextInt();              scanner.nextLine();
            System.out.println("Variable L \t\t\t= \t"+ tmpForFile[2]);
            tmpForFile[3] = scanner.nextInt();             scanner.nextLine();
            System.out.println("Number of Nodes \t=\t"+ tmpForFile[3]);
            tmpForFile[4] = scanner.nextInt();              scanner.nextLine();
            System.out.println("Variable k \t\t\t= \t"+ tmpForFile[4]);
            tmpForFile[5] = scanner.nextInt();              scanner.nextLine();
            System.out.println("Variable q \t\t\t= \t"+ tmpForFile[5]);
            tmpForFile[6] = scanner.nextInt();              scanner.nextLine();
            System.out.println("Variable t_inf \t\t= \t"+ tmpForFile[6]);

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}