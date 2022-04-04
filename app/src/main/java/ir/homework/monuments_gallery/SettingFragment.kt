package ir.homework.monuments_gallery

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import ir.homework.monuments_gallery.databinding.FragmentHomeBinding
import ir.homework.monuments_gallery.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {
    lateinit var binding: FragmentSettingBinding
    lateinit var sharedPreferences: SharedPreferences

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val numItem = sharedPreferences.getString("num_image", "4")?.toInt()
        if (numItem != null) {
            binding.seekbarNum.progress = numItem
            binding.tvNumItem.text = binding.seekbarNum.progress.toString()
        }

        binding.seekbarNum.setOnSeekBarChangeListener(object:
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                seek: SeekBar,
                progress: Int, fromUser: Boolean
            ) {
                binding.tvNumItem.text = binding.seekbarNum.progress.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                val editor = sharedPreferences.edit()
                editor.putString("num_image", binding.seekbarNum.progress.toString())
                editor.apply()
            }
        })

//        binding.btnNumSubmit.setOnClickListener{
//            val editor = sharedPreferences.edit()
//            editor.putString("num_image", binding.etNumImage.text.toString())
//            editor.apply()
//        }

        binding.btnEditProfile.setOnClickListener{
            findNavController().navigate(R.id.action_nav_setting_to_editProfileFragment)
        }
        binding.btnEditBankAccount.setOnClickListener{
            findNavController().navigate(R.id.action_nav_setting_to_editBankAccountFragment)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE)
    }
}

//<LinearLayout
//android:layout_width="match_parent"
//android:layout_height="0dp"
//android:layout_weight="1"
//android:orientation="horizontal"
//android:padding="8dp">
//
//<EditText
//android:id="@+id/et_num_image"
//android:layout_width="100dp"
//android:layout_height="match_parent"
//android:hint="4"
//android:textSize="36sp" />
//<Button
//android:layout_width="100dp"
//android:layout_height="match_parent"
//android:id="@+id/btn_num_submit"
//android:text="submit"/>
//</LinearLayout>