package comp3350.umhub.tests.business;

import org.junit.Before;
import org.junit.Test;

import java.util.List;


import comp3350.umhub.application.Services;
import comp3350.umhub.business.IAccessMajors;
import comp3350.umhub.objects.Major;
import comp3350.umhub.persistence.sqlite.MajorSQLDB;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AccessMajorsIT {
    private IAccessMajors accessMajors;


    @Before
    public void setUp(){
        this.accessMajors = Services.getAccessMajors();
    }

    @Test
    public void getMajorsTest(){

        System.out.println("\n Starting Access Majors integration test - getMajors");
        List<Major> majors  =accessMajors.getAllMajors();

        assertNotNull("Majors list should not be null", majors);
        assert(majors.size()!=0);
        assertTrue("Accounting".equals(majors.get(0).getName()));

        System.out.println("Finished Access Majors integration test - getMajors");

    }


}
