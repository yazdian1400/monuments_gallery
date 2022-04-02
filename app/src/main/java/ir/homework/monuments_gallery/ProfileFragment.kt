package ir.homework.monuments_gallery

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import ir.homework.monuments_gallery.databinding.FragmentHomeBinding
import ir.homework.monuments_gallery.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(requireActivity())
            .load(R.drawable.profile1)
            .circleCrop()
            .into(binding.ivProfile)

        val fullName = sharedPreferences.getString("fullName", "")
        val email = sharedPreferences.getString("email", "")
        val phoneNumber = sharedPreferences.getString("phoneNumber", "")
        val address = sharedPreferences.getString("address", "")
        val nationalCode = sharedPreferences.getString("nationalCode", "")

        binding.tvProfileName.text = fullName
        binding.tvProfileNationalCode.text = nationalCode
        binding.tvProfileTel.text = phoneNumber
        binding.tvProfileAddress.text = address
        binding.tvProfileEmail.text = email

        binding.btnShowBankAccount.setOnClickListener{
            findNavController().navigate(R.id.action_nav_profile_to_bankAccountFragment)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE)
    }
}