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

// Kliknięcie w link płatnosci.
WebUI.click(findTestObject('Object Repository/Wykonanie przelewu/LinkPayments'))

// Ustawienie odbiorcy
WebUI.setText(findTestObject('Object Repository/Wykonanie przelewu/FieldReceiver'), receiver)

// Ustawienie konta do przelania kwoty.
WebUI.setText(findTestObject('Wykonanie przelewu/FieldAccountId'), accountId)

// Ustawienie kwoty.
WebUI.setText(findTestObject('Object Repository/Wykonanie przelewu/FieldAmount'), amount.toString())

/// Ustawienie tematu przelewu.
WebUI.setText(findTestObject('Object Repository/Wykonanie przelewu/FieldSubject'), subject)

// Sprawdzenie czy roznica na aktualnym stanie konta po wykonaniu przelewu jest wlasciwa.
WebUI.verifyEqual((availableAmount - WebUI.getText(findTestObject('Object Repository/Wykonanie przelewu/TextMoneyAfterTransfer')).replace(' ', '').replace(',', '.').toDouble()).round(2), amount)

// Ustawienie daty realizacji
WebUI.setText(findTestObject('Object Repository/Wykonanie przelewu/FieldRealisationDate'), realisationDate)

// Klikniecie w przycisk dalej.
WebUI.click(findTestObject('Object Repository/Wykonanie przelewu/ButtonNext'))