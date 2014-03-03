package com.ets.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.ets.classes.Attendance;
import com.ets.classes.Course;
import com.ets.classes.Grades;
import com.ets.classes.Mentor;
import com.ets.classes.Student;

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

	@SuppressWarnings({ "rawtypes", "unused" })
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
					}
				}
			}
			System.out.println(fileType);
			if (fileType.equals("studentDetails")) {
				Student student = new Student();
				student.getStudentDetails(fileName);
				out.println("<html>" + "<script>"
						+ "alert('successfully uploded');" + "</script>"
						+ "</html>");
				
				RequestDispatcher dispatch = request
						.getRequestDispatcher("adminHomePage.jsp");
				dispatch.include(request, response);
			} else if (fileType.equals("mentorDetails")) {
				Mentor mentor = new Mentor();
				mentor.getMentorDetails(fileName);
				out.println("<html>" + "<script>"
						+ "alert('successfully uploded');" + "</script>"
						+ "</html>");
				
				RequestDispatcher dispatch = request
						.getRequestDispatcher("adminHomePage.jsp");
				dispatch.include(request, response);
			} else if (fileType.equals("courseDetails")) {
				Course course = new Course();
				course.getCourseDetails(fileName);
				out.println("<html>" + "<script>"
						+ "alert('successfully uploded');" + "</script>"
						+ "</html>");
				
				RequestDispatcher dispatch = request
						.getRequestDispatcher("adminHomePage.jsp");
				dispatch.include(request, response);
			} else if (fileType.equals("attendance")) {
				Attendance attendance = new Attendance();
				attendance.getAttendanceDetails(fileName);
				out.println("<html>" + "<script>"
						+ "alert('successfully uploded');" + "</script>"
						+ "</html>");
				
				RequestDispatcher dispatch = request
						.getRequestDispatcher("adminHomePage.jsp");
				dispatch.include(request, response);
			} else if (fileType.equals("grades")) {
				Grades grade = new Grades();
				grade.getGradeDetails(fileName);
				out.println("<html>" + "<script>"
						+ "alert('successfully uploded');" + "</script>"
						+ "</html>");
				
				RequestDispatcher dispatch = request
						.getRequestDispatcher("adminHomePage.jsp");
				dispatch.include(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
