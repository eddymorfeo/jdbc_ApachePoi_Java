package mysql;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class Main {

	public static void main(String[] args) {

		System.out.println("INICIO");

		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Verdulero", "root",
					"C3ntaur0.123");

			// SELECT
			PreparedStatement preparedStatement = conexion.prepareStatement("SELECT * FROM usuario");
			ResultSet resultSet = preparedStatement.executeQuery();

			ArrayList<String> listaNombres = new ArrayList<String>();

			while (resultSet.next()) {
				System.out.println(resultSet.getInt("idUsuario"));
				System.out.println(resultSet.getString("nombre"));
				listaNombres.add(resultSet.getString("nombre"));
			}

			// INSERT
//            preparedStatement = conexion.prepareStatement("INSERT INTO USUARIO VALUES (?,?)");
//            preparedStatement.setString(1, null);
//            preparedStatement.setString(2, "Claudio Sandoval");
//            preparedStatement.executeUpdate();

			// UPDATE
//            preparedStatement = conexion.prepareStatement("UPDATE USUARIO SET NOMBRE = 'Jose' WHERE IdUsuario = 1");
//            preparedStatement.executeUpdate();
			// DELETE O TRUNCATE
//            preparedStatement = conexion.prepareStatement("TRUNCATE TABLE USUARIO");
//            preparedStatement.executeUpdate();
			Workbook workbook = new XSSFWorkbook();
			Sheet sheet = workbook.createSheet("Hoja Prueba");

			// FILA 1
			Row row = sheet.createRow(0);

			for (int i = 0; i < listaNombres.size(); i++) {
				Cell cell7 = row.createCell(i);
				cell7.setCellValue(listaNombres.get(i));

			}

//            Cell cell = row.createCell(0);
//            cell.setCellValue("nombre 1");
//            
//            Cell cell2 = row.createCell(1);
//            cell2.setCellValue("nombre 2");
//            
//            Cell cell3 = row.createCell(2);
//            cell3.setCellValue("nombre 3");
			// FILA 2
//            Row row1 = sheet.createRow(1);
//            Cell cell4 = row1.createCell(0);
//            cell4.setCellValue(listaNombres.get(0));
//            
//            Cell cell5 = row1.createCell(1);
//            cell5.setCellValue(listaNombres.get(1));
//            
//            Cell cell6 = row1.createCell(2);
//            cell6.setCellValue(listaNombres.get(2));
			File file = new File("Archivo de Prueba.xlsx");
			FileOutputStream fileoutputstream = new FileOutputStream(file);

			workbook.write(fileoutputstream);
			conexion.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("e = " + e.getMessage());
		}

		System.out.println("FIN");
	}
}