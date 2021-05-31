import Classes.Admin;
import Classes.Cars;
import Classes.Clients;
import Classes.Orders;
import Services.AdminServices;
import Services.CarsServices;
import Services.ClientsServices;
import Services.Impl.AdminServicesImpl;
import Services.Impl.CarsServicesImpl;
import Services.Impl.ClientsServicesImpl;
import Services.Impl.OrdersServicesImpl;
import Services.OrdersServices;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Date;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

public class SeleniumTests {
    private final ClientsServices clientsServices = new ClientsServicesImpl();
    private final CarsServices carsServices = new CarsServicesImpl();
    private final OrdersServices ordersServices = new OrdersServicesImpl();
    private final AdminServices adminServices = new AdminServicesImpl();

    String URL = "http://localhost:8080/";
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void settings() {
        final String chromeDriverPath = "D:/Program Files (x86)/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
        driver = new ChromeDriver(capabilities);
        driver.manage().window().setSize(new Dimension(1000, 1000));
        driver.manage().timeouts().implicitlyWait(10, SECONDS);

        wait = new WebDriverWait(driver,10);
        driver.manage().timeouts().pageLoadTimeout(10, SECONDS);
    }

    @Test(priority=1)
    public void FirstClientScenario() {
        driver.get(URL);
        WebElement button = wait.until(visibilityOfElementLocated(By.id("sign_in")));
        Assert.assertEquals(driver.getTitle(), "Start page");
        button.click();

        wait.until(stalenessOf(button));
        button = wait.until(visibilityOfElementLocated(By.id("log_in")));
        Assert.assertEquals(driver.getTitle(), "Sign in");

        Clients client = clientsServices.findById(337);

        driver.findElement(By.id("login")).sendKeys(client.getLogin());
        driver.findElement(By.id("password")).sendKeys(client.getPassword());
        button.click();

        wait.until(stalenessOf(button));
        Assert.assertEquals(driver.getTitle(), "Start page");

        Cars cars = carsServices.findById(521);

        Select dropDown = new Select(driver.findElement(By.id("brand")));
        dropDown.selectByValue(cars.getBrand());

        Select dropDown1 = new Select(driver.findElement(By.id("manufacturer")));
        dropDown1.selectByValue(cars.getManufacturer());

        Select dropDown2 = new Select(driver.findElement(By.id("technical_not")));
        dropDown2.selectByValue(cars.getTechnical_not());

        Select dropDown3 = new Select(driver.findElement(By.id("addition_devices")));
        dropDown3.selectByValue(cars.getAddition_devices());

        Select dropDown4 = new Select(driver.findElement(By.id("costumer_not")));
        dropDown4.selectByValue(cars.getCostumer_not());

        Select dropDown5 = new Select(driver.findElement(By.id("mutable_not")));
        dropDown5.selectByValue(cars.getMutable_not());

        button = wait.until(visibilityOfElementLocated(By.id("submit")));
        button.click();
        wait.until(stalenessOf(button));
        Assert.assertEquals(driver.getTitle(), "Cars");

        button = wait.until(visibilityOfElementLocated(By.id("checkout")));
        button.click();
        wait.until(stalenessOf(button));
        Assert.assertEquals(driver.getTitle(), "Check out");

        button = wait.until(visibilityOfElementLocated(By.id("create")));
        button.click();
        wait.until(stalenessOf(button));
        Assert.assertEquals(driver.getTitle(), "Order Create");

        Select dropDown6 = new Select(driver.findElement(By.id("test_drive")));
        dropDown6.selectByValue("true");

        button = wait.until(visibilityOfElementLocated(By.id("create")));
        button.click();
        wait.until(stalenessOf(button));
        Assert.assertEquals(driver.getTitle(), "Orders");
        Assert.assertEquals(driver.findElement(By.id("id234")).getText(), "234");
    }

