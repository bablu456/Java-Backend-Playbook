import java.util.ArrayList;
import java.util.List;

public final class ImmutableStudent {
    private final String name;
    private final int id;
    private final List<String> skills;

    public ImmutableStudent(String name, int id, List<String> skills) {
        this.name = name;
        this.id = id;
        this.skills = new ArrayList<>(skills);
    }

    public String getName(){return name;}
    public int getId(){return id;}

    public List<String> getSkills(){
        return new ArrayList<>(skills);
    }
}
