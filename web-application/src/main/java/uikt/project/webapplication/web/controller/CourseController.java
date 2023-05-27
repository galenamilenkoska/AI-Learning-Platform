package uikt.project.webapplication.web.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uikt.project.webapplication.model.entities.courses.Course;
import uikt.project.webapplication.service.inteface.ICourseService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Controller
public class CourseController {

    private final ICourseService courseService;

    public CourseController(ICourseService courseService) {
        this.courseService = courseService;
    }

//    @GetMapping("/home")
//    public String index() {
//        return "home.html";
//    }

    @GetMapping("/home")
    public String getCourses(Model model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "home";
    }

    @GetMapping("/courses/{id}")
    public String getCourse(@PathVariable("id") Long id, Model model) {
        Course course = courseService.getCourseById(id);
        model.addAttribute("course", course);
        return "course";
    }

    @PostMapping("/courses")
    public String createCourse(@RequestParam("name") String name,
                               @RequestParam("description") String description,
                               @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                               @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
                               @RequestParam("administratorId") Long administratorId,
                               @RequestParam("instructorId") Long instructorId,
                               @RequestParam("file") MultipartFile file) throws IOException {

        byte[] content = file.getBytes();
        String fileName = file.getOriginalFilename();
        String mimeType = file.getContentType();

        courseService.createCourse(name, description, startDate, endDate, administratorId, instructorId, content, fileName, mimeType);
        return "redirect:/courses";
    }


    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable("id") Long courseId,
                               @RequestBody Course courseDetails) {
        return courseService.updateCourse(courseId, courseDetails);
    }

    @DeleteMapping("/courses/{id}")
    public String deleteCourse(@PathVariable("id") Long id) {
        courseService.deleteCourse(id);
        return "redirect:/courses";
    }

}

//@RestController
//@RequestMapping("/home")
//public class CourseController {
//
//    private final ICourseService courseService;
//
//    public CourseController(ICourseService courseService) {
//        this.courseService = courseService;
//    }
//
//    @GetMapping
//    public List<Course> getAllCourses() {
//        return courseService.getAllCourses();
//    }
//
//    @GetMapping("/{id}")
//    public Course getCourseById(@PathVariable("id") Long courseId) {
//        return courseService.getCourseById(courseId);
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Course createCourse(@RequestParam("name") String name,
//                               @RequestParam("description") String description,
//                               @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
//                               @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
//                               @RequestParam("administratorId") Long administratorId,
//                               @RequestParam("instructorId") Long instructorId,
//                               @RequestParam("file") MultipartFile file) throws IOException {
//
//        byte[] content = file.getBytes();
//        String fileName = file.getOriginalFilename();
//        String mimeType = file.getContentType();
//
//        return courseService.createCourse(name, description, startDate, endDate, administratorId, instructorId, content, fileName, mimeType);
//    }
//
//    @PutMapping("/{id}")
//    public Course updateCourse(@PathVariable("id") Long courseId,
//                               @RequestBody Course courseDetails) {
//        return courseService.updateCourse(courseId, courseDetails);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteCourse(@PathVariable("id") Long courseId) {
//        courseService.deleteCourse(courseId);
//    }
//}
