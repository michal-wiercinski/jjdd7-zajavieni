package com.isa.zajavieni.oauth;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.AuthorizationCodeResponseUrl;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.servlet.auth.oauth2.AbstractAuthorizationCodeCallbackServlet;
import com.google.api.services.oauth2.Oauth2;
import com.google.api.services.oauth2.model.Userinfoplus;
import com.isa.zajavieni.dto.UserDto;
import com.isa.zajavieni.provider.TemplateProvider;
import com.isa.zajavieni.service.UserService;
import java.io.IOException;
import java.util.UUID;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/oauth2callback")
public class Oauth2CallbackServlet extends AbstractAuthorizationCodeCallbackServlet {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @EJB
  UserService userService;

  @EJB
  OauthBuilder oauthBuilder;

  @Inject
  private TemplateProvider templateProvider;

  @Override
  protected void onSuccess(HttpServletRequest req, HttpServletResponse resp, Credential credential)
      throws ServletException, IOException {

    Oauth2 oauth2 = oauthBuilder.buildOauth(credential);
    Userinfoplus info = oauth2.userinfo().get().execute();
    String name = info.getName();
    String email = info.getEmail();
    req.getSession().setAttribute("google_name", name);
    req.getSession().setAttribute("email", email);
    resp.sendRedirect("/");

    if (!userService.ifExist(email)) {
      UserDto user = new UserDto();
      user.setName(name);
      user.setEmail(email);
      userService.createNewUser(user);
      logger.info("User for name: {} has been save in base.", user.getName());
    }

  }

  @Override
  protected void onError(HttpServletRequest req, HttpServletResponse resp,
      AuthorizationCodeResponseUrl errorResponse) throws ServletException, IOException {
    super.onError(req, resp, errorResponse);
  }

  @Override
  protected AuthorizationCodeFlow initializeFlow() throws ServletException, IOException {
    return GoogleLoginCommons.buildFlow();
  }

  @Override
  protected String getRedirectUri(HttpServletRequest httpServletRequest)
      throws ServletException, IOException {
    return GoogleLoginCommons.buildRedirectUri(httpServletRequest);
  }

  @Override
  protected String getUserId(HttpServletRequest httpServletRequest)
      throws ServletException, IOException {
    return UUID.randomUUID().toString();
  }
}
