package comp3350.umhub.tests.business;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import comp3350.umhub.business.AccessMajors;
import comp3350.umhub.business.IAccessMajors;
import comp3350.umhub.objects.Major;
import comp3350.umhub.persistence.interfaces.IMajorPersistence;
import comp3350.umhub.persistence.stubs.MajorPersistenceStub;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AccessMajorsTest {
    private IAccessMajors accessMajors;

    @Before
    public void setUp() {
        IMajorPersistence persistence = new MajorPersistenceStub();
        accessMajors = new AccessMajors(persistence);

    }


    @Test
    public void testGetMajors()
    {
        final Major major;
        System.out.println("\nStarting test AccessMajors");
        List<Major> majors = accessMajors.getAllMajors();
        assertNotNull("list of major should not be null", majors);
        major = majors.get(0);
        assertNotNull("first sequential major should not be null", major);
        assertEquals("Accounting", major.getName());

        System.out.println("Finished test AccessMajors");
    }




}
