package ru.itmo.wp.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayList;

public class StaticServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<File> requestFiles = getRequestFiles(request);
        if (requestFiles == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        response.setContentType(getContentTypeFromName(requestFiles.get(0).getPath()));
        OutputStream outputStream = response.getOutputStream();
        for (File requestFile : requestFiles) {
            Files.copy(requestFile.toPath(), outputStream);
        }
        outputStream.flush();
    }

    private ArrayList<File> getRequestFiles(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        String[] uris = requestURI.split("\\+");
        ArrayList<File> requestFiles = new ArrayList<>();

        for (String uri : uris) {
            if (!uri.startsWith("/")) {
                uri = "/" + uri;
            }
            File srcFile =  new File(new File(getServletContext().getRealPath("")).getParentFile().getParentFile(),
                    "/src/main/webapp/static" + uri);
            File staticFile = new File(getServletContext().getRealPath("/static") + uri);
            if (srcFile.isFile()) {
                requestFiles.add(srcFile);
            } else if (staticFile.isFile()) {
                requestFiles.add(staticFile);
            } else {
                return null;
            }
        }
        return requestFiles;
    }

    private String getContentTypeFromName(String name) {
        name = name.toLowerCase();

        if (name.endsWith(".png")) {
            return "image/png";
        }

        if (name.endsWith(".jpg")) {
            return "image/jpeg";
        }

        if (name.endsWith(".html")) {
            return "text/html";
        }

        if (name.endsWith(".css")) {
            return "text/css";
        }

        if (name.endsWith(".js")) {
            return "application/javascript";
        }

        throw new IllegalArgumentException("Can't find content type for '" + name + "'.");
    }
}
