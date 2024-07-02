package com.example.instragram;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;


public class Video extends Fragment {

    RecyclerView recyclerView;

    int i= 0;

    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap = new HashMap<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_video, container, false);



        MakeHasmap();

        recyclerView = view.findViewById(R.id.recyclerView);

        My_adapter myAdapter = new My_adapter();
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    public class My_adapter extends RecyclerView.Adapter<My_adapter.ViewHolder>{

        public class ViewHolder extends RecyclerView.ViewHolder{

            CircleImageView profile_image;
            TextView chanel_name,song_chanelname,discriotion,hastag,comment,like;

            VideoView idVideoView;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                idVideoView = itemView.findViewById(R.id.idVideoView);
                chanel_name = itemView.findViewById(R.id.chanel_name);
                song_chanelname = itemView.findViewById(R.id.song_chanelname);
                hastag = itemView.findViewById(R.id.hastag);
                comment = itemView.findViewById(R.id.comment);
                discriotion = itemView.findViewById(R.id.discriotion);
                like = itemView.findViewById(R.id.like);
                profile_image = itemView.findViewById(R.id.profile_image);

            }
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.video_layout,parent,false);


            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            HashMap<String,String > hashMap1 = arrayList.get(position);

            String chanel_name= hashMap1.get("chanel_name");
            String song_name = hashMap1.get("song_name");
            String like = hashMap1.get("like");
            String discription = hashMap1.get("discription");
            String commen = hashMap1.get("commen");
            String profile = hashMap1.get("profile");
            String video = hashMap1.get("video");
            String taggs = hashMap1.get("taggs");


            holder.chanel_name.setText(chanel_name);
            holder.song_chanelname.setText(song_name+"__"+chanel_name);
            holder.like.setText(like);
            holder.discriotion.setText(discription);
            holder.comment.setText("View all "+commen+" comments");
            holder.profile_image.setImageResource(Integer.parseInt(profile));
            holder.hastag.setText(taggs);


            String path = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.video1;
            holder.idVideoView.setVideoURI(Uri.parse(path));

            holder.idVideoView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (i==0){
                        holder.idVideoView.start();
                        i=1;
                    }else {
                        holder.idVideoView.stopPlayback();
                        i=0;
                    }


                }
            });


        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }


    }




    public void MakeHasmap(){







        hashMap = new HashMap<>();
        hashMap.put("itemType","VIDEO");
        hashMap.put("video","video1");
        hashMap.put("chanel_name","Moonlit Echoes__4d");
        hashMap.put("song_name","InstaInspire");
        hashMap.put("like","2554");
        hashMap.put("discription","Moments captured, stories told, memories made");
        hashMap.put("commen","5k");
        hashMap.put("profile",""+R.drawable.pro11);
        hashMap.put("taggs","#PhotoOfTheDay...");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("itemType","VIDEO");
        hashMap.put("video_id","video2");
        hashMap.put("chanel_name","Whispered Dreams__2d");
        hashMap.put("song_name","SnapFusion");
        hashMap.put("like","26k");
        hashMap.put("discription","Creating magic through lens, one click");
        hashMap.put("commen","12k");
        hashMap.put("profile",""+R.drawable.pro1);
        hashMap.put("taggs","#InstaDaily...");
        arrayList.add(hashMap);




        hashMap = new HashMap<>();
        hashMap.put("itemType","VIDEO");
        hashMap.put("video","video1");
        hashMap.put("chanel_name","SnapStories");
        hashMap.put("song_name","SnapChic ");
        hashMap.put("like","136k");
        hashMap.put("discription","Snapshots of joy, love, and adventure");
        hashMap.put("commen","12k");
        hashMap.put("profile",""+R.drawable.pro5);
        hashMap.put("taggs","#InstaLove...");
        arrayList.add(hashMap);





        hashMap = new HashMap<>();
        hashMap.put("itemType","VIDEO");
        hashMap.put("video","video1");
        hashMap.put("chanel_name","Velvet Horizons__9d");
        hashMap.put("song_name","Moonlit Echoes");
        hashMap.put("like","2654");
        hashMap.put("discription","Life's beauty, captured one photo at time.");
        hashMap.put("commen","19k");
        hashMap.put("profile",""+R.drawable.pro11);
        hashMap.put("taggs","#InstaMood...");
        arrayList.add(hashMap);




        hashMap = new HashMap<>();
        hashMap.put("itemType","VIDEO");
        hashMap.put("video","video1");
        hashMap.put("chanel_name","Symphony of Shadows__12h");
        hashMap.put("song_name","InstaAura");
        hashMap.put("like","1256");
        hashMap.put("discription","Capturing life's moments, one snap at a time.");
        hashMap.put("commen","1364");
        hashMap.put("profile",""+R.drawable.pro2);
        hashMap.put("taggs","#InstaPic...");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("itemType","VIDEO");
        hashMap.put("video","video1");
        hashMap.put("chanel_name","Electric Embrace__5d");
        hashMap.put("song_name","Moonlit Echoes");
        hashMap.put("like","12");
        hashMap.put("discription","Inspiration through lens, life in focus");
        hashMap.put("commen","12");
        hashMap.put("profile",""+R.drawable.pro12);
        hashMap.put("taggs","#PicOfTheDay...");
        arrayList.add(hashMap);






        hashMap = new HashMap<>();
        hashMap.put("itemType","VIDEO");
        hashMap.put("video","video1");
        hashMap.put("chanel_name","Dancing in the Rain__2h");
        hashMap.put("song_name","InstaFlicks");
        hashMap.put("like","5226");
        hashMap.put("discription","Capturing life's moments, one snap at a time.");
        hashMap.put("commen","2365");
        hashMap.put("profile",""+R.drawable.pro12);
        hashMap.put("taggs","#Photographer...");
        arrayList.add(hashMap);







        hashMap = new HashMap<>();
        hashMap.put("itemType","VIDEO");
        hashMap.put("video","video1");
        hashMap.put("chanel_name","Cascading Light__25d");
        hashMap.put("song_name","SnapSavvy");
        hashMap.put("like","6k");
        hashMap.put("discription","Capturing life's moments, one snap at a time.");
        hashMap.put("commen","5k");
        hashMap.put("profile",""+R.drawable.pro5);
        hashMap.put("taggs","#Capture...");
        arrayList.add(hashMap);







        hashMap = new HashMap<>();
        hashMap.put("itemType","VIDEO");
        hashMap.put("video","video1");
        hashMap.put("chanel_name","Broken Harmonies__7d");
        hashMap.put("song_name","SnapFusion");
        hashMap.put("like","235k");
        hashMap.put("discription","Capturing life's moments, one snap at a time.");
        hashMap.put("commen","12k");
        hashMap.put("profile",""+R.drawable.pro3);
        hashMap.put("taggs","#LifeInPhotos...");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("itemType","VIDEO");
        hashMap.put("video","video1");
        hashMap.put("chanel_name","Moonlit Echoes__4d");
        hashMap.put("song_name","InstaInspire");
        hashMap.put("like","2554");
        hashMap.put("discription","Moments captured, stories told, memories made");
        hashMap.put("commen","5k");
        hashMap.put("profile",""+R.drawable.pro11);
        hashMap.put("taggs","#PhotoOfTheDay...");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("itemType","VIDEO");
        hashMap.put("video_id","video2");
        hashMap.put("chanel_name","Whispered Dreams__2d");
        hashMap.put("song_name","SnapFusion");
        hashMap.put("like","26k");
        hashMap.put("discription","Creating magic through lens, one click");
        hashMap.put("commen","12k");
        hashMap.put("profile",""+R.drawable.pro1);
        hashMap.put("taggs","#InstaDaily...");
        arrayList.add(hashMap);









        hashMap = new HashMap<>();
        hashMap.put("itemType","VIDEO");
        hashMap.put("video","video1");
        hashMap.put("chanel_name","SnapStories");
        hashMap.put("song_name","SnapChic ");
        hashMap.put("like","136k");
        hashMap.put("discription","Snapshots of joy, love, and adventure");
        hashMap.put("commen","12k");
        hashMap.put("profile",""+R.drawable.pro5);
        hashMap.put("taggs","#InstaLove...");
        arrayList.add(hashMap);





        hashMap = new HashMap<>();
        hashMap.put("itemType","VIDEO");
        hashMap.put("video","video1");
        hashMap.put("chanel_name","Velvet Horizons__9d");
        hashMap.put("song_name","Moonlit Echoes");
        hashMap.put("like","2654");
        hashMap.put("discription","Life's beauty, captured one photo at time.");
        hashMap.put("commen","19k");
        hashMap.put("profile",""+R.drawable.pro11);
        hashMap.put("taggs","#InstaMood...");
        arrayList.add(hashMap);




        hashMap = new HashMap<>();
        hashMap.put("itemType","VIDEO");
        hashMap.put("video","video1");
        hashMap.put("chanel_name","Symphony of Shadows__12h");
        hashMap.put("song_name","InstaAura");
        hashMap.put("like","1256");
        hashMap.put("discription","Capturing life's moments, one snap at a time.");
        hashMap.put("commen","1364");
        hashMap.put("profile",""+R.drawable.pro2);
        hashMap.put("taggs","#InstaPic...");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("itemType","VIDEO");
        hashMap.put("video","video1");
        hashMap.put("chanel_name","Electric Embrace__5d");
        hashMap.put("song_name","Moonlit Echoes");
        hashMap.put("like","12");
        hashMap.put("discription","Inspiration through lens, life in focus");
        hashMap.put("commen","12");
        hashMap.put("profile",""+R.drawable.pro12);
        hashMap.put("taggs","#PicOfTheDay...");
        arrayList.add(hashMap);




        hashMap = new HashMap<>();
        hashMap.put("itemType","VIDEO");
        hashMap.put("video","video1");
        hashMap.put("chanel_name","Dancing in the Rain__2h");
        hashMap.put("song_name","InstaFlicks");
        hashMap.put("like","5226");
        hashMap.put("discription","Capturing life's moments, one snap at a time.");
        hashMap.put("commen","2365");
        hashMap.put("profile",""+R.drawable.pro12);
        hashMap.put("taggs","#Photographer...");
        arrayList.add(hashMap);






        hashMap = new HashMap<>();
        hashMap.put("itemType","VIDEO");
        hashMap.put("video","video1");
        hashMap.put("chanel_name","Cascading Light__25d");
        hashMap.put("song_name","SnapSavvy");
        hashMap.put("like","6k");
        hashMap.put("discription","Capturing life's moments, one snap at a time.");
        hashMap.put("commen","5k");
        hashMap.put("profile",""+R.drawable.pro5);
        hashMap.put("taggs","#Capture...");
        arrayList.add(hashMap);




        hashMap = new HashMap<>();
        hashMap.put("itemType","VIDEO");
        hashMap.put("video","video1");
        hashMap.put("chanel_name","Broken Harmonies__7d");
        hashMap.put("song_name","SnapFusion");
        hashMap.put("like","235k");
        hashMap.put("discription","Capturing life's moments, one snap at a time.");
        hashMap.put("commen","12k");
        hashMap.put("profile",""+R.drawable.pro3);
        hashMap.put("taggs","#LifeInPhotos...");
        arrayList.add(hashMap);




    }



}