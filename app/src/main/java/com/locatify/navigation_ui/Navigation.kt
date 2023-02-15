import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.locatify.uiscreens.LoginScreen

import com.locatify.uiscreens.StartScreen

@Composable
fun Navigation (navController: NavHostController){

NavHost(navController = navController, startDestination = NavScreens.Start.route){
    composable(route = NavScreens.Start.route){
        StartScreen(navController)
    }
    composable(route = NavScreens.Login.route){
        LoginScreen(navController)
    }
}
}