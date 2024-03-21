import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CatImageAutomation {

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Open the webpage with cat images
        driver.get("https://www.google.com/search?q=cat&tbm=isch");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Find and click the 'Images' button
        WebElement imagesButton = driver.findElement(By.xpath("//a[@data-ved='0ahUKEwjg-dWP_9LwAhXEmOAKHfJXANgQ4dUDCAY&uact=5']"));
        imagesButton.click();

        // Scroll down to load more images
        for (int i = 0; i < 5; i++) {
            driver.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            try {
                Thread.sleep(2000); // Wait for images to load
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Locate all image elements
        java.util.List<WebElement> imageElements = driver.findElements(By.xpath("//img[@class='rg_i Q4LuWd']"));

        // Iterate through the image elements and display the first 50 images
        int count = 0;
        for (WebElement imageElement : imageElements) {
            if (count == 50)
                break;
            imageElement.click(); // Click on the image to enlarge it
            try {
                Thread.sleep(1000); // Wait for the image to load
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }

        // Close the browser
        driver.quit();
    }
}
