package com.kodebug.randomquotegenerator.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.shimmer

@Composable
@Preview(showBackground = true)
fun ShimmeringPlaceholder(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .shimmer()
        .fillMaxWidth()) {
        Box(modifier = modifier
            .height(20.dp)
            .fillMaxWidth()
            .background(Color.LightGray))
        Spacer(modifier = Modifier.height(18.dp))
        Box(
            modifier = modifier
                .height(20.dp)
                .fillMaxWidth(.7f)
                .align(alignment = Alignment.CenterHorizontally)
                .background(Color.LightGray)
        )
        Spacer(modifier = Modifier.height(18.dp))
        Box(
            modifier = modifier
                .height(20.dp)
                .align(alignment = Alignment.CenterHorizontally)
                .fillMaxWidth(.5f)
                .background(Color.LightGray)
        )
        Spacer(modifier = Modifier.height(38.dp))
        Box(
            modifier = modifier
                .height(6.dp)
                .align(alignment = Alignment.CenterHorizontally)
                .fillMaxWidth(.5f)
                .background(Color.LightGray)
        )
        Spacer(modifier = Modifier.height(26.dp))
        Box(
            modifier = modifier
                .height(20.dp)
                .align(alignment = Alignment.CenterHorizontally)
                .fillMaxWidth(.5f)
                .background(Color.LightGray)
        )
    }
}