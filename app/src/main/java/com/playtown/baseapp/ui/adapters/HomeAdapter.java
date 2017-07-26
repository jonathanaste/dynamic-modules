package com.playtown.baseapp.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.playtown.baseapp.R;
import com.playtown.baseapp.interfaces.HomeCallback;
import com.playtown.baseapp.models.Element;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    private HomeCallback recyclerCallback;
    private ArrayList<Element> elementList;
    private Context context;

    public HomeAdapter(Context context, HomeCallback callback) {
        this.context = context;
        this.elementList = new ArrayList<>();
        this.recyclerCallback = callback;
    }

    public void updateData(List<Element> items) {
        this.elementList.addAll(items);
        notifyDataSetChanged();
    }

    public void showProgress() {
        elementList.add(new Element());
        notifyItemInserted(elementList.size());
    }

    public void hideProgress() {
        if (!elementList.isEmpty() && elementList.get(elementList.size() - 1).getId() == 0) {
            elementList.remove(elementList.size() - 1);
            notifyItemRemoved(elementList.size());
        }
    }

    public void setData(List<Element> itemList) {
        clear();
        this.elementList.addAll(itemList);
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(viewType, parent, false);
        return new MyViewHolder(v, viewType);
    }


    @Override
    public int getItemViewType(int position) {
        int viewType;
        if (position == 0) {
            viewType = R.layout.item_news_module;
        } else {
            viewType = R.layout.item_news_small;
        }
        return viewType;
    }

    @Override
    public int getItemCount() {
        return elementList != null ? elementList.size() : 0;
    }

    public Element getItem(int position) {
        return elementList.get(position);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        if (getItem(position) != null) {
            holder.bind(getItem(position));
        }
    }

    public void clear() {
        this.elementList.clear();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView category;
        private ImageView image;

        private View.OnClickListener onRowClicked = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerCallback.onItemClickWithView(getAdapterPosition(), image);
            }
        };

        MyViewHolder(View itemView, int viewType) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.title);
            category = (TextView) itemView.findViewById(R.id.category);
            itemView.setOnClickListener(onRowClicked);

        }

        void bind(final Element item) {

            if (item.getId() != 0) {
                title.setText(item.getTitle().toUpperCase());
                category.setText(item.getCategory());
                Picasso.with(context).load(item.getPreview()).into(image);
            }
        }
    }
}
