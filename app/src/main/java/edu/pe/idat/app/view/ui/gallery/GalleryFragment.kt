package edu.pe.idat.app.view.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import edu.pe.idat.app.databinding.FragmentGalleryBinding
import edu.pe.idat.app.view.adapter.FotosAdapter
import edu.pe.idat.app.viewmodel.FotosViewModel

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private lateinit var fotosViewModel: FotosViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        binding.rvfotos.layoutManager = LinearLayoutManager(requireActivity())
        fotosViewModel = ViewModelProvider(requireActivity()).get(FotosViewModel::class.java)
        listarFotos()
        return binding.root
    }

    private fun listarFotos(){
        fotosViewModel.listarFotos().observe(viewLifecycleOwner, Observer {
            binding.rvfotos.adapter = FotosAdapter(it)
        })
    }

}