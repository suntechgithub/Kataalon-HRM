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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Login_To_HRM'), [('username') : username, ('password') : password], FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Object Repository/HRM_Page_Approve_Timesheet/b_Time'))

WebUI.mouseOver(findTestObject('Object Repository/HRM_Page_Approve_Timesheet/a_Timesheets'))

WebUI.click(findTestObject('Object Repository/HRM_Page_Approve_Timesheet/a_Employee Timesheets'))

WebUI.setText(findTestObject('Object Repository/HRM_Page_Approve_Timesheet/input_EmployeeName'), '2903')

WebUI.sendKeys(findTestObject('Object Repository/HRM_Page_Approve_Timesheet/input_EmployeeName'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/HRM_Page_Approve_Timesheet/btn_Search'))

WebUI.waitForElementClickable(findTestObject('Object Repository/HRM_Page_Approve_Timesheet/select_Timesheets'), 60)

Thread.sleep(5000)

WebUI.selectOptionByIndex(findTestObject('Object Repository/HRM_Page_Approve_Timesheet/select_Timesheets'), '10', FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('HRM_Page_Approve_Timesheet/textarea_Comment'))

WebUI.setText(findTestObject('Object Repository/HRM_Page_Approve_Timesheet/textarea_Comment'), 'Approve')

WebUI.mouseOver(findTestObject('HRM_Page_Approve_Timesheet/input_Comment_button'))

WebUI.click(findTestObject('Object Repository/HRM_Page_Approve_Timesheet/input_Comment_button'))

WebUI.click(findTestObject('Object Repository/HRM_Page_Approve_Timesheet/input_ConfirmationRequired'))

WebUI.takeScreenshot()

WebUI.verifyElementPresent(findTestObject('Object Repository/HRM_Page_Approve_Timesheet/div_TimesheetApproved'), 0)

WebUI.callTestCase(findTestCase('Logout_HRM'), [:], FailureHandling.STOP_ON_FAILURE)

