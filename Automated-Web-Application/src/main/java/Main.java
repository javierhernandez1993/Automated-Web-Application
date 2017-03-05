import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hi, I am a BOT!");
        //Thread.sleep(5000);

        System.setProperty("webdriver.chrome.driver", "");

        //******************************** open Chrome and go to website ********************************
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        //options.addArguments("start-maximized");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver driver = new ChromeDriver(capabilities); //BREAKING HERE!
        driver.get("http://www.supremenewyork.com/shop/shirts/z4fqw32ih");
        //driver.get("http://www.adidas.com/us/men-nmd-shoes");

        //******************************** click on product to buy **************************************
        //driver.findElement(By.cssSelector("#product-BA7231 > div.innercard > div.image.plp-image-bg > a > img")).click();
        //driver.findElement(By.cssSelector("#shop-scroller > li:nth-child(12) > a > img")).click(); //supreme

        //******************************** pop-up after clicking on product *****************************
/*        String parentWindowHandler_PopUp = driver.getWindowHandle(); // Store your parent window
        String subWindowHandler_PopUp = null;

        System.out.println("Number of windows: " + driver.getWindowHandles().size());
        System.out.println("Is empty?: " + driver.getWindowHandles().isEmpty());

        Set<String> handles_popup = driver.getWindowHandles(); // get all window handles
        Iterator<String> iterator_popup = handles_popup.iterator();
        while (iterator_popup.hasNext()){
            subWindowHandler_PopUp = iterator_popup.next();
        }
        driver.switchTo().window(subWindowHandler_PopUp);

        if (driver.findElement(By.cssSelector("body > div.ui-dialog.ui-widget.ui-widget-content.ui-corner-all.signUpOverlay.popup-scale-in > div.ui-dialog-titlebar.ui-widget-header.ui-corner-all.ui-helper-clearfix > a")).getSize() != null) {
            System.out.println("inside the if statement");
            driver.findElement(By.cssSelector("body > div.ui-dialog.ui-widget.ui-widget-content.ui-corner-all.signUpOverlay.popup-scale-in > div.ui-dialog-titlebar.ui-widget-header.ui-corner-all.ui-helper-clearfix > a")).click();
        }

        driver.switchTo().window(parentWindowHandler_PopUp);
*/
        System.out.println("Finished pop-up case. About to click on size.");

        //******************************** select size of product ***************************************
        //click on size-dropdown
        driver.findElement(By.cssSelector("#size")).click();
        //driver.findElement(By.cssSelector("#buy-block > div.buy-block-header > div.rbk-rounded-block > div.add-product-block > form > div.clearfix.size-qty-container > div.size-dropdown-block > div > div > a")).click();
        //click on actual size button
        driver.findElement(By.cssSelector("#size > option:nth-child(1)")).click();
        //driver.findElement(By.cssSelector("#buy-block > div.buy-block-header > div.rbk-rounded-block > div.add-product-block > form > div.clearfix.size-qty-container > div.size-dropdown-block > div > div > div > div.ffSelectMenuMidBG > div > ul > li:nth-child(2) > span")).click();

        System.out.println("Finished picking size. About to add to cart.");

        //******************************** add to cart **************************************************
        driver.findElement(By.cssSelector("#add-remove-buttons > input")).click();
        //driver.findElement(By.xpath("//*[@id=\"buy-block\"]/div[1]/div[5]/div[2]/form/div[8]/div[1]/button")).click();

        System.out.println("Finished adding to cart. About to checkout.");

        //******************************** checkout *****************************************************
        driver.findElement(By.cssSelector("#cart > a.button.checkout")).click();
/*        String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
        String subWindowHandler = null;

        System.out.println("window handle check 1.");

        Set<String> handles = driver.getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler);
        System.out.println("window handle check 2.");

        //WebElement checkoutElement = driver.findElement(By.xpath("//*[@id=\"minicart_overlay\"]/div[2]/a[2]"));
        WebElement checkoutElement = driver.findElement(By.cssSelector("#minicart_overlay > div.minicart_summery > a.co-btn_primary.btn_checkout.btn_showcart.button-ctn.button-brd.adi-gradient-blue.button-full-width.button-forward.btn.btn-cart.btn-block"));
        System.out.println("checkoutElement check 1.");
        checkoutElement.click();
        System.out.println("checkoutElement check 2.");
*/

        System.out.println("Finished checking out. About to enter credit card info.");

        //******************************** credit card info *********************************************
        //name
        driver.findElement(By.cssSelector("#order_billing_name")).sendKeys("Javier Hernandez");
        //email
        driver.findElement(By.cssSelector("#order_email")).sendKeys("jhern0093@gmail.com");
        //tel
        driver.findElement(By.cssSelector("#order_tel")).sendKeys("(818)524-8168");
        //address
        driver.findElement(By.cssSelector("#bo")).sendKeys("4 Violet Ln");
        //zip
        driver.findElement(By.cssSelector("#order_billing_zip")).sendKeys("93117");
        //city
        driver.findElement(By.cssSelector("#order_billing_city")).sendKeys("Goleta");
        //number
        driver.findElement(By.cssSelector("#cnb")).sendKeys("4815830020732068");
        //cvv
        driver.findElement(By.cssSelector("#vval")).sendKeys("732");

        //driver.findElement(By.cssSelector("#pay > input")).click();
    }
}
