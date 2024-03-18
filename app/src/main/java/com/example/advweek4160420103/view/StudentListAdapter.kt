package com.example.advweek4160420103.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.advweek4160420103.databinding.StudentListItemBinding
import com.example.advweek4160420103.model.Student

class StudentListAdapter(val studentList:ArrayList<Student>)
    :RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>()
{
    class StudentViewHolder(var binding: StudentListItemBinding)
        :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding = StudentListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return StudentViewHolder(binding)

    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
            holder.binding.txtID.text = studentList[position].id
            holder.binding.txtName.text = studentList[position].name
            holder.binding.btnDetail.setOnClickListener {
                val action = StudentListFragmentDirections.actionStudentDetail()
                Navigation.findNavController(it).navigate(action)
        }

    }
    fun updateStudentList(newStudentList: ArrayList<Student>) {
        studentList.clear()
        studentList.addAll(newStudentList)
        notifyDataSetChanged()
    }


}









