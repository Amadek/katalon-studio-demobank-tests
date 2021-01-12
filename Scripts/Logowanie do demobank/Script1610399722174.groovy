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

WebUI.openBrowser(websiteUrl)

// Sprawdzenie wyswietlenia "to pole jest wymagane" dla pola identyfikator.
WebUI.click(findTestObject('Logowanie do demobank/FieldID'))

WebUI.click(findTestObject('Logowanie do demobank/TextLoginHeader'))

WebUI.verifyElementPresent(findTestObject('Logowanie do demobank/RequiredFieldText'), 1)

// Wypełnienie pola identyfikator.
WebUI.click(findTestObject('Logowanie do demobank/KeyboardIcon'))

WebUI.click(findTestObject('Logowanie do demobank/KeyBoard_Q'))
WebUI.click(findTestObject('Logowanie do demobank/KeyBoard_A'))
WebUI.click(findTestObject('Logowanie do demobank/Keyboard_Z'))
WebUI.click(findTestObject('Logowanie do demobank/KeyboardAccept'))

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Logowanie do demobank/FieldID'), "value"), "qaz", false)

WebUI.setText(findTestObject('Logowanie do demobank/FieldID'), userId)

// Sprawdzenie działania znaku zapytania przy polu identyfikator.
WebUI.mouseOver(findTestObject('Logowanie do demobank/QuestionMark'))

WebUI.verifyElementPresent(findTestObject('Logowanie do demobank/QuestionMarkInfo'), 1)

// Sprawdzenie zapomniałem identyfikatora.
WebUI.click(findTestObject('Logowanie do demobank/LinkForgetID'))

WebUI.verifyElementPresent(findTestObject('Logowanie do demobank/DialogBox'), 1)

WebUI.click(findTestObject('Logowanie do demobank/DialogBoxExit'))

// Zatwierdzenie formularza przyciskiem dalej.
WebUI.click(findTestObject('Logowanie do demobank/ButtonNext'))

// Sprawdzenie wyswietlenia "to pole jest wymagane" dla pola hasła.
Thread.sleep(1000)
WebUI.waitForElementPresent(findTestObject('Logowanie do demobank/FieldPassword'), 5)
WebUI.waitForElementClickable(findTestObject('Logowanie do demobank/FieldPassword'), 5)
WebUI.click(findTestObject('Logowanie do demobank/FieldPassword'))

WebUI.click(findTestObject('Logowanie do demobank/TextLoginHeader'))

WebUI.verifyElementPresent(findTestObject('Logowanie do demobank/TextRequiredFieldPassword'), 1)

// Wypełnienie pola password.
WebUI.click(findTestObject('Object Repository/Logowanie do demobank/KeyboardPassword'))

WebUI.click(findTestObject('Object Repository/Logowanie do demobank/KeyboardPassword_Q'))
WebUI.click(findTestObject('Object Repository/Logowanie do demobank/KeyboardPassword_A'))
WebUI.click(findTestObject('Object Repository/Logowanie do demobank/KeyboardPassword_Z'))
WebUI.click(findTestObject('Object Repository/Logowanie do demobank/KeyboardPasswordAccept'))

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Logowanie do demobank/FieldPassword'), "value"), "qaz", false)

WebUI.setText(findTestObject('Logowanie do demobank/FieldPassword'), userPassword)

// Sprawdzenie zapomniałem hasła.
WebUI.click(findTestObject('Object Repository/Logowanie do demobank/LinkForgetPassword'))

WebUI.verifyElementPresent(findTestObject('Logowanie do demobank/DialogBox'), 1)

WebUI.click(findTestObject('Logowanie do demobank/DialogBoxExit'))

// Sprawdzenie działania znaku zapytania przy polu hasła.
WebUI.mouseOver(findTestObject('Object Repository/Logowanie do demobank/QuestionMarkForPassword'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Logowanie do demobank/QuestionMarkInfoForPassword'), 1)

// Kliknięcie przycisku zaloguj się.
WebUI.click(findTestObject('Logowanie do demobank/ButtonNext'))

// Sprawdzenie loginu po zalogowaniu się do panelu.
WebUI.verifyElementPresent(findTestObject('Object Repository/Logowanie do demobank/TextUserName'), 5)
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Logowanie do demobank/TextUserName')), userFirstName + " " + userLastName, false)

