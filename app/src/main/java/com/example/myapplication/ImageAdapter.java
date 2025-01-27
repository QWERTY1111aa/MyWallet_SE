package com.example.myapplication;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
//
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private final Context context;
    private final List<Uri> imageUriList;

    public ImageAdapter(Context context, List<Uri> imageUriList) {
        this.context = context;
        this.imageUriList = imageUriList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_image, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageURI(imageUriList.get(position));

        holder.imageView.setOnClickListener(v -> showImageDialog(imageUriList.get(position)));
    }

    @Override
    public int getItemCount() {
        return imageUriList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
    private void showImageDialog(Uri imageUri) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_image);

        ImageView imageView = dialog.findViewById(R.id.dialogImageView);
        imageView.setImageURI(imageUri);

        dialog.show();
    }
}