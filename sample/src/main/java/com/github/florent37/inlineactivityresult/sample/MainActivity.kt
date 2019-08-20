package com.github.florent37.inlineactivityresult.sample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.florent37.runtimepermission.RuntimePermission
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Sample of a very basic activity asking for permission.
 * It shows a button to trigger the permission dialog if permission is needed,
 * and hide it when it doesn't
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rx.setOnClickListener {
            open(MainActivityRx::class.java)
        }

        java7.setOnClickListener {
            open(MainActivityJava7::class.java)
        }

        java8.setOnClickListener {
            open(MainActivityJava8::class.java)
        }

        kotlin.setOnClickListener {
            open(MainActivityKotlin::class.java)
        }

        kotlinCoroutine.setOnClickListener {
            open(MainActivityKotlinCoroutine::class.java)
        }

        kotlinCoroutine.setOnClickListener {
            open(MainActivityKotlinCoroutine::class.java)
        }
    }

    private fun open(classActivity: Class<*>) {
        RuntimePermission.askPermission(this)
                .onAccepted {
                    startActivity(Intent(this, classActivity))
                }
                .ask()
    }
}
