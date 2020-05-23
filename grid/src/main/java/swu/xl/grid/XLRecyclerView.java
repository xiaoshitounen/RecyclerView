package swu.xl.grid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class XLRecyclerView extends RecyclerView {

    /**
     * 构造方法：Java代码初始化
     * @param context
     */
    public XLRecyclerView(@NonNull Context context) {
        super(context);

        //初始化操作
        init();
    }

    /**
     * 构造方法：Xml代码初始化
     * @param context
     * @param attrs
     */
    public XLRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        //初始化操作
        init();
    }

    /**
     * 初始化操作
     */
    private void init() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),4);
        this.setLayoutManager(gridLayoutManager);
        this.setAdapter(new MyAdapter(DataUtil.loadData(getContext())));
    }

    /**
     * 适配器
     */
    class MyAdapter extends RecyclerView.Adapter{
        //存储数据
        private List<FriendBean> friends;

        //构造方法
        public MyAdapter(List<FriendBean> friends) {
            this.friends = friends;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            //加载布局
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_layout, parent, false);

            //返回布局
            return new MyViewHolder(inflate);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            //加载数据
            FriendBean friend = friends.get(position);

            //设置数据
            MyViewHolder myViewHolder = (MyViewHolder) holder;
            myViewHolder.icon_view.setImageResource(friend.getIcon_id());
            myViewHolder.name_view.setText(friend.getName());
            myViewHolder.mode_view.setText(friend.getMode());
        }

        @Override
        public int getItemCount() {
            return friends.size();
        }
    }

    /**
     * ViewHolder
     */
    static class MyViewHolder extends RecyclerView.ViewHolder{
        //显示好友的头像
        ImageView icon_view;
        //显示好友的名称
        TextView name_view;
        //显示好友的动态
        TextView mode_view;

        /**
         * 构造方法
         * @param itemView
         */
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //绑定控件
            icon_view = itemView.findViewById(R.id.friend_icon);
            name_view = itemView.findViewById(R.id.friend_name);
            mode_view = itemView.findViewById(R.id.friend_mode);
        }
    }
}
