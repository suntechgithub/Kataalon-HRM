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
import java.text.SimpleDateFormat as SimpleDateFormat

WebUI.callTestCase(findTestCase('Login_To_HRM'), [('username') : role_User, ('password') : password], FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Object Repository/HRM_Page_Expense/b_Expense'))

WebUI.click(findTestObject('Object Repository/HRM_Page_Expense/a_Apply Expense'))

WebUI.setText(findTestObject('Object Repository/HRM_Page_Expense/input__tripName'), 'Test')

WebUI.selectOptionByValue(findTestObject('Object Repository/HRM_Page_Expense/select_ClientName'), '2', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/HRM_Page_Expense/select_ProjectName'), '3', true)

WebUI.setText(findTestObject('Object Repository/HRM_Page_Expense/input_Date'), '2024-05-07')

WebUI.sendKeys(findTestObject('HRM_Page_Expense/input_Date'), Keys.chord(Keys.ENTER))

WebUI.selectOptionByValue(findTestObject('Object Repository/HRM_Page_Expense/select_ExpenseType'), '14', true)

WebUI.setText(findTestObject('Object Repository/HRM_Page_Expense/text_Description'), 'Support for release work')

WebUI.selectOptionByValue(findTestObject('Object Repository/HRM_Page_Expense/select_PaidInAdvance'), '1', true)

WebUI.sendKeys(findTestObject('Object Repository/HRM_Page_Expense/input__ExpenseAttachment'), 'C:\\Users\\sandeepk\\Downloads\\Expense.pdf')

WebUI.setText(findTestObject('Object Repository/HRM_Page_Expense/input_Amount'), '500')

WebUI.selectOptionByValue(findTestObject('Object Repository/HRM_Page_Expense/select_Currency'), 'INR', true)

WebUI.takeScreenshot()

WebUI.click(findTestObject('HRM_Page_Expense/btn_Submit'))

Date currentDateTime = new Date()

SimpleDateFormat dateFormat = new SimpleDateFormat('yyyy-MM-dd HH:mm:ss')

String formattedDateTime = dateFormat.format(currentDateTime)

println('Current Datetime is: ' + formattedDateTime)

WebUI.acceptAlert()

WebUI.mouseOver(findTestObject('Object Repository/HRM_Page_Expense/div_SuccessfullySaved'))

WebUI.verifyElementPresent(findTestObject('HRM_Page_Expense/div_SuccessfullySaved'), 0)

WebUI.mouseOver(findTestObject('Object Repository/HRM_Page_Expense/b_Expense'))

WebUI.mouseOver(findTestObject('Object Repository/HRM_Page_Expense/a_View Expense'))

WebUI.click(findTestObject('Object Repository/HRM_Page_Expense/a_View My Expense'))

WebUI.navigateToUrl('http://172.16.29.165/symfony/web/index.php/expense/viewMyExpenseReport')

submittedDateTime = WebUI.getText(findTestObject('Object Repository/HRM_Page_Expense/txt_SubmittedDateTime'), FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot()

println('Submitted DateTime is: ' + submittedDateTime)

Date date1 = dateFormat.parse(formattedDateTime)

Date date2 = dateFormat.parse(submittedDateTime)

if (date2.compareTo(date1) < 0) {
    println('Submitted DateTime is after the datetime during the submission')
}

WebUI.callTestCase(findTestCase('Logout_HRM'), [:], FailureHandling.STOP_ON_FAILURE)

