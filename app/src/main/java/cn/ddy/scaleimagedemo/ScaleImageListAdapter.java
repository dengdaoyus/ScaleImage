package cn.ddy.scaleimagedemo;

import android.graphics.PointF;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.ddy.scaleimage.ImageSource;
import cn.ddy.scaleimage.RxScaleImageView;

/**
 * Created by Administrator on 2017/12/14 0014.
 */

public class ScaleImageListAdapter  extends RecyclerView.Adapter<ScaleImageListAdapter.ViewHolder> {

    private List<String> mValues;

    public ScaleImageListAdapter(List<String> items) {
        mValues = items;
    }

    @Override
    public ScaleImageListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_scaleimg, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.mItem = mValues.get(position);

        holder.tvName.setText(holder.mItem);
      //  displayLongPic(holder.imageView);
        holder.imageView.setImage(ImageSource.asset("changtu.jpg"));
        holder.imageView.setZoomEnabled(false);
                if (  holder.imageView.isReady()) {
                    float maxScale =   holder.imageView.getMaxScale();
                    PointF center = new PointF(  holder.imageView.getSWidth(), 0);
                    holder.imageView.setScaleAndCenter(maxScale, center);
                }
    }


    @Override
    public int getItemCount() {
        return mValues.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public String mItem;
        @BindView(R.id.imageView)
        RxScaleImageView imageView;
        @BindView(R.id.tv_name)
        TextView tvName;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, view);
        }
    }

//    private void displayLongPic(SubsamplingScaleImageView longImg) {
//        longImg.setQuickScaleEnabled(true);
//        longImg.setZoomEnabled(true);
//        longImg.setPanEnabled(true);
//        longImg.setDoubleTapZoomDuration(100);
//        longImg.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CENTER_CROP);
//        longImg.setDoubleTapZoomDpi(SubsamplingScaleImageView.ZOOM_FOCUS_CENTER);
//        longImg.setImage(ImageSource.asset("changtu.png"), new ImageViewState(0, new PointF(0, 0), 0));
//    }
}
