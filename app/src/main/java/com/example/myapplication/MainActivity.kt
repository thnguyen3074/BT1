package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import android.widget.ImageButton
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnBack: ImageButton = findViewById(R.id.btn_back)
        val btnEdit: ImageButton = findViewById(R.id.btn_edit)
        val editName: EditText = findViewById(R.id.edit_profile_name)
        val editLocation: EditText = findViewById(R.id.edit_profile_location)

        // Biến kiểm tra trạng thái chỉnh sửa
        var isEditing = false

        btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed() // Quay lại màn hình trước đó
        }

        // Xử lý khi nhấn nút Edit
        btnEdit.setOnClickListener {
            isEditing = !isEditing

            if (isEditing) {
                // Bật chế độ chỉnh sửa
                editName.isEnabled = true
                editLocation.isEnabled = true
                editName.requestFocus()

                // Đổi icon thành "Save"
                btnEdit.setImageResource(R.drawable.save) // Đặt icon Save phù hợp
            } else {
                // Lưu dữ liệu (tùy chỉnh theo logic của bạn)
                editName.isEnabled = false
                editLocation.isEnabled = false

                // Đổi icon lại thành "Edit"
                btnEdit.setImageResource(R.drawable.edit_square_24dp_1f1f1f_fill0_wght400_grad0_opsz24)
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }
    }
    }