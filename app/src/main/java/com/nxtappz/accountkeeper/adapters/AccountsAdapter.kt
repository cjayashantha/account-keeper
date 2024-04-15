package com.nxtappz.accountkeeper.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nxtappz.accountkeeper.databinding.ListItemAccountBinding
import com.nxtappz.accountkeeper.dto.Account

class AccountsAdapter(val accounts: List<Account>) :
    RecyclerView.Adapter<AccountsAdapter.ViewHolder>() {
    class ViewHolder(binding: ListItemAccountBinding) : RecyclerView.ViewHolder(binding.root) {
        val image: ImageView = binding.logo;
        val account: TextView = binding.account;
        val username: TextView = binding.username;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemAccountBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = accounts.size;

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = accounts[position];
        holder.account.text = item.account;
        holder.username.text = item.username;
        holder.image.setImageResource(item.image);
    }
}
