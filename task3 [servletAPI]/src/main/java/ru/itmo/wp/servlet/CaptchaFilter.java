package ru.itmo.wp.servlet;

import ru.itmo.wp.util.ImageUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Base64;
import java.util.concurrent.ThreadLocalRandom;

public class CaptchaFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (!request.getMethod().equals("GET")) {
            chain.doFilter(request, response);
        } else {
            HttpSession session = request.getSession();
            String sessionCaptcha = (String) session.getAttribute("captcha");
            if (sessionCaptcha == null) {
                sendCaptchaPage(request, response, getNewCaptcha());
            } else if (sessionCaptcha.equals("Correct")) {
                chain.doFilter(request, response);
            } else {
                String inputCaptcha = request.getParameter("input");
                if (inputCaptcha == null) {
                    sendCaptchaPage(request, response, Integer.parseInt(sessionCaptcha));
                } else if (sessionCaptcha.equals(inputCaptcha)) {
                    session.setAttribute("captcha", "Correct");
                    chain.doFilter(request, response);
                } else {
                    sendCaptchaPage(request, response, getNewCaptcha());
                }
            }
        }
    }

    private int getNewCaptcha() {
        int left = 100;
        int right = 999;
        return ThreadLocalRandom.current().nextInt(left, right + 1);
    }

    private void sendCaptchaPage(HttpServletRequest request, HttpServletResponse response, int captchaAnswer)
            throws IOException {
        request.getSession().setAttribute("captcha", Integer.toString(captchaAnswer));

        byte[] imageBytes = ImageUtils.toPng(Integer.toString(captchaAnswer));
        String imageBytesAsBase64InString = new String(Base64.getEncoder().encode(imageBytes));
        String html =
                "<html>" +
                "<head>" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\">" +
                "</head>" +
                "<body>" +
                "<img id=\"profileImage\" src=\"data:image/png;base64, " + imageBytesAsBase64InString + "\">" +
                "<form>" +
                "<label>Enter the captcha:</label>" +
                "<input id=\"input\" name=\"input\">" +
                "</form>" +
                "</body>" +
                "</html>";
        response.setContentType("text/html");
        response.getOutputStream().write(html.getBytes());
        response.getOutputStream().flush();
    }
}