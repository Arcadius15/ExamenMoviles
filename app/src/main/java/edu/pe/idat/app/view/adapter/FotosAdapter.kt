package edu.pe.idat.app.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.pe.idat.app.databinding.CardviewFotosBinding
import edu.pe.idat.app.retrofit.response.JSONPlaceholder

class FotosAdapter (private var lstfotos:List<JSONPlaceholder>):RecyclerView.Adapter<FotosAdapter.ViewHolder>(){
    inner class ViewHolder(val binding:CardviewFotosBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CardviewFotosBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(lstfotos[position]){
                if (albumId %2==0){
                    binding.textView2.text = albumId.toString()
                    binding.textView3.text  = id.toString()
                    binding.textView4.text  = title
                    binding.textView5.text = thumbnailUrl
                    //val foto = "https://i0.wp.com/hotbook.mx/wp-content/uploads/2019/01/fotosparis_portada.jpg?fit=1024%2C682&ssl=1"
                    //las imagenes de json place holder no tienen extension
                    Glide.with(holder.itemView.context)
                        .load(thumbnailUrl)
                        .centerCrop()
                        .into(binding.ivfoto)
                    holder.itemView.visibility = View.VISIBLE
                    holder.itemView.layoutParams = RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
                }else{
                    holder.itemView.visibility = View.GONE
                    holder.itemView.layoutParams = RecyclerView.LayoutParams(0,0)
                }
            }
        }
    }

    override fun getItemCount()= lstfotos.size
}