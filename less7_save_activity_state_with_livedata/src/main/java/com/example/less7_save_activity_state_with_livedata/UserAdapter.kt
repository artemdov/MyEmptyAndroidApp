package com.example.less7_save_activity_state_with_livedata


import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class UserAdapter(private var context: Context, private var userList: List<User>) :
    RecyclerView.Adapter<UserAdapter.UserHolder>() {


    private val inflater: LayoutInflater = LayoutInflater.from(context)

    //Нам нужно указать идентификатор макета для отдельного элемента списка, созданный нами ранее в файле
    // list_item.xml. А также вернуть наш объект класса ViewHolder. Допустим, устройство может
    // отобразить на экране 9 элементов списка. RecyclerView создаст 11-12 элементов (с запасом).
    // Неважно, каким большим будет ваш список, но все данные будут размещаться в тех же 11 элементах,
    // автоматически меняя содержимое при прокрутке.

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val itemView = inflater.inflate(R.layout.user_item, parent, false)
        Log.d("##userList", userList.toString())
        return UserHolder(itemView)
    }

    //основной метод из которого мы наполняем потом данными лэйаут
    //Параметр position отвечает за позицию в списке (индекс), по которой можно получить нужные данные.
    //можно было так описать но напишем с bind

//    override fun onBindViewHolder(holder: UserHolder, position: Int) {
//        val userItem = userList[position]
//
//
//        holder.userName.text = userItem.name
//        holder.userDescription.text = userItem.descr
//    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bind(userList[position])
    }

    //возвращает количество необходимых айтемов на экране чтобы было удобно адаптировать размер списка и
    // чтобы распределить ресурсы и подготовиться к отображению на экране

    override fun getItemCount(): Int {
        return userList.size
    }

    //в нем связываем с помощью айди данные из класса User

//     также перепишем через bind
//    class UserHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var userName: TextView = itemView.findViewById(R.id.userName)
//        var userDescription: TextView = itemView.findViewById(R.id.userDesr)
//    }

    //передвем новые данные и оповещаем адаптер о необходимости обновления списка
    fun refreshUsers(users: List<User>) {
        this.userList = users
        notifyDataSetChanged()
    }

    class UserHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userName: TextView = itemView.findViewById(R.id.userName)
        private val userDescription: TextView = itemView.findViewById(R.id.userDesr)

        fun bind(user: User) {
            userName.text = user.name
            userDescription.text = user.descr
        }

    }

}