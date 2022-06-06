@file:Suppress("RemoveEmptyParenthesesFromLambdaCall", "RemoveEmptyParenthesesFromLambdaCall")

package binar.greta.pert6_tugas.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import binar.greta.pert6_tugas.model.GetAllNewsItem
import binar.greta.pert6_tugas.view.ui.theme.Pert6_TugasTheme

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pert6_TugasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val detail = intent.getSerializableExtra("DETAIL") as GetAllNewsItem
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text(text = detail.title)
                        Text(text = detail.description)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting3(name: String) {
    Column() {

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview3() {
    Pert6_TugasTheme {
        Greeting3("Android")
    }
}