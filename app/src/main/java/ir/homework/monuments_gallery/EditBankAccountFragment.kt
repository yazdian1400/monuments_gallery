package ir.homework.monuments_gallery

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ir.homework.monuments_gallery.databinding.FragmentBankAccountBinding
import ir.homework.monuments_gallery.databinding.FragmentEditBankAccountBinding

class EditBankAccountFragment : Fragment() {
    lateinit var binding: FragmentEditBankAccountBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEditBankAccountBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSaveBankAccount.setOnClickListener{
            if (areAllFieldsFilled()) {
                val editor = sharedPreferences.edit()
                editor.putString("accountNumber", binding.etAccountNumber.text.toString())
                editor.putString("cardNumber", binding.etCardNumber.text.toString())
                editor.putString("shebaNumber", binding.etShebaNumber.text.toString())
                editor.apply()
                requireActivity().onBackPressed()
            } else {
                showErrorForFilling()
            }
        }
    }

    private fun showErrorForFilling() {
        if (binding.etAccountNumber.text.isNullOrBlank())
            binding.etAccountNumber.error = "Please, Enter your account number."
        if (binding.etCardNumber.text.isNullOrBlank())
            binding.etCardNumber.error = "Please, Enter your card number."
        if (binding.etShebaNumber.text.isNullOrBlank())
            binding.etShebaNumber.error = "Please, Enter your sheba number."
    }

    private fun areAllFieldsFilled(): Boolean {
        if (binding.etAccountNumber.text.isNullOrBlank())    return false
        if (binding.etCardNumber.text.isNullOrBlank())    return false
        if (binding.etShebaNumber.text.isNullOrBlank())    return false
        return true
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE)
    }
}