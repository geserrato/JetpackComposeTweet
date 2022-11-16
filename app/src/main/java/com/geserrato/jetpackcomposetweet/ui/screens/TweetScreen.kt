package com.geserrato.jetpackcomposetweet.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.geserrato.jetpackcomposetweet.R

@Composable
fun TweetScreen() {

    Column() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            HeaderScreen()
            BodyScreen()
        }
        Divider()
    }
}

@Composable
fun BodyScreen() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp)
    ) {
        TitleTweetBody()
        BodyText()
        ImageBody()
        FooterBody(Modifier.padding(end = 4.dp))
    }
}

@Composable
fun FooterBody(modifier: Modifier) {
    var chat by remember { mutableStateOf(false) }
    var rt by remember { mutableStateOf(false) }
    var liked by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        SocialIcon(
            modifier = Modifier.weight(1f),
            unSelectedIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_chat),
                    contentDescription = "Icon chat",
                    modifier = modifier,
                    tint = Color(0xFF7E8B98)
                )
            },
            selectedIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_chat_filled),
                    contentDescription = "Icon chat",
                    modifier = modifier,
                    tint = Color(0xFF7E8B98)
                )
            },
            isSelected = chat
        ) {
            chat = !chat
        }
        SocialIcon(
            modifier = Modifier.weight(1f),
            unSelectedIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_rt),
                    contentDescription = "Icon chat",
                    modifier = modifier,
                    tint = Color(0xFF7E8B98)
                )
            },
            selectedIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_rt),
                    contentDescription = "Icon chat",
                    modifier = modifier,
                    tint = Color(0xFF2DCC10)
                )
            },
            isSelected = rt
        ) {
            rt = !rt
        }
        SocialIcon(
            modifier = Modifier.weight(1f),
            unSelectedIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_like),
                    contentDescription = "Icon Like",
                    modifier = modifier,
                    tint = Color(0xFF7E8B98)
                )
            },
            selectedIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_like_filled),
                    contentDescription = "Icon Like",
                    modifier = modifier,
                    tint = Color(0xFFE70923)
                )
            },
            isSelected = liked
        ) {
            liked = !liked
        }

        Icon(painter = painterResource(id = R.drawable.ic_share), contentDescription = "Icon Share")
    }
}

@Composable
fun SocialIcon(
    modifier: Modifier,
    unSelectedIcon: @Composable () -> Unit,
    selectedIcon: @Composable () -> Unit,
    isSelected: Boolean,
    onItemSelected: () -> Unit
) {
    val defaultValue = 1
    Row(
        modifier = Modifier.clickable { onItemSelected() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isSelected) {
            selectedIcon()
        } else {
            unSelectedIcon()
        }

        Text(
            text = if (isSelected) (defaultValue + 1).toString() else defaultValue.toString(),
            color = Color(0xFF7E8B98),
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 5.dp)
        )
    }
}

@Composable
fun ImageBody() {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "Body screen",
        modifier = Modifier
            .fillMaxWidth()
            .size(200.dp)
            .clip(RoundedCornerShape(10)),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun TitleTweetBody() {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Top) {
        Text(
            text = "Gerardo Estrella",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(text = "@geserrato", modifier = Modifier.padding(end = 8.dp))
        Text(text = "11 nov.", modifier = Modifier.padding(end = 8.dp))
        Spacer(modifier = Modifier.weight(1f))
        Icon(painter = painterResource(id = R.drawable.ic_dots), contentDescription = "Dots Menu")
    }
}

@Composable
fun BodyText() {
    Text(
        text = "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto.",
        modifier = Modifier.padding(bottom = 16.dp)
    )
}


@Composable
fun HeaderScreen() {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "Image Profile",
        modifier = Modifier
            .clip(CircleShape)
            .size(55.dp)
    )
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun TweetScreenPreview() {
    TweetScreen()
}