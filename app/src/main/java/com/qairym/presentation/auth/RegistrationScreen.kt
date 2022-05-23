package com.qairym.presentation.auth

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.qairym.R
import com.qairym.data.utils.AuthResult
import com.qairym.presentation.Screen
import com.qairym.presentation.ui.theme.ButtonBackground
import com.qairym.presentation.ui.theme.GrayBackground
import com.qairym.presentation.ui.theme.Shapes
import com.qairym.presentation.ui.theme.TextColor
import com.qairym.presentation.auth.utils.AuthUiEvent

@ExperimentalMaterialApi
@Composable
fun RegistrationScreen(
    navController: NavHostController,
    viewModel: AuthViewModel = hiltViewModel(),
) {
    val state = viewModel.state
    val context = LocalContext.current

    LaunchedEffect(viewModel, context) {
        viewModel.authResults.collect { result ->
            when(result) {
                is AuthResult.Authorized -> {
                    navController.navigate(route = Screen.MainScreen.route) {
                        popUpTo(Screen.RegistrationScreen.route) {
                            inclusive = true
                        }
                    }
                }
                is AuthResult.Unauthorized -> {
                    Toast.makeText(
                        context,
                        "You're not authorized",
                        Toast.LENGTH_LONG
                    ).show()
                }
                is AuthResult.UnknownError -> {
                    Toast.makeText(
                        context,
                        "An unknown error occurred",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
                .padding(32.dp, 32.dp, 32.dp, 32.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painterResource(
                    id = R.drawable.qairym_logo
                ),
                contentDescription = "logo",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Регистрация",
                style = MaterialTheme.typography.body2,
                color = TextColor,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 32.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White
                ),
                shape = Shapes.large,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painterResource(
                        id = R.drawable.google_logo
                    ),
                    contentDescription = "logo",
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Войти с помощью Google",
                    style = MaterialTheme.typography.body2,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(5.dp)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Divider(
                    color = GrayBackground,
                    thickness = 2.dp,
                    modifier = Modifier
                        .weight(0.8f)
                )
                Text(
                    text = "или используйте эл. почту",
                    style = MaterialTheme.typography.body2,
                    color = TextColor,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .weight(3f)
                        .padding(5.dp)
                )
                Divider(
                    color = GrayBackground,
                    thickness = 2.dp,
                    modifier = Modifier
                        .weight(0.8f)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

//            OutlinedTextField(
//                value = state.signUpEmail,
//                onValueChange = {
//                    viewModel.onEvent(AuthUiEvent.SignUpEmailChanged(it))
//                },
//                singleLine = true,
//                label = { Text("Электронная почта") },
//                shape = RoundedCornerShape(15.dp),
//                modifier = Modifier.fillMaxWidth(),
//                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    focusedBorderColor = TextColor,
//                    focusedLabelColor = TextColor,
//                    cursorColor = TextColor
//                )
//            )

//            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = state.signUpUsername,
                onValueChange = {
                    viewModel.onEvent(AuthUiEvent.SignUpUsernameChanged(it))
                },
                singleLine = true,
                label = { Text("Имя пользователя") },
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = TextColor,
                    focusedLabelColor = TextColor,
                    cursorColor = TextColor
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = state.signUpPassword,
                onValueChange = {
                    viewModel.onEvent(AuthUiEvent.SignUpPasswordChanged(it))
                },
                singleLine = true,
                label = { Text("Пароль") },
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = TextColor,
                    focusedLabelColor = TextColor,
                    cursorColor = TextColor
                )
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = state.signUpPassword,
                onValueChange = {
                    viewModel.onEvent(AuthUiEvent.SignUpPasswordChanged(it))
                },
                singleLine = true,
                label = { Text("Повторите пароль") },
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = TextColor,
                    focusedLabelColor = TextColor,
                    cursorColor = TextColor
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (state.signUpUsername.isNotEmpty() && state.signUpPassword.isNotEmpty()) {
                        viewModel.onEvent(AuthUiEvent.SignUp)
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = ButtonBackground
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(15.dp)
            ) {
                Text(
                    text = "Регистрация",
                    style = MaterialTheme.typography.body2,
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(5.dp),
                )
                Spacer(modifier = Modifier.width(10.dp))
                Image(
                    painterResource(
                        id = R.drawable.login_arrow
                    ),
                    contentDescription = "logo",
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Уже есть аккаунт?",
                style = MaterialTheme.typography.body2,
                color = TextColor,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(),
            )
            Surface(
                onClick = {
                    navController.navigate(route = Screen.LoginScreen.route) {
                        popUpTo(Screen.RegistrationScreen.route) {
                            inclusive = true
                        }
                    }
                }
            ) {
                Text(
                    text = "Войти в аккаунт",
                    style = MaterialTheme.typography.overline,
                    color = TextColor,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                )
            }
        }
    }
    if (state.isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}
