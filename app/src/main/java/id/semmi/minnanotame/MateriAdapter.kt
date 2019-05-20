package id.semmi.minnanotame

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.materi.view.*


class MateriAdapter(val context: Context, val listMateri: List<Materi>) : RecyclerView.Adapter<MateriAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val materiView = inflater.inflate(R.layout.materi, parent, false)
        return MateriAdapter.ViewHolder(materiView)
    }

    override fun getItemCount(): Int {
        return listMateri.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(context, listMateri[position])

    }


    class ViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView) {
        fun bind(context: Context, materi: Materi) {
            itemView?.description?.text = materi.description
            itemView?.title?.text = materi.title

            val kalimatAdapter = KalimatAdapter(context, materi.kalimat)

            itemView?.kalimatRv?.adapter = kalimatAdapter

            itemView?.kalimatRv?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)


            Glide
                .with(context)
                .load(materi.image)
                .into(itemView.image)

        }
    }
}