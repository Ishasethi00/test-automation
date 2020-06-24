
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.awt.Desktop;
import java.util.Vector;
public class ExcelTest {
	
	public void readExcel(String filePath,String sheetName,Vector<String> v) throws Exception {
		System.setProperty("webdriver.chrome.driver",
                "D:\\Downloads\\chromedriver_win32\\chromedriver.exe");
		File file = new File(filePath);
		FileInputStream is = new FileInputStream(file);
		Workbook tsWb = new XSSFWorkbook(is);
		Sheet tsSheet = tsWb.getSheet(sheetName);
		int rowCount = tsSheet.getLastRowNum() - tsSheet.getFirstRowNum() -1;
		System.out.println("No.of Test Cases :"+ rowCount);
		CellStyle greencolor  = tsWb.createCellStyle();
		greencolor.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		CellStyle redcolor  = tsWb.createCellStyle();
		redcolor.setFillForegroundColor(IndexedColors.RED.getIndex());
		for(int i= 1 ; i<= rowCount ; i++) {
			 Row row = tsSheet.getRow(i);
			 int j=0;
			 ChromeOptions options = new ChromeOptions();
			 options.addArguments("headless");
			 options.addArguments("window-size=1200x600");
			 WebDriver driver = new ChromeDriver(options);
			 //WebDriver driver = new ChromeDriver();
			 String baseurl = "http://localhost/Covid19_Registry_Form.html";
			 driver.get(baseurl);
			 WebElement pid = null,fname = null,testm=null,lname=null,res=null,dob=null,street1=null,city1=null,state1=null,sod=null,street2=null,city2=null,state2=null,labdir=null,pdate=null,spe=null,submit=null;
			 try {
				 pid = driver.findElement(By.id("pid"));
			 }catch(Exception e) {
				 System.out.println("webelement exception");
				 e.printStackTrace();
			 }
			 try {
			 	fname = driver.findElement(By.id("fname"));
			 }catch(Exception e) {
				 System.out.println("webelement exception");
				 e.printStackTrace();
			 }
			 try {
				 lname = driver.findElement(By.id("lname"));
			 }catch(Exception e) {
				 System.out.println("webelement exception");
				 e.printStackTrace(); 
			 }
			 try {
				 spe = driver.findElement(By.id("spe"));
			 }catch(Exception e) {
				 System.out.println("webelement exception");
				 e.printStackTrace(); 
			 }
			 try {
				 dob = driver.findElement(By.id("dob"));
			 }catch(Exception e) {
				 System.out.println("webelement exception");
				 e.printStackTrace();
			 }
			 try{
				 street1 = driver.findElement(By.id("add1stre"));
			 }catch(Exception e) {
				 System.out.println("webelement exception");
				 e.printStackTrace();
			 }
			 try{
				 city1 = driver.findElement(By.id("add1cit"));
			 }catch(Exception e) {
				 System.out.println("webelement exception");
				 e.printStackTrace();
			 }
			 try{
				state1 = driver.findElement(By.id("add1sta"));
			 }catch(Exception e) {
				 System.out.println("webelement exception");
				 e.printStackTrace();
			 }
			 try{
				sod = driver.findElement(By.id("source"));
			 }catch(Exception e) {
				 System.out.println("webelement exception");
				 e.printStackTrace();
			 }
			 try{
				 street2 = driver.findElement(By.id("add2stre"));
			 }catch(Exception e) {
				 System.out.println("webelement exception");
				 e.printStackTrace();
			 }
			 try{
				 city2 = driver.findElement(By.id("add2cit"));
			 }catch(Exception e) {
				 System.out.println("webelement exception");
				 e.printStackTrace();
			 }
			 try{
				state2 = driver.findElement(By.id("add2sta"));
			 }catch(Exception e) {
				 System.out.println("webelement exception");
				 e.printStackTrace();
			 }
			 try{
				 labdir = driver.findElement(By.id("dir"));
			 }catch(Exception e) {
				 System.out.println("webelement exception");
				 e.printStackTrace();
			 }
			 try{
				 testm = driver.findElement(By.id("testm"));
			 }catch(Exception e) {
				 System.out.println("webelement exception");
				 e.printStackTrace();
			 }
			 try{
				pdate = driver.findElement(By.id("dop"));
			 }catch(Exception e) {
				 System.out.println("webelement exception");
				 e.printStackTrace();
			 }
			 try{
					res = driver.findElement(By.id("res"));
				 }catch(Exception e) {
					 System.out.println("webelement exception");
					 e.printStackTrace();
				 }
			 try{
				  submit = driver.findElement(By.id("button1"));
			 }catch(Exception e) {
				 System.out.println("webelement exception");
				 e.printStackTrace();
			 }
		     try { 
			 	 if(row.getCell(j) != null) {
					fname.sendKeys(row.getCell(j).getStringCellValue());
				 }
				 j++;
				 if(row.getCell(j) != null) {
				 	pid.sendKeys(row.getCell(j).getStringCellValue());
				 }
				 j++;
				 if(row.getCell(j) != null) {
					dob.sendKeys(row.getCell(j).getStringCellValue());
				 }
				 j++;
				 if(row.getCell(j) != null) {
					 street1.sendKeys(row.getCell(j).getStringCellValue());
				 }
				 j++;
				 if(row.getCell(j) != null) {
					 sod.sendKeys(row.getCell(j).getStringCellValue());
				 }
				 j++;
				 if(row.getCell(j) != null) {
				 	street2.sendKeys(row.getCell(j).getStringCellValue());
				 }
				 j++;
				 if(row.getCell(j) != null) {
					labdir.sendKeys(row.getCell(j).getStringCellValue());
				 }
				 j++;
				 if(row.getCell(j) != null) {
					 //tmethod.selectByValue(row.getCell(j).getStringCellValue());
					 testm.sendKeys(row.getCell(j).getStringCellValue());
				 }
				 j++;
				 if(row.getCell(j) != null) {
						spe.sendKeys(row.getCell(j).getStringCellValue());
					 }
				 j++;
				 if(row.getCell(j) != null) {
					pdate.sendKeys(row.getCell(j).getStringCellValue());
				 }
				 j++;
				 if(row.getCell(j) != null) {
					 res.sendKeys(row.getCell(j).getStringCellValue());
				 }
				 j++;
				 if(row.getCell(j) != null) {
					lname.sendKeys(row.getCell(j).getStringCellValue());
				 }
				 j++;
				 if(row.getCell(j) != null) {	
					 city1.sendKeys(row.getCell(j).getStringCellValue());
				 }
				 j++;
				 if(row.getCell(j) != null) {
					 state1.sendKeys(row.getCell(j).getStringCellValue());
				 }
				 j++;
				 if(row.getCell(j) != null) {	
					 city2.sendKeys(row.getCell(j).getStringCellValue());
				 }
				 j++;
				 if(row.getCell(j) != null) {
					 state2.sendKeys(row.getCell(j).getStringCellValue());
				 }
				 j++;
				 String expRes = row.getCell(j).getStringCellValue();
				 j++;
				 //submit.click();
				 submit.sendKeys(Keys.ENTER);
				 String status = "";
				 if(driver.getPageSource().contains("Successful")) {
					 status = status + "Accepted";
					 v.add(status);
				 }
				 else {
					 status = status + "Declined";
					 v.add(status);
				 }	 
				 Cell cell = row.createCell(j);
				 cell.setCellValue(v.get(i-1));
				 j++;
				 Cell cell2 = row.createCell(j);
				 if(expRes.equals(status)) {
					 cell2.setCellValue("Passed");
					 cell2.setCellStyle(greencolor);
				 }
				 else {
					 cell2.setCellValue("Failed");
					 cell2.setCellStyle(redcolor);
				 }
				 driver.close();
 
		    }catch(Exception e) {
		    	e.printStackTrace();
		    }
		     System.out.println("Processed Test Cases : "+i+"/"+rowCount);
 
		}
		is.close();
		
		FileOutputStream fo = new FileOutputStream(file);
		tsWb.write(fo);
		fo.close();
		tsWb.close();
		Desktop desktop = Desktop.getDesktop();
		desktop.open(file);
	}
	
	public static void main(String[] args) {
		
		String path = "C:/Users/sseth/eclipse-workspace/TestWordpressLogin/src/TestCases.xlsx";
		String sheetname = "Sheet1";
		Vector<String> v = new Vector<String>();
		ExcelTest e = new ExcelTest();
		try {
			e.readExcel(path,sheetname,v);
		}
		catch(Exception ex) {
			System.out.println("caught ioexception");
			ex.printStackTrace();
		}
	}
 
}
