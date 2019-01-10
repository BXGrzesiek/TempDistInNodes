import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader
{
    public static void reader() throws FileNotFoundException
    {

            File file = new File("file.txt");
            Scanner in = new Scanner(file);
            String zdanie = in.nextLine();
            System.out.println(zdanie);
    }
    public static void reader_all() throws FileNotFoundException
    {
        File file = new File("file.txt");
        Scanner in = new Scanner(file);
        for (int i=0; i<file.length(); i++)
        {
            String zdanie = in.next();
            in.nextLine();
            System.out.println(zdanie);
        }
    }
}