package com.example.dimanaux.animals.facts.ui

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dimanaux.animals.facts.R
import com.example.dimanaux.animals.facts.domain.AnimalFacts
import com.example.dimanaux.animals.facts.domain.AnimalType
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : Fragment() {
    private lateinit var animalFacts: AnimalFacts

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        view.mainLayout.setOnClickListener {
            animalFacts.anotherFact { fact ->
                mainTextView.text = fact
            }
        }
        return view
    }

    companion object {
        fun newInstance(context: Context) =
            MainFragment().apply {
                animalFacts = AnimalFacts(
                    listOf(
                        AnimalType.CAT
                    ),
                    context
                )
            }
    }
}
