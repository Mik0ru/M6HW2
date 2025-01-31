package com.example.m6hw2.ui.screens.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.m6hw2.data.BookModel
import com.example.m6hw2.ui.activity.CustomNavController
import com.example.m6hw2.ui.screens.Screens


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailScreen(navController: CustomNavController, book: BookModel) {
    Button(
        modifier = Modifier
            .padding(top = 36.dp, start = 24.dp),
        onClick = {
            navController.navigate(Screens.Main)
        }
    ) {
        Text(text = "Back")
    }
    Column{
        Column (
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = book.title,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(bottom = 16.dp, top = 100.dp)
            )
            Column(
                modifier = Modifier
                    .width(200.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                GlideImage(
                    model = book.imageUrl,
                    contentDescription = "image",
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, top = 16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Автор: \n${book.author}",
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(vertical = 12.dp)
            )
            Text(
                text = "Описание: \n${book.description}",
                fontSize = 20.sp,
                modifier = Modifier
                    .verticalScroll(
                        rememberScrollState()
                    )
                    .padding(bottom = 24.dp, end = 16.dp)
            )
        }
    }
}