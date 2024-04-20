package comp3350.umhub.tests.objects;

import org.junit.Test;

import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.TutorEntry;

import static org.junit.Assert.assertEquals;

public class TutorEntryTest {

    @Test
    public void testTutor(){
        TutorEntry tutorEntry1, tutorEntry2;

        System.out.println("\nStarting testTutor");

        tutorEntry1 = new TutorEntry("Naruto","nuzumaki@myumanitoba.ca","COMP 3350","Professor");
        assertEquals(tutorEntry1.getName(),"Naruto");
        assertEquals(tutorEntry1.getEmail(),"nuzumaki@myumanitoba.ca");
        assertEquals(tutorEntry1.getCourse(),"COMP 3350");
        assertEquals(tutorEntry1.getType(),"Professor");
        assertEquals(tutorEntry1.displayName(),"Professor Naruto");


        System.out.println("Finished testTutor");

    }
}
