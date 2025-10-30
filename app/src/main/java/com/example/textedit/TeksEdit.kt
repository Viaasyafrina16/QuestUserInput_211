package com.example.textedit

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf

@Composable
fun FormDataDiri(modifier : Modifier
){
    //variabel-variabel untuk mengingat nilai masukan dari keyboard
    var textNama by remember{ mutableStateOf(value = "")}
    var textAlamat by remember{ mutableStateOf(value = "")}
    var textJK by remember{ mutableStateOf(value = "")}
}