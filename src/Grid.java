public class Grid extends GlobalData
{
    public static int nElements;

    void grid(int nNode)
    {
        this.nNode = nNode;
        nElements = nNode - 1;
        System.out.println("Number of Elements: "+ nElements);

    }

}