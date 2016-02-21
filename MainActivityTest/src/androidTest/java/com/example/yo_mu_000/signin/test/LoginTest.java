package com.example.yo_mu_000.signin.test;

import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


@SuppressWarnings("rawtypes")
public class LoginTest extends ActivityInstrumentationTestCase2 {
  	private Solo solo;
  	
  	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.example.yo_mu_000.signin.MainActivity";

    private static Class<?> launcherActivityClass;
    static{
        try {
            launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
        } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
        }
    }
  	
  	@SuppressWarnings("unchecked")
    public LoginTest() throws ClassNotFoundException {
        super(launcherActivityClass);
    }

  	public void setUp() throws Exception {
        super.setUp();
		solo = new Solo(getInstrumentation());
		getActivity();
  	}
  
   	@Override
   	public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
  	}
  
	public void testRun() {
        //Wait for activity: 'com.example.yo_mu_000.signin.MainActivity'
		solo.waitForActivity("MainActivity", 2000);
        //Set default small timeout to 16120 milliseconds
		Timeout.setSmallTimeout(16120);
        //Click on Empty Text View
		solo.clickOnView(solo.getView("usernameInput"));
        //Enter the text: 'yogin'
		solo.clearEditText((android.widget.EditText) solo.getView("usernameInput"));
		solo.enterText((android.widget.EditText) solo.getView("usernameInput"), "yogin");
        //Click on Empty Text View
		solo.clickOnView(solo.getView("passwordInput"));
        //Enter the text: 'yo'
		solo.clearEditText((android.widget.EditText) solo.getView("passwordInput"));
		solo.enterText((android.widget.EditText) solo.getView("passwordInput"), "yo");
        //Click on Sign in
		solo.clickOnView(solo.getView("signInButton"));
        //Wait for activity: 'com.example.yo_mu_000.signin.Gallery'
		assertTrue("Gallery is not found!", solo.waitForActivity("Gallery"));
        //Press menu back key
		solo.goBack();
        //Click on yo
		solo.clickOnView(solo.getView("passwordInput"));
        //Enter the text: 'yog'
		solo.clearEditText((android.widget.EditText) solo.getView("passwordInput"));
		solo.enterText((android.widget.EditText) solo.getView("passwordInput"), "yog");
        //Press next button
		solo.pressSoftKeyboardNextButton();
        //Click on Sign in
		solo.clickOnView(solo.getView("signInButton"));
        //Click on Sign up
		solo.clickOnView(solo.getView("signUpButton"));
        //Wait for activity: 'com.example.yo_mu_000.signin.signUp'
		assertTrue("signUp is not found!", solo.waitForActivity("signUp"));
        //Click on Empty Text View
		solo.clickOnView(solo.getView("nameInput"));
        //Enter the text: 'yogesh'
		solo.clearEditText((android.widget.EditText) solo.getView("nameInput"));
		solo.enterText((android.widget.EditText) solo.getView("nameInput"), "yogesh");
        //Click on Empty Text View
		solo.clickOnView(solo.getView("dobInput"));
        //Set default small timeout to 28036 milliseconds
		Timeout.setSmallTimeout(28036);
        //Enter the text: '05/02/88'
		solo.clearEditText((android.widget.EditText) solo.getView("dobInput"));
		solo.enterText((android.widget.EditText) solo.getView("dobInput"), "05/02/88");
        //Click on Empty Text View
		solo.clickOnView(solo.getView("phoneInput"));
        //Enter the text: '7777758'
		solo.clearEditText((android.widget.EditText) solo.getView("phoneInput"));
		solo.enterText((android.widget.EditText) solo.getView("phoneInput"), "7777758");
        //Enter the text: 'vacoas'
		solo.clearEditText((android.widget.EditText) solo.getView("addressInput"));
		solo.enterText((android.widget.EditText) solo.getView("addressInput"), "vacoas");
        //Press next button
		solo.pressSoftKeyboardNextButton();
        //Click on submit
		solo.clickOnView(solo.getView("submitButtonSignUpId"));
        //Wait for activity: 'com.example.yo_mu_000.signin.signUpDetails'
		assertTrue("signUpDetails is not found!", solo.waitForActivity("signUpDetails"));
        //Click on Empty Text View
		solo.clickOnView(solo.getView("usernameInputSignUpDetails"));
        //Enter the text: 'yogesh'
		solo.clearEditText((android.widget.EditText) solo.getView("usernameInputSignUpDetails"));
		solo.enterText((android.widget.EditText) solo.getView("usernameInputSignUpDetails"), "yogesh");
        //Click on Empty Text View
		solo.clickOnView(solo.getView("passwordInputSignUpDetails"));
        //Enter the text: 'yog'
		solo.clearEditText((android.widget.EditText) solo.getView("passwordInputSignUpDetails"));
		solo.enterText((android.widget.EditText) solo.getView("passwordInputSignUpDetails"), "yog");
        //Click on Empty Text View
		solo.clickOnView(solo.getView("confirmpassInputSignUpDetails"));
        //Enter the text: 'yog'
		solo.clearEditText((android.widget.EditText) solo.getView("confirmpassInputSignUpDetails"));
		solo.enterText((android.widget.EditText) solo.getView("confirmpassInputSignUpDetails"), "yog");
        //Press next button
		solo.pressSoftKeyboardNextButton();
        //Click on Sign Up
		solo.clickOnView(solo.getView("signUpButtonSignUpDetailsId"));
        //Wait for activity: 'com.example.yo_mu_000.signin.MainActivity'
		assertTrue("MainActivity is not found!", solo.waitForActivity("MainActivity"));
        //Click on Empty Text View
		solo.clickOnView(solo.getView("usernameInput"));
        //Enter the text: 'yogesh'
		solo.clearEditText((android.widget.EditText) solo.getView("usernameInput"));
		solo.enterText((android.widget.EditText) solo.getView("usernameInput"), "yogesh");
        //Click on Empty Text View
		solo.clickOnView(solo.getView("passwordInput"));
        //Enter the text: 'yog'
		solo.clearEditText((android.widget.EditText) solo.getView("passwordInput"));
		solo.enterText((android.widget.EditText) solo.getView("passwordInput"), "yog");
        //Click on Sign in
		solo.clickOnView(solo.getView("signInButton"));
        //Wait for activity: 'com.example.yo_mu_000.signin.Gallery'
		assertTrue("Gallery is not found!", solo.waitForActivity("Gallery"));
        //Press menu back key
		solo.goBack();
	}
}
