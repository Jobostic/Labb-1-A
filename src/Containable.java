import java.util.Collection;
import java.util.List;

/**
 * An interface containble for all objects that can store/hold other objects.
 */
public interface Containable {



    public List<PhysicalObject> getStorage();

    public int getMaxStorage();

    public void setMaxStorage(int maxStorage);

    public void addObject(PhysicalObject c);

    public PhysicalObject getObject(int i);

    public PhysicalObject removeObject(PhysicalObject c);

}
