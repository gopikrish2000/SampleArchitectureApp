package com.gopi.architecture.sample.samplearchitectureapp.UIStuff.snackBar

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.widget.Toast
import com.gopi.architecture.sample.samplearchitectureapp.R
import kotlinx.android.synthetic.main.activity_snack_bar.*
import android.databinding.adapters.TextViewBindingAdapter.setText
import android.text.style.UnderlineSpan
import android.text.SpannableString




class SnackBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snack_bar)

        val mySnackbar = Snackbar.make(rootView,
                "onboarding_something_went_wrong", Snackbar.LENGTH_INDEFINITE)
        mySnackbar.setAction("RETRY", {  Toast.makeText(this,"undo clicked",Toast.LENGTH_LONG).show() })
        mySnackbar.show()

        val str = getString(R.string.terms_condition_text_new)
//        terms_and_conditions.setText(Html.fromHtml(str))

        val content = SpannableString(str)
        content.setSpan(UnderlineSpan(), str.indexOf("Terms"), str.length, 0)
        terms_and_conditions.setText(content)



    }
}
