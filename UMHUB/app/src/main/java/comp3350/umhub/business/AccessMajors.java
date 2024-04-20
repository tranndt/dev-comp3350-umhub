package comp3350.umhub.business;


import java.util.List;

import comp3350.umhub.application.Services;
import comp3350.umhub.objects.Major;
import comp3350.umhub.persistence.interfaces.IMajorPersistence;

public class AccessMajors implements IAccessMajors {

    private final IMajorPersistence majorPersistence;

    public AccessMajors() {
        majorPersistence = Services.getMajorPersistence();
    }
    public AccessMajors(final IMajorPersistence persistence) {
        majorPersistence = persistence;
    }


    @Override
    public Major getMajor(String majorId) {
        if (majorId != null) return majorPersistence.getMajor(majorId);
        return null;
    }

    @Override
    public List<Major> getAllMajors() {
        return majorPersistence.getMajorsSequential();
    }
}
