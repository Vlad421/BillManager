package my.sdlc.billmanager;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import my.sdlc.billmanager.entity.flow.Earn;

/** @noinspection ClassEscapesDefinedScope*/
public class FlowListAdapter extends RecyclerView.Adapter<FlowListAdapter.EntryHolder> {

    ArrayList<Earn> data;

    /** @noinspection InnerClassMayBeStatic*/
    class EntryHolder extends RecyclerView.ViewHolder {
        TextView text;

        public EntryHolder(@NonNull View itemView) {
            super(itemView);

            text = itemView.findViewById(R.id.entry_item_description);
        }

        public TextView getTextView() {
            return text;
        }
    }


    public FlowListAdapter(ArrayList<Earn> data) {
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
        holder.getTextView().setText(data.get(position).getCategory());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}
