package comp3350.umhub.persistence.interfaces;

import java.util.List;

import comp3350.umhub.objects.Major;

public interface IMajorPersistence {
    List<Major> getMajorsSequential();
    Major getMajor(String majorName);



}