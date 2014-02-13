package com.ets.classes;

/**
 * @author Mani
 * 
 */
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

public class Course {

	private Connection con;
	private String query;
	private Statement st;
	private ResultSet rs;

	public Course() {
		con = MySQLCon.connectToDB();
		try {
			st = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author Sneha
	 * It returns the details of the courses from the database
	 * 
	 * @param filename
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public ResultSet getCourseDetails(String filename) {
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
				String courseId = "";
				String name = "";
				double credits = 0;
				double duration = 0;
				double year = 0;
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
							courseId = cell.getStringCellValue().trim();
								count++;
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

						else if (count == 2)

						{
							System.out.println("in2 ");
							credits = cell.getNumericCellValue(); // very next
																	// to
																	// studentName
																	// is
																	// student
																	// email
							count++;
						} else if (count == 3) {
							System.out.println("in3 ");
							duration = cell.getNumericCellValue(); // very next
																	// to
																	// studentName
																	// is
																	// student
																	// email
							count++;
						} else if (count == 4) {
							System.out.println("in4 ");
							year = cell.getNumericCellValue(); // very next to
																// studentName
																// is student
																// email
							count++;
						}
					} else {
						if (count == 0) {
							courseId = cell.getStringCellValue().trim();
							count++;
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

						else if (count == 2)

						{
							System.out.println("in2 ");
							credits = cell.getNumericCellValue(); // very next
																	// to
																	// studentName
																	// is
																	// student
																	// email
							count++;
						} else if (count == 3) {
							System.out.println("in3 ");
							duration = cell.getNumericCellValue(); // very next
																	// to
																	// studentName
																	// is
																	// student
																	// email
							count++;
						} else if (count == 4) {
							System.out.println("in4 ");
							year = cell.getNumericCellValue(); // very next to
																// studentName
																// is student
																// email
							count++;
						}
					}
				}

				if (rowCount >= 1) {
					query = "insert into ets.ets_course_details set cd_course_id=\""
							+ courseId
							+ "\" , cd_name=\""
							+ name
							+ "\", cd_credits=\""
							+ credits
							+ "\", cd_duration=\""
							+ duration
							+ "\", cd_course_year=\"" + year + "\";";
					System.out.println(query);
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
	
	public ResultSet getCourseDetails()
	{
		try {
			System.out.println("hiiii  courses");
			query = "select * from  ets_course_details cd ";
			System.out.println(query);
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
		
	}
}
