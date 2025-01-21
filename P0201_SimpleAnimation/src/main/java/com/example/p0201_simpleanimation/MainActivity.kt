package com.example.p0201_simpleanimation

import android.os.Bundle
import android.view.ContextMenu
import android.view.ContextMenu.ContextMenuInfo
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    val MENU_ALPHA_ID: Int = 1
    val MENU_SCALE_ID: Int = 2
    val MENU_TRANSLATE_ID: Int = 3
    val MENU_ROTATE_ID: Int = 4
    val MENU_COMBO_ID: Int = 5

    var tv: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.tv)
        tv?.setOnCreateContextMenuListener(this)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenuInfo?,
    ) {
        when (v.id) {
            R.id.tv -> {
                // добавляем пункты
                menu.add(0, MENU_ALPHA_ID, 0, "alpha");
                menu.add(0, MENU_SCALE_ID, 0, "scale");
                menu.add(0, MENU_TRANSLATE_ID, 0, "translate");
                menu.add(0, MENU_ROTATE_ID, 0, "rotate");
                menu.add(0, MENU_COMBO_ID, 0, "combo");
            }
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        var anim: Animation? = null
        when (item.itemId) {
            MENU_ALPHA_ID -> anim = AnimationUtils.loadAnimation(this, R.anim.myalpha)
            MENU_SCALE_ID -> anim = AnimationUtils.loadAnimation(this, R.anim.myscale)
            MENU_COMBO_ID -> anim = AnimationUtils.loadAnimation(this, R.anim.mycombo)
            MENU_ROTATE_ID -> anim = AnimationUtils.loadAnimation(this, R.anim.myrotate)
            MENU_TRANSLATE_ID -> anim = AnimationUtils.loadAnimation(this, R.anim.mytrans)
        }
        tv?.startAnimation(anim)

        return super.onContextItemSelected(item)
    }
}