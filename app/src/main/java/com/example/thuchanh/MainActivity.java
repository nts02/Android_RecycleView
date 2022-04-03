package com.example.thuchanh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.thuchanh.model.Cat;
import com.example.thuchanh.model.CatAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  CatAdapter.CatItemListener{

    private RecyclerView recyclerView;
    private CatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rview);
        adapter = new CatAdapter(getList());
        adapter.setCatItemListener(this);
        GridLayoutManager manager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    private List<Cat> getList() {
        List<Cat> list = new ArrayList<Cat>();
        list.add(new Cat(R.drawable.cat,"Meo pho"));
        list.add(new Cat(R.drawable.cat1,"Meo pho1"));
        list.add(new Cat(R.drawable.cat2,"Meo pho2"));
        list.add(new Cat(R.drawable.cat3,"Meo pho3"));
        list.add(new Cat(R.drawable.cat4,"Meo pho4"));
        list.add(new Cat(R.drawable.cat5,"Meo pho5"));
        return list;
    }

    @Override
    public void onItemClick(View view, int position) {
        Cat c = getList().get(position);
        Toast.makeText(this,c.getName(),Toast.LENGTH_SHORT).show();
    }
}