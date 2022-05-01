package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public abstract class BasePage {

	WebDriver driver;
	JavascriptExecutor js;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//here we initiate the javascriptexecutor to use any time we need to run a javascript
		js=(JavascriptExecutor)driver;
	}

	public void click (WebElement el) {
		highlightElement(el, "green");
		el.click();
	}

	public void fillText (WebElement el, String text) {
		highlightElement(el, "yellow");
		el.clear();
		el.sendKeys(text);
	}

	public void selectText(WebElement el, String text) {
		Select select = new Select(el);
		select.selectByVisibleText(text);
	}

	public void selectIndex(WebElement el, int i) {
		Select select = new Select(el);
		select.selectByIndex(i);
	}
	
	protected void highlightElement(WebElement element, String color) {
		//keep the old style to change it back
		String originalStyle = element.getAttribute("style");
		String newStyle = "border: 2px solid " + color + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Change the style 
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + newStyle + "');},0);",
				element);

		//change the style back after few seconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},800);", element);
	}
}
