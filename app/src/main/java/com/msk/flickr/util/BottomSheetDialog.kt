package com.msk.flickr.util

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.msk.flickr.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet.*

class BottomSheetDialog : BottomSheetDialogFragment() {

    private lateinit var mBottomSheetListener: BottomSheetListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
         inflater.inflate(R.layout.bottom_sheet, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        published.setOnClickListener {
            mBottomSheetListener.onOptionClick(SortByDate.PUBLISHED)
            dismiss()
        }
        datetaken.setOnClickListener {
            mBottomSheetListener.onOptionClick(SortByDate.DATE_TAKEN)
            dismiss()
        }
    }

    interface BottomSheetListener{
        fun onOptionClick(selectedDate: SortByDate)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            mBottomSheetListener = context as BottomSheetListener
        }
        catch (e: ClassCastException){
            throw ClassCastException(context.toString())
        }

    }
}
enum class SortByDate{
    PUBLISHED,
    DATE_TAKEN
}