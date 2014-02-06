package com.ets.servlets;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.ets.classes.MySQLCon;

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
	private String path;

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
		// Get the file location where it would be stored.
		filePath = getServletContext().getInitParameter("Create");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		// Set response content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Check that we have a file upload request
		isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) {
			System.out.println("helloooo");
			return;
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// maximum size that will be stored in memory
		factory.setSizeThreshold(maxMemSize);
		// Location to save data that is larger than maxMemSize.
		factory.setRepository(new File("E:\\temp"));

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		// maximum file size to be uploaded.
		upload.setSizeMax(maxFileSize);

		try {
			System.out.println("in try???");
			// Parse the request to get file items.
			List fileItems = upload.parseRequest(request);

			// Process the uploaded file items
			Iterator i = fileItems.iterator();

			// to get name of the picture
			String fileName = null;
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
				}
				out.println("File Upload DOne");

				// passing to db starts here.......
				path = fileName;
				System.out.println(path);

				try {

					Class.forName("com.mysql.jdbc.Driver");
					Connection con = MySQLCon.connectToDB();
					Statement st = con.createStatement();
					String s = "E:\\data\\" + path;
					System.out.println(s);
					InputStream input = new BufferedInputStream(
							new FileInputStream(s));
					POIFSFileSystem fs = new POIFSFileSystem(input);
					HSSFWorkbook wb = new HSSFWorkbook(fs);
					HSSFSheet sheet = wb.getSheetAt(0);

					Iterator rows = sheet.rowIterator();
					int rowCount = 0;
					while (rows.hasNext()) // to select each row
					{
						HSSFRow row = (HSSFRow) rows.next();
						String rollNo = "";
						String studentName = "";
						String email = "";
						int count = 0; // to count the cells in the row; we need
										// only three column rollNo, Name, email
						Iterator cells = row.cellIterator();
						while (cells.hasNext() && rowCount >= 1) // to move to
																	// the
																	// first
																	// cell in
																	// a row
						{
							HSSFCell cell = (HSSFCell) cells.next();
							if (HSSFCell.CELL_TYPE_STRING == cell.getCellType()) // for
																					// the
																					// cells
																					// containing
																					// string
							{
								if (count == 0) {
									rollNo = cell.getStringCellValue().trim();
									// if(rollNo.subSequence(0,
									// 4).equals("IH20"))
									// //rollNo starts with IH20
									{
										count++;
									}
								} else if (count == 1) {
									studentName = cell.getStringCellValue()
											.trim(); // very
														// next
														// to
														// roll
														// no
														// is
														// student
														// name
									count++;
								}

								else if (count == 2) {
									email = cell.getStringCellValue().trim(); // very
																				// next
																				// to
																				// studentName
																				// is
																				// student
																				// email
									count++;
								}
							}
						}

						String insertStudentDetails = null;
						if (rowCount >= 1) {
							// System.out.println(rollNo+" "+studentName+" "+email);ow
							insertStudentDetails = "insert into ets.ets_student_details set sd_student_id=\""
									+ rollNo
									+ "\" , sd_name=\""
									+ studentName
									+ "\", sd_email=\""
									+ email
									+ "\", sd_password=\"\", sd_dob=\"0000-00-00\", sd_phone=\"\", sd_address=\"\", sd_gender=\"\", sd_admitted_year=\"0000\", sd_program=\"\",sd_status=\"\";";
							System.out.println(insertStudentDetails);
							try {
								st.executeUpdate(insertStudentDetails);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						rowCount++;
					}
				} catch (Exception excep) {
					System.out.println(excep);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
