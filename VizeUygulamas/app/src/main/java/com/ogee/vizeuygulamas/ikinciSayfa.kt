package com.ogee.vizeuygulamas

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ikinciSayfa : AppCompatActivity() {
    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var checkBoxRememberMe: CheckBox
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ikinci_sayfa)

        // XML'deki View'ları tanımla
        editTextUsername = findViewById(R.id.editTextText)
        editTextPassword = findViewById(R.id.editTextTextPassword)
        checkBoxRememberMe = findViewById(R.id.checkBox)
        val buttonLogin = findViewById<Button>(R.id.button)

        // SharedPreferences ile verileri sakla
        sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE)
        val savedUsername = sharedPreferences.getString("USERNAME", "")
        val savedPassword = sharedPreferences.getString("PASSWORD", "")
        val isRemembered = sharedPreferences.getBoolean("REMEMBER_ME", false)

        // Daha önceki giriş bilgilerini yükle
        if (isRemembered) {
            editTextUsername.setText(savedUsername)
            editTextPassword.setText(savedPassword)
            checkBoxRememberMe.isChecked = true
        }

        // Giriş butonuna tıklanınca
        buttonLogin.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            if (username == "hasan" && password == "123") { // Doğru kullanıcı adı ve şifre
                // Kullanıcı bilgilerini sakla
                val editor = sharedPreferences.edit()
                if (checkBoxRememberMe.isChecked) {
                    editor.putString("USERNAME", username)
                    editor.putString("PASSWORD", password)
                    editor.putBoolean("REMEMBER_ME", true)
                } else {
                    editor.clear() // Beni Hatırla seçili değilse bilgileri sil
                }
                editor.apply()

                // Üçüncü sayfaya yönlendirme
                val intent = Intent(this, ucuncusayfa::class.java)
                //intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            } else { // Yanlış kullanıcı adı veya şifre
                Toast.makeText(this, "Kullanıcı adı veya şifre yanlış!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    /*override fun onResume() {
        super.onResume()
        // Beni Hatırla durumu kontrol et
        val isRemembered = sharedPreferences.getBoolean("REMEMBER_ME", false)
        if (isRemembered) {
            // Eğer "Beni Hatırla" seçiliyse kayıtlı bilgileri yükle
            val savedUsername = sharedPreferences.getString("USERNAME", "")
            val savedPassword = sharedPreferences.getString("PASSWORD", "")
            editTextUsername.setText(savedUsername)
            editTextPassword.setText(savedPassword)
            checkBoxRememberMe.isChecked = true
        } else {
            // Eğer "Beni Hatırla" seçili değilse alanları temizle
            editTextUsername.text.clear()
            editTextPassword.text.clear()
            checkBoxRememberMe.isChecked = false
        }
    }
*/

}
