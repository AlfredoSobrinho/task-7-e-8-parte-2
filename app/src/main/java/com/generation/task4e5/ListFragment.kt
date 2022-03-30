package com.generation.task4e5

import android.os.Bundle
import android.service.controls.actions.FloatAction
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.generation.task4e5.adapter.Postadapter
import com.generation.task4e5.model.Post
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ListFragment : Fragment() {

    private val mainViewModel: MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mainViewModel.listPost()

        val view = inflater.inflate(R.layout.fragment_list, container, false)


        val recyclepost = view.findViewById<RecyclerView>(R.id.recycletarefa)

        val adapter = Postadapter()

        recyclepost.layoutManager = LinearLayoutManager(context)
        recyclepost.adapter = adapter

        recyclepost.setHasFixedSize(true)


        val botaoir = view.findViewById<FloatingActionButton>(R.id.floatingActionButton)

        botaoir.setOnClickListener {

            findNavController().navigate(
                R.id.action_listFragment_to_segundoFragment
            )


        }


        mainViewModel.myPostResponse.observe(viewLifecycleOwner, {

                response ->
            if (response != null) {

                adapter.setlista(response.body()!!)
            }


        })

        return view
    }

}
