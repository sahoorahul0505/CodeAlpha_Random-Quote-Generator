package com.kodebug.randomquotegenerator.view.presentstion.screens

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush.Companion.verticalGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kodebug.randomquotegenerator.R
import com.kodebug.randomquotegenerator.view.components.CustomFontBerkshireWash
import com.kodebug.randomquotegenerator.view.components.CustomFontCinzel
import com.kodebug.randomquotegenerator.view.components.CustomFontHandePre
import com.kodebug.randomquotegenerator.view.components.ShimmeringPlaceholder
import com.kodebug.randomquotegenerator.viewModel.QuoteViewModel

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun QuoteScreen(modifier: Modifier = Modifier, viewModel: QuoteViewModel = hiltViewModel()) {


    val state = viewModel.quoteState.collectAsState()
    val context = LocalContext.current
    val offset = Offset(4.0f, 8.0f)


    Box(modifier = modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.metalic1),
            contentDescription = null,
            modifier = modifier
                .offset(x = 0.dp, y = (-450).dp)
                .blur(radius = 6.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
                .rotate(180f)
                .size(700.dp),
//                .align(alignment = Alignment.Center),
            contentScale = ContentScale.Crop
        )

        Card(
            modifier = modifier
                .fillMaxWidth(.7f)
                .height(74.dp)
                .align(alignment = Alignment.TopCenter)
                .padding(10.dp)
                .clip(shape = RoundedCornerShape(100.dp))
        ) {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .background(
                        brush = verticalGradient(
                            listOf(
                                Color(0xFF724fab),
                                Color(0xFF8A60CC)
                            )
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "Quote Generator",
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Normal,
                        fontFamily = CustomFontBerkshireWash,
                        shadow = Shadow(
                            color = Color.Black, offset = offset, blurRadius = 10f
                        )
                    ),
                    color = Color.White
                )
            }
        }

        Image(
            painter = painterResource(id = R.drawable.metalic5),
            contentDescription = null,
            modifier = modifier
                .offset(x = 0.dp, y = 100.dp)
                .blur(radius = 6.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
                .size(700.dp),
//                .align(alignment = Alignment.Center),
            contentScale = ContentScale.Crop
        )

        Card(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(.60f)
                .align(alignment = Alignment.BottomCenter)
                .clip(
                    shape = RoundedCornerShape(
                        topStart = 50.dp,
                        topEnd = 50.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 0.dp
                    )
                ),
            colors = CardDefaults.cardColors(Color.White.copy(alpha = .94f)),
            elevation = CardDefaults.elevatedCardElevation(10.dp)
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = modifier.height(20.dp))
                when {
                    state.value.isLoading -> {
                        ShimmeringPlaceholder()
                    }

                    state.value.error != null -> {
                        Toast.makeText(context, state.value.error, Toast.LENGTH_SHORT).show()
                    }

                    state.value.data != null -> {
                        val quote = state.value.data?.first()?.q
                        val author = state.value.data?.first()?.a
                        Text(
                            text = quote.toString(),
                            style = TextStyle(
                                fontSize = 30.sp,
                                textAlign = TextAlign.Center,
                                fontFamily = CustomFontBerkshireWash,
                                fontWeight = FontWeight.Normal,
                                lineHeight = 1.4.em,
                                color = Color.Black,
                                shadow = Shadow(
                                    color = Color(0xFFC6AAF6), offset = offset, blurRadius = 10f
                                )
                            )
                        )
                        HorizontalDivider(
                            modifier = modifier
                                .fillMaxWidth(.7f)
                                .padding(top = 40.dp)
                                .shadow(elevation = 3.dp, spotColor = Color(0xFF8A60CC)),
                            color = Color(0xFF8A60CC),
                            thickness = 3.dp
                        )

                        Row(
                            modifier = modifier.padding(top = 18.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "~~  ",
                                style = TextStyle(
                                    fontSize = 30.sp,
                                    fontStyle = FontStyle.Italic,
                                    fontWeight = FontWeight.Bold,
                                    shadow = Shadow(
                                        color = Color(0xFF9D6DE1), offset = offset, blurRadius = 10f
                                    ),
                                    color = Color(0xFF8A60CC)
                                )
                            )
                            Text(
                                text = author.toString(),
                                style = TextStyle(
                                    fontSize = 18.sp,
                                    fontStyle = FontStyle.Italic,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = CustomFontCinzel,
                                    color = Color.Black,
                                    textDecoration = TextDecoration.Underline,
                                    letterSpacing = 2.sp
                                )
                            )
                            Text(
                                text = "  ~~",
                                style = TextStyle(
                                    fontSize = 30.sp,
                                    fontStyle = FontStyle.Italic,
                                    fontWeight = FontWeight.Bold,
                                    shadow = Shadow(
                                        color = Color(0xFF9D6DE1), offset = offset, blurRadius = 10f
                                    ),
                                    color = Color(0xFF8A60CC)
                                )
                            )
                        }
                    }
                }

            }

        }

        Image(
            painter = painterResource(id = R.drawable.energy3),
            contentDescription = null,
            modifier = modifier
                .offset(x = 0.dp, y = (650).dp)
                .rotate(10f)
                .blur(radius = 30.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded),
            contentScale = ContentScale.Crop
        )

        OutlinedButton(
            onClick = {
                viewModel.getRandomQuote()
            },
            modifier = modifier
                .height(120.dp)
                .width(300.dp)
                .align(alignment = Alignment.BottomCenter)
                .padding(bottom = 50.dp),
            colors = ButtonDefaults.buttonColors(Color.White.copy(alpha = .4f)),
//            elevation = ButtonDefaults.buttonElevation(10.dp),
            border = BorderStroke(4.dp, Color(0xFF8A60CC))
        ) {
            if (state.value.isLoading) {
                Text(
                    text = "Loading...",
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = CustomFontHandePre,
                        color = Color(0xFF8A60CC),
                        shadow = Shadow(
                            color = Color.White, offset = offset, blurRadius = 10f
                        )
                    )
                )
            } else {
                Text(
                    text = "New Quote",
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = CustomFontHandePre,
                        color = Color(0xFF8A60CC),
                        shadow = Shadow(
                            color = Color.White, offset = offset, blurRadius = 10f
                        )
                    )
                )
            }
        }
        Text(
            text = "Made with ❤️ by KodeBug.",
            style = TextStyle(
                color = Color(0xFF8A60CC)
            ),
            modifier = modifier
                .padding(6.dp)
                .align(Alignment.BottomCenter)
        )
    }
}