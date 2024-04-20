package comp3350.umhub.persistence.stubs;

import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.objects.Program;
import comp3350.umhub.persistence.interfaces.IProgramPersistence;

public class ProgramPersistenceStub implements IProgramPersistence {
    List<Program> programs;

    public ProgramPersistenceStub(){
        this.programs = new ArrayList<>();
        String major1 = "Computer Science";
        String major2 = "Engineering";
        String major3 = "Mathematics";
        String major4 = "Accounting";
        programs.add(new Program("Computer Science General",major1));
        programs.add(new Program("Computer Science - Math Joint Honors",major1));
        programs.add(new Program("Computer Science - Physics Joint Honors",major1));
        programs.add(new Program("Computer Science - Philosophy Joint Honors",major1));
        programs.add(new Program("Computer Science Honors, Coop",major1));
        programs.add(new Program("Physics - Math Joint Honors",major3));
        programs.add(new Program("Math is fun program",major3));
        programs.add(new Program("Math is not fun program",major3));
        programs.add(new Program("Civil Engineering",major2));
        programs.add(new Program("Mechanical Engineering",major2));
        programs.add(new Program("Engineering program 3",major2));
        programs.add(new Program("Engineering program 4",major2));
        programs.add(new Program("Accounting program 1",major4));
        programs.add(new Program("Accounting program 2",major4));
        programs.add(new Program("Accounting program 3",major4));

    }

    @Override
    public List<Program> getProgramsSequential() {
        return programs;
    }

    @Override
    public Program getProgram(String pid) {
        Program program = null;
        for (Program p : programs) {
            if (p.getName() == pid){
                program = p;
                break;
            }
        }
        return program;
    }

    @Override
    public List<Program> getProgramsByMajor(String myMajor) {
        List<Program> programList = new ArrayList<>();
        for (Program p : programs) {
            if (p.getMajor() == myMajor){
                programList.add(p);
            }
        }
        return programList;
    }

    @Override
    public List<Program> getProgramsByCourse(String course) {
        return new ArrayList<>();
    }
}
