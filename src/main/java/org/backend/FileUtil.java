package org.backend;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.backend.models.EmployeeRequest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FileUtil {

    String filePath = "./data/";


    public List<EmployeeRequest>  getTestData(String excelFilePath) throws IOException
    {

        List<EmployeeRequest> listEmployees = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(new File(filePath+excelFilePath));
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();

        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            EmployeeRequest employeeRequest = createEmployeeRequest();
            while (cellIterator.hasNext()) {
                Cell nextCell = cellIterator.next();
                int columnIndex = nextCell.getColumnIndex();
                switch (columnIndex) {
                    case 0:
                        employeeRequest.setEmployee_firstname(nextCell.getStringCellValue());
                        break;
                    case 1:
                        employeeRequest.setEmployee_lastname(nextCell.getStringCellValue());
                        break;
                    case 2:
                        employeeRequest.setEmployee_phonenumbe(nextCell.getStringCellValue());
                        break;
                    case 3:
                        employeeRequest.setAdemployee_emaildress(nextCell.getStringCellValue());
                        break;
                }
            }
            listEmployees.add(employeeRequest);
        }
        workbook.close();
        inputStream.close();
        return listEmployees;
    }

    private EmployeeRequest createEmployeeRequest(){
        EmployeeRequest employeeRequest = new EmployeeRequest();
        employeeRequest.setCreatedAt(1648601996);
        employeeRequest.setEmployee_firstname("Mickey");
        employeeRequest.setEmployee_lastname("Mouse");
        employeeRequest.setEmployee_phonenumbe("586-956-4902");
        employeeRequest.setAdemployee_emaildress("mickey_mouse@gmail.com");
        employeeRequest.setCitemployee_addressy("Durham");
        employeeRequest.setStateemployee_dev_level("101");
        employeeRequest.setEmployee_onleave(false);
        employeeRequest.setEmployee_hire_date(new Date());
        return employeeRequest;

    }
     public static void main(String...strings) throws IOException{
         FileUtil fileUtil = new FileUtil();
         //fileUtil.readExcel("test-data.xlsx","Sheet1");
         List<EmployeeRequest> testData = fileUtil.getTestData("test-data.xlsx");
         System.out.println(testData.size());
     }
}
