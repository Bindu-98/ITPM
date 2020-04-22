package com.itpm;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpload extends HttpServlet {
	 private static final long serialVersionUID = 2841886829265955337L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());

			List<FileItem> multifiles = sf.parseRequest(request);

			for (FileItem item : multifiles) {

				item.write(new File("C:\\Users\\WIN10\\Desktop\\ITPM Maven\\itpmproj\\" + item.getName()));

			}
		} catch (Exception e) {
			System.out.println(e);
		}

		//System.out.println("File Uploaded");

	}

}
