package com.xamarin.testcloud.simplecreditcardvalidator;

import android.app.Application;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class SimpleCreditCardValidatorTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void test_Acessando_a_Tela_Inicial() {
        onView(withText("Simple Credit Card Validator")).check(matches(isDisplayed()));
    }

    @Test
    public void test_Validacao_de_Cartao_De_Credito_Com_Sucesso() {
        onView(withId(R.id.creditCardNumberText))
                .perform(typeText("1234567890123456"), closeSoftKeyboard());
        onView(withId(R.id.validateButton)).perform(click());

        onView(withId(R.id.validationSuccessMessage))
                .check(matches(withText("The credit card number is valid!")));
    }

    @Test
    public void test_Validaca_de_Cartao_De_Credito_Com_Campo_Em_Branco() {
        onView(withId(R.id.creditCardNumberText))
                .perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.validateButton)).perform(click());

        onView(withId(R.id.errorMessagesText))
                .check(matches(withText("This is not a credit card number.")));
    }

    @Test
    public void test_Validaca_de_Cartao_De_Credito_com_numero_muito_grande() {
        onView(withId(R.id.creditCardNumberText))
                .perform(typeText("99999999999999999"), closeSoftKeyboard());
        onView(withId(R.id.validateButton)).perform(click());

        onView(withId(R.id.errorMessagesText))
                .check(matches(withText("Credit card number is too long.")));
    }

    @Test
    public void test_Validaca_de_Cartao_De_Credito_com_numero_muito_pequeno() {
        onView(withId(R.id.creditCardNumberText))
                .perform(typeText("1234"), closeSoftKeyboard());
        onView(withId(R.id.validateButton)).perform(click());

        onView(withId(R.id.errorMessagesText))
                .check(matches(withText("Credit card number is too short.")));
    }
}