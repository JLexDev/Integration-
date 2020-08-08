package com.jlexdev.prueba.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jlexdev.prueba.R
import com.jlexdev.prueba.models.UserResponse
import com.jlexdev.prueba.network.ApiService
import com.jlexdev.prueba.network.ServiceBuilder
import kotlinx.android.synthetic.main.activity_add_user.*
import kotlinx.android.synthetic.main.activity_user.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddUserAcivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)

        saveNewUser()
    }

    private fun saveNewUser() {
        btn_save_user.setOnClickListener {

            /* Create New User
            val newUser = UserResponse()
            newUser.name = et_name.text.toString()
            newUser.job = et_job.text.toString()*/


            val apiService = ServiceBuilder.buildService(ApiService::class.java)

            val requestCall = apiService.addNewUser()

            requestCall.enqueue(object: Callback<UserResponse> {
                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    Toast.makeText(this@AddUserAcivity, "Falló en agregar usuario",
                        Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
                ) {
                    if (response.isSuccessful) {
                        finish()

                        if (response.code() == 201) {
                            var newUserCreated = response.body()
                            Toast.makeText(this@AddUserAcivity, "Se agregó exitosamente",
                                Toast.LENGTH_SHORT).show()
                        }

                    } else {
                        Toast.makeText(this@AddUserAcivity, "Falló en agregar usuario",
                            Toast.LENGTH_SHORT).show()
                    }
                }

            })

        }
    }
}