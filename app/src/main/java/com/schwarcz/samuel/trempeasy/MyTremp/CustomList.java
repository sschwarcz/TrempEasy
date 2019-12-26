package com.schwarcz.samuel.trempeasy.MyTremp;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.schwarcz.samuel.trempeasy.R;
import com.schwarcz.samuel.trempeasy.model.Tremp;

import java.util.Vector;

import androidx.annotation.NonNull;

//public class CustomList extends ArrayAdapter<DocumentReference>{
//    private final Activity context;
//   // private final Vector<DocumentReference> web;
//    Vector<DocumentReference> tremps ;
//    private final Integer imageId;
//  //  TextView mFrom,mto , mhour , mplaces;
//
//    public CustomList(Activity context, Vector<DocumentReference> web) {
//        super(context, R.layout.list_single ,web);
//        Log.d("test","customList");
//        this.context = context;
//        this.tremps = web;
//        this.imageId = R.drawable.ic_launcher_foreground;
//    }
//
//    @Override
//    public View getView(int position, View view, ViewGroup parent) {
//       Log.d("test","getView");
//        LayoutInflater inflater = context.getLayoutInflater();
//        View rowView= inflater.inflate(R.layout.list_single, null, true);
//        final TextView mFrom = (TextView) rowView.findViewById(R.id.list_item_from);
//        final TextView mto = (TextView) rowView.findViewById(R.id.list_item_to);
//        final TextView mhour = (TextView) rowView.findViewById(R.id.list_item_hour);
//        final TextView mplaces = (TextView) rowView.findViewById(R.id.list_item_places);
//        final ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
//
//        if(tremps!= null) {
//            tremps.get(position).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                @Override
//                public void onSuccess(DocumentSnapshot documentSnapshot) {
//                    if (documentSnapshot.exists()) {
//                        String from = documentSnapshot.getString("from");
//                        String to = documentSnapshot.getString("to");
//                        String hour = documentSnapshot.getString("hour");
//                        String places = documentSnapshot.getString("places");
//                        mFrom.setText(from);
//                        mto.setText(to);
//                        mhour.setText(hour);
//                        mplaces.setText(places);
//                        imageView.setImageResource(imageId);
//                        Log.d("test", from);
//                    }
//                }
//            }).addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//
//                }
//            });
//        }
//        return rowView;
//    }
public class CustomList extends ArrayAdapter<DataSnapshot> {
    private final Activity context;
    // private final Vector<DocumentReference> web;
    Vector<DataSnapshot> tremps;
    private final Integer imageId;
    //  TextView mFrom,mto , mhour , mplaces;

    public CustomList(Activity context, Vector<DataSnapshot> web) {
        super(context, R.layout.list_single, web);
        Log.d("test", "customList");
        this.context = context;
        this.tremps = web;
        this.imageId = R.drawable.ic_launcher_foreground;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_single, null, true);
        final TextView mFrom = (TextView) rowView.findViewById(R.id.list_item_from);
        final TextView mto = (TextView) rowView.findViewById(R.id.list_item_to);
        final TextView mhour = (TextView) rowView.findViewById(R.id.list_item_hour);
        final TextView mplaces = (TextView) rowView.findViewById(R.id.list_item_places);
        final ImageView imageView = (ImageView) rowView.findViewById(R.id.img);

        if (tremps != null) {
            DataSnapshot data = tremps.get(position);
            if (data.exists()) {
                Tremp t = data. getValue(Tremp.class);
                String from = t.getFrom();
                String to = t.getTo();
                String hour = t.getHour();
                String places = t.getRemainPlaces();
                mFrom.setText(from);
                mto.setText(to);
                mhour.setText(hour);
                mplaces.setText(places);
                imageView.setImageResource(imageId);


            }
        }
            return rowView;


    }

}
