package com.shirishkoirala.devchallenge.ui.ratingdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.shirishkoirala.devchallenge.databinding.FragmentRatingDialogBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RatingDialogFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentRatingDialogBinding
    private lateinit var viewModel: RatingDialogViewModel

    @Inject
    lateinit var ratingDialogViewModelFactory: RatingDialogViewModelFactory

    private var movieId: Int? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRatingDialogBinding.inflate(layoutInflater, container, false)
        viewModel =
            ViewModelProvider(this, ratingDialogViewModelFactory)[RatingDialogViewModel::class.java]
        binding.cancelButton.setOnClickListener {
            this.dismiss()
        }
        movieId = arguments?.getInt("movie_id")

        binding.saveButton.setOnClickListener {
            val score = binding.ratingScoreEditText.text.toString()
            if (score.isNotEmpty()) {
                var doubleScore: Double? = null
                try {
                    doubleScore = score.toDouble()
                } catch (e: NumberFormatException) {
                    Toast.makeText(requireContext(), "Invalid score.", Toast.LENGTH_LONG).show()
                }
                doubleScore?.let { doubleScore ->
                    if (doubleScore in 1.0..10.0) {
                        movieId?.let {
                            viewModel.postRating(it, doubleScore)
                        }
                    } else {
                        Toast.makeText(
                            requireContext(),
                            "Rating must be more than 1 and less than or equal to 10.",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }

        viewModel.dismiss.observe(viewLifecycleOwner) {
            this.dismiss()
        }
        return binding.root
    }
}