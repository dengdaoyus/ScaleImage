package cn.ddy.scaleimagedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ScaleImgListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<String> notes=new ArrayList<>();
    private ScaleImageListAdapter scaleImageListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scaleimg_list);
        mRecyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        initAdapter();
        getData();
    }
    private  void initAdapter(){
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        scaleImageListAdapter=new ScaleImageListAdapter(notes);
        mRecyclerView.setAdapter(scaleImageListAdapter);
    }
    private void getData(){
        notes.clear();
        for (int i = 0; i <10 ; i++) {
            notes.add("我是文字"+i);
        }
        scaleImageListAdapter.notifyDataSetChanged();
    }
}
