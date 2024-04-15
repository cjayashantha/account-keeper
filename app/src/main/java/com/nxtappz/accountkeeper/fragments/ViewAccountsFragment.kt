package com.nxtappz.accountkeeper.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.nxtappz.accountkeeper.R
import com.nxtappz.accountkeeper.adapters.AccountsAdapter
import com.nxtappz.accountkeeper.databinding.FragmentViewAccountsBinding
import com.nxtappz.accountkeeper.dto.Account


/**
 * A simple [Fragment] subclass.
 * Use the [ViewAccountsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ViewAccountsFragment : Fragment() {

    private lateinit var binding: FragmentViewAccountsBinding;
    private lateinit var accounts: List<Account>;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);


        accounts = mutableListOf<Account>(
            Account(1, "Google", "abc@gmail.com", "123", R.drawable.acc_mail_24),
            Account(1, "Hotmail", "qwe@gmail.com", "123", R.drawable.acc_account_24),
            Account(1, "Yahoo", "tjt@gmail.com", "123", R.drawable.acc_user_24),
            Account(1, "Outlook", "edc@gmail.com", "123", R.drawable.acc_bank_24),
        );
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentViewAccountsBinding.inflate(inflater, container, false);
        with(binding.listAccounts) {
            layoutManager = LinearLayoutManager(context);
            adapter = AccountsAdapter(accounts);
        }
        return binding.root;
    }
}