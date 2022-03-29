package ir.homework.monuments_gallery

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import ir.homework.monuments_gallery.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var sharedPreferences: SharedPreferences
    private val itemList = mutableListOf<ConstraintLayout>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
    return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemList.clear()
        itemList.add(binding.cl1)
        itemList.add(binding.cl2)
        itemList.add(binding.cl3)
        itemList.add(binding.cl4)
        itemList.add(binding.cl5)
        itemList.add(binding.cl6)
        val numImage = sharedPreferences.getString("num_image", "4")
        setVisibilityOfItems(numImage)
        Toast.makeText(requireContext(), numImage, Toast.LENGTH_LONG).show()

    }

    private fun setVisibilityOfItems(numImage: String?) {
        if (numImage != null) {
            val num = numImage.toInt()
            if (num in 1..6){
                for (i in 0 until num) {
                    itemList[i].isVisible = true
                }
                for (i in num..5) {
                    itemList[i].isVisible = false
                }
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE)
    }
}