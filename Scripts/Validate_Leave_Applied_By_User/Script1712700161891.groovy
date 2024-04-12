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

WebUI.callTestCase(findTestCase('Login_To_HRM'), [('username') : username, ('password') : password], FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Object Repository/HRM_Page_Leave/b_Leave'))

WebUI.click(findTestObject('Object Repository/HRM_Page_Leave/a_Leave'))

WebUI.navigateToUrl('http://172.16.29.165/symfony/web/index.php/leave/applyLeave')

WebUI.verifyElementPresent(findTestObject('Object Repository/HRM_Page_Leave/h1_Apply Leave'), 0)

WebUI.selectOptionByValue(findTestObject('Object Repository/HRM_Page_Leave/select_LeaveOptions'), '9', true)

// Function to check if a given date is a weekend (Saturday or Sunday)
// Get the current date
Date currentDate = new Date()

// Generate a random number of days (you can change the range as per your requirement)
int randomDays = new Random().nextInt(30) + 1

// Add the random number of days to the current date
Calendar cal = Calendar.getInstance()

cal.setTime(currentDate)

cal.add(Calendar.DAY_OF_MONTH, randomDays)

Date futureDate = cal.getTime()

// Check if the future date falls on a weekend
while (isWeekend(futureDate)) {
    // If it's a weekend, add 2 more days
    cal.add(Calendar.DAY_OF_MONTH, 2)

    futureDate = cal.getTime()
}

// Format the final date as "yyyy-MM-dd"
SimpleDateFormat dateFormat = new SimpleDateFormat('yyyy-MM-dd')

String futureRandomDate = dateFormat.format(futureDate)

WebUI.setText(findTestObject('Object Repository/HRM_Page_Leave/input__applyleavetxtFromDate'), futureRandomDate)

WebUI.sendKeys(findTestObject('Object Repository/HRM_Page_Leave/input__applyleavetxtFromDate'), Keys.chord(Keys.ENTER))

WebUI.selectOptionByLabel(findTestObject('Object Repository/HRM_Page_Leave/select_Full DayHalf Day'), 'Full Day', false)

WebUI.setText(findTestObject('Object Repository/HRM_Page_Leave/text_Comment_ApplyLeave'), 'Test')

WebUI.click(findTestObject('Object Repository/HRM_Page_Leave/input__applyBtn'))

WebUI.click(findTestObject('Object Repository/HRM_Page_Leave/input_Confirmation Required'))

WebUI.verifyElementPresent(findTestObject('Object Repository/HRM_Page_Leave/div_SuccessfullySubmitted'), 0)

WebUI.callTestCase(findTestCase('Logout_HRM'), [:], FailureHandling.STOP_ON_FAILURE)

def isWeekend(def date) {
    Calendar cal = Calendar.getInstance()

    cal.setTime(date)

    int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK)

    return (dayOfWeek == Calendar.SATURDAY) || (dayOfWeek == Calendar.SUNDAY)
}

