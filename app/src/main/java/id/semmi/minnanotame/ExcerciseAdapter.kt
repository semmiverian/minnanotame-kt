package id.semmi.minnanotame

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.kosakata.view.*
import kotlinx.android.synthetic.main.soal.view.*

class ExcerciseAdapter(val context: Context, val excercises: List<Excercise>) : RecyclerView.Adapter<ExcerciseAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExcerciseAdapter.ViewHolder {
        val inflater = LayoutInflater.from(context)
        val soalView = inflater.inflate(R.layout.soal, parent, false)
        return ExcerciseAdapter.ViewHolder(soalView)
    }

    override fun getItemCount(): Int {
        return excercises.size
    }

    override fun onBindViewHolder(holder: ExcerciseAdapter.ViewHolder, position: Int) {
        holder.bind(context, excercises[position])
    }

    class ViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView) {
        fun bind(context: Context, excercise: Excercise) {
            itemView?.soal?.text = excercise.soal
        }

    }
}