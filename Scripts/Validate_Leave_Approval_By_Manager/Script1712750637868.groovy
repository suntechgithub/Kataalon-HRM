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

WebUI.mouseOver(findTestObject('Object Repository/HRM_Pending_Leave_Approvals/b_Leave'))

WebUI.click(findTestObject('Object Repository/HRM_Pending_Leave_Approvals/a_Leave List'))

WebUI.setText(findTestObject('Object Repository/HRM_Pending_Leave_Approvals/input_EmployeeName'), '2903')

WebUI.sendKeys(findTestObject('Object Repository/HRM_Pending_Leave_Approvals/input_EmployeeName'), Keys.chord(Keys.ENTER))

WebUI.navigateToUrl('http://172.16.29.165/symfony/web/index.php/leave/viewLeaveList')

WebUI.click(findTestObject('HRM_Pending_Leave_Approvals/btn_Search'))

WebUI.navigateToUrl('http://172.16.29.165/symfony/web/index.php/leave/viewLeaveList/reset/1')

WebUI.selectOptionByLabel(findTestObject('Object Repository/HRM_Pending_Leave_Approvals/select_Select Action'), 'Approve', 
    true)

WebUI.click(findTestObject('Object Repository/HRM_Pending_Leave_Approvals/btn_Save'))

WebUI.click(findTestObject('Object Repository/HRM_Pending_Leave_Approvals/input_Confirmation Required'))

WebUI.mouseOver(findTestObject('Object Repository/HRM_Pending_Leave_Approvals/div_SuccessfullyUpdated'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/HRM_Pending_Leave_Approvals/div_SuccessfullyUpdated'), 0)

WebUI.callTestCase(findTestCase('Logout_HRM'), [:], FailureHandling.STOP_ON_FAILURE)

