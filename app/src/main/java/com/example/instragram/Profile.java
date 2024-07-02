package com.example.instragram;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.ResultReceiver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;


public class Profile extends Fragment {


    RecyclerView recyclerView;
    TextView name;

    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap = new HashMap<>() ;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        MakeHasmap();

        recyclerView = view.findViewById(R.id.recyclerView);
        name = view.findViewById(R.id.name);

        name.setText("@nafiz_ahmed2655");


        My_adapter myAdapter = new My_adapter();
        recyclerView.setAdapter(myAdapter);
        LinearLayoutManager layoutManager= new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);



        return view;
    }

    public class My_adapter extends RecyclerView.Adapter<My_adapter.ViewHolder>{
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.layout,parent,false);

            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            HashMap<String,String> hashMap1 = arrayList.get(position);
            String image = hashMap1.get("iamge");
            String name = hashMap1.get("name");

            holder.profile.setImageResource(Integer.parseInt(image));
            holder.name.setText(name);

        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{

            CircleImageView profile;
            TextView name;


            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                name = itemView.findViewById(R.id.name);
                profile = itemView.findViewById(R.id.profile);
            }
        }
    }

    public void MakeHasmap (){
        hashMap = new HashMap<>();
        hashMap.put("iamge",""+R.drawable.pro1);
        hashMap.put("name","Julker Nime");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("iamge",""+R.drawable.pro2);
        hashMap.put("name","Tangir Tamin");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("iamge",""+R.drawable.pro3);
        hashMap.put("name","Munshi Amiroul");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("iamge",""+R.drawable.pro4);
        hashMap.put("name","Rabbir Hasan");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("iamge",""+R.drawable.pro5);
        hashMap.put("name","Bodiyar Hasan");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("iamge",""+R.drawable.pro8);
        hashMap.put("name","Ahasan Habib");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("iamge",""+R.drawable.pro10);
        hashMap.put("name","Rabbi Khan");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("iamge",""+R.drawable.pro11);
        hashMap.put("name","Arman Hasan");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("iamge",""+R.drawable.pro12);
        hashMap.put("name","Sime Ahmed");
        arrayList.add(hashMap);



    }
}