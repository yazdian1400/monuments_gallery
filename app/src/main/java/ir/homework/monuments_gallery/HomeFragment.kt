package ir.homework.monuments_gallery

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import ir.homework.monuments_gallery.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var sharedPreferences: SharedPreferences
    private val imageList = mutableListOf<ImageView>()
    private val textList = mutableListOf<TextView>()

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

        initViews()
    }

    private fun initViews() {
        setViewLists()
        setImageAndTitleOfItems()
        val numImage = sharedPreferences.getString("num_image", "4")
        showNameOfUser()
        setVisibilityOfItems(numImage)
    }

    private fun showNameOfUser() {
        val showProfile = sharedPreferences.getBoolean("showProfile", false)
        if (showProfile) {
            val fullName = sharedPreferences.getString("fullName", "")
            binding.tvNameHome.text = "welcome $fullName"
            binding.tvNameHome.isVisible = true
        } else {
            binding.tvNameHome.isVisible = false
        }
    }

    private fun setViewLists() {
        imageList.clear()
        imageList.add(binding.iv1)
        imageList.add(binding.iv2)
        imageList.add(binding.iv3)
        imageList.add(binding.iv4)
        imageList.add(binding.iv5)
        imageList.add(binding.iv6)

        textList.clear()
        textList.add(binding.tv1)
        textList.add(binding.tv2)
        textList.add(binding.tv3)
        textList.add(binding.tv4)
        textList.add(binding.tv5)
        textList.add(binding.tv6)
    }

    private fun setImageAndTitleOfItems() {
        for (i in 0..5) {
            Repository.setMonumentList()
            textList[i].text = Repository.monumentList[i].title
            Glide.with(requireActivity())
                .load(Repository.monumentList[i].src)
                .circleCrop()
                .into(imageList[i])
        }
    }

    private fun setVisibilityOfItems(numImage: String?) {
        if (numImage != null) {
            val num = numImage.toInt()
            if (num in 1..6){
                for (i in 0 until num) {
                    imageList[i].isVisible = true
                    textList[i].isVisible = true
                }
                for (i in num..5) {
                    imageList[i].isVisible = false
                    textList[i].isVisible = false
                }
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE)
    }
}