package ir.reza_mahmoudi.githubusers.feature_search.presentation

import androidx.navigation.NavController
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import ir.reza_mahmoudi.githubusers.core.presentation.MainActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.mockito.Mockito.mock
import ir.reza_mahmoudi.githubusers.R
import ir.reza_mahmoudi.githubusers.core.util.atPositionOnView
import ir.reza_mahmoudi.githubusers.feature_search.util.test_data.SEARCH_RESPONSE_FAKE_DATA
import org.junit.Test

@HiltAndroidTest
@ExperimentalCoroutinesApi
class SearchFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var mActivityRule = ActivityScenarioRule(MainActivity::class.java)


    @Before
    fun setup() {
        hiltRule.inject()
        val navController = mock(NavController::class.java)
        navController.navigate(R.id.frgSearch)
    }

    @Test
    fun navigate_to_SearchFragment_should_display_recyclerview() {
        onView(withId(R.id.rcv_users_list))
            .check(matches(isDisplayed()))
    }


    @Test
    fun navigate_to_SearchFragment_should_display_searchBox() {
        onView(withId(R.id.lyt_search_box)).check(matches(isDisplayed()))
        onView(withId(R.id.edt_search)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_search)).check(matches(isDisplayed()))
    }


    @Test
    fun search_specific_item_should_display_the_item_at_expected_index() {
        val userItem = SEARCH_RESPONSE_FAKE_DATA.users[0]

        onView(withId(R.id.edt_search)).perform(ViewActions.replaceText(userItem.login))

        onView(withId(R.id.btn_search)).perform(ViewActions.click())


        onView(withId(R.id.rcv_users_list))
            .perform(scrollToPosition<UserListAdapter.ViewHolder>(0))
            .check(
                matches(
                    atPositionOnView(
                        0,
                        withText(userItem.login),
                        R.id.txt_user_name
                    )
                )
            )
    }
}