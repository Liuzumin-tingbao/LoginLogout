package Login.write.quit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
    WebDriver wb;
    @BeforeMethod
    public void OpenChrome() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","E:\\IDEAProject\\drivers\\chromedriver.exe");
        wb = new ChromeDriver();
        wb.get("http://127.0.0.1:5000/login");
        wb.findElement(By.xpath("/html/body/section/div/div/div/form/p[4]/a")).click();
        Thread.sleep(2000);
        wb.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("124@qq.com");
        wb.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
        wb.findElement(By.xpath("//*[@id=\"cpassword\"]")).sendKeys("123456");
        wb.findElement(By.xpath("/html/body/section/div/div/div/form/p[2]/input")).click();
    }
    @Test
    public void LoginWeb() throws InterruptedException {
        //登陆
        wb.get("http://127.0.0.1:5000/login");
        wb.findElement(By.id("email")).sendKeys("124@qq.com");
        wb.findElement(By.id("password")).sendKeys("123456");
        wb.findElement(By.xpath("/html/body/section/div/div/div/form/p[3]/input")).click();
        //发帖
        Thread.sleep(2000);

        wb.findElement(By.xpath("/html/body/header/div/div/div/strong/a")).click();
        wb.findElement(By.xpath("//*[@id=\"new_post_link\"]")).click();

        Thread.sleep(3000);
        wb.findElement(By.xpath("//*[@id=\"title\"]")).sendKeys("1234");
        wb.findElement(By.xpath("//*[@id=\"slug\"]")).sendKeys("1234");
        wb.findElement(By.xpath("//*[@id=\"body\"]")).sendKeys("123456767889");
        wb.findElement(By.xpath("//*[@id=\"new_post_form\"]/div/form/p[2]/input")).click();
        Thread.sleep(3000);

        wb.findElement(By.xpath("/html/body/header/div/div/div/a[2]")).click();
        Thread.sleep(2000);
    }
    @AfterMethod
    public void CloseChrome(){
        wb.quit();
    }
}
