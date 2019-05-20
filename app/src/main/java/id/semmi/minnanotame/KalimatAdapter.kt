package id.semmi.minnanotame

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.kalimat.view.*

class KalimatAdapter(val context: Context, val listKalimat: List<Kalimat>) : RecyclerView.Adapter<KalimatAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val materiView = inflater.inflate(R.layout.kalimat, parent, false)
        return KalimatAdapter.ViewHolder(materiView)
    }

    override fun getItemCount(): Int {
        return listKalimat.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(context, listKalimat[position])

    }


    class ViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView) {
        fun bind(context: Context, materi: Kalimat) {
            Glide
                .with(context)
                .load(materi.image)
                .into(itemView.image)

            itemView?.detail?.text = materi.description
        }
    }
}