package comp3350.umhub.business;

import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.application.Services;
import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;
import comp3350.umhub.persistence.interfaces.IProgramPersistence;

public class AccessPrograms implements IAccessPrograms {

    private final IProgramPersistence programPersistence;

    public AccessPrograms() {
        programPersistence = Services.getProgramPersistence();
    }

    public AccessPrograms(final IProgramPersistence persistence) {
        programPersistence = persistence;
    }

    @Override
    public List<Program> getAllPrograms() {
        return programPersistence.getProgramsSequential();
    }

    @Override
    public Program getProgram(String pid) {
        if (pid != null) return programPersistence.getProgram(pid);
        return null;
    }


    @Override
    public List<Program> getProgramsByMajor(Major major) {
        if (major != null) return programPersistence.getProgramsByMajor(major.getName());
        return new ArrayList<>();
    }

    @Override
    public List<Program> getProgramsByCourse(Course course) {
        if (course != null) return programPersistence.getProgramsByCourse(course.getId());
        return new ArrayList<>();
    }
}
