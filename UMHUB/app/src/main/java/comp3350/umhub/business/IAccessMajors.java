package comp3350.umhub.business;

import java.util.List;

import comp3350.umhub.objects.Major;

public interface IAccessMajors {
    Major getMajor(String majorId);
    List<Major> getAllMajors();
}
