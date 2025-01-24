package com.example.recyclerview


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView


class StudentAdapter(private var context: Context, private var studentList: List<Student>) :
    RecyclerView.Adapter<StudentAdapter.MyViewHolder>() {


    private val inflater: LayoutInflater = LayoutInflater.from(context)

    //в нем связываем с помощью айди данные из класса Student

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val group: TextView = itemView.findViewById(R.id.group_txt)
        val skills: TextView = itemView.findViewById(R.id.skills_txt)
        val fullname: TextView = itemView.findViewById(R.id.fullname_txt)
    }

    //Нам нужно указать идентификатор макета для отдельного элемента списка, созданный нами ранее в файле
    // list_item.xml. А также вернуть наш объект класса ViewHolder. Допустим, устройство может
    // отобразить на экране 9 элементов списка. RecyclerView создаст 11-12 элементов (с запасом).
    // Неважно, каким большим будет ваш список, но все данные будут размещаться в тех же 11 элементах,
    // автоматически меняя содержимое при прокрутке.

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = inflater.inflate(R.layout.list_item, parent, false)

        return MyViewHolder(itemView)
    }

    //основной метод из которого мы наполняем потом данными лэйаут
    //Параметр position отвечает за позицию в списке (индекс), по которой можно получить нужные данные.

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val student = studentList[position]

        //это чтобы чередовать цвета айтемов
        if (position % 2 == 0) {
            holder.itemView.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    androidx.cardview.R.color.cardview_dark_background
                )
            )
        } else {
            holder.itemView.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    com.google.android.material.R.color.material_dynamic_neutral30
                )
            )
        }

        holder.fullname.text = student.fullName
        holder.skills.text = "skills: ${student.skills}"
        holder.group.text = "group: ${student.group}"
    }

    //возвращает количество необходимых айтемов на экране чтобы было удобно адаптировать размер списка и
    // чтобы распределить ресурсы и подготовиться к отображению на экране

    override fun getItemCount(): Int {
        return studentList.size
    }
}


//data class StudentAdapterData(val context: Context, val studentList: List<Student>)
//
//fun createStudentAdapter(data: StudentAdapterData): RecyclerView.Adapter<ViewHolder> {
//    val inflater = LayoutInflater.from(data.context)
//
//    return object : RecyclerView.Adapter<ViewHolder>() {
//        override fun getItemCount(): Int {
//            return data.studentList.size
//        }
//
//        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//            val student = data.studentList[position]
//            // Привязка данных к ViewHolder
//        }
//    }
//}