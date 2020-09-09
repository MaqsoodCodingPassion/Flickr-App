package com.msk.flickr.util

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.appcompat.app.AlertDialog


class ShowErrorDialog : DialogFragment() {
    companion object {
        private const val TITLE = "title"
        private const val MESSAGE = "message"
        fun newInstance(title:String,message:String): ShowErrorDialog {
            val dialog = ShowErrorDialog()
            dialog.arguments = Bundle().apply {
                putString(TITLE,title)
                putString(MESSAGE,message)
            }
            return dialog
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return context?.let {
            AlertDialog.Builder(it)
                .setTitle(arguments?.getString(TITLE))
                .setMessage(arguments?.getString(MESSAGE))
                .setPositiveButton(android.R.string.ok) { dialog, _ ->
                    dialog.dismiss()
                }
        }!!.create()
    }
}