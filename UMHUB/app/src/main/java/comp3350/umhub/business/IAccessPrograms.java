package comp3350.umhub.business;


import java.util.List;

import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;

public interface IAccessPrograms {
    List<Program> getAllPrograms();
    Program getProgram(String pid);
    List<Program> getProgramsByMajor(Major major);
    List<Program> getProgramsByCourse(Course course);
}