package comp3350.umhub.persistence.interfaces;

import java.util.List;

import comp3350.umhub.objects.Program;

public interface IProgramPersistence {
    List<Program> getProgramsSequential();
    Program getProgram(String pid);

    List<Program> getProgramsByMajor(String myMajor);

    List<Program> getProgramsByCourse(String course);

}
