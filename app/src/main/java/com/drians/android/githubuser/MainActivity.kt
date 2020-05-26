package com.drians.android.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.drians.android.githubuser.adapter.UserAdapter
import com.drians.android.githubuser.model.User
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private var user: MutableList<User> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prepare()

        recyclerview_user.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)

        recyclerview_user.adapter = UserAdapter (this, user) {
            startActivity<DetailUserActivity>("DATA_USER" to it)
        }
    }

    private fun prepare(){

        val dataUsername = resources.getStringArray(R.array.username)
        val dataName = resources.getStringArray(R.array.name)
        val dataAvatar = resources.obtainTypedArray(R.array.avatar)
        val dataCompany = resources.getStringArray(R.array.company)
        val dataLocation = resources.getStringArray(R.array.location)
        val dataRepository = resources.getStringArray(R.array.repository)
        val dataFollower = resources.getStringArray(R.array.followers)
        val dataFollowing = resources.getStringArray(R.array.following)

        user.clear()

        for (i in dataUsername.indices) {
            user.add(
                User(dataUsername[i], dataName[i], dataAvatar.getResourceId(i, 0),
                dataCompany[i], dataLocation[i], dataRepository[i], dataFollower[i],
                dataFollowing[i])
            )
        }

        dataAvatar.recycle()
    }
}
