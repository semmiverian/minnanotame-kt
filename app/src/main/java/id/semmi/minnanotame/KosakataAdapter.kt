package id.semmi.minnanotame

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.kosakata.*
import kotlinx.android.synthetic.main.kosakata.view.*


class KosakataAdapter(val context: Context, val listKosakata: List<Kosakata>) : RecyclerView.Adapter<KosakataAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val colorView = inflater.inflate(R.layout.kosakata, parent, false)
        return KosakataAdapter.ViewHolder(colorView)
    }

    override fun getItemCount(): Int {
        return listKosakata.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(context, listKosakata[position])
    }


    class ViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView) {

        fun bind(context: Context, kosakata: Kosakata) {
            itemView?.sub1?.text = kosakata.sub1
            itemView?.main?.text = kosakata.title
            itemView?.sub2?.text = kosakata.sub2

        }

    }
}