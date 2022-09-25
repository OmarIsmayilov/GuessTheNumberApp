package com.omarismayilov.guessthenumber

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.BaseTransientBottomBar.ANIMATION_MODE_FADE
import com.google.android.material.snackbar.BaseTransientBottomBar.ANIMATION_MODE_SLIDE
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_gmae.*
import kotlinx.android.synthetic.main.fragment_gmae.view.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlin.random.Random

class GmaeFragment : Fragment() {
    var randomEded =0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        randomEded = Random.nextInt(101)
        Log.e("rastgele sayi", randomEded.toString())
    }

    var hak = 0
    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val tasarim = inflater.inflate(R.layout.fragment_gmae, container, false)


        tasarim.guessbutton.setOnClickListener{

            if(editText.text.isEmpty()){
                val sb = Snackbar.make(it,"   Enter the number above",Snackbar.LENGTH_SHORT).setAction("Wr",null)
                sb.setTextColor(Color.WHITE)
                sb.view.setBackgroundColor(Color.DKGRAY)
                sb.setAnimationMode(ANIMATION_MODE_SLIDE)
                sb.show()
                return@setOnClickListener
            }

            val number = editText.text.toString().toInt()
            tasarim.editText.setText("")
            hak=hak+1
            tasarim.kalanHak.text = "-$hak-"

            if(number>randomEded){
                tasarim.durumImage.setImageResource(R.drawable.decreasevector)

            }

            if (number<randomEded){
                tasarim.durumImage.setImageResource(R.drawable.increasevector)

            }

            if (number==randomEded) {
                val gecis = GmaeFragmentDirections.gametoresult(result = true, sonucHak = hak,randomEded= randomEded)
                Navigation.findNavController(it).navigate(gecis)
                return@setOnClickListener
            }

            if (hak>20){
                val gecis = GmaeFragmentDirections.gametoresult(result = false, sonucHak = hak,randomEded= randomEded)
                Navigation.findNavController(it).navigate(gecis)
                return@setOnClickListener
            }




        }
        return tasarim
    }


}


