package edu.unicauca.navegacionaplimovil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    Navegacion()
                }
            }
        }
    }
}

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

@Composable
fun Navegacion(){
    val navHostController = rememberNavController()
    NavHost(navController = navHostController,
        startDestination = Pantallas.Inicio.name) {
        composable(route = Pantallas.Inicio.name){
            PantallaInicial(
                onNextClick = {navHostController.navigate(Pantallas.Segunda.name)}
            )
        }
        composable(route = Pantallas.Segunda.name){
            SegundaPantalla(
                onClick = {navHostController.navigate(Pantallas.Tercera.name)}
            )
        }
        composable(route = Pantallas.Tercera.name){
            TerceraPantalla(
                irAinicio = {navHostController.navigate(Pantallas.Inicio.name)}
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewInicial(){
    NavegacionAplimovilTheme {
        PantallaInicial(
            onNextClick = {}
        )
    }
}

enum class Pantallas(){
    Inicio,
    Segunda,
    Tercera,
}




