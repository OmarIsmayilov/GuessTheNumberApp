package com.omarismayilov.guessthenumber

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_gmae.*
import kotlinx.android.synthetic.main.fragment_result.*

class ResultFragment : Fragment() {
    var gelenResult = true
    var gelenHak = 0
    var gelenRandom = 0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {

            gelenResult = ResultFragmentArgs.fromBundle(it).result
            gelenHak = ResultFragmentArgs.fromBundle(it).sonucHak
            gelenRandom = ResultFragmentArgs.fromBundle(it).randomEded
        }


        if(gelenResult){
            resultimage.setImageResource(R.drawable.winlogo)
            resultText.text = "Winner"
            textViewHak.text = "  Step : $gelenHak\nRandom number: $gelenRandom"
        }else{
            resultimage.setImageResource(R.drawable.loselogo)
            resultText.text = "Loser"
            textViewHak.text = " Step : $gelenHak \nYour step is >20 \nRandom number: $gelenRandom"
        }

        restartButton.setOnClickListener{
            val gecis = ResultFragmentDirections.resulttogame()
            Navigation.findNavController(it).navigate(gecis)
        }
    }


}