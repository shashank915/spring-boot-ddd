//package com.ace.registration;
//
//import CourseId;
//import StudentId;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//public class RegisterTest {
//@Test
//    public void checkRegistrationValidTest()
//    {
//        List<Register> list=new ArrayList<Register>();
//        for(int i=1;i<=10;i++)
//        {
//            list.add(new Register(new StudentId(i+0L),new CourseId(8L)));
//        }
//        Register register=new Register(new StudentId(9L),new CourseId(9L));
//        Assert.assertNull(register.getStatus());
//        register.checkRegistrationValid(list);
//        Assert.assertNotNull(register.getStatus());
//        Assert.assertEquals("waiting",register.getStatus());
//
//
//        List<Register> list1=new ArrayList<Register>();
//        for(int i=1;i<10;i++)
//        {
//            list1.add(new Register(new StudentId(i+0L),new CourseId(8L)));
//        }
//        Register register1=new Register(new StudentId(10L),new CourseId(11L));
//        register1.checkRegistrationValid(list1);
//        Assert.assertEquals("approved",register1.getStatus());
//
//    }
//
//    public void checkCourseSelectionAllowTest()
//    {
//       List<Register> list=IntStream.range(1,5).mapToObj(x->new Register(new StudentId(x+0L),new CourseId(9L))).collect(Collectors.toList());
//       /* List<Register> list=new ArrayList<Register>();
//        for(int i=1;i<5;i++)
//        {
//            list.add(new Register(new StudentId(12L),new CourseId(i+0L)));
//        }*/
//        Register register=new Register(new StudentId(9L),new CourseId(9L));
//        Assert.assertEquals(true,register.checkCourseSelectionAllow(list));
//
//List<Register> list1=IntStream.rangeClosed(1,5).mapToObj(x->new Register(new StudentId(12L),new CourseId(x+0L))).collect(Collectors.toList());
//
//        /*List<Register> list1=new ArrayList<Register>();
//        for(int i=1;i<=5;i++)
//        {
//            list.add(new Register(new StudentId(12L),new CourseId(i+0L)));
//        }*/
//        Register register1=new Register(new StudentId(9L),new CourseId(9L));
//        Assert.assertEquals(false,register1.checkCourseSelectionAllow(list));
//
//
//    }
//}
