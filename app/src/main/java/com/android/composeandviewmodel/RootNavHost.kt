package com.android.composeandviewmodel

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController


@Composable
fun RootNavHost() {
    val remNavController = rememberNavController()
    NavHost(
        navController = remNavController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen {
                remNavController.navigate(Screen.Home.route)
            }
        }
        composable(Screen.Home.route) {
            HomeScreen(productId ="", productDetailScreen = {
                val route = Screen.ProductDetail.createRoute(productId = it)
                remNavController.navigate(route)
            })
        }

        composable(route = Screen.ProductDetail.route) {navBackStackEntry ->

            val productId = navBackStackEntry.arguments?.getString("productId")

            ProductDetail(productId.orEmpty()) {

                remNavController.navigateUp()
            }
        }
//        dialog(
//            route = Screen.ProductDetail.route
//        ) {
//            ProductDetail()
//        }
    }
}