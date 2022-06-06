@file:Suppress("RemoveEmptyParenthesesFromLambdaCall")

package binar.greta.pert6_tugas.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import binar.greta.pert6_tugas.model.GetAllNewsItem
import binar.greta.pert6_tugas.view.ui.theme.Pert6_TugasTheme
import binar.greta.pert6_tugas.viewmodel.NewsVM
import coil.compose.rememberImagePainter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pert6_TugasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val newsVM = viewModel(modelClass = NewsVM::class.java)
                    val datanews by newsVM.datastate.collectAsState()

                    LazyColumn{
                        if (datanews.isEmpty()){
                            item {

                            }
                        }
                        items(datanews){
                            Greeting2(news = it)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting2(news : GetAllNewsItem) {
    Column(modifier = Modifier.padding(15.dp)) {
        val mCon = LocalContext.current
        Card(modifier = Modifier
            .clickable {
                val pindah = Intent(mCon, DetailActivity::class.java)
                pindah.putExtra("DETAIL", news)
                mCon.startActivity(pindah)
                Toast.makeText(mCon, news.title, Toast.LENGTH_LONG).show()
            }
            .padding(5.dp)
            .fillMaxWidth()) {
            Row() {
                Image(painter = rememberImagePainter(data = news.image), contentDescription = "icon",
                modifier = Modifier.height(50.dp)
                    .padding(5.dp))
                Column(modifier = Modifier.padding(start = 15.dp)) {
                    Text(text = news.title)
                    Text(text = news.author)
                    Text(text = news.createdAt)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview2() {
    Pert6_TugasTheme {
//        Greeting2("Android")
    }
}