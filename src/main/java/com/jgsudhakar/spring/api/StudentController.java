package com.jgsudhakar.spring.api;

import com.jgsudhakar.spring.iface.StudentIFace;
import com.jgsudhakar.spring.req.StudentReqDto;
import com.jgsudhakar.spring.res.StudentResDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.api.StudentController
 * @Date : 09/10/2020
 */
@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentIFace studentIFace;

    @GetMapping("/")
    public List<StudentResDto> getStuList(HttpSession httpSession) {
        return studentIFace.getStudentList();
    }

    @PostMapping(value = "/confirmstudent",consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public StudentReqDto getData (HttpSession httpSession, HttpServletResponse response, @RequestBody StudentReqDto studentReqDto) {
      String sessionId = httpSession.getId();
      System.out.println("Http Session Id::"+sessionId);
      httpSession.setAttribute(sessionId,studentReqDto);
      response.setHeader("token",sessionId);
      return studentReqDto;
    }

    @PostMapping(value = "/save",consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public StudentReqDto saveStudent (HttpServletRequest request, @RequestHeader(name = "token",required = true) String token) throws Exception {
      StudentReqDto studentReqDto =(StudentReqDto)request.getSession().getAttribute(token);
      if(null == studentReqDto)
          throw new Exception("INVALID_TOKEN");
      studentIFace.save(studentReqDto);
      return studentReqDto;
    }

    @GetMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public StudentResDto saveStudent (@PathVariable(name = "id") Long id) throws Exception {
        StudentResDto studentDetails = studentIFace.getStudentDetails(id);
        return studentDetails;
    }
    @DeleteMapping(value = "/")
    public void deleteSession (HttpServletRequest request) throws Exception {
        //invalidate the session , this will clear the data from configured database (Mysql/redis/hazelcast)
        request.getSession().invalidate();
    }

}
