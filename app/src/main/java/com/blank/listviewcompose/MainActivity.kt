package com.blank.listviewcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.blank.listviewcompose.ui.androidNameList
import com.blank.listviewcompose.ui.theme.ListviewComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListviewComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   Column{
                       listRow()
                       gridView()
                       listColumn()
                   }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun listColumn() {
    LazyColumn(
        contentPadding = PaddingValues(8.dp)
    ) {
        items(androidNameList) { item ->
            Column {
                Text(text = item.name)
                Divider()
            }
        }
    }
}

@Composable
fun listRow(modifier: Modifier = Modifier) {
    LazyRow {
        items(androidNameList) { item ->
            Column(
                Modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = modifier
                        .size(64.dp)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(50)),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = item.imageResourceId),
                    contentDescription = null
                )
                Text(text = item.name)
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun gridView(modifier: Modifier = Modifier) {

    LazyVerticalGrid(cells = GridCells.Fixed(2)) {
        items(androidNameList) { item ->
            Image(
                modifier = modifier
                    .size(64.dp)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(50)),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = item.imageResourceId),
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewListColumn() {
    listColumn()
}

@Preview(showBackground = true)
@Composable
fun previewListRow() {
    listRow()
}

@Preview(showBackground = true)
@Composable
fun previewGrid() {
    gridView()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ListviewComposeTheme {
        Greeting("Android")
    }
}
