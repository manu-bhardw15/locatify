package com.locatify.uiscreens

import NavScreens
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.Visibility
import androidx.navigation.NavController
import com.locatify.R

@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Welcome Back!",
            style = TextStyle(
                fontSize = 30.sp,
                fontStyle = FontStyle(R.font.m_medium)
            ),
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(24.dp, 80.dp, 0.dp),
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.black)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Sign in to your account",
            style = TextStyle(
                colorResource(id = R.color.purple_200),
                fontSize = 20.sp,
                fontStyle = FontStyle(R.font.m_light)
            ),
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(24.dp, 0.dp, 0.dp),
            fontWeight = FontWeight.Normal,
            color = colorResource(id = R.color.neutral)
        )

//        Spacer(modifier = Modifier.height(40.dp))
        Image(
            painter = painterResource(id = R.drawable.message_image),
            contentDescription = "group",
            modifier = Modifier
                .width(331.dp)
                .height(331.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(30.dp))
        var text by remember { mutableStateOf("Name") }

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            placeholder = {
                Text(
                    "Email",
                    style = TextStyle(
                        fontStyle = FontStyle(R.font.m_medium),
                        color = Color(R.color.neutral)
                    )
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors
                (
                focusedBorderColor = colorResource(id = R.color.edit_text_color),
                unfocusedBorderColor = colorResource(id = R.color.edit_text_color),
                backgroundColor = colorResource(id = R.color.edit_text_color)
            ),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 10.dp, 20.dp, 0.dp)
        )

//        EditTextMail()
        EditTextPassword()
//        SelectableTextField(navController,modifier = Modifier.height(20.dp),"mmmm", onClick = { Unit })

        Spacer(modifier = Modifier.height(70.dp))
        Button(
            onClick = {
                navController.navigate(NavScreens.Start.route)
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
            SignIn()
        }
    }
}

@Composable
fun SignIn() {
    Row(modifier =Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.Center) {
        var enabled by remember { mutableStateOf(true)}
        val context= LocalContext.current
        ClickableText(
                text = AnnotatedString("Forgot Password?",
                spanStyle = SpanStyle(fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle(R.font.m_medium),
                    color = Color(R.color.blue),
                )
            ) ,
            onClick = {
                Toast.makeText(context,"forgot pssword", Toast.LENGTH_SHORT).show()
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
}


@Composable
fun  EditTextMail(){
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Password")},
        singleLine = true,
        placeholder = { Text("Password") },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (passwordVisible)
                Icon(painter = painterResource(id = R.drawable.baseline_remove_red_eye_24), contentDescription = "")
            else Icon(painter = painterResource(id = R.drawable.hide), contentDescription = "")

            // Please provide localized description for accessibility services
            val description = if (passwordVisible) "Hide password" else "Show password"

            IconButton(onClick = {passwordVisible = !passwordVisible}){
//                Icon(imageVector  = image, description)
                Icon(painter = painterResource(id = R.drawable.baseline_remove_red_eye_24), contentDescription = "")
            }
        }
    )
}
@Composable
fun EditTextPassword(){
//    Spacer(modifier = Modifier.height(10.dp))
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    var text by remember { mutableStateOf("Password")}

    TextField(
        value = text,
        onValueChange = {text=it},
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (passwordVisible)
                Icon(painter = painterResource(id = R.drawable.baseline_remove_red_eye_24), contentDescription = "")
            else Icon(painter = painterResource(id = R.drawable.hide), contentDescription = "")

            // Please provide localized description for accessibility services
            val description = if (passwordVisible) "Hide password" else "Show password"

            IconButton(onClick = {passwordVisible = !passwordVisible}){
//                Icon(imageVector  = image, description)
                Icon(painter = painterResource(id = R.drawable.baseline_remove_red_eye_24), contentDescription = "")
            }
        },
        placeholder = { Text("Password",
            style = TextStyle(fontStyle = FontStyle(R.font.m_medium),
                color = Color(R.color.neutral)
            )
        )},
        colors = TextFieldDefaults.outlinedTextFieldColors
            (focusedBorderColor = colorResource(id =R.color.edit_text_color),
            unfocusedBorderColor = colorResource(id =R.color.edit_text_color),
            backgroundColor = colorResource(id =R.color.edit_text_color)),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 10.dp, 20.dp, 0.dp)
            .clickable { println("clickedddddddd") }


    )




}

@Composable
fun SelectableTextField(
    navController: NavController,
    modifier: Modifier = Modifier,
    textValue: String,
    onClick: () -> Unit
) {
    TextField(
        value = textValue,
        onValueChange = {},
        modifier = modifier
            .fillMaxWidth()
            .clickable {

            },
        enabled = false
    )
}