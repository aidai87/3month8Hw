package com.example.a3month8hw

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.a3month8hw.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val alertDialog = AlertDialog.Builder(requireContext())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(requireActivity())
            .load("https://millenniumblogger.com/wp-content/uploads/2021/09/google-dark.jpg")
            .centerCrop().into(binding.iv)
        binding.iv.setOnClickListener() {

            alertDialog.setTitle("вы хотите опусташить картинку?")
            alertDialog.setPositiveButton("Да") { dialog, _ ->
                Glide.with(requireActivity())
                    .load("https://cdn.trinixy.ru/pics5/20130809/otnoshenie_13.jpg").centerCrop()
                    .into(binding.iv)
                binding.iv.setOnClickListener() {
                    alertDialog.setTitle("Хотите вернуть картинку?")
                    alertDialog.setPositiveButton("Да") { diolog, _ ->
                        Glide.with(requireActivity())
                            .load("https://millenniumblogger.com/wp-content/uploads/2021/09/google-dark.jpg")
                            .centerCrop().into(binding.iv)
                    }
                    alertDialog.setNegativeButton("Нет") { diolog, _ ->
                        diolog.dismiss()
                    }
                    alertDialog.create().show()
                }
            }
            alertDialog.setNegativeButton("Нет") { diolog, _ ->
                diolog.dismiss()
            }
            alertDialog.create().show()

        }
    }
}