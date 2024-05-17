package com.example.notesapp.fragment


import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.notesapp.Model.Notes
import com.example.notesapp.R
import com.example.notesapp.ViewModel.NotesViewModal
import com.example.notesapp.databinding.FragmentAddNoteBinding
import com.example.notesapp.databinding.FragmentHomeBinding
import java.sql.Date


class add_note : Fragment() {

    lateinit var binding: FragmentAddNoteBinding
    var priority : String = "1"
   private lateinit var notesViewModel: NotesViewModal
   //var notesviewModal = ViewModelProvider(this).get(NotesViewModal::class.java)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddNoteBinding.inflate(layoutInflater,container,false)

       notesViewModel = ViewModelProvider(this).get(NotesViewModal::class.java)



        binding.pGreen.setOnClickListener{
            priority = "1"
            binding.pGreen.setImageResource(R.drawable.baseline_add_task_24)
            binding.pRed.setImageResource(0)
            binding.pYellow.setImageResource(0)
        }

        binding.pRed.setOnClickListener{
            priority = "2"
            binding.pGreen.setImageResource(0)
            binding.pRed.setImageResource(R.drawable.baseline_add_task_24)
            binding.pYellow.setImageResource(0)
        }

        binding.pYellow.setOnClickListener{
            priority = "3"
            binding.pGreen.setImageResource(0)
            binding.pRed.setImageResource(0)
            binding.pYellow.setImageResource(R.drawable.baseline_add_task_24)

        }
        binding.btnSave.setOnClickListener {
            createNotes()
        }
        return binding.root
    }


    private fun createNotes() {

        val title = binding.edttitle.text.toString()
        val subtitle = binding.edtsubtitle.text.toString()
        val notes = binding.edtnotes.text.toString()

        val d = java.util.Date()
        val notesDate: CharSequence = DateFormat.format("MMMM d, yyyy",d.time)

        val data =Notes(null,
            title,subtitle,notes,notesDate.toString(),
            priority)
        notesViewModel.addNotes(data)

    }

}