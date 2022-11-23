package Common;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelpers {
    private static Sheet ExcelWSheet;
    private static Workbook ExcelWBook;
    private static org.apache.poi.ss.usermodel.Cell Cell;
    private static org.apache.poi.ss.usermodel.Row Row;

    public  void setExcelFile(String path, String sheetName) {
        try {
            ExcelWBook = new XSSFWorkbook(path);
            ExcelWSheet = ExcelWBook.getSheet(sheetName);
        } catch (Exception e) {
        }
    }

    public  int getNumRow() {
        return ExcelWSheet.getLastRowNum() - ExcelWSheet.getFirstRowNum() ;
    }

    public  String getCellData(int RowNum, int ColNum) {
        try {
            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(Cell);
        } catch (Exception e) {
            return "";
        }
    }
}