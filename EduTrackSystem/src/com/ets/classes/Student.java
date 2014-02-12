package com.ets.classes;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class Student {

	private Connection con;
	private String query;
	private Statement st;
	private ResultSet rs;
	private String userName;

	public Student() {
		con = MySQLCon.connectToDB();
		try {
			st = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean isValidUser(String username, String password) {
		try {
			String query = "select sd_status from ets_student_details where sd_student_id = '"
					+ username + "' and sd_password = '" + password + "' "; // query
																			// for
																			// the
																			// database
			rs = st.executeQuery(query);
			while (rs.next()) {
				if (rs.getString("sd_status").equalsIgnoreCase("a")) {
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return false; // if nothing matches
	}
	
	/**
	 * Author Mano
	 * 
	 * It Returns the registered Students list
	 * @return
	 */
	public ResultSet getRegisteredStudentsList() {
		try {
			query = "select * from ets_student_details where sd_status = 'a'";
			rs = st.executeQuery(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * Author Mano
	 * 
	 * It Returns the UnRegistered Students List
	 * @return
	 */
	public ResultSet getUnRegisteredStudents()
	{
		try {
			query = "select * from ets_student_details where sd_status = 'p'";
			rs = st.executeQuery(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * @Author Sneha
	 * 
	 * @param filename
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public ResultSet getStudentDetails(String filename) {
		try {
			
			String s = "E:\\data\\" + filename;
			
			InputStream input = new BufferedInputStream(new FileInputStream(s));
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
							rollNo = cell.getStringCellValue().trim();
							{
								count++;
							}
						} else if (count == 1) {
							studentName = cell.getStringCellValue().trim(); // very
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

				if (rowCount >= 1) {
					query = "insert into ets.ets_student_details set sd_student_id=\""
							+ rollNo
							+ "\" , sd_name=\""
							+ studentName
							+ "\", sd_email=\""
							+ email
							+ "\", sd_password=\"\", sd_dob=\"0000-00-00\", sd_phone=\"\", sd_address=\"\", sd_gender=\"\",  sd_status=\"\", sd_year_in_course=\"0\";";
					try {
						st.executeUpdate(query);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				rowCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet getAllDetails(String username) {
		HashMap<String,String> map = new HashMap<String,String>();
		try {
			String query = "select * from ets_student_details where sd_student_id = '"
					+ username + "'"; // query
																			// for
																			// the
																			// database
			rs = st.executeQuery(query);
			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null; // if nothing matches
	}
	
	public ResultSet getSelectedYearStudents(String year) {
		try {
			query = "select sd_student_id from ets_student_details where sd_year_in_course = "
					+ year;
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet getFeedBackNotifications(String userName) {
		System.out.println("user name: " + userName);
		try {
			query = "select * from ets_mentor_feedback where mf_open_status = 'notopen' and mf_student_id = '" + userName + "';";
			System.out.println(query);
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}