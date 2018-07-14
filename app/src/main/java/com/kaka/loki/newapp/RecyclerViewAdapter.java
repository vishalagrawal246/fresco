package com.kaka.loki.newapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.ContentResolver;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    List<String> mArrayListOne;
    List<String> mArrayListTwo;
    List<String> mArrayList3;
    List<String> mArrayList4;
    Context c;


    public RecyclerViewAdapter(List<String> mArrayListOne, List<String>mArrayListTwo, List<String>mArrayList3, List<String>mArrayList4) {

        this.mArrayListOne= mArrayListOne;
        this.mArrayListTwo= mArrayListTwo;
        this.mArrayList3= mArrayList3;
        this.mArrayList4= mArrayList4;

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public SimpleDraweeView simpleDraweeViewOne, simpleDraweeViewTwo, simpleDraweeView3,simpleDraweeView4;


        public MyViewHolder(View itemView) {
            super(itemView);

            simpleDraweeViewOne= (SimpleDraweeView) itemView.findViewById(R.id.draweeViewOne);
            simpleDraweeViewTwo= (SimpleDraweeView) itemView.findViewById(R.id.draweeViewTwo);
            simpleDraweeView3= (SimpleDraweeView) itemView.findViewById(R.id.draweeView3);
            simpleDraweeView4=  itemView.findViewById(R.id.draweeView4);




        }
    }
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_view, parent, false);


        MyViewHolder myViewHolder= new MyViewHolder(view);

        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Uri uriOne= Uri.parse(mArrayListOne.get(position));
        Uri uriTwo= Uri.parse(mArrayListTwo.get(position));
        Uri uri3= Uri.parse(mArrayList3.get(position));
        Uri uri4= Uri.parse(mArrayList4.get(position));

        DraweeController controllerOne = Fresco.newDraweeControllerBuilder()
                .setUri(uriOne)
                .setAutoPlayAnimations(true)
                .build();

        holder.simpleDraweeViewOne.setController(controllerOne);
        holder.simpleDraweeViewTwo.setImageURI(uriTwo);
        holder.simpleDraweeView3.setImageURI(uri3);
        holder.simpleDraweeView4.setImageURI(uri4);

        holder.simpleDraweeViewOne.getHierarchy().setActualImageScaleType(com.facebook.drawee.drawable.ScalingUtils.ScaleType.FIT_CENTER);
        holder.simpleDraweeViewTwo.getHierarchy().setActualImageScaleType(com.facebook.drawee.drawable.ScalingUtils.ScaleType.FIT_CENTER);
        holder.simpleDraweeView3.getHierarchy().setActualImageScaleType(com.facebook.drawee.drawable.ScalingUtils.ScaleType.FIT_CENTER);
        holder.simpleDraweeView4.getHierarchy().setActualImageScaleType(com.facebook.drawee.drawable.ScalingUtils.ScaleType.FIT_CENTER);

//        com.facebook.imagepipeline.request.ImageRequest request = com.facebook.imagepipeline.request.ImageRequestBuilder.newBuilderWithSource(uri4)
//                .setResizeOptions(new com.facebook.imagepipeline.common.ResizeOptions(100, 100))
//                .build();
//            holder.simpleDraweeView4.setController(
//                Fresco.newDraweeControllerBuilder()
//                    .setOldController(holder.simpleDraweeView4.getController())
//                    .setImageRequest(request)
//                    .build());


//            try {
//                Bitmap bitmap= android.provider.MediaStore.Images.Media.getBitmap(c.getContentResolver(),uri4);
//                holder.simpleDraweeView4.setImageBitmap(bitmap);
//
//
//            } catch (java.io.IOException e) {
//                e.printStackTrace();
//            }

    }


    @Override
    public int getItemCount() {
        return mArrayListOne.size();
    }
}