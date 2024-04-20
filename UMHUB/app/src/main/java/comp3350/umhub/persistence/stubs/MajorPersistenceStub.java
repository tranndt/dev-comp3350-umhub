package comp3350.umhub.persistence.stubs;

import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.objects.Major;
import comp3350.umhub.persistence.interfaces.IMajorPersistence;

public class MajorPersistenceStub implements IMajorPersistence {
    private List<Major> majors;

    public MajorPersistenceStub(){
        this.majors = new ArrayList<>();
        majors.add(new Major("Accounting"));
        majors.add(new Major("Computer Science"));
        majors.add(new Major("Engineering"));
        majors.add(new Major("Mathematics"));
        majors.add(new Major("Philosophy"));
        majors.add(new Major("Social Work"));
    }

    @Override
    public List<Major> getMajorsSequential(){
        return majors ;
    }

    @Override
    public Major getMajor(String majorName) {
        Major major = null;
        for (Major p : majors) {
            if (p.getName() == majorName){
                major = p;
                break;
            }
        }
        return major;
    }
}
