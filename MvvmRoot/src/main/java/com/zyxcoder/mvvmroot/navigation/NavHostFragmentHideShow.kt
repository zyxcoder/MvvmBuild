package com.zyxcoder.mvvmroot.navigation

import android.view.View
import androidx.navigation.Navigator
import androidx.navigation.fragment.*

/**
 * Create by zyx_coder on 2022/12/5
 * Hide - Show NavHostFragment
 */
class NavHostFragmentHideShow : NavHostFragment() {


    /**
     * @return 使用自己的FragmentNavigator
     */
    override fun createFragmentNavigator(): Navigator<out FragmentNavigator.Destination?> {
        return FragmentNavigatorHideShow(requireContext(), childFragmentManager, containerId)
    }


    private val containerId: Int
        get() {
            val id = id
            return if (id != 0 && id != View.NO_ID) {
                id
                // Fallback to using our own ID if this Fragment wasn't added via
                // add(containerViewId, Fragment)
            } else R.id.nav_host_fragment_container
        }
}