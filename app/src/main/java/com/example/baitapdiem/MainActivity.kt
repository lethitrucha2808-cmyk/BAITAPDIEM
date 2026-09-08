package com.example.baitapdiem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BaiTapDiem()
        }
    }
}

@Composable
fun BaiTapDiem() {

    var math by remember { mutableStateOf("") }
    var programming by remember { mutableStateOf("") }
    var database by remember { mutableStateOf("") }

    var ketQua by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text("THÔNG TIN ĐIỂM SINH VIÊN")

        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            value = math,
            onValueChange = { math = it },
            label = { Text("Nhập điểm Math") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = programming,
            onValueChange = { programming = it },
            label = { Text("Nhập điểm Programming") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = database,
            onValueChange = { database = it },
            label = { Text("Nhập điểm Database") }
        )

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = {

                val diemMath = math.toDouble()
                val diemProgramming = programming.toDouble()
                val diemDatabase = database.toDouble()

                val tongDiem =
                    diemMath + diemProgramming + diemDatabase

                val gpa = tongDiem / 3

                val diemCaoNhat =
                    maxOf(diemMath, diemProgramming, diemDatabase)

                val trangThai = if (gpa >= 5.0) {
                    "ĐẠT"
                } else {
                    "KHÔNG ĐẠT"
                }

                ketQua = """
                    
                    ===== KẾT QUẢ =====
                    Math: $diemMath
                    Programming: $diemProgramming
                    Database: $diemDatabase
                    
                    Tổng điểm: $tongDiem
                    Điểm trung bình: $gpa
                    Điểm cao nhất: $diemCaoNhat
                    Sinh viên: $trangThai
                """.trimIndent()
            }
        ) {
            Text("TÍNH KẾT QUẢ")
        }

        Spacer(modifier = Modifier.height(15.dp))

        Text(ketQua)
    }
}