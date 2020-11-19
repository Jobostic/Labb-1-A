import java.util.List;

/**
 * An interface containble for all objects that can store/hold other objects.
 */
public interface Containable {

    public List<MyObject> getStorage();

    public int getMaxStorage();

    public void setMaxStorage(int maxStorage);

    public void addObject(MyObject c);

    public MyObject getObject(int i);

    public MyObject removeObject(MyObject c);

}
