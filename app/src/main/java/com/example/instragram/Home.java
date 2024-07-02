package com.example.instragram;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;


public class Home extends Fragment {

    RecyclerView recyclerView;

    int i= 0;

    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap = new HashMap<>();




    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        MakeHasmap();

        recyclerView = view.findViewById(R.id.recyclerView);
        My_adapter myAdapter = new My_adapter();
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        return view;

    }


    public class My_adapter extends RecyclerView.Adapter{

        int IMAGE= 0;
        int VIDEO = 1;
        int LAYOUT = 2;

        public class image_View_Holder extends RecyclerView.ViewHolder{


            CircleImageView profile_image;
            TextView chanel_name,song_chanelname,discriotion,hastag,comment,like;

            ImageView imageView;

            public image_View_Holder(@NonNull View itemView) {
                super(itemView);
                profile_image = itemView.findViewById(R.id.profile_image);
                chanel_name = itemView.findViewById(R.id.chanel_name);
                song_chanelname = itemView.findViewById(R.id.song_chanelname);
                discriotion = itemView.findViewById(R.id.discriotion);
                hastag = itemView.findViewById(R.id.hastag);
                comment = itemView.findViewById(R.id.comment);
                imageView = itemView.findViewById(R.id.imageView);
                like = itemView.findViewById(R.id.like);



            }
        }
        public class layout_view_Holder extends RecyclerView.ViewHolder{



            public layout_view_Holder(@NonNull View itemView) {
                super(itemView);

            }
        }
        public class Video_View_Holder extends RecyclerView.ViewHolder{

            CircleImageView profile_image;
            TextView chanel_name,song_chanelname,discriotion,hastag,comment,like;

            VideoView idVideoView;



            public Video_View_Holder(@NonNull View itemView) {
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
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if (viewType==IMAGE){
                View image_view = layoutInflater.inflate(R.layout.image_layout,parent,false);
                return new image_View_Holder(image_view);

            }else if (viewType==VIDEO){
                View video_view = layoutInflater.inflate(R.layout.video_layout,parent,false);



                return new Video_View_Holder(video_view);

            }else {

                View layout_view = layoutInflater.inflate(R.layout.layout_layout,parent,false);
                return new layout_view_Holder(layout_view);

            }


        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


            HashMap<String,String> hashMap1 = arrayList.get(position);



            if (getItemViewType(position)==LAYOUT){

                layout_view_Holder l_layoutViewHolder = (layout_view_Holder) holder;





            }else if (getItemViewType(position)==IMAGE){
                image_View_Holder i_imageViewHolder = (image_View_Holder) holder;







                String chanel_name= hashMap1.get("chanel_name");
                String song_name = hashMap1.get("song_name");
                String like = hashMap1.get("like");
                String discription = hashMap1.get("discription");
                String commen = hashMap1.get("commen");
                String profile = hashMap1.get("profile");
                String imageUrl = hashMap1.get("imageUrl");
                String taggs = hashMap1.get("taggs");


                i_imageViewHolder.chanel_name.setText(chanel_name);
                i_imageViewHolder.song_chanelname.setText(song_name+"__"+chanel_name);
                i_imageViewHolder.like.setText(like+" Likes");
                i_imageViewHolder.discriotion.setText(discription);
                i_imageViewHolder.comment.setText("View all "+commen+" comments");
                i_imageViewHolder.profile_image.setImageResource(Integer.parseInt(profile));
                i_imageViewHolder.imageView.setImageResource(Integer.parseInt(imageUrl));
                i_imageViewHolder.hastag.setText(taggs);








            }else {
                Video_View_Holder v_videoViewHolder = (Video_View_Holder) holder;


                String chanel_name= hashMap1.get("chanel_name");
                String song_name = hashMap1.get("song_name");
                String like = hashMap1.get("like");
                String discription = hashMap1.get("discription");
                String commen = hashMap1.get("commen");
                String profile = hashMap1.get("profile");
                String video = hashMap1.get("video");
                String taggs = hashMap1.get("taggs");


                v_videoViewHolder.chanel_name.setText(chanel_name);
                v_videoViewHolder.song_chanelname.setText(song_name+"__"+chanel_name);
                v_videoViewHolder.like.setText(like);
                v_videoViewHolder.discriotion.setText(discription);
                v_videoViewHolder.comment.setText("View all "+commen+" comments");
                v_videoViewHolder.profile_image.setImageResource(Integer.parseInt(profile));
                v_videoViewHolder.hastag.setText(taggs);

                String path = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.video1;
                v_videoViewHolder.idVideoView.setVideoURI(Uri.parse(path));


                v_videoViewHolder.idVideoView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (i==0){
                            v_videoViewHolder.idVideoView.start();
                            i=1;
                        }else {
                            v_videoViewHolder.idVideoView.stopPlayback();
                            i=0;
                        }


                    }
                });

            }

        }








        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        @Override
        public int getItemViewType(int position) {

            hashMap = arrayList.get(position);
            String itemtype = hashMap.get("itemType");
            if (itemtype.contains("IMAGE")){
                return IMAGE;
            }else if (itemtype.contains("VIDEO")){
                return VIDEO;
            }else {
                return LAYOUT;
            }

        }
    }

    // flower class item/////////////////////////////////////////////////////////////




    public void MakeHasmap(){

        hashMap = new HashMap<>();
        hashMap.put("itemType","LAYOUT");
        hashMap.put("imageUrl","");
        hashMap.put("chanel_name","");
        hashMap.put("song_name","");
        hashMap.put("like","");
        hashMap.put("discription","");
        hashMap.put("commen","");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("itemType","IMAGE");
        hashMap.put("imageUrl",""+R.drawable.pic2);
        hashMap.put("chanel_name","SnapStories");
        hashMap.put("song_name","SnapFusion");
        hashMap.put("like","5226");
        hashMap.put("discription","Capturing life's moments, one snap at a time.");
        hashMap.put("commen","2365");
        hashMap.put("profile",""+R.drawable.pro1);
        hashMap.put("taggs","#InstaGood...");
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
        hashMap.put("itemType","IMAGE");
        hashMap.put("imageUrl",""+R.drawable.pic3);
        hashMap.put("chanel_name","Midnight Serenade__5d");
        hashMap.put("song_name","TrendSetterGram");
        hashMap.put("like","5226");
        hashMap.put("discription","Every picture tells a unique, beautiful story");
        hashMap.put("commen","5k");
        hashMap.put("profile",""+R.drawable.pro3);
        hashMap.put("taggs","#PhotoGram...");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("itemType","IMAGE");
        hashMap.put("imageUrl",""+R.drawable.pic4);
        hashMap.put("chanel_name","Echoes of Tomorrow__8h");
        hashMap.put("song_name","SnapJourney");
        hashMap.put("like","262");
        hashMap.put("discription","Passion for photography, love for life");
        hashMap.put("commen","12");
        hashMap.put("profile",""+R.drawable.pro4);
        hashMap.put("taggs","#PhotoGram...");
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
        hashMap.put("itemType","IMAGE");
        hashMap.put("imageUrl",""+R.drawable.pic5);
        hashMap.put("chanel_name","Starlit Skies__8d");
        hashMap.put("song_name","InstaMuse");
        hashMap.put("like","12k");
        hashMap.put("discription","Capturing life's moments, one snap at a time.");
        hashMap.put("commen","3k");
        hashMap.put("profile",""+R.drawable.pro5);
        hashMap.put("taggs","#directselling...");
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
        hashMap.put("itemType","IMAGE");
        hashMap.put("imageUrl",""+R.drawable.pic6);
        hashMap.put("chanel_name","Lost in Reverie__12d");
        hashMap.put("song_name","Moonlit Echoes");
        hashMap.put("like","5226");
        hashMap.put("discription","Exploring the world, one photo per moment");
        hashMap.put("commen","125");
        hashMap.put("profile",""+R.drawable.pro8);
        hashMap.put("taggs","#InstaFollow...");
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
        hashMap.put("itemType","IMAGE");
        hashMap.put("imageUrl",""+R.drawable.pic11);
        hashMap.put("chanel_name","Golden Hours__14h");
        hashMap.put("song_name","Moonlit Echoes");
        hashMap.put("like","1256");
        hashMap.put("discription","Adventure awaits, capturing every precious moment");
        hashMap.put("commen","4924");
        hashMap.put("profile",""+R.drawable.pro10);
        hashMap.put("taggs","#InstaPhoto...");
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
        hashMap.put("itemType","IMAGE");
        hashMap.put("imageUrl",""+R.drawable.pic6);
        hashMap.put("chanel_name","Serendipity's Song__4h");
        hashMap.put("song_name","InstaAura");
        hashMap.put("like","12543");
        hashMap.put("discription","Capturing life's moments, one snap at a time.");
        hashMap.put("commen","1245");
        hashMap.put("profile",""+R.drawable.pro11);
        hashMap.put("taggs","#InstaArt...");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("itemType","IMAGE");
        hashMap.put("imageUrl",""+R.drawable.pic7);
        hashMap.put("chanel_name","SnapStories");
        hashMap.put("song_name","PhotoBliss");
        hashMap.put("like","5k");
        hashMap.put("discription","Living life, capturing moments, sharing love");
        hashMap.put("commen","2k");
        hashMap.put("profile",""+R.drawable.pro12);
        hashMap.put("taggs","#Snapshot...");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("itemType","IMAGE");
        hashMap.put("imageUrl",""+R.drawable.pic8);
        hashMap.put("chanel_name","Whispers of Fate__2d");
        hashMap.put("song_name","Moonlit Echoes");
        hashMap.put("like","1264k");
        hashMap.put("discription","Everyday moments, extraordinary stories, endless love");
        hashMap.put("commen","123k");
        hashMap.put("profile",""+R.drawable.pro4);
        hashMap.put("taggs","#Photography...");
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
        hashMap.put("itemType","IMAGE");
        hashMap.put("imageUrl",""+R.drawable.pic10);
        hashMap.put("chanel_name","Solstice Serenade__1d");
        hashMap.put("song_name","Moonlit Echoes");
        hashMap.put("like","1264");
        hashMap.put("discription","Life's journey, beautifully documented through .");
        hashMap.put("commen","325");
        hashMap.put("profile",""+R.drawable.pro1);
        hashMap.put("taggs","#directselling...");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("itemType","IMAGE");
        hashMap.put("imageUrl",""+R.drawable.pic2);
        hashMap.put("chanel_name","Crimson Reflections__15d");
        hashMap.put("song_name","Moonlit Echoes");
        hashMap.put("like","654");
        hashMap.put("discription","Capturing life's moments, one snap at a time.");
        hashMap.put("commen","123");
        hashMap.put("profile",""+R.drawable.pro3);
        hashMap.put("taggs","#PhotoLover...");
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
        hashMap.put("itemType","IMAGE");
        hashMap.put("imageUrl",""+R.drawable.pic11);
        hashMap.put("chanel_name","Fragile Promises__9h");
        hashMap.put("song_name","Moonlit Echoes");
        hashMap.put("like","1364");
        hashMap.put("discription","Capturing life's moments, one snap at a time.");
        hashMap.put("commen","236k");
        hashMap.put("profile",""+R.drawable.pro12);
        hashMap.put("taggs","#InstaCapture...");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("itemType","IMAGE");
        hashMap.put("imageUrl",""+R.drawable.pic6);
        hashMap.put("chanel_name","SnapStories__3h");
        hashMap.put("song_name","SnapJourney");
        hashMap.put("like","5226");
        hashMap.put("discription","Capturing life's moments, one snap at a time.");
        hashMap.put("commen","2365");
        hashMap.put("profile",""+R.drawable.pro11);
        hashMap.put("taggs","#InstaMoments...");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("itemType","IMAGE");
        hashMap.put("imageUrl",""+R.drawable.pic7);
        hashMap.put("chanel_name","Radiant Reverie__7h");
        hashMap.put("song_name","TrendSetterGram");
        hashMap.put("like","5226");
        hashMap.put("discription","Capturing life's moments, one snap at a time.");
        hashMap.put("commen","2365");
        hashMap.put("profile",""+R.drawable.pro12);
        hashMap.put("taggs","#MomentCaptured...");
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
        hashMap.put("itemType","IMAGE");
        hashMap.put("imageUrl",""+R.drawable.pic2);
        hashMap.put("chanel_name","SnapStories");
        hashMap.put("song_name","SnapFusion");
        hashMap.put("like","5226");
        hashMap.put("discription","Capturing life's moments, one snap at a time.");
        hashMap.put("commen","2365");
        hashMap.put("profile",""+R.drawable.pro1);
        hashMap.put("taggs","#InstaGood...");
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
        hashMap.put("itemType","IMAGE");
        hashMap.put("imageUrl",""+R.drawable.pic3);
        hashMap.put("chanel_name","Midnight Serenade__5d");
        hashMap.put("song_name","TrendSetterGram");
        hashMap.put("like","5226");
        hashMap.put("discription","Every picture tells a unique, beautiful story");
        hashMap.put("commen","5k");
        hashMap.put("profile",""+R.drawable.pro3);
        hashMap.put("taggs","#PhotoGram...");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("itemType","IMAGE");
        hashMap.put("imageUrl",""+R.drawable.pic4);
        hashMap.put("chanel_name","Echoes of Tomorrow__8h");
        hashMap.put("song_name","SnapJourney");
        hashMap.put("like","262");
        hashMap.put("discription","Passion for photography, love for life");
        hashMap.put("commen","12");
        hashMap.put("profile",""+R.drawable.pro4);
        hashMap.put("taggs","#PhotoGram...");
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
        hashMap.put("itemType","IMAGE");
        hashMap.put("imageUrl",""+R.drawable.pic5);
        hashMap.put("chanel_name","Starlit Skies__8d");
        hashMap.put("song_name","InstaMuse");
        hashMap.put("like","12k");
        hashMap.put("discription","Capturing life's moments, one snap at a time.");
        hashMap.put("commen","3k");
        hashMap.put("profile",""+R.drawable.pro5);
        hashMap.put("taggs","#directselling...");
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
        hashMap.put("itemType","IMAGE");
        hashMap.put("imageUrl",""+R.drawable.pic6);
        hashMap.put("chanel_name","Lost in Reverie__12d");
        hashMap.put("song_name","Moonlit Echoes");
        hashMap.put("like","5226");
        hashMap.put("discription","Exploring the world, one photo per moment");
        hashMap.put("commen","125");
        hashMap.put("profile",""+R.drawable.pro8);
        hashMap.put("taggs","#InstaFollow...");
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
        hashMap.put("itemType","IMAGE");
        hashMap.put("imageUrl",""+R.drawable.pic11);
        hashMap.put("chanel_name","Golden Hours__14h");
        hashMap.put("song_name","Moonlit Echoes");
        hashMap.put("like","1256");
        hashMap.put("discription","Adventure awaits, capturing every precious moment");
        hashMap.put("commen","4924");
        hashMap.put("profile",""+R.drawable.pro10);
        hashMap.put("taggs","#InstaPhoto...");
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
        hashMap.put("itemType","IMAGE");
        hashMap.put("imageUrl",""+R.drawable.pic6);
        hashMap.put("chanel_name","Serendipity's Song__4h");
        hashMap.put("song_name","InstaAura");
        hashMap.put("like","12543");
        hashMap.put("discription","Capturing life's moments, one snap at a time.");
        hashMap.put("commen","1245");
        hashMap.put("profile",""+R.drawable.pro11);
        hashMap.put("taggs","#InstaArt...");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("itemType","IMAGE");
        hashMap.put("imageUrl",""+R.drawable.pic7);
        hashMap.put("chanel_name","SnapStories");
        hashMap.put("song_name","PhotoBliss");
        hashMap.put("like","5k");
        hashMap.put("discription","Living life, capturing moments, sharing love");
        hashMap.put("commen","2k");
        hashMap.put("profile",""+R.drawable.pro12);
        hashMap.put("taggs","#Snapshot...");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("itemType","IMAGE");
        hashMap.put("imageUrl",""+R.drawable.pic8);
        hashMap.put("chanel_name","Whispers of Fate__2d");
        hashMap.put("song_name","Moonlit Echoes");
        hashMap.put("like","1264k");
        hashMap.put("discription","Everyday moments, extraordinary stories, endless love");
        hashMap.put("commen","123k");
        hashMap.put("profile",""+R.drawable.pro4);
        hashMap.put("taggs","#Photography...");
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
        hashMap.put("itemType","IMAGE");
        hashMap.put("imageUrl",""+R.drawable.pic10);
        hashMap.put("chanel_name","Solstice Serenade__1d");
        hashMap.put("song_name","Moonlit Echoes");
        hashMap.put("like","1264");
        hashMap.put("discription","Life's journey, beautifully documented through .");
        hashMap.put("commen","325");
        hashMap.put("profile",""+R.drawable.pro1);
        hashMap.put("taggs","#directselling...");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("itemType","IMAGE");
        hashMap.put("imageUrl",""+R.drawable.pic2);
        hashMap.put("chanel_name","Crimson Reflections__15d");
        hashMap.put("song_name","Moonlit Echoes");
        hashMap.put("like","654");
        hashMap.put("discription","Capturing life's moments, one snap at a time.");
        hashMap.put("commen","123");
        hashMap.put("profile",""+R.drawable.pro3);
        hashMap.put("taggs","#PhotoLover...");
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
        hashMap.put("itemType","IMAGE");
        hashMap.put("imageUrl",""+R.drawable.pic11);
        hashMap.put("chanel_name","Fragile Promises__9h");
        hashMap.put("song_name","Moonlit Echoes");
        hashMap.put("like","1364");
        hashMap.put("discription","Capturing life's moments, one snap at a time.");
        hashMap.put("commen","236k");
        hashMap.put("profile",""+R.drawable.pro12);
        hashMap.put("taggs","#InstaCapture...");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("itemType","IMAGE");
        hashMap.put("imageUrl",""+R.drawable.pic6);
        hashMap.put("chanel_name","SnapStories__3h");
        hashMap.put("song_name","SnapJourney");
        hashMap.put("like","5226");
        hashMap.put("discription","Capturing life's moments, one snap at a time.");
        hashMap.put("commen","2365");
        hashMap.put("profile",""+R.drawable.pro11);
        hashMap.put("taggs","#InstaMoments...");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("itemType","IMAGE");
        hashMap.put("imageUrl",""+R.drawable.pic7);
        hashMap.put("chanel_name","Radiant Reverie__7h");
        hashMap.put("song_name","TrendSetterGram");
        hashMap.put("like","5226");
        hashMap.put("discription","Capturing life's moments, one snap at a time.");
        hashMap.put("commen","2365");
        hashMap.put("profile",""+R.drawable.pro12);
        hashMap.put("taggs","#MomentCaptured...");
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