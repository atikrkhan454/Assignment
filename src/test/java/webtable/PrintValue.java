package webtable;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class PrintValue {

    public static WebDriver driver;

    WebElement table = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody"));
    List<WebElement> rows_table = table.findElements(By.tagName("tr"));
    int rows_count = rows_table.size();
    List<WebElement> column_table = table.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody//tr[1]/td"));
    int column_count = column_table.size();
    List<WebElement> column1 = table.findElements(By.tagName("th"));
    int table_header = column1.size();

    public static void main(String[] args) {

        driverSetup();
        PrintValue value=new PrintValue();
        value.assignment1();
        value.assignment2();
        value.assignment3();
        assignment4();



    }
    public static void driverSetup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        WebElement table = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody"));
        List<WebElement> rows_table = table.findElements(By.tagName("tr"));
        int rows_count = rows_table.size();
        System.out.println("Total no of row " + rows_count);
        List<WebElement> column_table = table.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody//tr[1]/td"));
        int column_count = column_table.size();
        System.out.println("Total no of column " + column_count);

    }
    public  void assignment1() {
        System.out.println("assignment 1");
        System.out.println(" ");

        System.out.println("Structure value is " + table_header);
        String value = driver.findElement(By.xpath("//td[contains(text(),'4 buildings')]")).getText();
        System.out.println("Value of total column " + value);
    }
    public void assignment2() {
        System.out.println("Assignment 2");
        System.out.println(" ");

        for (int k = 1; k <= table_header; k++) {
            String Values = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody//tr[" + k + "]")).getText();
            System.out.println(Values);
        }
        for (int i = 1; i <= rows_count; i++) {


            for (int j = 1; j <= column_count; j++) {


                String Table_data = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody//tr[" + i + "]/td[" + j + "]")).getText();

                System.out.print(" " + Table_data + " ");

            }

            System.out.println();


        }
    }
    public void assignment3() {
        System.out.println("Assignment 3");
        System.out.println(" ");
        for (int row = 1; row <= rows_count; row++) {
            String Height = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr[" + row + "]/td[3]")).getText();
            String Name = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr[" + row + "]/th")).getText();
            System.out.println(Name + " Height is " + Height);
        }
    }
    public static void assignment4(){
        System.out.println("Assignment 4");
        System.out.println(" ");

        List<WebElement> lastRow=driver.findElements(By.xpath("//tfoot/tr/*"));
        int lastRowColumn= lastRow.size();
        if(lastRowColumn==2) {
            System.out.println("Last row have " + lastRowColumn + "nos of columns");
        }else {
            System.out.println("Last row have not 2 column");
        }

        driver.quit();
    }

}
