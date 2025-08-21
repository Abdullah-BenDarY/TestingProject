package com.example.roomtesting.utils

import android.os.Build
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

fun Fragment.showMessage(message: Any?) {
    val rootView = requireView()

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        Snackbar.make(rootView, message.toString(), Snackbar.LENGTH_LONG).show()
    } else {
        Toast.makeText(requireContext(), message.toString(), Toast.LENGTH_LONG).apply {
            show()
        }
    }
}