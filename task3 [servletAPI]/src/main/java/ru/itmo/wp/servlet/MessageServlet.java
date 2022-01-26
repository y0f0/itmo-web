package ru.itmo.wp.servlet;

import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

public class MessageServlet extends HttpServlet {
    ArrayList<MessageInfo> messageInfos = new ArrayList<>();
    private class MessageInfo {
        private final String user;
        private final String text;

        public MessageInfo(String user, String text) {
            this.user = user;
            this.text = text;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        switch (request.getRequestURI()) {
            case "/message/auth": {
                String user = request.getParameter("user");

                request.getSession().setAttribute("user", user == null ? "" : user);

                String json = new Gson().toJson(user);
                response.getWriter().print(json);
                response.getWriter().flush();
                break;
            }
            case "/message/findAll": {
                String json = new Gson().toJson(messageInfos);
                response.getWriter().print(json);
                response.getWriter().flush();
                break;
            }
            case "/message/add": {
                String user = request.getSession().getAttribute("user").toString();
                String text = request.getParameter("text");

                MessageInfo messageInfo = new MessageInfo(user, text);

                messageInfos.add(messageInfo);
                break;
            }
        }
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}

