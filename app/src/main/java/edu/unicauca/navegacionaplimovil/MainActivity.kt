package edu.unicauca.navegacionaplimovil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.unicauca.navegacionaplimovil.ui.theme.NavegacionAplimovilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavegacionAplimovilTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationComposable(navHostController = rememberNavController())
                }
            }
        }
    }
}



@Composable
fun NavigationComposable(navHostController: NavHostController = rememberNavController()){

    NavHost(
        navController = navHostController,
        startDestination = ScreensEnum.Home.name) {
        composable(route = ScreensEnum.Home.name){
            Screen(
                title = stringResource(R.string.home_screen_title),
                actionTitle = stringResource(R.string.bt_next),
                color = Color.Yellow,
                onClick = {navHostController.navigate(ScreensEnum.Second.name)}
            )
        }
        composable(route = ScreensEnum.Second.name){
            Screen(
                title = stringResource(R.string.second_screen_title),
                actionTitle = stringResource(R.string.bt_next),
                color = Color.Red,
                onClick = {navHostController.navigate(ScreensEnum.Third.name)}
            )
        }
        composable(route = ScreensEnum.Third.name){
            Screen(
                title = stringResource(R.string.third_screen_title),
                actionTitle = stringResource(R.string.bt_home),
                color = Color.Gray,
                onClick = {navHostController.navigate(ScreensEnum.Home.name)}
            )
        }

    }
}

@Composable
fun Screen(title: String,
           actionTitle: String,
           onClick: () -> Unit,
           color: Color
){
    Surface(color = color) {
        Column (horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()){
            Text(text = title)
            Button(onClick = onClick) {
                Text(text = actionTitle)
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewInicial(){
    NavegacionAplimovilTheme {
        Screen(
            title = "Sample Screen",
            actionTitle = "Action",
            color = Color.Gray,
            onClick = {}
        )
    }
}

enum class ScreensEnum(){
    Home,
    Second,
    Third,
}


/*
@Composable
fun PantallaInicial(
    onNextClick: ()-> Unit
){
    Column (horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()){
        Text(text = "Bienvenidos")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onNextClick) {
            Text(text = "Iniciar")
        }
    }
}

@Composable
fun SegundaPantalla(
    onClick:()->Unit
){
    Column (horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()){
        Text(text = "Segunda pantalla")
        Button(onClick = onClick) {
            Text(text = "Siguiente")
        }
    }
}

@Composable
fun TerceraPantalla(
    irAinicio: ()->Unit
){
    Column (horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()){
        Text(text = "Ultima Pantalla")
        Button(onClick = irAinicio) {
            Text(text = "Ir al Inicio")
        }
    }
}

 */



