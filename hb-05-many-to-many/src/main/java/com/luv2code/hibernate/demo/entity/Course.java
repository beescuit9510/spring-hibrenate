package com.luv2code.hibernate.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString(exclude = {"instructor", "reviews","students"})
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    @NonNull
    private String title;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Review> reviews;


    // when delete
//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH
//            })
//    @JoinTable(name = "course_student",
//            joinColumns = @JoinColumn(name = "course_id"),
//            inverseJoinColumns = @JoinColumn(name = "student_id"))
    @ManyToMany(mappedBy = "courses",
                fetch = FetchType.LAZY,
                cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}
    )
    private List<Student> students;


    public void addReview(Review review) {
        if (reviews == null) {
            reviews = new ArrayList<>();
        }
        reviews.add(review);
    }


    public void addStudent(Student student) {
        if(students == null){
            students = new ArrayList<>();
        }
        students.add(student);
        student.getCourses().add( this );
    }

    public void removeStudent(Student student) {
        if(students == null){
            students = new ArrayList<>();
        }
        students.remove(student);
        student.getCourses().remove( this );
    }
}
