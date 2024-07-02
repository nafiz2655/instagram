package com.example.instragram;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;


public class Search extends Fragment {

    RecyclerView recyclerView;
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap= new HashMap<>();





    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_search, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);


        MakeHasmap();

        My_Adapter myAdapter = new My_Adapter();
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));


        return view;
    }

    public class My_Adapter extends RecyclerView.Adapter<My_Adapter.MY_Holder>{

        ImageView imageView;

        public class MY_Holder extends RecyclerView.ViewHolder{
            public MY_Holder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.imageView);

            }
        }

        @NonNull
        @Override
        public MY_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView = layoutInflater.inflate(R.layout.search_layout,parent,false);

            return new MY_Holder(myView);
        }

        @Override
        public void onBindViewHolder(@NonNull MY_Holder holder, int position) {

            HashMap<String,String> hashMap1 = arrayList.get(position);
            String image = hashMap1.get("image");
            imageView.setImageResource(Integer.parseInt(image));


        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }


    }

    private void MakeHasmap() {

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pro1);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pro2);
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pro3);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pro4);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pro5);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pro8);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pro10);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pro11);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pro12);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pic2);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pic3);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pic4);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pic5);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pic6);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pic7);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pic8);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pic9);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pic10);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pic11);
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pro1);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pro2);
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pro3);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pro4);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pro5);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pro8);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pro10);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pro11);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pro12);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pic2);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pic3);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pic4);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pic5);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pic6);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pic7);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pic8);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pic9);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pic10);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pic11);
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pro1);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pro2);
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pro3);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pro4);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pro5);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pro8);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pro10);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pro11);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pro12);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pic2);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pic3);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pic4);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pic5);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pic6);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pic7);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pic8);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pic9);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pic10);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image",""+R.drawable.pic11);
        arrayList.add(hashMap);




    }


}