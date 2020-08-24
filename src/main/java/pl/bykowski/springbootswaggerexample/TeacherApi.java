package pl.bykowski.springbootswaggerexample;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api2/teachers")
public class TeacherApi {

    private List<Student> studentList;

    public TeacherApi() {
        this.studentList = new ArrayList<>();
        studentList.add(new Student(1, "Przemek", "Bykowski"));
    }

    @ApiOperation(value = "Find student by id", notes = "provide information about student by id")
    @GetMapping("/{id}")
    public Student getStudents(@ApiParam(value = "unique id of student", example = "123") @PathVariable int id) {
        return studentList.stream()
                .filter(student -> student.getId() == id).findFirst().get();
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentList;
    }


    @PostMapping
    public boolean addStudent(@RequestBody Student student) {
        return studentList.add(student);
    }
}


