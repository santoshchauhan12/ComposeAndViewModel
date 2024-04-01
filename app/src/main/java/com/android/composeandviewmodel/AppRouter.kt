package com.android.composeandviewmodel

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument


private object Route {
    const val LOGIN = "login"
    const val HOME = "home"
    const val PRODUCT_DETAIL = "productDetail/${ArgParams.PRODUCT_ID}}"
}
//
//sealed class Screen(val route: String) {
//
//    object ProductDetail: Screen(
//        route = Route.PRODUCT_DETAIL,
//        navArguments = listOf(navArgument(ArgParams.PRODUCT_ID) {
//            type = NavType.Companion.StringType}){
//            fun createRoute(productId: String) =
//                Routes.PRODUCT_DETAIL.replace(
//                    ArgParams.toPath(ArgParams.PRODUCT_ID), productId)
//        }
//}


sealed class Screen(val route: String, val navArgument: List<NamedNavArgument> = emptyList()) {
    object Login : Screen(Route.LOGIN)
    object Home : Screen(Route.HOME)

    object ProductDetail : Screen(
        Route.PRODUCT_DETAIL,
        listOf(navArgument(ArgParams.PRODUCT_ID) {
            type = NavType.Companion.StringType
        }
        )
    ) {

        fun createRoute(productId: String) =
            Route.PRODUCT_DETAIL
                .replace(ArgParams.toPath(ArgParams.PRODUCT_ID), productId)
    }
}


private object ArgParams {
    const val PRODUCT_ID = "productId"

    fun toPath(param: String) = "{${param}}"
}
