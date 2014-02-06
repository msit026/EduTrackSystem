package com.ets.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.ets.classes.CourseDetails;
import com.ets.classes.MentorDetails;
import com.ets.classes.StudentDetails;

/**
 * Servlet implementation class BasicPageServlet
 */
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private boolean isMultipart;
	private String filePath;
	private int maxFileSize = 500 * 1024;
	private int maxMemSize = 40 * 1024;
	private File file;
	String path;

	/**
	 * @throws SQLException
	 * @see HttpServlet#HttpServlet()
	 */
	public FileUploadServlet() throws SQLException {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	public void init() {
		filePath = getServletContext().getInitParameter("Create");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String fileType = null;

		// Check that we have a file upload request
		isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) {
			return;
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();

		factory.setSizeThreshold(maxMemSize);// maximum size that will be stored
												// in memory

		factory.setRepository(new File("E:\\temp"));// Location to save data
													// that is larger than
													// maxMemSize.

		ServletFileUpload upload = new ServletFileUpload(factory);// Create a
																	// new file
																	// upload
																	// handler

		upload.setSizeMax(maxFileSize);// maximum file size to be uploaded.

		try {
			List fileItems = upload.parseRequest(request);// Parse the request
															// to get file
															// items.
			// Process the uploaded file items
			Iterator i = fileItems.iterator();

			String fileName = null;// to get name of the File
			// to get all the fields in the HTML file request
			while (i.hasNext()) {
				FileItem fi = (FileItem) i.next(); // getting each file item one
													// after other
				if (!fi.isFormField()) {
					// Get the uploaded file parameters
					String fieldName = fi.getFieldName(); // content field name
					fileName = fi.getName(); // content value of file i.e name
												// of the path selected
					String contentType = fi.getContentType();
					boolean isInMemory = fi.isInMemory();
					long sizeInBytes = fi.getSize();
					// Write the file
					if (fileName.lastIndexOf("\\") >= 0) { // to get the path
															// existence folder
						file = new File(
								filePath
										+ fileName.substring(fileName
												.lastIndexOf("\\")));
					} else {
						file = new File(
								filePath
										+ fileName.substring(fileName
												.lastIndexOf("\\") + 1));
					}
					fi.write(file); // writing the path into the file location
				} else {
					if (fi.getFieldName().equals("type")) {
						fileType = fi.getString();
						out.println(fileType);
					}
				}
			}
			out.println("File Upload DOne");

			path = fileName;
			System.out.println(path);
			System.out.println("type is " + fileType);

			if (fileType.equals("StudentDetails")) {
				StudentDetails student = new StudentDetails();
				student.getStudentDetails(path);
			} else if (fileType.equals("MentorDetails")) {
				MentorDetails mentor = new MentorDetails();
				mentor.getMentorDetails(path);
			} else if (fileType.equals("CourseDetails")) {
				CourseDetails course = new CourseDetails();
				course.getCourseDetails(path);
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
