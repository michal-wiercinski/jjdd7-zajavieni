package com.isa.zajavieni.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isa.zajavieni.dto.UserDto;
import com.isa.zajavieni.service.UserService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

  @EJB
  UserService userService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String email = req.getSession().getAttribute("email").toString();
    Optional<UserDto> user = userService.getUserByEmail(email);
    ObjectMapper objectMapper = new ObjectMapper();
    if (user.isPresent()) {
      String json = objectMapper.writeValueAsString(user.get());
      resp.getWriter().println(json);
    } else {
      resp.setStatus(404);
    }

  }
}
