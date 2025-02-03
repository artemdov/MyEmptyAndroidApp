package com.example.cicerone_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cicerone_app.databinding.FragmentBlankBinding // Data Binding класс создаётся автоматически на основе вашего XML

class BlankFragment : Fragment() {

    // Data Binding объект для fragment_blank.xml
    private var _binding: FragmentBlankBinding? = null
    private val binding get() = _binding!! // Безопасный доступ к Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Создаем binding из fragment_blank.xml
        _binding = FragmentBlankBinding.inflate(inflater, container, false)

        // Привязываем фрагмент (для переменной "fragment" в XML)
        binding.fragment = this

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Убираем binding, чтобы избежать утечек памяти
    }

    // Метод для обработки клика по кнопке
    fun onNavigateButtonClicked() {
        println("Button clicked!") // Временная проверка, что клик работает

        // Выполняем переход на SecondBlankFragment
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, SecondBlankFragment.newInstance(42))
            .addToBackStack(null)
            .commit()
    }

    companion object {
        // Фабричный метод для создания фрагмента с параметрами
        fun newInstance(): BlankFragment {
            return BlankFragment()
        }
    }
}
