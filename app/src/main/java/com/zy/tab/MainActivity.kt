package com.zy.tab

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        header_recyclerView.layoutManager = LinearLayoutManager(this)
        header_recyclerView.setHasFixedSize(true)
        adapter = ListAdapter()
        header_recyclerView.adapter = adapter
        adapter.setNewData(listOf("1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"))
        val list = ArrayList<Fragment>()
        for (i in 0.. 10){
            list.add(TabFragment())
        }
        val adapter1 = MyAdapter(list)
        viewPager.adapter = adapter1
        tab_layout.setupWithViewPager(viewPager)
        tab_layout.tabMode=TabLayout.MODE_SCROLLABLE
        for (i in 0..10){
            tab_layout.getTabAt(i)?.text = "首页$i"
        }
        
        adapter.setOnItemClickListener { adapter, view, position -> 
            Toast.makeText(this,position.toString(),Toast.LENGTH_SHORT).show()
        }
        
      
    }


    inner class MyAdapter(list: ArrayList<Fragment>) :
        FragmentPagerAdapter (supportFragmentManager) {

        private val fragments = list

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }
        

    }
}
