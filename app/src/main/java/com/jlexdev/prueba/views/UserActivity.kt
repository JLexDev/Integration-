package com.jlexdev.prueba.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.jlexdev.prueba.R
import com.jlexdev.prueba.adapter.UserAdapter
import com.jlexdev.prueba.models.UserResponse
import com.jlexdev.prueba.network.ApiService
import com.jlexdev.prueba.network.ServiceBuilder
import kotlinx.android.synthetic.main.activity_user.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserActivity : AppCompatActivity() {

    companion object {
        val TAG: String = UserActivity::class.java.simpleName
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        addNewUser()
    }

    private fun addNewUser() {
        btn_add_user.setOnClickListener {
            val intent = Intent(this, AddUserAcivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        setupRecycler()
        loadUsers()
    }


    private fun setupRecycler() {
        //rv_users.adapter = UserAdapter(userList)
        rv_users.layoutManager = LinearLayoutManager(this@UserActivity)
        rv_users.setHasFixedSize(true)
    }


    private fun loadUsers() {

        val apiService = ServiceBuilder.buildService(ApiService::class.java)

        val requestCall = apiService.getUsers()

        requestCall.enqueue(object: Callback<List<UserResponse>> {

            override fun onFailure(call: Call<List<UserResponse>>, t: Throwable) {
                // Show Error
                /*Toast.makeText(this@UserActivity, "Ocurrió un error: $t",
                                Toast.LENGTH_SHORT).show()*/
                
                Log.e(TAG, "Failure: $t")
            }

            override fun onResponse(
                call: Call<List<UserResponse>>,
                response: Response<List<UserResponse>>
            ) {
                if (response.isSuccessful) {
                    val userList = response.body()!!
                    rv_users.adapter = UserAdapter(userList)

                /*} else if (response.code() == 401) {
                    // TODO: No hacer
                    Toast.makeText(this@UserActivity, "Intenta otra vez" + t.toString(),
                        Toast.LENGTH_SHORT).show()
                */

                } else {
                    Toast.makeText(this@UserActivity, "Falló en retornar usuarios.",
                        Toast.LENGTH_SHORT).show()
                }
            }

        })
    }
}