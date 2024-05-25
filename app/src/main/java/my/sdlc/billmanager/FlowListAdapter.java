/*
 * Copyright (c) 2024.
 * Vlad421 https://github.com/Vlad421
 */

package my.sdlc.billmanager;


import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import my.sdlc.billmanager.entity.flow.Entry;
/**
 * @author Vlad421 <a href="https://github.com/Vlad421">...</a>
 */
/** @noinspection ClassEscapesDefinedScope*/

public class FlowListAdapter extends RecyclerView.Adapter<FlowListAdapter.EntryHolder> {

    /**
     * RecyclerView adapter to handle displaying of entries
     *
     */

    ArrayList<Entry> data;

    /** @noinspection InnerClassMayBeStatic*/
    class EntryHolder extends RecyclerView.ViewHolder {
        TextView descriptionView;
        TextView amountView;
        TextView dateView;
        TextView categoryView;

        public EntryHolder(@NonNull View itemView) {
            super(itemView);

            descriptionView = itemView.findViewById(R.id.entry_item_description);
            amountView = itemView.findViewById(R.id.entry_amount);
            dateView = itemView.findViewById(R.id.entry_date);
            categoryView = itemView.findViewById(R.id.entry_category);

        }

        public TextView getDescriptionView() {
            return descriptionView;
        }



        public TextView getAmountView() {
            return amountView;
        }

        public TextView getDateView() {
            return dateView;
        }

        public TextView getCategoryView() {
            return categoryView;
        }
    }


    /**
     * Constructor
     * @param data list of entries
     */
    public FlowListAdapter(ArrayList<Entry> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public EntryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_flow_element, parent, false);

        return new EntryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EntryHolder holder, int position) {
        holder.getDescriptionView().setText(data.get(position).getDescription());
        holder.getAmountView().setText(String.valueOf( data.get(position).getAmount()));
        DateFormat date =  SimpleDateFormat.getDateInstance();

        holder.getDateView().setText(date.format( data.get(position).getDate()));
        holder.getCategoryView().setText(data.get(position).getCategory());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}
