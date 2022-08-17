package com.android.surveysaurus.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.surveysaurus.R
import com.android.surveysaurus.activity.MainActivity
import com.android.surveysaurus.adapter.OptionAdapter
import com.android.surveysaurus.adapter.SurveyAdapter
import com.android.surveysaurus.databinding.FragmentCreateSurveyBinding
import com.android.surveysaurus.databinding.FragmentSurveysBinding
import com.android.surveysaurus.model.SurveyModel
import java.lang.reflect.Array

//
class SurveysFragment : Fragment(), SurveyAdapter.Listener {
    private var _binding: FragmentSurveysBinding? = null
    private val binding get() = _binding!!
    private lateinit var surveyAdapter: SurveyAdapter
    private var surveyModel: ArrayList<SurveyModel> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSurveysBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.surveysRecycler.layoutManager = GridLayoutManager(view.context, 2)
        surveyAdapter = SurveyAdapter(surveyModel, this@SurveysFragment)
        binding.surveysRecycler.adapter = surveyAdapter


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var options = arrayOf<String>("Cat", "Dog", "Golden Fish", "Dolphin", "Rabbit")

        var surveyModel1: SurveyModel = SurveyModel(
            "Which animals do you like most?", "Yok",
            options
        )

        var options2 = arrayOf<String>(
            "Books and articles",
            "YouTube tutorial videos",
            "Online or face to face courses",
            "Experience with little investment"
        )

        var surveyModel2: SurveyModel = SurveyModel(
            "What resources have you used or are you using for your training?", "Yok",
            options2
        )

        var options3 = arrayOf<String>(
            "Stock market", "Foreign exchange", "Commodity", "Bond market", "Cryptocurrency market"
        )

        var surveyModel3: SurveyModel = SurveyModel(
            "In which financial markets do you operate?", "Yok",
            options3
        )

        surveyModel.add(surveyModel1)
        surveyModel.add(surveyModel2)
        surveyModel.add(surveyModel3)
        surveyModel.add(surveyModel1)
        surveyModel.add(surveyModel2)



        surveyAdapter.notifyDataSetChanged()
    }

    override fun onItemClick(surveyModel: SurveyModel) {
        val action =
            ViewPagerFragmentDirections.actionViewPagerFragmentToFillSurveyFragment(surveyModel)
        Navigation.findNavController(binding.root).navigate(action)
    }


}