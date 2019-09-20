package com.isa.zajavieni.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

@WebServlet("/oauth2callback")
@SuppressWarnings("serial")
public class Oauth2CallbackServlet extends HttpServlet {

    private static final Collection<String> SCOPES = Arrays.asList("id", "email");
    private static final String USERINFO_ENDPOINT
            = "https://www.googleapis.com/plus/v1/people/me/openIdConnect";
    private static final JsonFactory JSON_FACTORY = new JacksonFactory();
    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

    private GoogleAuthorizationCodeFlow flow;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,
            ServletException {

        // Ensure that this is no request forgery going on, and that the user
        // sending us this connect request is the user that was supposed to.
        if (req.getSession().getAttribute("state") == null
                || !req.getParameter("state").equals((String) req.getSession().getAttribute("state"))) {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.sendRedirect("/main");
            return;
        }

        req.getSession().removeAttribute("state");     // Remove one-time use state.

        flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT,
                JSON_FACTORY,
                getServletContext().getInitParameter("client.id"),
                getServletContext().getInitParameter("client.secret"),
                SCOPES).build();

        final TokenResponse tokenResponse =
                flow.newTokenRequest(req.getParameter("code"))
                        .setRedirectUri(getServletContext().getInitParameter("/oauth2callback"))
                        .execute();

        req.getSession().setAttribute("token", tokenResponse.toString()); // Keep track of the token.
        final Credential credential = flow.createAndStoreCredential(tokenResponse, null);
        final HttpRequestFactory requestFactory = HTTP_TRANSPORT.createRequestFactory(credential);

        final GenericUrl url = new GenericUrl(USERINFO_ENDPOINT);      // Make an authenticated request.
        final HttpRequest request = requestFactory.buildGetRequest(url);
        request.getHeaders().setContentType("application/json");

        final String jsonIdentity = request.execute().parseAsString();
        @SuppressWarnings("unchecked")
        HashMap<String, String> userIdResult =
                new ObjectMapper().readValue(jsonIdentity, HashMap.class);
        // From this map, extract the relevant profile info and store it in the session.
        req.getSession().setAttribute("userEmail", userIdResult.get("email"));
        req.getSession().setAttribute("userId", userIdResult.get("sub"));
        req.getSession().setAttribute("userImageUrl", userIdResult.get("picture"));
        resp.sendRedirect((String) req.getSession().getAttribute("loginDestination"));
    }
}
