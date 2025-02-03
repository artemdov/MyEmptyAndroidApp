package com.example.cicerone_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.cicerone_app.databinding.FragmentSecondBlankBinding

class SecondBlankFragment : Fragment() {

    private var _binding: FragmentSecondBlankBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Настраиваем Data Binding
        _binding = FragmentSecondBlankBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()
    }

    private fun setupToolbar() {
        // Получаем Toolbar из макета
        val toolbar = binding.toolbar

        // Устанавливаем Toolbar как ActionBar для этого фрагмента
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)

        // Включаем кнопку "Назад"
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true) // Показываем стрелку назад
        }

        // Обрабатываем нажатие на стрелку "Назад"
        toolbar.setNavigationOnClickListener {
            // Возвращаемся на предыдущий экран
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Избегаем утечек памяти
    }

    companion object {
        fun newInstance(id: Int): SecondBlankFragment {
            return SecondBlankFragment().apply {
                arguments = Bundle().apply {
                    putInt("id", id)
                }
            }
        }
    }
}
