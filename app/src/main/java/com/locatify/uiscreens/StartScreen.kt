package com.locatify.uiscreens

import NavScreens
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.locatify.R

@Composable
fun StartScreen(navController: NavController) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Locatify", style = TextStyle(
                colorResource(id = R.color.purple_200),
                fontSize = 40.sp
            ), textAlign = TextAlign.Center,
            modifier = Modifier.padding(125.dp, 77.dp, 115.dp), fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(52.dp))

        Image(
            painter = painterResource(id = R.drawable.group_sign), contentDescription = "group",
            modifier = Modifier
                .width(331.dp)
                .height(331.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(50.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                "Always be calm for your\n" +
                        " loved ones",
                Modifier.padding(14.dp, 0.dp, 14.dp),
                textAlign = TextAlign.Center,
                style = typography.h4,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(70.dp))
        Button(
            onClick = {
                navController.navigate(NavScreens.Login.route)
            },
            modifier = Modifier
                .height(70.dp)
                .width(327.dp)
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(16.dp),
            colors= ButtonDefaults.buttonColors(backgroundColor =
            colorResource(id = R.color.purple_200))
        )
        {
            Text(text = "Sign In", style = TextStyle(color = Color.White), fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(10.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.CenterHorizontally)
                .padding(10.dp)
                .padding(50.dp, 0.dp, 0.dp)
        ) {
            AnnotatedClickableText()
        }
    }
}

@Composable
fun AnnotatedClickableText() {

    Row(modifier =Modifier.fillMaxWidth()) {
        Text(text = "Don't have an account?",
            style = TextStyle(colorResource(id = R.color.blue),
            fontSize = 20.sp,
                fontStyle = FontStyle(R.font.m_medium)
            )
        )

        var enabled by remember { mutableStateOf(true)}
        val context= LocalContext.current
        ClickableText(
            text = AnnotatedString(" Sign Up",
                spanStyle = SpanStyle(fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle(R.font.m_medium),
                color = colorResource(id = R.color.purple_200)
                )
            ) ,
            onClick = {
                      Toast.makeText(context,"jkahjka",Toast.LENGTH_SHORT).show()
            },
            )

//        ClickableText(
//            Text(text = "Sign In",
//                style = TextStyle(colorResource(id = R.color.purple_200),
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 20.sp,
//                    fontStyle = FontStyle(R.font.m_medium),
//                    )
//            )




    }



//    val annotatedText = buildAnnotatedString {
//        //append your initial text
//
//        withStyle(
//            style = SpanStyle(
//                colorResource(id = R.color.blue),
//                fontSize = 20.sp,
//               fontStyle = FontStyle(R.font.m_medium)
//            )
//        ) {
//            append("Don't have an account? ")
//
//        }
//
//        //Start of the pushing annotation which you want to color and make them clickable later
//        pushStringAnnotation(
//            tag = "SignUp",// provide tag which will then be provided when you click the text
//            annotation = "SignUp"
//        )
//        //add text with your different color/style
//        withStyle(
//            style = SpanStyle(
//                colorResource(id = R.color.purple_200),
//                fontWeight = FontWeight.Bold,
//                        fontSize = 20.sp,
//                fontStyle = FontStyle(R.font.m_medium)
//            )
//        ) {
//            append("Sign Up")
//        }
//        // when pop is called it means the end of annotation with current tag
//        pop()
//    }
//
//    ClickableText(
//        text = annotatedText,
//        onClick = { offset ->
//            annotatedText.getStringAnnotations(
//                tag = "SignUp",// tag which you used in the buildAnnotatedString
//                start = offset,
//                end = offset
//            )[0].let { annotation ->
//                //do your stuff when it gets clicked
//                Log.d("Clicked", annotation.item)
//            }
//        }
//    )
}