package com.itpm;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

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

				item.write(new File("C:\\Users\\WIN10\\git\\ITPM_REPO\\itpmproj\\Uploaded Files\\" + item.getName()));

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		File htmlFile = new File("C:\\Users\\WIN10\\git\\ITPM_REPO\\itpmproj\\Choose\\index.html");
		Desktop.getDesktop().browse(htmlFile.toURI());

		//System.out.println("File Uploaded");

	}

}
