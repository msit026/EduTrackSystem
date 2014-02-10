package com.ets.classes;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class Mentor {

	private Connection con;
	private String query;
	private Statement st;
	private ResultSet rs;

	public Mentor()// For the Purpose of the database connection
	{
		con = MySQLCon.connectToDB();
		try {
			st = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean isValidUser(String username, String password) {

		try {
			String query = "select md_status from ets_mentor_details where md_mentor_id = '"
					+ username + "' and md_password = '" + password + "' "; // query
																			// for
																			// the
																			// database
			rs = st.executeQuery(query);

			while (rs.next()) {
				if (rs.getString("md_status").equalsIgnoreCase("a")) {
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return false; // if nothing matches or if the user is not approved
	}

	/**
	 * Author Mano
	 *  
	 * It Returns the Courses of all the years
	 * @return
	 */
	public ResultSet showCourses()// Returns courses resultset
	{
		try {
			query = "select * from ets_course_details;";
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * Author Mano
	 * 
	 * It Returns the Grades of the given Student
	 * @param studentId
	 * @return
	 */
	public ResultSet getGrades(String n)// Returns grades of the student
	{
		try {

			query = "select scd.scd_student_id,sd.sd_name,cd.cd_name,scd.scd_grade from ets_student_course_details scd,ets_student_details sd,ets_course_details cd where "
					+ "scd.scd_student_id = sd.sd_student_id"
					+ " and "
					+ "scd.scd_course_id = cd_course_id;";
			System.out.println(query);
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * @author Sneha
	 * 
	 * @param filename
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public ResultSet getMentorDetails(String filename) {
		try {

			String s = "E:\\data\\" + filename;
			System.out.println(s);
			
			InputStream input = new BufferedInputStream(new FileInputStream(s));
			POIFSFileSystem fs = new POIFSFileSystem(input);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);

			Iterator rows = sheet.rowIterator();
			int rowCount = 0;
			while (rows.hasNext()) // to select each row
			{
				HSSFRow row = (HSSFRow) rows.next();
				String mentorId = "";
				String name = "";
				String email = "";
				String department = "";
				int count = 0; // to count the cells in the row; we need only
								// three column rollNo, Name, email
				Iterator cells = row.cellIterator();
				while (cells.hasNext() && rowCount >= 1) // to move to the first
															// cell in a row
				{
					HSSFCell cell = (HSSFCell) cells.next();
					if (HSSFCell.CELL_TYPE_STRING == cell.getCellType()) // for
																			// the
																			// cells
																			// containing
																			// string
					{
						if (count == 0) {
							mentorId = cell.getStringCellValue().trim();
							{
								count++;
							}
						} else if (count == 1) {
							name = cell.getStringCellValue().trim(); // very
																		// next
																		// to
																		// roll
																		// no is
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
						} else if (count == 3) {
							department = cell.getStringCellValue().trim();
							count++;
						}
					}
				}

				if (rowCount >= 1) {
					query = "insert into ets.ets_mentor_details set md_mentor_id=\""
							+ mentorId
							+ "\" , md_name=\""
							+ name
							+ "\", md_email=\""
							+ email
							+ "\", md_password=\"\", md_dob=\"0000-00-00\", md_phone=\"\", md_address=\"\", md_gender=\"\",   md_department=\""
							+ department + "\",md_status=\"\";";
					try {
						st.executeUpdate(query);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				rowCount++;
			}
		} catch (Exception excep) {
			System.out.println(excep);
		}
		return rs;
	}
}