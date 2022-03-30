package com.generation.task4e5

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.generation.task4e5.databinding.FragmentSegundoBinding
import com.generation.task4e5.model.Post
import com.generation.task4e5.model.Temas
import java.time.LocalDate

class SegundoFragment : Fragment() {

    private lateinit var binding: FragmentSegundoBinding

    private var temaSelecionado = 0L

    private val mainViewmodel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSegundoBinding.inflate(layoutInflater, container, false)

        mainViewmodel.listTemas()

        mainViewmodel.myTemasResponse.observe(viewLifecycleOwner) { response ->
            Log.d("Requisicao", response.body().toString())
            spinnerTemas(response.body())
        }



        binding.Postar1.setOnClickListener {


            inserirNoBanco()
        }





        return binding.root
    }

    fun spinnerTemas(temas: List<Temas>?) {

        if (temas != null) {
            binding.spinner.adapter = ArrayAdapter(
                requireContext(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, temas
            )

            binding.spinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                        val temaSelecionadoFun = binding.spinner.selectedItem as Temas

                        temaSelecionado = temaSelecionadoFun.id

                    }


                    override fun onNothingSelected(p0: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }

                }


        }


    }

    fun validarCampos(
        autor: String, imagem: String, titulo: String, descricao: String
    ): Boolean {

        return !(
                autor == "" || autor.length < 3 || autor.length > 20) ||
                (imagem == "" || imagem.length < 5 || imagem.length > 200) ||
                (titulo == "" || titulo.length < 3 || titulo.length > 20) ||
                (descricao == "" || descricao.length < 3 || descricao.length > 200)



    }


    fun inserirNoBanco() {


        val autor = binding.editTextTextPersonName.text.toString()
        val titulo = binding.editTextTextPersonName4.text.toString()
        val imagem = binding.editTextTextPersonName3.text.toString()
        val descricao = binding.editTextTextPersonName5.text.toString()
        val temas = Temas(temaSelecionado, null, null)
        val data = LocalDate.now().toString()


        if (autor.isEmpty()|| titulo.isEmpty() ||descricao.isEmpty()) {
            Toast.makeText(
                context,  "Preencha todos os campos!", Toast.LENGTH_LONG
            ).show()}

        else {

            validarCampos(autor, imagem, titulo, descricao)


            val post = Post(
                0, titulo, descricao, imagem, data, autor, temas
            )

            mainViewmodel.addPost(post)
            Toast.makeText(

                context, "Postado",
                Toast.LENGTH_LONG
            ).show()
            findNavController().navigate(R.id.action_segundoFragment_to_listFragment)
        }

    }

    /*fun empty(){


        val autor = binding.editTextTextPersonName.text.toString()
        val titulo = binding.editTextTextPersonName4.text.toString()
        val descricao = binding.editTextTextPersonName5.text.toString()



        if (autor.isEmpty()|| titulo.isEmpty() ||descricao.isEmpty()) {
            Toast.makeText(
                context,  "Preencha todos os campos!", Toast.LENGTH_LONG
            ).show()
        } else {

            findNavController().navigate(
                R.id.action_segundoFragment_to_listFragment


            )
        }
*/


    }

