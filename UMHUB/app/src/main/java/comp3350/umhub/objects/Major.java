package comp3350.umhub.objects;


public class Major {
    private final String name;

    public Major(String name){
        this.name = name;
    }


    public String getName(){
        return this.name;
    }

    public boolean equals(Major other){
        return this.name.equals(other.name);
    }

    @Override
    public String toString() {
        return "Major{" +
                "name='" + name + '\'' +
                '}';
    }
}
