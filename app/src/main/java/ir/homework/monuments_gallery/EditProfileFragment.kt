package ir.homework.monuments_gallery

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ir.homework.monuments_gallery.databinding.FragmentEditProfileBinding

class EditProfileFragment : Fragment() {
    lateinit var binding: FragmentEditProfileBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showDataIfExist()

        binding.btnSave.setOnClickListener{
            if (areAllFieldsFilled()) {
                val editor = sharedPreferences.edit()
                editor.putString("fullName", binding.etFullname.text.toString())
                editor.putString("email", binding.etEmail.text.toString())
                editor.putString("phoneNumber", binding.etTel.text.toString())
                editor.putString("address", binding.etAddress.text.toString())
                editor.putString("nationalCode", binding.etNationalCode.text.toString())
                editor.putBoolean("showProfile", binding.switchShowProfile.isChecked)
                editor.apply()
                requireActivity().onBackPressed()
            } else {
                showErrorForFilling()
            }
        }
    }

    private fun showDataIfExist() {
        val fullName = sharedPreferences.getString("fullName", binding.etFullname.text.toString())
        if (fullName != "") {
            val email = sharedPreferences.getString("email", "")
            val phoneNumber = sharedPreferences.getString("phoneNumber", "")
            val address = sharedPreferences.getString("address", "")
            val nationalCode = sharedPreferences.getString("nationalCode", "")
            val showProfile = sharedPreferences.getBoolean("showProfile", false)

            binding.etFullname.setText(fullName)
            binding.etEmail.setText(email)
            binding.etAddress.setText(address)
            binding.etNationalCode.setText(nationalCode)
            binding.etTel.setText(phoneNumber)
            binding.switchShowProfile.isChecked = showProfile
        }

    }

    private fun showErrorForFilling() {
        if (binding.etFullname.text.isNullOrBlank())
            binding.etFullname.error = "Please, Enter your full name."
        if (binding.etNationalCode.text.isNullOrBlank())
            binding.etNationalCode.error = "Please, Enter your national code."
        if (binding.etTel.text.isNullOrBlank())
            binding.etTel.error = "Please, Enter your phone number."
        if (binding.etAddress.text.isNullOrBlank())
            binding.etAddress.error = "Please, Enter your address."
        if (binding.etEmail.text.isNullOrBlank())
            binding.etEmail.error = "Please, Enter your email address."
    }

    private fun areAllFieldsFilled(): Boolean {
        if (binding.etFullname.text.isNullOrBlank())    return false
        if (binding.etNationalCode.text.isNullOrBlank())    return false
        if (binding.etTel.text.isNullOrBlank())    return false
        if (binding.etAddress.text.isNullOrBlank())    return false
        if (binding.etEmail.text.isNullOrBlank())    return false

        return true
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE)
    }
}