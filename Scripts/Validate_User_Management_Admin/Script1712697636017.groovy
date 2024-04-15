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

WebUI.callTestCase(findTestCase('Login_To_HRM'), [('username') : role_Admin, ('password') : password], FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Object Repository/HRM_Page_UserManagement/b_Admin'))

WebUI.mouseOver(findTestObject('Object Repository/HRM_Page_UserManagement/a_User Management'))

WebUI.click(findTestObject('HRM_Page_UserManagement/a_Users'))

WebUI.navigateToUrl('http://172.16.29.165/symfony/web/index.php/admin/viewSystemUsers')

WebUI.takeScreenshot()

WebUI.setText(findTestObject('Object Repository/HRM_Page_UserManagement/input_Username_searchSystemUseruserName'), 'testers')

WebUI.click(findTestObject('Object Repository/HRM_Page_UserManagement/input_Status__search'))

WebUI.click(findTestObject('Object Repository/HRM_Page_UserManagement/a_testers'))

WebUI.takeScreenshot()

WebUI.verifyElementPresent(findTestObject('Object Repository/HRM_Page_UserManagement/h1_Edit User'), 0)

WebUI.click(findTestObject('Object Repository/HRM_Page_UserManagement/input__btnSave'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/HRM_Page_UserManagement/select_AdminAdmin ControllerESSTeam Lead'), 
    'Team Lead', true)

WebUI.click(findTestObject('Object Repository/HRM_Page_UserManagement/input__btnSave'))

WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/HRM_Page_UserManagement/input_Confirmation Required_dialogUpdateBtn'))

WebUI.mouseOver(findTestObject('Object Repository/HRM_Page_UserManagement/a_User Management'))

WebUI.click(findTestObject('HRM_Page_UserManagement/a_Users'))

WebUI.navigateToUrl('http://172.16.29.165/symfony/web/index.php/admin/viewSystemUsers')

WebUI.setText(findTestObject('Object Repository/HRM_Page_UserManagement/input_Username_searchSystemUseruserName'), 'testers')

WebUI.click(findTestObject('Object Repository/HRM_Page_UserManagement/input_Status__search'))

WebUI.verifyElementText(findTestObject('Object Repository/HRM_Page_UserManagement/text_UserRole'), 'Team Lead')

WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/HRM_Page_UserManagement/a_testers'))

WebUI.verifyElementPresent(findTestObject('Object Repository/HRM_Page_UserManagement/h1_Edit User'), 0)

WebUI.click(findTestObject('Object Repository/HRM_Page_UserManagement/input__btnSave'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/HRM_Page_UserManagement/select_AdminAdmin ControllerESSTeam Lead'), 
    'ESS', true)

WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/HRM_Page_UserManagement/input__btnSave'))

WebUI.click(findTestObject('Object Repository/HRM_Page_UserManagement/input_Confirmation Required_dialogUpdateBtn'))

WebUI.takeScreenshot()

WebUI.callTestCase(findTestCase('Logout_HRM'), [:], FailureHandling.STOP_ON_FAILURE)

