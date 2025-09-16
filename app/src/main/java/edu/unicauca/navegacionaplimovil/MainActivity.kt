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
import androidx.compose.ui.graphics.Color
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
                    Navegacion(navHostController = rememberNavController())
                }
            }
        }
    }
}



@Composable
fun Navegacion(navHostController: NavHostController = rememberNavController()){

    NavHost(
        navController = navHostController,
        startDestination = Pantallas.Inicio.name) {
        composable(route = Pantallas.Inicio.name){
            Pantalla(
                title = "Pantalla Inicial",
                actionTitle = "Siguiente",
                color = Color.Yellow,
                onClick = {navHostController.navigate(Pantallas.Segunda.name)}
            )
        }
        composable(route = Pantallas.Segunda.name){
            Pantalla(
                title = "Segunda Pantalla",
                actionTitle = "Siguiente",
                color = Color.Red,
                onClick = {navHostController.navigate(Pantallas.Tercera.name)}
            )
        }
        composable(route = Pantallas.Tercera.name){
            Pantalla(
                title = "Pantalla Final",
                actionTitle = "Ir al Inicio",
                color = Color.Gray,
                onClick = {navHostController.navigate(Pantallas.Inicio.name)}
            )
        }

    }
}

@Composable
fun Pantalla(title: String,
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
        Pantalla(
            title = "Ejemplo Pantalla",
            actionTitle = "Accion",
            color = Color.Gray,
            onClick = {}
        )
    }
}

enum class Pantallas(){
    Inicio,
    Segunda,
    Tercera,
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



