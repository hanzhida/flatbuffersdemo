package mapbox1.myapplication;

import com.google.flatbuffers.FBTable;
import com.google.flatbuffers.Index;

import java.util.List;

public class DeveloperModel extends FBTable{
    @Index(id = 0)
    String name;
    @Index(id = 1)
    String id;
    @Index(id = 2)
    boolean isOpen;
    @Index(id = 3)
    int permission;
    @Index(id = 4)
    float temperature;
    @Index(id = 5)
    String outer;
    @Index(id = 6)
    List<String> subList;


}
