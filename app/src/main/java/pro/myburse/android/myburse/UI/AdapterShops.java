package pro.myburse.android.myburse.UI;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.mikepenz.iconics.view.IconicsTextView;

import java.util.ArrayList;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;
import pro.myburse.android.myburse.Model.Shop;
import pro.myburse.android.myburse.R;
import pro.myburse.android.myburse.Utils.SingleVolley;



public class AdapterShops extends RecyclerView.Adapter<AdapterShops.ShopViewHolder> {
    ArrayList<Shop> mShops;
    Context mContext;

    public AdapterShops(ArrayList<Shop> shops){
        super();
        this.mShops=shops;
    }

    @Override
    public ShopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.card, parent, false);
        return new ShopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ShopViewHolder holder, int position) {
        final Shop mShop = mShops.get(position);

        ImageLoader imageLoader = SingleVolley.getInstance(mContext).getImageLoader();

        imageLoader.get(mShop.getOwner().getAvatarUrl(), new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                holder.mOwnerImage.setImageBitmap(response.getBitmap());
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.wtf("ImageLoader","OnErrorResponse\n"+error.toString());
            }
        });
//        holder.mOwnerImage.setImageUrl(mShop.getOwnerAvatar(), SingleVolley.getInstance(mContext).getImageLoader());
        holder.mOwnerName.setText(mShop.getOwner().getName());
        holder.mItemType.setVisibility(View.GONE);
        holder.mCreated.setText(mShop.getCreatedAtFormated());
        holder.mUpdated.setText(mShop.getUpdatedAtFormated());
        holder.mTitle.setText(mShop.getTitle());
        imageLoader.get(mShop.getImage().getUrl(), new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                holder.mImage.setImageBitmap(response.getBitmap());
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.wtf("ImageLoader","OnErrorResponse\n"+error.toString());
            }
        });
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N) {
            holder.mPreview.setText(Html.fromHtml(mShop.getText().toString(), Html.FROM_HTML_MODE_COMPACT));
        }else{
            holder.mPreview.setText(Html.fromHtml(mShop.getText().toString()));
        }
        holder.mRating.setNumStars(5);
        holder.mRating.setRating(mShop.getRating());
        holder.mCounters.setText(String.format("{faw-comment} %d ",mShop.getReviewsCount()));
    }


    @Override
    public int getItemCount() {
        return mShops.size();
    }

    static class ShopViewHolder extends RecyclerView.ViewHolder{

        CardView cv;
        ImageView mOwnerImage;
        TextView mOwnerName;
        TextView mItemType;
        TextView mCreated;
        TextView mUpdated;
        TextView mTitle;
        ImageView mImage;
        TextView mPreview;
        MaterialRatingBar mRating;
        IconicsTextView mCounters;


        private ShopViewHolder(View itemView) {
            super(itemView);
            cv =  itemView.findViewById(R.id.cv);
            mOwnerImage = cv.findViewById(R.id.owner_avatar);
            mOwnerName = cv.findViewById(R.id.owner_name);
            mItemType = cv.findViewById(R.id.item_type);
            mCreated = cv.findViewById(R.id.created);
            mUpdated = cv.findViewById(R.id.updated);
            mTitle = cv.findViewById(R.id.title);
            mImage = cv.findViewById(R.id.image);
            mPreview = cv.findViewById(R.id.text);
            mRating = cv.findViewById(R.id.rating);
            mCounters = cv.findViewById(R.id.counters);
        }

    }
}
