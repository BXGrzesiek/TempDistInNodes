
public class Node extends GlobalData
{
    double t;       // Temperatura w węźle
    int id;            // Identyfikator węzła
    int BC;        // 1-posiada warunek brzegowy 0-nie posiada warunku brzegowego

    public Node(int id,int BC,int t)
    {
        this.id=id;
        this.BC=BC;
        this.t=t;

    }
}
