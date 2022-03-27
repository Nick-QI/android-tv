package com.nickboomboom.tv.components.customPlayer;

import android.content.Context;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nickboomboom.tv.R;



public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
	private static final String TAG = "ChanelAdapter";
	private String[] list;
	private Context context;


	public ItemAdapter(Context context, String[] list) {
		this.list = list;
		this.context = context;
	}

	@NonNull
	@Override
	public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View itemView = LayoutInflater.from(context).inflate(R.layout.player_layout_source, parent, false);
		return new ItemAdapter.ViewHolder(itemView);
	}

	@Override
	public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {
		final int _position = position;
		String title = this.list[_position];
		holder.btn_view.setText(title);
		holder.btn_view.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Log.d(TAG, "onClick: " + view.isFocused());
			}
		});
	}

	@Override
	public int getItemCount() {
		return this.list.length;
	}

	public class ViewHolder extends RecyclerView.ViewHolder {

		Button btn_view;
		View item_view;

		public ViewHolder(@NonNull View itemView) {
			super(itemView);

			btn_view = itemView.findViewById(R.id.player_layout_source_btn);
			item_view = itemView;
		}
	}
}
