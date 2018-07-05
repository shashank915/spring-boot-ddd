//package com.ace.registration.model;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//public class StudentTest {
//
//@Test
//    public void registerTest()
//    {
//        Student student =new Student("Amit",new StudentId(6L));
//
//        List<Register> list1=IntStream.range(1,5).mapToObj(x->new Register(new StudentId(12L),new CourseId(x+0L))).collect(Collectors.toList());
//
//        Assert.assertEquals(true,(student.register(new CourseId(5),list1)).isRight());
//
//
//        Assert.assertNotNull(student.register(new CourseId(7L),list1));
//
//        List<Register> list2=IntStream.rangeClosed(1,5).mapToObj(x->new Register(new StudentId(12L),new CourseId(x+0L))).collect(Collectors.toList());
//
//        Assert.assertEquals(true,(student.register(new CourseId(5),list2)).isLeft());
//
//    }
//}
