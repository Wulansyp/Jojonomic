import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import java.sql.Driver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import java.sql.DriverManager
import org.openqa.selenium.By as By


WebUI.click(findTestObject('Object Repository/Loc/clc_loc'))
WebUI.setText(findTestObject('Object Repository/Loc/inputLoc'), Location)
WebUI.click(findTestObject('Object Repository/Loc/btn_search'))

WebDriver Driver = DriverFactory.getWebDriver()

ArrayList LocationService = new ArrayList() //menampung jumlah location
TestObject ResultList = findTestObject('Object Repository/Loc/resultList')
String FElement = "${ResultList.findPropertyValue('xpath')}"
WebElement Result = Driver.findElement(By.xpath(FElement))

List<WebElement> Elements = Result.findElements(By.tagName('a')) 
for (int i =0 ; i<Elements.size() ; i++ )
{
	LocationService.add(Elements[i].getText())
}

if (LocationService.contains(LocationName))
{
	println 'true'
}
else println 'false'