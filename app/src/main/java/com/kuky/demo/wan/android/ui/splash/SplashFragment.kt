package com.kuky.demo.wan.android.ui.splash

import android.os.Bundle
import android.os.Handler
import android.view.View
import com.kuky.demo.wan.android.R
import com.kuky.demo.wan.android.base.BaseFragment
import com.kuky.demo.wan.android.databinding.FragmentSplashBinding

/**
 * @author kuky.
 * @description 欢迎页
 */
class SplashFragment : BaseFragment<FragmentSplashBinding>() {
    companion object {
        private val mHandler = Handler()
    }

    override fun getLayoutId(): Int = R.layout.fragment_splash

    override fun initFragment(view: View, savedInstanceState: Bundle?) {}

    override fun onResume() {
        super.onResume()
        // TODO 放在onResume中可以防止锁屏不跳转问题，发现更好的方案再替换
        mHandler.postDelayed({
            mNavController.let {
                val graph = it.navInflater.inflate(R.navigation.wan_navigation)
                    .apply { startDestination = R.id.mainFragment }
                it.graph = graph
            }
        }, 3000L)
    }
}