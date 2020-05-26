package com.drians.android.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.drians.android.githubuser.model.User
import kotlinx.android.synthetic.main.activity_detail_user.*

class DetailUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        val actionbar = supportActionBar
        actionbar?.title = resources.getString(R.string.label_detail_user)
        actionbar?.elevation = 0F

        actionbar?.setDisplayHomeAsUpEnabled(true)
        actionbar?.setDisplayHomeAsUpEnabled(true)

        val user = intent.getParcelableExtra<User>("DATA_USER")

        user?.avatar?.let { Glide.with(this).load(it).into(img_avatar) }
        txt_name.text = user?.name
        txt_username.text = user?.username
        txt_location.text = user?.location
        txt_company.text = user?.company
        txt_repository.text = user?.repository
        txt_follower.text = user?.follower
        txt_following.text = user?.following
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
