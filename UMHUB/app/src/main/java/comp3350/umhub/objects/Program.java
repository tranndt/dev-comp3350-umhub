package comp3350.umhub.objects;

public class Program {
    private final String name;
    private String major;

    public Program(String name, String major){
        this.name = name;
        this.major = major;
    }


    public String getName() {
        return name;
    }

    public String getMajor(){
        return major;
    }

    public boolean equals(Program other)
    {
        return this.name.equals(other.name);
    }

    @Override
    public String toString() {
        return "Program{" +
                "name='" + name + '\'' +
                ", major=" + major +
                '}';
    }
}
