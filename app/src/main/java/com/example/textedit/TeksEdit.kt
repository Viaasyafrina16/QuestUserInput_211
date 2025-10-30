package com.example.textedit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp

@Composable
fun FormDataDiri(modifier : Modifier
){
    //variabel-variabel untuk mengingat nilai masukan dari keyboard
    var textNama by remember { mutableStateOf( "")}
    var textAlamat by remember{ mutableStateOf( "")}
    var textJK by remember{ mutableStateOf("")}

    //variabel-variabel untuk menyimpan data yang diperoleh dari komponen
    var nama by remember {mutableStateOf( "")}
    var alamat by remember {mutableStateOf( "")}
    var jenis by remember {mutableStateOf( "")}

    val gender:List<String> = ListOf("Laki-laki", "Perempuan")

    Column (modifier = Modifier.padding(top= 50.dp),
        verticalArrangement = Arrangement.top,
        horizontalAlignment = Alignment.CenterHorizontally){
        OutlinedTextField(
            value = textNama,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.width(  250.dp),
            label = { Text(text = "Nama Lengkap" ) },
            onValueChange =  {
                textNama = it

            }
        )
        Row {
            gender.forEach { item ->
                Row(
                    modifier = Modifier.selectable(
                        selected = textJK == item,
                        onClick = { textJK = item }
                    ),
                    verticalAlignment = Alignment.CenterHorizontally
                ) {
                    RadioButton(
                        selected = textJK == item,
                        onClick = {
                            textJK = item
                        })
                    Text(item)

                }
            }
        }
        OutlinedTextField(
            value= textAlamat,
            singleLine =  true,
            modifier = Modifier.width( 250.dp),
            label = { Text(text = "Alamat Lengkap" )},
            onValueChange = {
                textAlamat = it
            }
        )

        HorizontalDivider(
            modifier = Modifier.padding(
                bottom = dimensionResource(R.dimen.padding_medium),
                top = dimensionResource(
                    id = R.dimen.padding_medium
                )),
            thickness = dimensionResource(R.dimen.divider_tipis)
            color= Color.darkGrey
        )
        Button(
            modifier = Modifier.fillMaxWidth( 1f),
            enabled = textNama,
            onClick = {
                nama = textNama
                jenis=textJK
                alamat = textAlamat
            }
        ){
            Text(text = stringResource(R.string.submit))
        }

        HorizontalDivider(
            modifier = Modifier.padding(
                bottom = dimensionResource(R.dimen.padding_medium),
                top = dimensionResource(
                    id = R.dimen.padding_medium
                )),
            thickness = dimensionResource(R.dimen.divider_tipis)
            color= Color.darkGrey

        )







    }
}