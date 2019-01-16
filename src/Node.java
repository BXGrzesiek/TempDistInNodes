public class Node {
    private static int count;
    private int id;
    private int condition;
    Node(int condition)
    {
        this.id = this.count;
        this.condition = condition;
        this.count ++;
    }
    int returnId()
    {
        return this.id;
    }

    int returnCondition()
    {
        return this.condition;
    }
}