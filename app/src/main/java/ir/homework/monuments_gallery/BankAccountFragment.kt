package ir.homework.monuments_gallery

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ir.homework.monuments_gallery.databinding.FragmentBankAccountBinding
import ir.homework.monuments_gallery.databinding.FragmentProfileBinding

class BankAccountFragment : Fragment() {
    lateinit var binding: FragmentBankAccountBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBankAccountBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val accountNumber = sharedPreferences.getString("accountNumber", "")
        val cardNumber = sharedPreferences.getString("cardNumber", "")
        val shebaNumber = sharedPreferences.getString("shebaNumber", "")

        binding.tvAccountNumber.text = accountNumber
        binding.tvCardNumber.text = cardNumber
        binding.tvShebaNumber.text = shebaNumber
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE)
    }
}