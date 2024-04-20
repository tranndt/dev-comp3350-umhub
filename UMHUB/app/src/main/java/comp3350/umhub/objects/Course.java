package comp3350.umhub.objects;


public class Course {
    private String name;
    private String id;
    private String description;
    private int year;
    private String major;

    public Course(String id){
        this.id = id;
    }

    public Course(String id, String name, String desc, int year){
        this.name = name;
        this.id = id;
        description = desc;
        this.year = year;
    }

    public Course(String id, String name, String desc, int year, String major){
        this.id = id;
        this.name = name;
        this.description = desc;
        this.year = year;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public String getMajor(){
        return major;
    }

    public boolean equals(Course other){
        return this.id.equals(other.id);
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", year=" + year +
                ", major=" + major +
                '}';
    }
}
