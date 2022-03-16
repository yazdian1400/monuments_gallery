package ir.homework.monuments_gallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ir.homework.monuments_gallery.databinding.FragmentHomeBinding
import ir.homework.monuments_gallery.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {
    lateinit var binding: FragmentSettingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}