package labPolymorphism;
/*
 * Name: Mick Zeller
 * Date: March 15,2015
 * */
public class CircusDog extends Dog
{
    public CircusDog(String b)
    {
        super(b);
    }

    @Override
    public void move()
    {
        System.out.println("tightrope walking");
    }
}
