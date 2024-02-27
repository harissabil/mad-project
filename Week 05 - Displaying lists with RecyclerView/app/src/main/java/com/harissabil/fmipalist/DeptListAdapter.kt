package com.harissabil.fmipalist

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.harissabil.fmipalist.data.Dept
import com.harissabil.fmipalist.databinding.ItemDeptBinding

class DeptListAdapter(private val deptList: List<Dept>) :
    RecyclerView.Adapter<DeptListAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemDeptBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDeptBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dept = deptList[position]
        holder.binding.apply {
            tvName.text = dept.name
            ivImage.load(dept.imageUrl)

            root.setOnClickListener {
                val intent = Intent(holder.itemView.context, DetailActivity::class.java)
                intent.putExtra("dept", dept)
                holder.itemView.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int = deptList.size
}