    @Test(priority=2)
    public void SecondClientScenario() {
        driver.get(URL);

        WebElement button = wait.until(visibilityOfElementLocated(By.id("submit")));
        Assert.assertEquals(driver.getTitle(), "Start page");

        Cars cars = carsServices.findById(521);

        Select dropDown = new Select(driver.findElement(By.id("brand")));
        dropDown.selectByValue(cars.getBrand());

        Select dropDown1 = new Select(driver.findElement(By.id("manufacturer")));
        dropDown1.selectByValue(cars.getManufacturer());

        Select dropDown2 = new Select(driver.findElement(By.id("technical_not")));
        dropDown2.selectByValue(cars.getTechnical_not());

        Select dropDown3 = new Select(driver.findElement(By.id("addition_devices")));
        dropDown3.selectByValue(cars.getAddition_devices());

        Select dropDown4 = new Select(driver.findElement(By.id("costumer_not")));
        dropDown4.selectByValue(cars.getCostumer_not());

        Select dropDown5 = new Select(driver.findElement(By.id("mutable_not")));
        dropDown5.selectByValue(cars.getMutable_not());

        button.click();
        wait.until(stalenessOf(button));

        Assert.assertEquals(driver.getTitle(), "Cars");
        button = wait.until(visibilityOfElementLocated(By.id("checkout")));
        button.click();
        wait.until(stalenessOf(button));

        Assert.assertEquals(driver.getTitle(), "Check out");
        button = wait.until(visibilityOfElementLocated(By.id("create")));
        button.click();
        wait.until(stalenessOf(button));

        button = wait.until(visibilityOfElementLocated(By.id("log_in")));
        Assert.assertEquals(driver.getTitle(), "Sign in");

        Clients client = clientsServices.findById(337);

        driver.findElement(By.id("login")).sendKeys(client.getLogin());
        driver.findElement(By.id("password")).sendKeys(client.getPassword());
        button.click();
        wait.until(stalenessOf(button));

        Assert.assertEquals(driver.getTitle(), "Order Create");

        Select dropDown6 = new Select(driver.findElement(By.id("test_drive")));
        dropDown6.selectByValue("true");

        button = wait.until(visibilityOfElementLocated(By.id("create")));
        button.click();
        Assert.assertEquals(driver.getTitle(), "Orders");
        Assert.assertEquals(driver.findElement(By.id("id235")).getText(), "235");
    }

    @Test(priority=3)
    public void FirstAdminScenario() {
        driver.get(URL);
        WebElement button = wait.until(visibilityOfElementLocated(By.id("sign_in")));
        Assert.assertEquals(driver.getTitle(), "Start page");
        button.click();

        wait.until(stalenessOf(button));
        button = wait.until(visibilityOfElementLocated(By.id("log_in")));
        Assert.assertEquals(driver.getTitle(), "Sign in");

        Admin admin = adminServices.authorizeAdmin("Admin000","qwertyAd001232");
        driver.findElement(By.id("login")).sendKeys(admin.getLogin());
        driver.findElement(By.id("password")).sendKeys(admin.getPassword());

        button.click();
        wait.until(stalenessOf(button));
        Assert.assertEquals(driver.getTitle(), "Admin page");
        button = wait.until(visibilityOfElementLocated(By.id("submit")));

        Select dropDown = new Select(driver.findElement(By.id("admin_func")));
        dropDown.selectByValue("7");
        button.click();
        wait.until(stalenessOf(button));

        Assert.assertEquals(driver.getTitle(), "Special page");
        button = wait.until(visibilityOfElementLocated(By.id("order_submit")));

        Select dropDown2 = new Select(driver.findElement(By.id("test_drive")));
        dropDown2.selectByValue("false");

        driver.findElement(By.id("date_of_order")).sendKeys("2021-05-31");
        driver.findElement(By.id("status")).sendKeys("new");
        button.click();
        List<Orders> orders = ordersServices.findOrdersByOrderNot(false, Date.valueOf("2021-05-31"),"new");
        Assert.assertFalse(orders.isEmpty());
    }

    @Test(priority=4)
    public void SecondAdminScenario() {
        driver.get(URL);
        WebElement button = wait.until(visibilityOfElementLocated(By.id("sign_in")));
        Assert.assertEquals(driver.getTitle(), "Start page");
        button.click();

        wait.until(stalenessOf(button));
        button = wait.until(visibilityOfElementLocated(By.id("log_in")));
        Assert.assertEquals(driver.getTitle(), "Sign in");

        Admin admin = adminServices.authorizeAdmin("Admin000", "qwertyAd001232");
        driver.findElement(By.id("login")).sendKeys(admin.getLogin());
        driver.findElement(By.id("password")).sendKeys(admin.getPassword());

        button.click();
        wait.until(stalenessOf(button));
        Assert.assertEquals(driver.getTitle(), "Admin page");
        button = wait.until(visibilityOfElementLocated(By.id("submit")));

        Select dropDown = new Select(driver.findElement(By.id("admin_func")));
        dropDown.selectByValue("3");
        button.click();
        wait.until(stalenessOf(button));

        Assert.assertEquals(driver.getTitle(), "Special page");
        button = wait.until(visibilityOfElementLocated(By.id("id_submit")));

        driver.findElement(By.id("_id")).sendKeys("339");
        button.click();
        wait.until(stalenessOf(button));

        Assert.assertEquals(driver.getTitle(), "Special page 2");
        button = wait.until(visibilityOfElementLocated(By.id("delete_client")));
        button.click();
        wait.until(stalenessOf(button));

        Assert.assertEquals(driver.getTitle(), "Admin page");
        Clients client = clientsServices.findById(336);
        Assert.assertNull(client);
    }
    @AfterClass
    public void end() {
        driver.quit();
    }
}
