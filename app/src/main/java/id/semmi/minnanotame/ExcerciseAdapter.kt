package id.semmi.minnanotame

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.soal.view.*

class ExcerciseAdapter(val context: Context, val excercises: List<Excercise>, val listener: (String, Int
) -> Unit) : RecyclerView.Adapter<ExcerciseAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExcerciseAdapter.ViewHolder {
        val inflater = LayoutInflater.from(context)
        val soalView = inflater.inflate(R.layout.soal, parent, false)
        return ExcerciseAdapter.ViewHolder(soalView)
    }

    override fun getItemCount(): Int {
        return excercises.size
    }

    override fun onBindViewHolder(holder: ExcerciseAdapter.ViewHolder, position: Int) {
        holder.bind(excercises[position], position, listener)
    }

    class ViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView) {
        fun bind(
            excercise: Excercise,
            position: Int,
            listener: (String, Int) -> Unit
        ) {
            itemView?.soal?.text = excercise.soal

            itemView?.answer?.addTextChangedListener(object : TextWatcher {
                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                    listener(itemView.answer.text.toString(), position)
                }

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun afterTextChanged(p0: Editable?) {
                }

            })
        }

    }
}