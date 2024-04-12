import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoin
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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint

WebUI.callTestCase(findTestCase('Login_To_HRM'), [('username') : username, ('password') : password], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/HRM_Page_TimeSheet/span_My Timesheet'))

//WebUI.click(findTestObject('Object Repository/HRM_Page_TimeSheet/Page_Sun Technologies HRM/span_My Timesheet'))
WebUI.waitForElementClickable(findTestObject('HRM_Page_TimeSheet/select_Timesheet'), 60)

WebUI.selectOptionByIndex(findTestObject('Object Repository/HRM_Page_TimeSheet/select_Timesheet'), '3', FailureHandling.STOP_ON_FAILURE)

//ele = WebUI.waitForElementPresent(findTestObject('Object Repository/HRM_Page_TimeSheet/btn_Edit'), 60)
/*if (ele == true) {
    WebUI.click(findTestObject('Object Repository/HRM_Page_TimeSheet/btn_Edit'))
}*/
WebUI.clearText(findTestObject('Object Repository/HRM_Page_TimeSheet/input_ProjectName'))

WebUI.setText(findTestObject('HRM_Page_TimeSheet/input_ProjectName'), 'ADS-Sun HRM')

Thread.sleep(1000)

WebUI.sendKeys(findTestObject('HRM_Page_TimeSheet/input_ProjectName'), Keys.chord(Keys.ENTER))

Thread.sleep(3000)

WebUI.selectOptionByValue(findTestObject('Object Repository/HRM_Page_TimeSheet/select_ProjectActivity'), '44', true)

WebUI.clearText(findTestObject('Object Repository/HRM_Page_TimeSheet/input_Hrs_Mon'))

WebUI.setText(findTestObject('Object Repository/HRM_Page_TimeSheet/input_Hrs_Mon'), '8:00')

WebUI.clearText(findTestObject('Object Repository/HRM_Page_TimeSheet/input_Hrs_Tue'))

WebUI.setText(findTestObject('Object Repository/HRM_Page_TimeSheet/input_Hrs_Tue'), '8:00')

WebUI.clearText(findTestObject('Object Repository/HRM_Page_TimeSheet/input_Hrs_Wed'))

WebUI.setText(findTestObject('Object Repository/HRM_Page_TimeSheet/input_Hrs_Wed'), '8:00')

WebUI.clearText(findTestObject('Object Repository/HRM_Page_TimeSheet/input_Hrs_Thu'))

WebUI.setText(findTestObject('Object Repository/HRM_Page_TimeSheet/input_Hrs_Thu'), '8:00')

WebUI.clearText(findTestObject('Object Repository/HRM_Page_TimeSheet/input_Hrs_Fri'))

WebUI.setText(findTestObject('Object Repository/HRM_Page_TimeSheet/input_Hrs_Fri'), '8:00')

/*List<WebElement> timeBoxes = WebUI.findWebElements(findTestObject('Object Repository/HRM_Page_TimeSheet/input_Hours'), 10, 
    FailureHandling.STOP_ON_FAILURE)

//WebUI.setText(findTestObject('Object Repository/HRM_Page_TimeSheet/input_Hours'), '8')
int numberOfTextboxes = timeBoxes.size()

for (int i = 1; i <= numberOfTextboxes; i++) {
    String xpath_timebox = ('//input[@class = \'timeBox\' and @type = \'text\'][' + i) + ']'

    TestObject timeBox = new TestObject()

    timeBox.addProperty('xpath', ConditionType.EQUALS, xpath_timebox)

    WebUI.clearText(findTestObject('Object Repository/HRM_Page_TimeSheet/input_ProjectName'))

    if ((i == 1) || (i == numberofTextboxes)) {
        WebUI.setText(findTestObject(textbox), '0' // Find the textbox element
            )
    } else {
        WebUI.setText(findTestObject(textbox), '8')
    }
}*/
WebUI.click(findTestObject('Object Repository/HRM_Page_TimeSheet/input__btnSave'))

WebUI.verifyElementPresent(findTestObject('Object Repository/HRM_Page_TimeSheet/div_SuccessfullySaved'), 0)

WebUI.click(findTestObject('Object Repository/HRM_Page_TimeSheet/btn_Submit'))

WebUI.click(findTestObject('Object Repository/HRM_Page_TimeSheet/input_ConfirmationRequired'))

WebUI.verifyElementPresent(findTestObject('Object Repository/HRM_Page_TimeSheet/div_TimesheetSubmitted'), 0)

WebUI.callTestCase(findTestCase('Logout_HRM'), [:], FailureHandling.STOP_ON_FAILURE)

