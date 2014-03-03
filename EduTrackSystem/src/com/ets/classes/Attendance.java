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

public class Attendance {

	private Connection con;
	private String query;
	private Statement st;
	private ResultSet rs;

	public Attendance() {
		con = MySQLCon.connectToDB();
		try {
			st = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author Ujvala
	 * 
	 * It gets the Attendance Details of the students
	 * @param path
	 */
	public void getAttendanceDetails(String path) {
		try {
			path = "E:\\data\\" + path;

			InputStream input = new BufferedInputStream(new FileInputStream(path));
			POIFSFileSystem fs = new POIFSFileSystem(input);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);

			Iterator rows = sheet.rowIterator();
			int rowCount = 0;
			while (rows.hasNext()) // to select each row
			{
				HSSFRow row = (HSSFRow) rows.next();
				String rollNo = "";
				double latehours = 0;
				double absentdays = 0;
				String mentor = null;
				double leave = 0;
				int count = 0; // to count the cells in the row; we need only
								// three column rollNo, Name, email
				Iterator cells = row.cellIterator();

				while (cells.hasNext() && rowCount >= 1) // to move to the first
															// cell in a row
				{
					HSSFCell cell = (HSSFCell) cells.next();
					System.out.println(HSSFCell.CELL_TYPE_STRING + "......."
							+ cell.getCellType());
					if (HSSFCell.CELL_TYPE_STRING == cell.getCellType()) // for
																			// the
																			// cells
																			// containing
																			// string
					{
						if (count == 0) {
							System.out.println("testing " + count);
							mentor = (String) cell.getStringCellValue().trim();
							count++;
						} else if (count == 1) {
							System.out.println("testing " + count);
							rollNo = cell.getStringCellValue().trim(); // very
																		// next
																		// to
																		// roll
																		// no is
																		// student
																		// name
							count++;
						} else if (count == 2) {
							System.out.println("testing........ " + count);
							leave = cell.getNumericCellValue(); // very next to
																// roll no is
																// student name
							count++;
						} else if (count == 3) {
							absentdays = cell.getNumericCellValue(); // very
																		// next
																		// to
																		// studentName
																		// is
																		// student
																		// email
							count++;
						} else if (count == 4) {
							latehours = cell.getNumericCellValue(); // very next
																	// to
																	// studentName
																	// is
																	// student
																	// email
							count++;
						}
					} else {
						if (count == 0) {
							mentor = cell.getStringCellValue().trim(); // very
																		// next
																		// to
																		// roll
																		// no is
																		// student
																		// name
							count++;
						} else if (count == 1) {

							rollNo = cell.getStringCellValue().trim(); // very
																		// next
																		// to
																		// roll
																		// no is
																		// student
																		// name
							count++;
						} else if (count == 2) {
							System.out.println("testing........ " + count);
							leave = cell.getNumericCellValue(); // very next to
																// roll no is
																// student name
							count++;
						} else if (count == 3) {
							absentdays = cell.getNumericCellValue(); // very
																		// next
																		// to
																		// studentName
																		// is
																		// student
																		// email
							count++;
						} else if (count == 4) {
							latehours = cell.getNumericCellValue(); // very next
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

					query = "insert into ets.ets_attendance_details values( '"
							+ rollNo
							+ "','"
							+ mentor
							+ "','November','"
							+ leave
							+ "','"
							+ latehours
							+ "','"
							+ absentdays
							+ "')";
					
					//query = "insert into ets_attendance_details (scd_student_id,scd_course_id,scd_grade,scd_year,scd_total)values ( '"+studentId+"', '"+courseId+"','"+grade+"','"
						//	+ year +",'"+total+"') on duplicate key update scd_grade = '"+grade+"', scd_year = '"+year+"', scd_total = "+ total +";";
					System.out.println(query);
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
	}
}
