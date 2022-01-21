package com.firefly.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.firefly.todo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var llist : MutableList<String>? = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Create EditText
        val editText = EditText(this)
        editText.setHint(R.string.enter_something)
        editText.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        editText.setPadding(20, 20, 20, 20)
        // Add EditText to LinearLayout
        binding.rootLayout.addView(editText)
        editText.id = R.id.editTextID

        val button = Button(this)
        button.setText(R.string.buttontext)
        button.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        button.setPadding(20, 20, 20, 20)
        binding.rootLayout.addView(button)
        button.id = R.id.buttonID
        button.setOnClickListener {
           if (editText.text!= null)
           {
               val check = CheckBox(this)
               check.layoutParams = LinearLayout.LayoutParams(
                   ViewGroup.LayoutParams.MATCH_PARENT,
                   ViewGroup.LayoutParams.WRAP_CONTENT
               )
               check.setText(editText.text.toString())
               check.setOnCheckedChangeListener { buttonView, isChecked ->
                   val msg = "You have " + "deleted this item"
                   Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
                   binding.rootLayout.removeView(check)
               }
               binding.rootLayout.addView(check)
               editText.text.clear()
           }
            else
           {
               Toast.makeText(this,"Enter something",Toast.LENGTH_LONG).show()
           }
        }




    }


}