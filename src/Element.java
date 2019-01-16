public class Element
{
    public static int nElements;
    public static int idElement;

    void elementInfo(int idElement)
    {
        this.idElement = idElement;
        for (int i = 0; i < nElements; i++)
        {
            System.out.println("Element No: " + Element.idElement);
        }
    }

    void showElements(int nElements)
    {
        this.nElements = nElements;
        Element element = new Element();
        element.elementInfo(idElement);
    }
}