// NAME : ROHIT CHOUDHARY
//REG NO. : 2400031478
package com.example.Course_S7;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findByTitleContaining(String title);
}
