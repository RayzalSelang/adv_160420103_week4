package com.example.advweek4160420103.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.advweek4160420103.R
import com.example.advweek4160420103.databinding.FragmentStudentDetailBinding
import com.example.advweek4160420103.viewmodel.DetailViewModel

class StudentDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    private var _binding: FragmentStudentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStudentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        observeViewModel()
        viewModel.fetch()
    }

    private fun observeViewModel() {
        viewModel.studentLD.observe(viewLifecycleOwner, Observer { student ->
            student?.let {
                binding.txtID.text = student.id?.toEditable()
                binding.txtName.text = student.name?.toEditable()
                binding.txtBod.text = student.dob?.toEditable()
                binding.txtPhone.text = student.phone?.toEditable()
                // Load the image using a library like Glide or Picasso
                // Here, I'm just setting a placeholder drawable to imageView2
                binding.imageView2.setImageResource(R.drawable.ic_launcher_foreground)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun String?.toEditable(): Editable {
        return Editable.Factory.getInstance().newEditable(this)
    }
}
