package daphne.example.cathos_proyecto;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.Request;

import java.util.ArrayList;

import daphne.example.cathos_proyecto.HomesApp.DataStruct;

import static java.util.ServiceLoader.load;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<DataStruct> data;

    public CustomAdapter(Context context, ArrayList<DataStruct>data){
        this.context = context;
        this.data = data;
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("CheckResult")
    @Override
    public View getView(int i , View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(this.context).inflate(R.layout.item_list, null, false);
        }
        TextView title = view.findViewById(R.id.title);
        TextView content = view.findViewById(R.id.content);
        ImageView poster = view.findViewById(R.id.poster);

        title.setText(data.get(i).getDirections());
        content.setText(data.get(i).getDescription());
        Button eliminar = view.findViewById(R.id.delete);
       eliminar.setTag(this.data.get(i));

        Glide.with(this.context)
                .load(data.get(i).getPrimary_photo())
                .centerCrop()
                .into(poster);

        return view;



    }
}
